package nemdata;

public class NIFixer{

/** When MN tokens are  translated, a unique character
 that functions as a temporary leading numeric
 indicator is placed at the start of the 
 braille numeric item. (Using a unique character
 is intended to differentiate a possible leading numeric 
 indicator from other uses of dots-3456.)
 The fixNI method deletes any of these temporary N.I.'s
 that aren't needed in the full expression
 and replaces the others with the correct character.

 Note that fixNI only applies to linear expressions,
 not matrices or planar arithmetic. It is intended to be
 used prior to any linebreaking.
 
*/

  static final String numericIndicator = "#";

   //Special (not ASCII Braille) character used for N.I. before
   //MN token contents solater can delete those that aren't needed.
  static final String tempNumericIndicator = "~";
  static final String unMinus = "-";
  static final String minusTNI = "-~";
  static final String trailingFlag = "{";

private NIFixer(){;}

public static String fixNI4Linear( String seq ){
 if (seq.length()<3) return seq;

 StringBuilder buf = new StringBuilder();
 
 int i0 = 0;
 String lastChar = seq.substring(0,1);

 //Assume start of sequence retains an N.I.
 if (seq.substring(0,1).equals( tempNumericIndicator )){
   buf.append( numericIndicator );
   i0 = 1;
   lastChar = numericIndicator;

 } else if (seq.substring(0,2).equals( minusTNI )){
   buf.append( unMinus );
   buf.append( numericIndicator );
   i0 = 2;
 //Check for a leading 1-cell flagged special character 
 //that retains a following numeric indicator
 } else if (seq.substring(1,2).equals(trailingFlag)){
   buf.append(seq.substring(0,1) );
   //Omit trailing flag
   if (seq.substring(2,3).equals( tempNumericIndicator )){
    buf.append( numericIndicator );
    i0 = 3;
    lastChar = numericIndicator;
   }
 }

 String currChar = "";
 for (int i=i0; i<seq.length(); i++){
  currChar = seq.substring(i,i+1);
  if (currChar.equals( tempNumericIndicator )){
    if (lastChar.equals( " " )){
      buf.append( numericIndicator );
      lastChar = numericIndicator; //Flagged?
    
     
    } else if (lastChar.equals( trailingFlag )){
      buf.append( numericIndicator );
      lastChar = numericIndicator;//Flagged?
    }

  } else if (lastChar.equals( " " ) && 
             currChar.equals( unMinus )){
     System.out.println( "last: |"+lastChar+"| "+currChar );
     buf.append( currChar );  

  } else if (!currChar.equals(trailingFlag)){
    buf.append( currChar );
    lastChar = currChar; 

  //Append - after space but leave space
  //as "lastChar" to flag retention of N.I.
  
    //Omit flag from revised sequence
  } else {
   lastChar = currChar;
  }

 
 
 }
  return buf.toString();
}
public static void main( String [] args ){
 String seq1 = "~123";
 String res1 = fixNI4Linear( seq1 );
 System.out.println( "seq: "+seq1+" res: "+res1 );
 String seq2 = "~.67";
 String res2 = fixNI4Linear( seq2 );
 System.out.println( "seq: "+seq2+" res: "+res2 );
 String seq3 = "~1+~2 .k ~3";
 String res3 = fixNI4Linear( seq3 );
 System.out.println( "seq: "+seq3+" res: "+res3 );
 String seq4 = "@,s{~4.1";
 String res4 = fixNI4Linear( seq4 );
 System.out.println( "seq: "+seq4+" res: "+res4 );
 String seq5 = "-~78";
 String res5 = fixNI4Linear( seq5 );
 System.out.println( "seq: "+seq5+" res: "+res5 );
 String seq6 = "~1+~2 .k -~3";
 String res6 = fixNI4Linear( seq6 );
 System.out.println( "seq: "+seq6+" res: "+res6 );
}
}//End Class NIFixer.