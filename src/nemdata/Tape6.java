package nemdata;
import java.io.*;
import java.nio.charset.Charset;
/**OUTPUT: Manages output files using 
   Java OutputStreamWriter and PrintWriter.
   Optionally adds a header to the file upon
   opening and a footer upon closing.
*/
public class Tape6 {

  public static final String END_FONT  = "</span>";
  public static final String XB_FONT   = " <span class=\"xb\">";

          /**XML entity for apostrophe character.*/
 static final String XML_APOS = "&apos;";

          /**XML entity for ampersand character.*/
 static final String XML_AMP  = "&amp;";

          /**XML entity for greater than character.*/
 static final String XML_GT   = "&gt;";

          /**XML entity for less than character.*/
 static final String XML_LT   = "&lt;";

          /**XML entity for neutral double quotes character.*/
 static final String XML_QUOT = "&quot;";

/**Maximum number of files that can be handled.
   [Using a dynamically-allocated array didn't
   seem worth it.]
*/
   static final int MAX_FILES = 20;

/**List of output files.*/
   static Tape6 [] fileList = new Tape6 [MAX_FILES];

/**Index into <code>fileList</code> of the last
   output file added to the list.*/
   static int fileIndex = -1;

/**Java FileWriter, see API.*/
   //FileWriter file;
   OutputStreamWriter file;

/**Java PrintWriter, see API.*/
   PrintWriter myout; 

/**Name of file.*/
   String fileName;

/**Flag that when false indicates the file has
   not been opened and any attempts to write to
   the file should be ignored. */
   boolean verbose = true;

/**Flag that when true causes certain information
   to be appended to the file just before 
   closing it.  */
   boolean addFooter = false;
//=============================================
/**Creates local output file with supplied 
   name.

   @param name Filename including extension.
*/
public Tape6 (String name){
  fileName = name;
  standard();
}//End Constructor.
//...............................................
/**Creates output file, adds boilerplate to
   the beginning of the file, and sets flag
   for adding footer to file.  Intended for 
   creating HTML files. 
 
   @param name   Filename.
   @param header Name of file containing 
                 boilerplate.  This file will
                 be opened and then closed by
                 the constructor.  It cannot
                 be open initially.                        
*/
public Tape6 (String name, String header){
  this (name);
  //withHeader (header);
  addFooter = true;
}//End Constructor.
//=============================================
/**Creates optional output file.  If file is
   to be used, adds boilerplate to
   the beginning of the file. 
 
   @param name      Filename.
   @param header    Name of file containing 
                    boilerplate.  This file will
                    be opened and then closed by
                    the constructor.  It cannot
                    be open initially. 
   @param verbose   Parameter that when true
                    treats file normally.  When
                    false creates dummy file.
                    Useful for optional output.                     
*/
public Tape6 (String name, String header,
              boolean verbose){
  this (name, header);
  this.verbose = verbose;
}//End Constructor.
//=============================================
private void standard (){
  try { 
    //fileName = name; 
    //file = new FileWriter( fileName );  
    file = new OutputStreamWriter(new FileOutputStream(fileName), 
                                  Charset.forName("UTF-8"));
    myout = new PrintWriter( file );
    fileIndex = fileIndex + 1;
    if (fileIndex < MAX_FILES){
       fileList[fileIndex] = this;
    } else {
//    There's probably a way to expand 
//    this array....
      System.out.println("TAPE6--Too many files.");
    } 
  } catch (java.io.IOException e) {  
    System.out.println ("Problem creating "+ 
                         fileName); 
    System.exit(0);
  }  
}
//=============================================
/**MathJax header.
*/
public void mjHeader( String myTitle ){
 //StringBuilder buf = new StringBuilder();
 //out( myTitle );
 out( "<!DOCTYPE html>" );
 out( "<html>" );
 out( "<head>" ); 
 out( "<title>"+myTitle+"</title>" );
 out( "<script type=\"text/javascript\"" );
 out( "src=\"https://cdnjs.cloudflare.com/ajax/libs/mathjax"+
      "/2.7.1/MathJax.js?config=MML_SVG\">" );
 out( "</script>" );
 out( "<style type=\"text/css\">" );
 out( ".sm {font-size: 18pt; font-family:SimBraille}" );
 out( ".cn {font-size: 20pt; font-family: 'Courier New'}" );
 out( "</style>" );
 out( "<head>" );
 out( "<body>" );

//this.out (buf.toString());
}
//  Fixes ASCII Braille String (or anything actually)
// by replacing (espcaping( any XML reserved 
// characters with the correct entities
public void outFix( String stag, String line, String etag ){
 String fixed = fixABrl( line );
 out(  stag+line+etag );
}
static String fixABrl( String aString ){
 StringBuilder buf = new StringBuilder();
 char [] aCharArray = aString.toCharArray();
 for (int c = 0; c<aCharArray.length; c++){
  buf.append( fixXMLText( aCharArray[c] ));
 }
 return buf.toString();
}
private static String fixXMLText( char a ){
 switch (a){
  case '&':
   return XML_AMP;
  case '\'':
   return XML_APOS;
  case '>':
   return XML_GT;
  case '<':
   return XML_LT;
  case '"':
   return XML_QUOT;
  default:
   return String.valueOf( a );
 }
}
/**Copies the specified file to this file.
   @param  header  Filename of file to be copied;
                   file must not be open and will be
                   closed after it is copied.

  private void withHeader (String header){
  Tape5 head = new Tape5(header);
  String lh = head.in();
  while (lh != null){
    this.out (lh);
    lh = head.in();
  }
  head.finish();
}
*/
//-------------------------------------------------
/**Optionally drives constructor.*/
static public Tape6 optTape6 (String name, 
                              String header, 
                              boolean x){
if (!x) return null;
return new Tape6 (name, header);
}
//-------------------------------------------------
/**Writes one line to this file.

   @param line   Line to be output.
*/
public void out (String line){
    if (verbose) myout.println(line);  
    return; 
}//End out().
public void println (String line){
 out (line);
}
//-------------------------------------------------
/**Outputs to this file a registration line of
   extended braille dots-123456 cells,
   formatted as an HTML paragraph.

   @param  lineLength  Number of cells
                       in line
*/
  public void registrationLine(int lineLength){
  StringBuffer lineOfDots = new StringBuffer();
  for (int i=0; i<lineLength; i++){
       lineOfDots = lineOfDots.append("&#x024C;");
  } 
  out ("<p>" + XB_FONT  + 
               lineOfDots.toString() +
               END_FONT + "</p>");
}//End registrationLine();
//-------------------------------------------------
/**DEPRECATED; IF USEd FOR ONE OUTPUT FILE,
   MUST BE USED FOR ALL.
   Closes this file.
*/
public void finish (){  
    myout.close();  
    return; 
}//End finish().
public void flush (){
 System.out.println ("FLUSH");
 //stackTrace();
 finishTape6( true );
}
public void setAddFooter( boolean foot ){
 addFooter = foot;
}
 
//-------------------------------------------------
/**Close all of the output files that have been
   created.  Add optional footer.
*/
public static void finishTape6 ( boolean af ){
 //System.out.println ( "Output files finished and closed." );
   if (fileIndex < 0) return;
   for (int i=0; i<fileIndex+1; i++){
       if (fileList[i].addFooter || af ){
           fileList[i].out ("</body>");
           fileList[i].out ("</html>");
       }
       fileList[i].myout.close();
   }
}//End finishTape6().      
}//End Class Tape6.