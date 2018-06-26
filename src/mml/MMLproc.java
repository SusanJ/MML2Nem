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
import nemdata.SpecialSymbol;
import nemdata.Tape6;
import nemdata.NIFixer;

public class MMLproc extends mmlParserBaseListener {

 static String [] fopen =  {"", "?", ",?", ",,?" };
 static String [] fslash = {"", "/", ",/", ",,/" };
 static String [] fclose = {"", "#", ",#", ",,#" };

 static Tape6 myOutput = new Tape6( "nemout.htm" );

  //Rule XIV Modifiers [or Limits]
 static String modOpen = "\"";
 static String dirUnder = "%";
 static String dirOver = "&gt;";
 static String modTerm = "]";
 

 static boolean spaceCmprSymbols = true;

 static String radical = ">";
 static String indexOfRadical = "<";
 static String radicalTerm = "]";
 static String [] radNest = {"", ".", "..", "...", "...." };

 static boolean boilerplate = true;
 static boolean trace = false;
 static boolean debug = true;
 static boolean deContent = false;
 static boolean debugTokment = false;
 static boolean debugLimits = true;
 static boolean debugScripts = false;
 static boolean debugSbase = false;
 static boolean debugSsub = false;
 static boolean debugSsup = false;
 static boolean addCurlies2Row = false;
 static boolean check86b = true;
 static boolean debugtcon = false;
 static boolean showParseTree = false;
 String tag;
 int munderCnt = 0;
 int moverCnt = 0;
 int fracLev = 0;
 int scriptLev = 0;

 Stack<ParseTree>fracEls = new Stack<ParseTree>();
 Stack<ParseTree>rootEls = new Stack<ParseTree>();
 Stack<ParserRuleContext>scriptsCtx = new Stack<ParserRuleContext>();
 Stack<ParserRuleContext>modunCtx = new Stack<ParserRuleContext>();
 Stack<ParserRuleContext>modovCtx = new Stack<ParserRuleContext>();
 Stack<String> overScripts = new  Stack<String>();


 Vocabulary VOCABULARY;
 static String[] ruleNames;

BufferedTokenStream allTokens;

//===================================================
//             Constructor
//===================================================
  MMLproc( BufferedTokenStream allTokens ){
   this.allTokens = allTokens;
   this.VOCABULARY = mmlParser.VOCABULARY;
   Letter fake = new Letter( "x", "X" );
   //String sc = Letter.singleCaps;
   //String capX = fake.getScUcBrl();
   //System.out.println( "Single caps hard-wired in Letter: "+sc+
    //" X: "+capX );
   Letter.makeTable( false );
   SpecialSymbol alsoFake = new SpecialSymbol( "~", "~" );
   SpecialSymbol.makeTables();
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
 public void enterDocument(mmlParser.DocumentContext ctx) {
 munderCnt = 0;
 moverCnt = 0;
 myOutput.out( "<h3>MathML to Nemeth Translation Examples</h3>" );
  if (boilerplate) explain( true );
}
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
 public void enterPara(mmlParser.ParaContext ctx) { 
  myOutput.out( "<p>"+ctx.getText()+"</p>" );
}


@Override
 public void exitInteger(mmlParser.IntegerContext ctx) {
  if (trace) System.out.println( "  exitInteger" );
  TerminalNode myIntNodes = ctx.INTEG();
  //Can check something about position sfor N.I. need?
  //if (debug) System.out.println( "exitInteger: "+ctx.getText() );
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
String tokContents( String text, String tok1, String tok2 ){
 String res1 = tokContents( text, tok1 );
 if (res1 != null) return res1;
 return tokContents( text, tok2 );
}

//Extract contents from "<tok ...>contents</..."
String tokContents( String text, String tok ){
 if (debugtcon) System.out.println( "tcon: |"+text+"| |"+tok+"|" );
 //StringBuilder buf = new StringBuilder( "<" );
 //buf.append( tok );
 String trimmed = text.trim();
 String check = trimmed.substring(1,3);
 System.out.println( "trimmed: "+trimmed+" check: "+check );
 if (!check.equals( tok )) return null;
 int send = trimmed.indexOf( ">" );
 int estrt = trimmed .substring(send).indexOf( "<" )+send;
 String extract = trimmed.substring( send+1, estrt );
 if (debugtcon) System.out.println( "extract: "+extract );
 return extract;
}
 //Helper method for getting 'name' of an element
 //Assumes text is "<name> .... 
String tagName( String text ){
 String trimmed = text.trim();
 int gt = trimmed.indexOf( ">" );
 if (gt < 2 ) {
   // True if child is a terminal node
   //System.out.println( "tagName--LOGIC error--text: |"+text+"|" );
   //System.exit( 0 );
   return null;
 }
 if (!trimmed.substring(0,1).equals("<")){
  System.out.println( "Warning, bad test in tagName: "+trimmed );
  return "";
 }
 return trimmed.substring(1,gt);
}
@Override
 public void enterElement(mmlParser.ElementContext ctx) { 
  //if (trace) System.out.println( " enterElement" );
  String name=tagName( ctx.getText() );
   if (name.startsWith( "math")) {
     StringBuilder buf = new StringBuilder();
     String tmp = null;
     for (int i=0; i<ctx.getChildCount(); i++){
      tmp = ctx.getChild(i).getText();
      System.out.println( "i: "+i+" text: |"+tmp+"|");
      if (tmp.startsWith("disp")) buf.append(" " );
      buf.append( tmp );
    }
      

     //setNEM(ctx, ctx.getText() );
     //TO-DO Fix N.I. useage for planar items
     myOutput.out( "<p>Rendered MathML input: </br>" );
     //myOutput.out(  ctx.getText()+"</p>"  );
     myOutput.out( buf.toString()+"</p>"  );
     return; 
  }
  if (name.equals( "document" )) return;
  System.out.println( "enterElement--WARNING--"+
    "unrecognized MathML element: "+name ); 
}
//========================================================
//   Munder, Mover, and Munderover processing starts here
//========================================================
@Override
 public void enterUndoverment(mmlParser.UndovermentContext ctx) { 
  if (trace) System.out.println( " enterUndoverment" ); 
  munderCnt = munderCnt+1;
  modunCtx.push( ctx );
  moverCnt = moverCnt+1;
  modovCtx.push( ctx );
}
@Override
 public void exitUndoverment(mmlParser.UndovermentContext ctx) {
  if (trace) System.out.println( " exitUndoverment" ); 
  int cnt = ctx.getChildCount();
  if (debugLimits){
   System.out.println( "exitUndover--no. of children: "+cnt );
  }
  if (ctx == modunCtx.peek()){
   if (debugLimits) System.out.println( "munderover under context matches!" );
  } else {
   System.out.println( "WARNING munderover under context DOES NOT match!" );
  }
  if (ctx == modovCtx.peek()){
   if (debugLimits) System.out.println( "munderover over context matches!" );
  } else {
   System.out.println( "WARNING munderover over context DOES NOT match!" );
  }
  // Cnt is total munder+munderOver while size is number not yet done
  //xorder is additional indicators needed
  int xorderUn = munderCnt-modunCtx.size();
  int xorderOv = moverCnt-modovCtx.size();
  String start =  modOpen;
  String indyUn = dirUnder;
  for (int i=0; i<xorderUn; i++){
   indyUn = indyUn+dirUnder;
  }
  String indyOv = dirOver;
  for (int i=0; i<xorderOv; i++){
   indyOv = indyOv+dirOver;
  }
  String term = modTerm;
  StringBuilder buf = new StringBuilder();
  //Outermost limit layout
  if (modunCtx.size() == 1 && modovCtx.size() == 1){
   System.out.println( "outer: indyOv: "+indyOv );
   buf.append( start );
   buf.append( getNEM (ctx.getChild(1) ) );
   buf.append( indyUn );
   buf.append( getNEM (ctx.getChild(2) ) );
   
   while (!overScripts.empty()){
    buf.append( overScripts.pop() );
    buf.append( indyOv );
   buf.append( getNEM (ctx.getChild(3) ) );
   }
   buf.append( term );
   System.out.println( "1 test: "+buf.toString() );
   setNEM(ctx, buf.toString() );
  } else {
   System.out.println( "inner: indyOv: "+indyOv );
   buf.append( getNEM (ctx.getChild(1) ) );
   buf.append( indyUn );
   buf.append( getNEM (ctx.getChild(2) ) );
   //buf.append( indyOv );
   overScripts.push( indyOv+getNEM(ctx.getChild(3) ) );
   //buf.append( getNEM (ctx.getChild(3) ) );
   System.out.println( "2 test: "+buf.toString() );
   setNEM(ctx, buf.toString() );
  }
  modunCtx.pop();
  modovCtx.pop();
 }

@Override
 public void enterUnderment(mmlParser.UndermentContext ctx) { 
  if (trace) System.out.println( " entertUnderment" );
  munderCnt = munderCnt+1;
  modunCtx.push( ctx );
 }
     // <munder> base  underscript </munder>
@Override
 public void exitUnderment(mmlParser.UndermentContext ctx) { 
  if (trace) System.out.println( " exitUnderment" );
  int cnt = ctx.getChildCount();
  if (debugLimits){
   System.out.println( "exitUnder--no. of children: "+cnt );
  }
  if (ctx == modunCtx.peek()){
   if (debugLimits) System.out.println( "munder context match!" );
  } else {
   System.out.println( "WARNING munder context DOES NOT match!" );
  }
  // Cnt is total munder+munderOver while size is number not yet done
  //xorder is additional indicators needed
  int xorder = munderCnt-modunCtx.size();
  String start =  modOpen;
  String indy = dirUnder;
  for (int i=0; i<xorder; i++){
   indy = indy+dirUnder;
  }
  String term = modTerm;
  StringBuilder buf = new StringBuilder();
  if (modunCtx.size() == 1){
   buf.append( start );
   buf.append( getNEM (ctx.getChild(1) ) );
   buf.append( indy );
   buf.append( getNEM (ctx.getChild(2) ) );
   buf.append( term );
   setNEM(ctx, buf.toString() );
  } else {
   buf.append( getNEM (ctx.getChild(1) ) );
   buf.append( indy );
   buf.append( getNEM (ctx.getChild(2) ) );
   setNEM(ctx, buf.toString() );
  //} else {
   //System.out.println( "munder nest not available: "+modunCtx.size() );
   //setNEM(ctx, "" );
  }
  modunCtx.pop();
}

@Override
 public void enterOverment(mmlParser.OvermentContext ctx) { 
  if (trace) System.out.println( " entertOverment" );
  //Check for special case for overbar per Sec. 86 b.
  //This can be mixed with std. use of 5-step
  if (check86b){
    String mac = tokContents( ctx.getChild(2).getText(), "mo" );
    System.out.println( "extracted mac: "+mac );
    System.out.println( "vartag: "+ctx.getChild(1).getText() );
    System.out.println( "mactag: "+ctx.getChild(2).getText() );
    String var = tokContents( ctx.getChild(1).getText(),
         "mn", "mi" );
    System.out.println( "chk86b--mac: "+mac+" var: "+var );
    boolean isMac = false;
    boolean is86b = false;
    if (mac.equals( "&#x000AF;" )) isMac = true;
    if (isMac){
     if (var != null && var.length() == 1){
      is86b = Character.isLetterOrDigit( var.charAt(0) );
     }
    } 
    if (is86b){
     System.out.println( "Need to use Sec. 86 b." );
     //TO-DO  flag???
     //String nemmac = var+":"+mac;
     //Set flag so exitOverment will do special case
     setNEM( ctx, "86b" );
     return;
    }
  }
  moverCnt = moverCnt+1;
  modovCtx.push( ctx );
 }
     // <mover> base  overscript </mover>
@Override
 public void exitOverment(mmlParser.OvermentContext ctx) { 
  if (trace) System.out.println( " exitOverment" );
 
  int cnt = ctx.getChildCount();
  if (debugLimits){
   System.out.println( "exitOver--no. of children: "+cnt );
  }
  String mac = getNEM( ctx );
  //Using contracted form for macron over single digit or letter
  if (mac != null && mac.equals( "86b" )){
    System.out.println( "exiOver -- contracted form for macron" );
   StringBuilder sbuf = new StringBuilder();
    //Check for #?
   sbuf.append( getNEM (ctx.getChild(1) ) );
   sbuf.append( getNEM (ctx.getChild(2) ) );
   setNEM(ctx, sbuf.toString() );
   return;
  }
  if (modovCtx.empty()){
   System.out.println( "LOGIC ERROR--exitOverment" );
   System.out.println( "modovCtx is empty!" );
   System.exit( 0 );
  }
  if (ctx == modovCtx.peek()){
   if (debugLimits) System.out.println( "mover context match!" );
  } else {
   System.out.println( "WARNING mover context DOES NOT match!" );
  }
  // Cnt is total movder+movderOver while size is number not yet done
  //xorder is additional indicators needed
  int xorder = moverCnt-modovCtx.size();
  String start =  modOpen;
  String indy = dirOver;
  for (int i=0; i<xorder; i++){
   indy = indy+dirOver;
  }
  String term = modTerm;
  StringBuilder buf = new StringBuilder();
  //Outermost uses all five steps of Nemeth Rule XIV, Sec. 86 a.
  if (modovCtx.size() == 1){
   buf.append( start );
   buf.append( getNEM (ctx.getChild(1) ) );
   buf.append( indy );
   buf.append( getNEM (ctx.getChild(2) ) );
   buf.append( term );
   setNEM(ctx, buf.toString() );
  } else {
   buf.append( getNEM (ctx.getChild(1) ) );
   buf.append( indy );
   buf.append( getNEM (ctx.getChild(2) ) );
   setNEM(ctx, buf.toString() );
  //} else {
   //System.out.println( "munder nest not available: "+modunCtx.size() );
   //setNEM(ctx, "" );
  }
  
  modovCtx.pop();
}
//===============================================
//   Mroot and Msqrt processing starts here
//===============================================
@Override
 public void enterRootment(mmlParser.RootmentContext ctx) { 
 rootEls.push( ctx );
 String strt = radical;
 String term = radicalTerm;
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
 if (debugTokment) System.out.println( " enterTokment" );
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
  String possAtt = "";
  if (cnt > 8) possAtt = ctx.getChild(2).getText();
  //Count back from end always the same whether or not
  //there are attributes
  int textPos = cnt-5;
  String tokType = ctx.getChild(1).getText();
  if (debugTokment) System.out.println( "tokType: |"+tokType+"|");
  String info = null;
  String ink = ctx.getChild( textPos ).getText();;
  if (tokType.equals( "mn" )){
   //System.out.println( "tokment mn input: "+ink );
   info = Numeric.transNum( ink, possAtt, true );
  } else if (tokType.equals( "mi" )){
   info = Letter.transVar( ink, possAtt );
  } else if (tokType.equals( "mo" )){
   if (debugTokment) System.out.println( "ss ink: |"+ink+"|");
   info = SpecialSymbol.getBraille( ink, possAtt, spaceCmprSymbols );
  } else {
   info = ctx.getChild(1).getText()+
   ":"+ctx.getChild(textPos).getText();
   if (debugTokment){
    System.out.println( "tokment info: "+ctx.getChild(1).getText()+
       ":"+ctx.getChild(textPos).getText() );
   }
  
  }
 if (debugTokment) System.out.println( "tokment info: "+info );
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
 //System.out.println( "EXITING ROWMENT Text: "+ctx.getText()+
    //" no. of children: "+cnt );
  System.out.println( "Rowment child count: "+cnt );

    StringBuilder buf = new StringBuilder();
    if (addCurlies2Row) buf.append( "{" );
    buf.append( nem.get(ctx.getChild(1) ) );
    //for (int i=3; i<4;i++){
     //String tmp = ctx.getChild( i).getText();
     //buf.append( nem.get(ctx.getChild(i) ) );
    //}
    if (addCurlies2Row) buf.append( "}");
    System.out.println( "Row output: "+buf.toString() );
    setNEM( ctx, buf.toString() );
    return;
 
}
@Override
 public void exitElement(mmlParser.ElementContext ctx) {
  String name=tagName( ctx.getText() ); 
  System.out.println( "\n      EXITING ELEMENT: "+name );   
 
  if(name.startsWith( "math" )){
    StringBuilder buf = new StringBuilder();
    int last = 4;   //ONLY WORKS IF MATH HAS ONE CHILD
  System.out.println( "math child cnt: "+ctx.getChildCount() );
  int toSave = ctx.getChildCount()-5;
  //for (int i=3; i<last;i++){
     buf.append( nem.get(ctx.getChild(toSave) ) );
  //}
    setNEM( ctx, buf.toString() );
    System.out.println( "$$$math element saved: "+buf.toString() );
    String nembrl = NIFixer.fixNI4Linear(buf.toString());
    myOutput.out( "<p>Nemeth translation: </br><span class=\"sm\">"+
                 nembrl+"</span></br>" );
    myOutput.out( "<span class=\"cn\">"+
                 nembrl+"</span></p>");
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
    if (  parentTag.startsWith( "mrow" ) 
       || parentTag.startsWith( "math" )
       || parentTag.startsWith( "msqrt" )
       || parentTag.startsWith( "mroot" )
       || parentTag.startsWith( "document" )
       ){
      StringBuilder buf = new StringBuilder();
      String childInfo;
      for (int i=0; i<ctx.getChildCount();i++){
        childName = tagName( ctx.getChild(i) );
        if (childName != null && !childName.equals( "justWS" )){
          childInfo = getNEM( ctx.getChild(i));
if (childInfo == null){
        if( deContent){
        System.out.println( "child--Name: "+childName+
                 " Info: |"+childInfo+"|" );
        }
}
  
          buf.append( childInfo );
          if (deContent){
            System.out.println( "child--Name: "+childName+
                 " Info: |"+childInfo+"|" );
          }
        }
      }
   if( deContent) System.out.println( "exitContent--trans: "+buf.toString() );
    setNEM( ctx, buf.toString() );
   } else {
      if( deContent){
       System.out.println( "exitContent, parent: "+parentTag );
      }
   }
 }
public static void explain( boolean shortOnly ){
 myOutput.out( "<p>This"+
  " translation of the MathML input to"+
  " the Nemeth braille math output"+
  " was produced automatically by "+
  " <a href=\"https://github.com/SusanJ/MML2Nem\">MML2Nem</a>.</p>" );
  if (shortOnly) return;
  myOutput.out(
  " <p>MML2Nem is a new  Java application that "+
  " uses a two-step process"+
  " to convert MathML to braille math."+
  " The first step analyzes the MathML input"+
  " using an ANTLR 4 parser for MathML. The parser was "+
  " generated from a MathML grammar created for this project by"+
  " extending Terence Parr's generic XML grammar."+
  " The second step translates the parser output "+
  " to braille using a  procedure implemented"+  
  " in Java. "+ 
  " (This webpage utilizes"+
  " <a href=\"https://www.mathjax.org/\">MathJax<a> for"+
  " rendering since MathJax can display MathML mathematics"+
  " in any browser. Click on the rendered MathML for options to"+
  " view the actual MathML input. )</p>"); 
}
 
//===========================================================
  public static void main( String[] args ) throws Exception {
//===========================================================

 System.out.println( "\n    Welcome to MML2Nem Translator!" );
 
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
    myOutput.mjHeader( "MML2Nem Test Page" );
    myOutput.setAddFooter( true );

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
         if (showParseTree){
          System.out.println( "     PARSE TREE: ");
          System.out.println( x );
         } 
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
     myOutput.finishTape6( true );  

 }//End Main.
}//End Class MMLproc.