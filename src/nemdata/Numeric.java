package nemdata;
import java.util.HashMap;

public class Numeric{

 //  Translate MathML Number (mn) token lement to
 // Nemeth Rule II Numeric Signs and Symbols
 // Per Sec. 12 Letters in non-decimal numbers must be lowercase
 static final Numeric [] numTable = {
  new Numeric( "#", "#", "en eye" ),  //Numeric Indicator (N.I.)
  new Numeric( ",", ",", "comma" ), new Numeric( ".", ".", "point" ),
  new Numeric( "0", "0", "zero" ),  new Numeric( "1", "1", "one" ),
  new Numeric( "2", "2", "two" ),   new Numeric( "3", "3", "three" ),
  new Numeric( "4", "4", "four" ),  new Numeric( "5", "5", "five" ),
  new Numeric( "6", "6", "six" ),   new Numeric( "7", "7", "seven" ),
  new Numeric( "8", "8", "eight" ), new Numeric( "9", "9", "nine" ),
  new Numeric( "A", "a", "aye"),    new Numeric( "a", "a", "aye"),
  new Numeric( "B", "b", "bee"),    new Numeric( "b", "b", "bee"),
  new Numeric( "C", "c", "see"),    new Numeric( "c", "c", "see"),
  new Numeric( "D", "d", "dee"),    new Numeric( "d", "d", "dee"),
  new Numeric( "E", "e", "eee"),    new Numeric( "e", "e", "eee"),
  new Numeric( "F", "f", "ef"),    new Numeric(  "f", "f", "ef")
 };

  static final String nemBoldSymInd = "_#";
  static final String nemItalSymInd = ".#";
  static final String numericIndicator = "#";
  static boolean debug = false;
  static String ginky;

 /** MathML token attributes
    fontweight  normal | bold 
    fontstyle  	normal | italic
 */

  //It's possible you can't have two tf's in Nemeth???
  static String smnTag     = "<mn>";
  static String sBOLDmnTag = "<mn fontweight=\"bold\">";
  static String sITALmnTag = "<mn fontstyle=\"italic\">";
  static String sBOLDITALmnTag = 
    "<mn fontweight=\"bold\" fontstyle=\"italic\">";
  static String emnTag = "</mn>";

  static HashMap<String,Numeric> numericItems =
     new HashMap<String,Numeric>();

  static boolean tableDone = makeTable( true );

  String brl;
  String boldBrl;
  String italBrl;
  String bolditalBrl;
  String italboldBrl;
  String ink;
  String speech;

 Numeric( String ink, String brl, String speech ){
   this.ink = ink;
   this.brl = brl;
   this.speech = speech;
  }
  String getBrl(){ return brl; };
  String getInk(){ return ink; };
//----------------------------------------------
  public static boolean makeTable( boolean display ){
   if (tableDone) {
     if (display) {
      System.out.println( " Numeric table size: "+
      numericItems.size() );
     }
     return true;
   }
   for (int i=0; i<numTable.length; i++){
    Numeric item = numTable[i];
    numericItems.put( item.getInk(), item );
   }
   if (display) {
      System.out.println( " Numeric table size: "+
     numericItems.size() );
   }
   return true;
  }
  static String getBrl( String key ){
   Numeric value = numericItems.get( key );
   if (value == null) return "";
   return numericItems.get( key ).getBrl();
  }
  public static String transNum( String seq, boolean ni ){
   StringBuilder buf = new StringBuilder();
   if (ni) buf.append( numericIndicator );
   String brl;
   for (int s=0; s<seq.length();s++){
    brl = getBrl( seq.substring(s,s+1));
    if (brl == null){
     System.out.println( "Numeric--transNum(): Cannot find "+
       "braille for: |"+seq.substring(s,s+1));
    } else {
     buf.append( brl );
    }
   }
   return buf.toString();
  }
/**
  public static String transTok2Num( String seq, String attribute ){
   if (seq.startsWith( nemBoldSymInd )){
    if (seq.length() < 3) return null;
    return btBoldNum2Tok( seq.substring(2), lead );
   }
   if (seq.startsWith( nemItalSymInd )){
    if (seq.length() < 3) return null;
    return btItalNum2Tok( seq.substring(2), lead );
   }
   return "";
   }

  public static String btBoldNum2Tok( String seq, boolean lead ){
   String ink = backTransNum( seq, lead );
   if (ink == null) return null;
   return sBOLDmnTag+ink+emnTag;
  }
  public static String btItalNum2Tok( String seq, boolean lead ){
   String ink = backTransNum( seq, lead );
   if (ink == null) return null;
   return sITALmnTag+ink+emnTag;
  }
*/
public static void main( String [] args ){
 makeTable( true );
 String ink = "1";
 String brl = getBrl( ink );
 System.out.println( "brl: "+brl+" ink: "+ink );
}
}//End Class Numeric.
