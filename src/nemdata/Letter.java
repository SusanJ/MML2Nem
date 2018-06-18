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
   //Hard-wired!!!!
 public static String singleCaps = ",";
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
  this.scUcBrl = singleCaps+lcBrl;
 }

 String getLcInk(){ return lcInk; }
 String getLcBrl(){ return lcBrl; }
 String getUcInk(){ return ucInk; }
 String getScUcBrl(){ return scUcBrl; }

 public static boolean makeTable( boolean display ){
  //if (tableDone) return true;
  System.out.println( "len: "+letters.length );
  for (int l = 0; l<letters.length; l++){
   Letter let = letters[l];
   inkLet2Brl.put( let.getLcInk(), let.getLcBrl() );
   inkLet2Brl.put( let.getUcInk(), let.getScUcBrl() );
  }
  if (display) System.out.println( "Letter table made." );
  return true;
 }
 static String getBrl( String key ){
   return inkLet2Brl.get( key );
 }
 public static String transVar( String seq, String attributes ){
   StringBuilder buf = new StringBuilder();
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
public static void main( String [] args ){
 makeTable( true );
}
}//End Class Letter.
