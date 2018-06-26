package nemdata;
import java.util.HashMap;

public class Letter{
 /**  Translate English letters from print to braille
   using Nemeth Rule III Sec. 20 for capital letters
   in math.
 */
 public static final Letter [] letters = {
  new Letter( "a", "A" ),
  new Letter( "b", "B" ),
  new Letter( "c", "C" ),
  new Letter( "d", "D" ),
  new Letter( "e", "E" ),
  new Letter( "f", "F" ),
  new Letter( "g", "G" ),
  new Letter( "h", "H" ),
  new Letter( "i", "I" ),
  new Letter( "j", "J" ),
  new Letter( "k", "K" ),
  new Letter( "l", "L" ),
  new Letter( "m", "M" ),
  new Letter( "n", "N" ),
  new Letter( "o", "O" ),
  new Letter( "p", "P" ),
  new Letter( "q", "Q" ),
  new Letter( "r", "R" ),
  new Letter( "s", "S" ),
  new Letter( "t", "T" ),
  new Letter( "u", "U" ),
  new Letter( "v", "V" ),
  new Letter( "w", "W" ),
  new Letter( "x", "X" ),
  new Letter( "y", "Y" ),
  new Letter( "z", "Z" )
 };

 static boolean debug = false;
   //Hard-wired!!!!
 public static final String singleCaps = ",";

 public static final String boldEngLetInd = "_;";
 public static final String italicEngLetInd = ".;";

 static boolean tableDone; // = makeTable( true );

 public static HashMap<String,String> inkLet2Brl = 
           new HashMap<String,String>();

 String lcInk;
 String lcBrl;
 String ucInk;
 String scUcBrl;

 public Letter( String lcInk, String ucInk ){
  this.lcInk = lcInk;
  this.lcBrl = lcInk;
  this.ucInk = ucInk;
  StringBuilder buf = new StringBuilder();
  //buf.append( "," );
  buf.append( singleCaps );
  buf.append( lcBrl );
  scUcBrl = buf.toString();
  //System.out.println( "scUcBrl: "+buf.toString()+" "+scUcBrl );
 }

 String getLcInk(){ return lcInk; }
 String getLcBrl(){ return lcBrl; }
 String getUcInk(){ return ucInk; }
 public String getScUcBrl(){ return scUcBrl; }

 public static boolean makeTable( boolean display ){
  //if (tableDone) return true;
  if (display){
   System.out.println( "len: "+letters.length+" sc: "+singleCaps );
  }
  for (int l = 0; l<letters.length; l++){
   Letter let = letters[l];
   inkLet2Brl.put( let.getLcInk(), let.getLcBrl() );
   inkLet2Brl.put( let.getUcInk(), let.getScUcBrl() );
  }
  if (display) System.out.println( "Letter table made with X: "+
     getBrl( "X" )  );
  return true;
 }
 static String getBrl( String key ){
   return inkLet2Brl.get( key );
 }

 //TO-DO Greek letters, italic for English letters, bold for both
 //Per Rule V, Sec. 32 d. it seems that in mathematical expressions the
 // bold letter symbol is used for each letter [Note that the useage
 // differs for digits and compound items]
 public static String transVar( String seq, String attributes ){
   boolean bold = false;
   if (attributes != null & debug ){
    System.out.println( "Letter.transVar--atts|"+attributes+
      "| def: "+Numeric.boldAtt);
   }
   if (attributes.equals( Numeric.boldAtt)){
    System.out.println( "Letter.transVar -- bold attribute." );
    bold = true;
   }
   StringBuilder buf = new StringBuilder();
   String brl;
   for (int s=0; s<seq.length();s++){
    brl = getBrl( seq.substring(s,s+1));
    if (brl == null){
     System.out.println( "Letter.transVar(): Cannot find "+
       "braille for: |"+seq.substring(s,s+1));
    } else {
     if (bold) buf.append( boldEngLetInd );
     buf.append( brl );
    }
   }
   return buf.toString();
  }
public static void main( String [] args ){
 makeTable( true );
}
}//End Class Letter.
