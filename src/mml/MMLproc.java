package mml;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.Vocabulary;

import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.lang.Character;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Pattern;

public class MMLproc extends mmlParserBaseListener {

 static String [] supind = {"", "^", "^^", "^^^" };
 static String [] supblev  = {"", "^", "^;", "^^;" };
 static String [] fopen =  {"", "?", ",?", ",,?" };
 static String [] fslash = {"", "/", ",/", ",,/" };
 static String [] fclose = {"", "#", ",#", ",,#" };
 static boolean trace = true;
 static boolean debug = true;
 static boolean deContent = true;
 String tag;
 int fracLev = 0;
 int scriptLev = 0;

 Stack<ParseTree>fracEls = new Stack<ParseTree>();
 Stack<String>scriptEls = new Stack<String>();

BufferedTokenStream allTokens;

  MMLproc( BufferedTokenStream allTokens ){
   this.allTokens = allTokens;
  }
//===================================================
  ParseTreeProperty<String> nem =
   new ParseTreeProperty<String>();

   //Annotate a tree node with its translation
  void setNEM( ParseTree ctx, String s ){
   nem.put( ctx, s );
  }
   //Get a previously-saved annotation for a tree node
  String getNEM( ParseTree ctx ) {
   return nem.get( ctx );
  }
//====================================================

@Override
 public void exitDocument(mmlParser.DocumentContext ctx) { 
  if (trace) System.out.println( "exitDocument" );
  //setNEM( ctx, ctx.getText() );

   StringBuilder buf = new StringBuilder();
    for (int i=0; i<ctx.getChildCount();i++){
     System.out.println( "exitDocument child: "+
            tagName( ctx.getChild(i)) );
     buf.append( nem.get(ctx.getChild(i) ) );
    }
    setNEM( ctx, buf.toString() );
   
 }
 //Ignore prolog
public void exitProlog( mmlParser.PrologContext ctx){
  setNEM( ctx, "" );
}
 //Ignore misc
public void exitMisc(mmlParser.MiscContext ctx){
  setNEM( ctx, "" );
}
@Override
 public void exitInteger(mmlParser.IntegerContext ctx) {
  if (trace) System.out.println( "  exitInteger" );
  TerminalNode myIntNodes = ctx.INTEG();
  //Can check something about position sfor N.I. need?
  if (debug) System.out.println( "exitInteger: "+ctx.getText() );
  //TO-DO TRANS!
  String num = ctx.getText();
  setNEM( ctx, num );
 }
ParseTree grandParent( ParseTree ctx ){
 ParseTree parent = ctx.getParent();
 if (parent == null) return null;
 return parent.getParent();
}
String grandparentName( ParseTree ctx ){
  ParseTree gp = grandParent( ctx );
  if (gp == null) return null;
  return tagName( gp );
}
String parentName( ParseTree ctx ){
  ParseTree p = ctx.getParent();
  if (p == null) return "";
  return tagName( p );
}
String tagName( ParseTree ctx ){
 return tagName( ctx.getText() );
}

 //Helper method for getting 'name' of an element
 //Assumes text is "<name> .... 
String tagName( String text ){
 int gt = text.indexOf( ">" );
 if (gt < 2 ) {
   // True if child is a terminal node
   //System.out.println( "tagName--LOGIC error--text: |"+text+"|" );
   //System.exit( 0 );
   return null;
 }
 if (!text.substring(0,1).equals("<")){
  System.out.println( "Warning, bad test in tagName: "+text );
  return "";
 }
 return text.substring(1,gt);
}
@Override
 public void enterElement(mmlParser.ElementContext ctx) { 
  if (trace) System.out.println( " enterElement" );
  String name=tagName( ctx.getText() );
  if (name.equals( "math")) {
     setNEM(ctx, ctx.getText() );
     return; 
  }
  System.out.println( "\n       -->ENTER Element: " +name);
  ParseTree gp = grandParent( ctx );
  if (gp != null){
     String old = gp.getText();
     System.out.println( "          text: "+ctx.getText()+
     " grandparent: "+old );
  }else{
  };
 //If the element is a token element save its name as annotation
 //then when the chardata checks its grandparent it will know
 //what kind of token element (if any) and replace the name with
 // proper text
 setNEM(ctx, ctx.getText() );
}

@Override
 public void enterSupment(mmlParser.SupmentContext ctx) {
  if (scriptEls.empty()){
   scriptEls.push( "^" );
  } else {
   String indy = scriptEls.peek()+"^";
   scriptEls.push( indy );
  }
}

	 
@Override 
 public void exitSupment(mmlParser.SupmentContext ctx) {
  if (trace) System.out.println( " ^^^exitSupment" );
  StringBuilder buf = new StringBuilder();
  buf.append( getNEM(ctx.getChild(1)) ); //Base
  buf.append( scriptEls.pop() );
  buf.append( getNEM(ctx.getChild(2)) ); //Superscript
  setNEM( ctx, buf.toString() );
}
@Override
 public void enterSubment(mmlParser.SubmentContext ctx) {
  if (scriptEls.empty()){
   scriptEls.push( ";" );
  } else {
   String indy = scriptEls.peek()+";";
   scriptEls.push( indy );
  }
}
@Override 
 public void exitSubment(mmlParser.SubmentContext ctx) {
  if (trace) System.out.println( " ;;;exitSubment" );
  StringBuilder buf = new StringBuilder();
  buf.append( getNEM(ctx.getChild(1)) ); //Base
  buf.append( scriptEls.pop() );
  buf.append( getNEM(ctx.getChild(2)) ); //Subscript
  setNEM( ctx, buf.toString() );
}

@Override
 public void enterFracment(mmlParser.FracmentContext ctx) { 
 if (fracEls.empty()) fracLev = 0;
 fracEls.push(ctx );
}

 //Layout elements such as msup
@Override
 public void exitFracment(mmlParser.FracmentContext ctx) { 
  if (trace) System.out.println( " ###exitFracment" );
  fracLev = fracLev + 1;
  if (!fracEls.empty()) fracEls.pop();
  System.out.println( "mfrac has: "+ctx.getChildCount()+" child nodes." );
  StringBuilder buf = new StringBuilder();
  buf.append( fopen[fracLev] );
  buf.append( getNEM(ctx.getChild(1)) );
  buf.append( fslash[fracLev] );
  buf.append( getNEM(ctx.getChild(2)) );
  buf.append( fclose[fracLev] );
  System.out.println( "Nem frac: "+buf.toString() );
  setNEM( ctx, buf.toString() );
}
@Override
 public void enterLayment(mmlParser.LaymentContext ctx) { 
  if (trace) System.out.println( " enterLayment" );
 String name = tagName(ctx);
 //Thinking about informing content child how many
 // children this layout element has
 // or would the content names "base" and "script" be better"
 // of the content could ask?
 if (name.equals( "msup" )){
  setNEM( ctx, "2" );
  return;
 }
 if (name.equals( "msubsup" )){
  setNEM( ctx, "3" );
  return;
 }
 setNEM( ctx, name );
}
//Fraction content should a single element with optional WS
//Translation should have 
@Override
 public void exitFraccontent(mmlParser.FraccontentContext ctx) {
 if (trace) System.out.println( "exitFraccontent" );
 //if (parentTag.equals("mrow" )){

   StringBuilder buf = new StringBuilder();
   String childInfo;
   String childName;
    for (int i=0; i<ctx.getChildCount();i++){
     childName = tagName( ctx.getChild(i) );
     if (childName != null && !childName.equals( "justWS" )){
      childInfo = getNEM( ctx.getChild(i));
      buf.append( childInfo );
      System.out.println( "name: "+childName+" childInfo: |"+childInfo+"|" );
     }
     //buf.append( nem.get(ctx.getChild(i) ) );
   }
   System.out.println( "FRAC-ELEM "+buf.toString() );
   setNEM( ctx, buf.toString() );
   return;
 //} 
}
@Override
 public void exitLayment(mmlParser.LaymentContext ctx) { 
  if (trace) System.out.println( " exitLayment" );
 String name = tagName(ctx);
 System.out.println( "^^^exitLayment: "+name+
   " chilren cnt: "+ctx.getChildCount() );  

  //This is a HACK for now

    StringBuilder buf = new StringBuilder();
    buf.append( name.toUpperCase() );  //PREPENDS MSUP!
    for (int i=3; i<4;i++){
     String tmp = ctx.getChild( i).getText();
     buf.append( nem.get(ctx.getChild(i) ) );
    }
    System.out.println( name+" output: "+buf.toString() );
    setNEM( ctx, buf.toString() );
    return;
 
                
}
@Override
 public void enterTokment(mmlParser.TokmentContext ctx) { 
 if (trace) System.out.println( " enterTokment" );
 //Tagname of this element saved temporarily
 String name = tagName(ctx);
 setNEM( ctx, name );
}
@Override
 public void exitTokment(mmlParser.TokmentContext ctx) { 
 if (trace) System.out.println( " exitTokment" );
 String name = tagName(ctx);
 //if (name.equals( "mn" )){
  System.out.println( "\n  ***exitTokment--tag: "+
                      getNEM( ctx ) );
 //}

 System.out.println( "tokment child count: "+ctx.getChildCount() );
 for (int i=0; i<ctx.getChildCount(); i++){
  System.out.println( "tokment child: "+i+" text: "+ctx.getChild(i).getText() );
 }
 String info = ctx.getChild(1).getText()+
   ":"+ctx.getChild(3).getText();
 System.out.println( "tokment info: "+ctx.getChild(1).getText()+
   ":"+ctx.getChild(3).getText() );
 setNEM( ctx, info );
}
@Override
 public void enterRowment(mmlParser.RowmentContext ctx) {
  if (trace) System.out.println( " enterRowment" ); 
 String name = tagName(ctx);
 setNEM( ctx, name );
}
@Override
 public void exitRowment(mmlParser.RowmentContext ctx) { 
  if (trace) System.out.println( " exitRowment" ); 
 String name = tagName( ctx );
 int cnt = ctx.getChildCount();
 System.out.println( "EXITING ROWMENT Text: "+ctx.getText()+
    " no. of children: "+cnt );

    StringBuilder buf = new StringBuilder();
    buf.append( "{" );
    buf.append( nem.get(ctx.getChild(1) ) );
    //for (int i=3; i<4;i++){
     //String tmp = ctx.getChild( i).getText();
     //buf.append( nem.get(ctx.getChild(i) ) );
    //}
    buf.append( "}");
    System.out.println( "Row output: "+buf.toString() );
    setNEM( ctx, buf.toString() );
    return;
 
}
@Override
 public void exitElement(mmlParser.ElementContext ctx) {
  String name=tagName( ctx.getText() ); 
  System.out.println( "\n      EXITING ELEMENT: "+name );   
 
  if(name.equals( "math" )){
    StringBuilder buf = new StringBuilder();
    int last = 4;   //ONLY WORKS IF MATH HAS ONE CHILD
    for (int i=3; i<last;i++){
     buf.append( nem.get(ctx.getChild(i) ) );
    }
    setNEM( ctx, buf.toString() );
    System.out.println( "$$$math element saved: "+buf.toString() );
    return;
   }
if(name.equals( "document" )){
    StringBuilder buf = new StringBuilder();
    int doclast = 4;   //ONLY WORKS IF MATH HAS ONE CHILD
    for (int i=3; i<doclast;i++){
     buf.append( nem.get(ctx.getChild(i) ) );
    }
    setNEM( ctx, buf.toString() );
    System.out.println( "$$$document element saved: "+buf.toString() );
    return;
   }
   if(name.equals( "mi" )){
    StringBuilder buf = new StringBuilder();
    //for (int i=0; i<ctx.getChildCount();i++){
    //buf.append( nem.get(ctx.getChild(i) ) );
    //}
    //setNEM( ctx, "X" );
    return;
   }

  //When you exit a row you gather up the children and
  //prepend a ( and append a ) to the string buffer
  int cnt = ctx.getChildCount();
  System.out.println( "         -->EXIT Element children: "+cnt );
  System.out.println( " text: "+ctx.getText() );
  boolean good = false;
  String tmp; 
  String impt = null;
  boolean skipOld = true;

if (skipOld){
  for (int i=0; i<ctx.getChildCount();i++){
   
   tmp = ctx.getChild(i).getText();
   if (i==0 && tmp.equals( "<" )){
    good = true;
   }
   if (good && i==1){
    tag = tmp;
   }
   if (good && i==3){
    impt = tmp;
   }
   System.out.println( "  child text: "+ctx.getChild(i).getText() );
  }
  System.out.println( "  TAG: "+tag+" value: "+impt );
 }//end skipOld
}
//Should be only when content is chardata or RowMent(s)
@Override public void exitRcontent(mmlParser.RcontentContext ctx) { 
 if (trace) System.out.println( "exitRcontent" );
 //if (parentTag.equals("mrow" )){
   StringBuilder buf = new StringBuilder();
   String childInfo;
   String childName;
    for (int i=0; i<ctx.getChildCount();i++){
     childName = tagName( ctx.getChild(i) );
     if (childName != null && !childName.equals( "justWS" )){
      childInfo = getNEM( ctx.getChild(i));
      buf.append( childInfo );
      System.out.println( "name: "+childName+" childInfo: |"+childInfo+"|" );
     }
     //buf.append( nem.get(ctx.getChild(i) ) );
   }
   System.out.println( "--> "+buf.toString() );
   setNEM( ctx, buf.toString() );
   return;
 //} 
}
@Override
public void exitContent (mmlParser.ContentContext ctx) { 

    if (trace) System.out.println( "  exitContent" );
    int cnt = ctx.getChildCount();
    String parentTag = parentName( ctx );
    if (deContent){
     System.out.println( "Content cnt: "+cnt+ " parent: "+
      parentName( ctx ) );
    }

    String childName = tagName( ctx.getChild(0) );
    System.out.println( " -->exitContent first child: "+childName );
    if (childName != null && cnt == 1){
     if (childName.equals( "justWS" )){
      setNEM( ctx, "" );
      return;
     }
    }

 if (parentTag.equals( "mrow" ) || parentTag.equals( "math" )){
   StringBuilder buf = new StringBuilder();
   String childInfo;
    for (int i=0; i<ctx.getChildCount();i++){
     childName = tagName( ctx.getChild(i) );
     if (childName != null && !childName.equals( "justWS" )){
      childInfo = getNEM( ctx.getChild(i));
      buf.append( childInfo );
      System.out.println( "name: "+childName+" childInfo: |"+childInfo+"|" );
     }
     //buf.append( nem.get(ctx.getChild(i) ) );
   }
   setNEM( ctx, buf.toString() );
   return;
 } 
/**
    int elems = 0;
    StringBuilder buf = new StringBuilder();
    for (int i=0; i<ctx.getChildCount();i++){
     childName = tagName( ctx.getChild (i) );
     if (childName != null){
      if (!childName.equals( "justWS" )){
       if (parentName( ctx ).equals( "msup" )){
         if (elems == 0) buf.append( "BASE: " );
         if (elems >0) buf.append( "SCRIPT: ");
       }
       buf.append( nem.get(ctx.getChild(i) ) );
       elems = elems+1;
       }
      }
    }
**/
    System.out.println( "~~~exitContent--text: "+ctx.getText()+
      " childCnt: "+ctx.getChildCount() );
     // " concat: "+buf.toString()+" elem kids: "+elems );
   // setNEM( ctx, buf.toString() );
    return;
   
}
//@Override
  public void XenterChardata(mmlParser.ChardataContext ctx) {
   System.out.println( "\n   >==ENTERChardata" );
   ParseTree gp = grandParent( ctx );
   if (gp != null ){
    System.out.println( "    mytext: "+ctx.getText() +
     " my grandparent's text: "+gp.getText() );
   }  
 } 

 //This could be a token element.
//@Override
  public void XexitChardata(mmlParser.ChardataContext ctx) {
   System.out.println( "\n     ==exitChardata" );
   String myText = ctx.getText();
   System.out.println( "       ==CDtext: "+myText );
   String grandparentName = grandparentName( ctx );
   System.out.println( "       ==CharData <GP>: "+grandparentName );

   if (grandparentName.equals( "mn" )){
    
    ParseTree gp = grandParent( ctx );
    System.out.println( "mn==getNEM was: "+getNEM( gp ));
    //setNEM( gp, "<mn>#"+myText+"</mn>" );
    setNEM( gp, "#"+myText );
    return;
   }
  if (grandparentName.equals( "mo" )){
    ParseTree gp = grandParent( ctx );
    System.out.println( "mo==getNEM was: "+getNEM( gp ));
    //setNEM( gp, "<mo>OP"+myText+"</mo>" );
    if (myText.equals( "=" )){
     setNEM( gp, " .k " );
    } else {
     setNEM( gp, myText );
    }
    return;
   }
   if (grandparentName.equals( "mi" )){
    ParseTree gp = grandParent( ctx );
    System.out.println( "mi==getNEM was: "+getNEM( gp ));
    //setNEM( gp, "<mi>VAR: "+myText+"</mi>" );
    setNEM( gp, myText );
    return;
   }

   StringBuilder buf = new StringBuilder();
    for (int i=0; i<ctx.getChildCount();i++){
     buf.append( nem.get(ctx.getChild(i) ) );
    }
    int length = buf.toString().length();
    System.out.println( "    ---exitingChardata--text: "+ctx.getText()+
                        " concat: "+buf.toString()+
       " length: "+length );
  
    if (buf.toString() == null || length==4 ){
     setNEM( ctx, "" );
     return;
    }
    //setNEM( ctx, buf.toString() );
      if (buf.toString() == "\\r\\n"){
     setNEM( ctx, "" );
     return;
    }
    setNEM( ctx, "atadc" );
    return;
} 
//===========================================================
  public static void main( String[] args ) throws Exception {
//===========================================================

 System.out.println( "\n    Welcome to MML Antlr Parser!" );
 
 String inputFile = null;
 CharStream input = null;
 if ( args.length > 0 ) inputFile = args[0];
 if (inputFile == null){
    Reader myReader = new InputStreamReader( System.in, "UTF-8");
    CodePointCharStream cpcs = CharStreams.fromReader( myReader );
    input = cpcs;
 } else {
    File f = new File( inputFile );
    if (f.exists() && !f.isDirectory() )  {
       input = CharStreams.fromFileName( inputFile );
    } else {
       System.out.println( "\n OOPS! Cannot find input file: "
                           +inputFile );
       System.exit( 0 );
    }
  }

  //Tape6 myOutput = new Tape6( "uebout.txt" );

/**  I. Connect input to lexer, have it create a token stream,
        provided token stream to parser and instruct parser to
        build a parse tree.  
*/
        // The names and location of thelexer and parser
        // depends on how they were created from their
        //respective grammars
        // Here "mml" is the user-specified prefix
        mmlLexer lexer = new mmlLexer( input );
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        mmlParser parser = new mmlParser( tokens ); 
        parser.setBuildParseTree( true );
		
/**  II. Start tree with the topmost rule in the Parser 
         grammar.  (Rule #0 if grammar starts with that one.)
*/
         ParseTree tree = parser.document();
         String x = tree.toStringTree( parser);
         System.out.println( "     PARSE TREE: ");
         System.out.println( x );
        //myOutput.println( "     PARSE TREE: ");
        //wrap( tmpTree, 60, myOutput );

/**  III. Insert logic to walk and annotate tree. */
          
          //Custom class that extends BaseListener generated by ANTLR
          MMLproc proc = new MMLproc( tokens );
          ParseTreeWalker walker = new ParseTreeWalker();
          walker.walk( proc, tree );

/**  IV. Display annotation   */

     System.out.println( "ANNOTATION");
     System.out.println( proc.getNEM( tree ) );

    //System.out.println();
     //System.out.println( "      ***Translation***" );
     //System.out.println(" Translated braille from annotated tree: ");
     //System.out.println( bt.getBrl( tree ) );

     //myOutput.finish();

 }//End Main.
}//End Class MMLproc.