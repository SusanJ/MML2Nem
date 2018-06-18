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

import nemdata.Numeric;
import nemdata.Letter;

public class MMLproc extends mmlParserBaseListener {

 static String [] fopen =  {"", "?", ",?", ",,?" };
 static String [] fslash = {"", "/", ",/", ",,/" };
 static String [] fclose = {"", "#", ",#", ",,#" };

 static String radical = ">";
 static String indexOfRadical = "<";
 static String radicalTerm = "]";
 static String [] radNest = {"", ".", "..", "...", "...." };

 static boolean trace = true;
 static boolean debug = true;
 static boolean deContent = true;
 static boolean debugTokment = false;
 static boolean debugScripts = false;
 static boolean debugSbase = false;
 static boolean debugSsub = false;
 static boolean debugSsup = false;
 String tag;
 int fracLev = 0;
 int scriptLev = 0;

 Stack<ParseTree>fracEls = new Stack<ParseTree>();
 Stack<ParseTree>rootEls = new Stack<ParseTree>();
 Stack<ParserRuleContext>scriptsCtx = new Stack<ParserRuleContext>();
 Vocabulary VOCABULARY;
 static String[] ruleNames;

BufferedTokenStream allTokens;

  MMLproc( BufferedTokenStream allTokens ){
   this.allTokens = allTokens;
   this.VOCABULARY = mmlParser.VOCABULARY;
   Letter fake = new Letter( "x", "X" );
   Letter.makeTable( true );
   //this.ruleNames = mmlParser.getRuleNames();
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
  //if (trace) System.out.println( " enterElement" );
  String name=tagName( ctx.getText() );
  if (name.equals( "math")) {
     setNEM(ctx, ctx.getText() );
     return; 
  }
  if (name.equals( "document" )) return;
  System.out.println( "enterElement--WARNING--"+
    "unrecognized MathML element: "+name ); 
}
//===============================================
//   Mroot and Msqrt processing starts here
//===============================================
@Override
 public void enterRootment(mmlParser.RootmentContext ctx) { 
 rootEls.push( ctx );
}

@Override
 public void exitRootment(mmlParser.RootmentContext ctx) {
  if (trace) System.out.println( " exitRootment" );
  StringBuilder buf = new StringBuilder();
  String indy = indexOfRadical;
  String strt = radical;
  String term = radicalTerm;
  int radOrder = rootEls.size()-1;
  if (radOrder > 0){
    indy = radNest[radOrder]+strt;
    term = radNest[radOrder]+term;
  }
  buf.append( indy );
  buf.append( getNEM (ctx.getChild(2) ) );
  buf.append( strt );
  buf.append( getNEM (ctx.getChild(1) ) );
  buf.append( term );
  setNEM(ctx, buf.toString() );
  rootEls.pop();
 }
@Override
 public void enterSqrtment(mmlParser.SqrtmentContext ctx) { 
  rootEls.push( ctx );
 }
@Override
 public void exitSqrtment(mmlParser.SqrtmentContext ctx) { 
  if (trace) System.out.println( " exitSqrtment" );
  StringBuilder buf = new StringBuilder();
  String strt = radical;
  String term = radicalTerm;
  int radOrder = rootEls.size()-1;
  if (radOrder > 0){
    strt = radNest[radOrder]+strt;
    term = radNest[radOrder]+term;
  }
  buf.append( strt );
  buf.append( getNEM (ctx.getChild(1) ) );
  buf.append( term );
  setNEM(ctx, buf.toString() );
  rootEls.pop();
 }
//===============================================
//   Mscript processing starts here
//===============================================
@Override
 public void enterSupment(mmlParser.SupmentContext ctx) {
  if (scriptsCtx.empty()) {
   if (debugScripts) System.out.println( "New scripts at supment." );
  }
  scriptsCtx.push( ctx );
}
  //Msub element	 
@Override 
 public void exitSupment(mmlParser.SupmentContext ctx) {
  if (trace) System.out.println( " ^^^exitSupment" );
  if (ctx == scriptsCtx.peek()){
   if (debugScripts) System.out.println( "msup context match!" );
  } else {
   System.out.println( "WARNING msup context DOES NOT match!" );
  }
  int ssize = scriptsCtx.size();
  if (debugScripts) System.out.println( "No. of scripts: "+ssize );
  scriptsCtx.pop();
  String indy = "^";
   //Multilevel Nemeth script indicators
  if (ssize > 1 ){
    String pre = checkParent( ctx, scriptsCtx.elementAt(0) );
    System.out.println( "Pre: "+pre );
    indy = pre+indy;
  }
  StringBuilder buf = new StringBuilder();
  buf.append( getNEM(ctx.getChild(1)) ); //Base
  buf.append( indy );
  buf.append( getNEM(ctx.getChild(2)) ); //Superscript
  setNEM( ctx, buf.toString() );
}
@Override
 public void enterSubment(mmlParser.SubmentContext ctx) {
 scriptsCtx.push( ctx );
 if (scriptsCtx.empty()) {
   if (debugScripts) System.out.println( "New scripts at subment." );
 }
}
  //Msub element
@Override 
 public void exitSubment(mmlParser.SubmentContext ctx) {
  if (trace) System.out.println( " ;;;exitSubment" );
  if (ctx == scriptsCtx.peek()){
   if (debugScripts) System.out.println( "msub context match!" );
  } else {
   System.out.println( "WARNING msub context DOES NOT match!" );
  }
  int ssize = scriptsCtx.size();
  if (debugScripts) System.out.println( "No. of scripts: "+ssize );
  scriptsCtx.pop();
  String indy = ";";
   //Get prefix for multilevel Nemeth script indicators
   //needed for nested MML script elements
  if (ssize > 1 ){
    String pre = checkParent( ctx, scriptsCtx.elementAt(0) );
    if (debugScripts) System.out.println( "Pre: "+pre );
    indy = pre+indy;
  }
  StringBuilder buf = new StringBuilder();
  buf.append( getNEM(ctx.getChild(1)) ); //Base
  buf.append( indy );
  buf.append( getNEM(ctx.getChild(2)) ); //Subscript
  setNEM( ctx, buf.toString() );
}

@Override
 public void enterSubsupment(mmlParser.SubsupmentContext ctx) {
  if (scriptsCtx.empty()) {
   if (debugScripts) System.out.println( "New scripts at subsupment." );
  }
  scriptsCtx.push( ctx );
 }
  //Msubsup element	
@Override 
 public void exitSubsupment(mmlParser.SubsupmentContext ctx) {
  if (trace) System.out.println( " ;^;^exitSubsupment" );
  int ssize = scriptsCtx.size();
  if (debugScripts) System.out.println( "No. of scripts: "+ssize );
  int cnt = ctx.getChildCount();
  //System.out.println( "exitSubsupment child cnt: "+cnt+
    //" ctx: "+ctx );
  //if (ctx == scriptsCtx.peek()){
   if (ctx.equals( scriptsCtx.peek() )){
   if (debugScripts) System.out.println( "msubsup context match!" );
  } else {
   System.out.println( "WARNING msubsup context DOES NOT match!" );
   //System.out.println( "peek: "+scriptsCtx.peek()+" now: "+ctx );
  }
  
  scriptsCtx.pop();
  StringBuilder buf = new StringBuilder();
  String supsub = ";";
  String supsup = "^";
  //Get prefix for Nemeth multi-level script indicators
  if (ssize > 1){
   String  pre = checkParent( ctx, scriptsCtx.elementAt(0) );
   if (pre != null){
    buf.append( pre );
    supsub = pre+supsub;
    supsup = pre+supsup;
   }
  }
  buf.append( getNEM(ctx.getChild(1)) ); //Base
  buf.append( supsub );
  buf.append( getNEM(ctx.getChild(2)) ); //Subscript
  buf.append( supsup );
  buf.append( getNEM(ctx.getChild(3)) ); //Superscript
  setNEM( ctx, buf.toString() );
}
public String xgetRule( ParserRuleContext ctx ){
 int ruleIndex = ctx.getRuleIndex();
 System.out.println( "RuleIndex: "+ruleIndex+" rule: "+ruleNames[ruleIndex] );
 ParserRuleContext parent = ctx.getParent();
 if (parent != null){
   ruleIndex = parent.getRuleIndex();
   System.out.println( "parent rule: "+ruleNames[ruleIndex] );
 }
 return "";
}
/** Gets any prefix for Nemeth higher-level subscript
   and superscript indicators
       ctx is context of current item
       topCtx is context of its highest level (outer) parent
*/
public String checkParent( ParserRuleContext ctx,
                           ParserRuleContext topCtx ){
 if (debugScripts){ 
  System.out.println( "checkParent()--Checking for script prefix...." );
 }
 ParserRuleContext parent = ctx.getParent();
 int ruleIndex;
 int loop = 0;
 StringBuilder buf = new StringBuilder();
 while (parent != null){
  ruleIndex = parent.getRuleIndex();
  if (debugScripts) System.out.println( ruleNames[ruleIndex] );
   if (ruleNames[ruleIndex].equals("basecontent" )){
   parent = parent.getParent();
   if (parent == topCtx) {
    if (buf.length()>0) return buf.toString();
    return "";
   }
  } else if (ruleNames[ruleIndex].equals("subcontent" )){ 
    buf.append( ";" );
    parent = parent.getParent();
    if (parent == topCtx) return buf.toString();
  } else if (ruleNames[ruleIndex].equals("supcontent" )){ 
    buf.append( "^" );
    parent = parent.getParent();
    if (parent == topCtx) return buf.toString();
  } else {
   parent = parent.getParent();
  }
   //"infinite" loop check in case of logic problem
  loop = loop+1;
  if (loop > 10) {
   System.out.println( " Checkparent--Warning: ended "+
         "search on loop count > 10" ); 
   return "";
  }
 }
 return "";
}
@Override
 public void enterBasecontent(mmlParser.BasecontentContext ctx) { }

@Override
 public void exitBasecontent(mmlParser.BasecontentContext ctx) {
  StringBuilder buf = new StringBuilder();
   String childInfo;
   String childName;
    for (int i=0; i<ctx.getChildCount();i++){
     childName = tagName( ctx.getChild(i) );
     if (childName != null && !childName.equals( "justWS" )){
      childInfo = getNEM( ctx.getChild(i));
      buf.append( childInfo );
      if (debugSbase){
       System.out.println( "name: "+childName+
         " childInfo: |"+childInfo+"|" );
      }
     }
     //buf.append( nem.get(ctx.getChild(i) ) );
   }
   if (debugSbase){
    System.out.println( "  Basecontent "+buf.toString() );
   }
   setNEM( ctx, buf.toString() );
   return;
 }
@Override
 public void enterSubcontent(mmlParser.SubcontentContext ctx) { }

@Override
 public void exitSubcontent(mmlParser.SubcontentContext ctx) { 
  if (trace) System.out.println( "  exitSubcontent" );
  StringBuilder buf = new StringBuilder();
   String childInfo;
   String childName;
    for (int i=0; i<ctx.getChildCount();i++){
     childName = tagName( ctx.getChild(i) );
     if (childName != null && !childName.equals( "justWS" )){
      childInfo = getNEM( ctx.getChild(i));
      buf.append( childInfo );
      if (debugSsub){
       System.out.println( "name: "+childName+
         " childInfo: |"+childInfo+"|" );
      }
     }
     //buf.append( nem.get(ctx.getChild(i) ) );
   }
   if (debugSsub){
    System.out.println( "Subcontent "+buf.toString() );
   }
   setNEM( ctx, buf.toString() );
   return;
}
@Override
 public void enterSupcontent(mmlParser.SupcontentContext ctx) { }
@Override
 public void exitSupcontent(mmlParser.SupcontentContext ctx) { 
  if (trace) System.out.println( "  exitSupcontent" );
  StringBuilder buf = new StringBuilder();
   String childInfo;
   String childName;
    for (int i=0; i<ctx.getChildCount();i++){
     childName = tagName( ctx.getChild(i) );
     if (childName != null && !childName.equals( "justWS" )){
      childInfo = getNEM( ctx.getChild(i));
      buf.append( childInfo );
      if (debugSsup){
       System.out.println( "name: "+childName+
         " childInfo: |"+childInfo+"|" );
      }
     }
     //buf.append( nem.get(ctx.getChild(i) ) );
   }
   if (debugSsup){
    System.out.println( "Supcontent "+buf.toString() );
   }
   setNEM( ctx, buf.toString() );
   return;
}
//......................................................
//    Mfrac
//.....................................................
@Override
 public void enterFracment(mmlParser.FracmentContext ctx) { 
 if (fracEls.empty()) fracLev = 0;
 fracEls.push(ctx );
}

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
  //Placeholder for generic layout element
@Override
 public void enterLayment(mmlParser.LaymentContext ctx) { 
  if (trace) System.out.println( " enterLayment" );
 String name = tagName( ctx );
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
 if (debugTokment){
  System.out.println( "\n  ***exitTokment--tag: "+
                      getNEM( ctx ) );
 }
 if (debugTokment){
  System.out.println( "tokment child count: "+ctx.getChildCount() );
  for (int i=0; i<ctx.getChildCount(); i++){
   System.out.println( "tokment child: "+i+" text: "+ctx.getChild(i).getText() );
  }
 }
 
  int cnt = ctx.getChildCount();
  //Count back from end always the same whether or not
  //there are attributes
  int textPos = cnt-5;
  String tokType = ctx.getChild(1).getText();
  String info = null;
  String ink = ctx.getChild( textPos ).getText();;
  if (tokType.equals( "mn" )){
   //System.out.println( "tokment mn input: "+ink );
   info = Numeric.transNum( ink, true );
  } else if (tokType.equals( "mi" )){
   info = Letter.transVar( ink, "" );
  } else {
   info = ctx.getChild(1).getText()+
   ":"+ctx.getChild(textPos).getText();
   if (debugTokment){
    System.out.println( "tokment info: "+ctx.getChild(1).getText()+
       ":"+ctx.getChild(textPos).getText() );
   }
  }
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
    if (trace) System.out.println( "\n  exitContent" );
    int cnt = ctx.getChildCount();
    String parentTag = parentName( ctx );
    if (deContent){
     System.out.println( "Content cnt: "+cnt+ " parent: "+
                parentName( ctx )+" "+ctx.getText() );
    }
    String childName = tagName( ctx.getChild(0) );
    if (deContent)System.out.println( " -->exitContent first child: "+childName );
    if (childName != null && cnt == 1){
     if (childName.equals( "justWS" )){
      setNEM( ctx, "" );
      return;
     }
    }

    //System.out.println( "exitContent, parent: "+parentTag );
    if (  parentTag.equals( "mrow" ) 
       || parentTag.equals( "math" )
       || parentTag.equals( "msqrt" )
       || parentTag.equals( "mroot" )
       ){
      StringBuilder buf = new StringBuilder();
      String childInfo;
      for (int i=0; i<ctx.getChildCount();i++){
        childName = tagName( ctx.getChild(i) );
        if (childName != null && !childName.equals( "justWS" )){
          childInfo = getNEM( ctx.getChild(i));
          buf.append( childInfo );
          if (deContent){
            System.out.println( "child--Name: "+childName+
                 " Info: |"+childInfo+"|" );
          }
        }
      }
    setNEM( ctx, buf.toString() );
   } else {
     System.out.println( "exitContent, parent: "+parentTag );
   }
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
        ruleNames = parser.getRuleNames();
		
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