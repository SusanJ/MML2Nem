package nemdata;
import java.util.HashMap;
public class SpecialSymbol {

/**
 Technical Note
   This class does not yet different results
   for operators indicated to be in boldface
   per MathML attributes.
*/

 enum SymbolCategory {MISC, MULT_DIV, ADD_SUB, COMPARISON};

 static final SpecialSymbol [] miscTable = {

   //Dots-456Rule XXII Miscellaneous Symbols
  new SpecialSymbol("_<", "&#x02C6;"), //Circumflex (Caret)
  new SpecialSymbol("_%", "&#x02C7;"), //Caron (Inverted Caret)
  new SpecialSymbol("_8", "&#x2207"),   //Combining question mark
  new SpecialSymbol("_0", "&#x2207"),   //Empty set
   //Dot-4 miscellaneous symbols
  new SpecialSymbol( "@,a", "&#x212B;"),    //Angstrom Unit
  new SpecialSymbol( "@,r", "&#x211E;"),    //Crossed R
  new SpecialSymbol( "@,p", "&#x00B6;"),    //Paragraph mark
  new SpecialSymbol( "@,s", "&#x00A7;"),    //Section mark
  new SpecialSymbol( "@a",  "@"),           // @
  new SpecialSymbol( "@e",  "&#x2208;"),    //element of 
  new SpecialSymbol( "@c",  "&#x00A2;"),    //cent 
  new SpecialSymbol( "@>",  "&#x00A2;"),    //Check mark
  new SpecialSymbol( "@$",  "&#x0111;"),    //Crossed d
  new SpecialSymbol( "@h",  "&#x0127;"),    //Crossed h
  new SpecialSymbol( "@s",  "$"),           //$
  new SpecialSymbol( "@0",  "%"),           //Percent sign
  new SpecialSymbol( "@d",  "&#x2202;"),    //Partial derivative
  new SpecialSymbol( "@=\\","exists"),      //Existential 
//quantifier ???  
  
  new SpecialSymbol( "@.l", "&#x00A2;"),    //Crossed lambda

  new SpecialSymbol( "&",    "!" ), // Factorial
  new SpecialSymbol( "=",    "?" ), // General omission
  new SpecialSymbol( "!",    "&#x222B;" ),  // Single integral
  new SpecialSymbol( "!!",   "&#x222C;" ),  // Double integral
  new SpecialSymbol( "!!!",  "&#x222D;" ),  // Triple integral
  new SpecialSymbol( "!@$c]","&#x222E;" ),  // Cont. integral
   // Int. with sup. square
  new SpecialSymbol( "!@$4]", "&#x2A16;" ), 

    // Int. with sup. rect.     
  new SpecialSymbol( "!@$r]", "{Int. w/ rect.}", false ), 
   // Int. with sup. infinity
  new SpecialSymbol( "!@,=]", "{Int. w/ inf.}", false ),

  new SpecialSymbol( "^.*",   "&#x00B0;" ), // Degrees (super)
  new SpecialSymbol( "^.*\"", "&#x00B0;" ), // Degrees (super)    
  new SpecialSymbol( "'",     "&#x2032;" ), // Single prime
  new SpecialSymbol( "''",    "&#x2033;" ), // Double prime
  new SpecialSymbol( ",=",    "&#x221E;" ), // Infinity

  new SpecialSymbol( "$--o",  "&#x2192;" ), // Rt. pting arrow
  new SpecialSymbol( "$o",    "&#x2192;" ), // Con.rt. pting arrow
  new SpecialSymbol( "$[--",  "&#x2190;" ), // Lft. pting arrow 
  new SpecialSymbol( "$[--o", "&#x2194;" ), // R&l pting arrow 
  new SpecialSymbol( "$<--o", "&#x2191;" ), // Up pting arrow 
  new SpecialSymbol( "$%--o", "&#x2193;" ), // Dwn. pting arrow 
  new SpecialSymbol( "$[--o", "&#x2195;" ),  // Up&dwn. pting arrow 

  new SpecialSymbol( ":", "&#x000AF;" ), //Overbar or macron

  new SpecialSymbol( "_4", "." )   //Period punctuation
 };

 static final SpecialSymbol [] addSubTable = {

  new  SpecialSymbol( "+",    "+" ),          // Plus
     // Plus followed by multi-purp. ind.
  new  SpecialSymbol( "+\"",  "+" ),   
  new  SpecialSymbol( "_+",   "+" ),   // Bold plus 
    // Bold plus followed by multi-purp. ind.
  new  SpecialSymbol( "_+\"", "+" ),   
  new  SpecialSymbol( "+-",   "&#x00B1;" ),    // Plus-minus
  new  SpecialSymbol( "-+", "&#x2213;" ),  // Minus-plus
  //new  SpecialSymbol( "+\"-", "+-" ),        // Plus foll. by minus
  //new  SpecialSymbol( "+\"-", "+<b>-</b>" ), // Plus foll. by bf minus
  new  SpecialSymbol( "-",    "-" ),  // Minus
  new  SpecialSymbol( "-",    "&#x2212;" ),  // Minus
    //Minus followed by multi-purp. ind.
  new  SpecialSymbol( "-\"",  "-" ),  
  new  SpecialSymbol( "_-",   "-" ),  // Bold minus
    //Bold minus followed by multi-purp. ind.
  new  SpecialSymbol( "_-\"", "-" ), 

    //Division symbol Rule XXIV Sec. 180 c(8)
  new  SpecialSymbol( "O",  ")" ), 
    //Division symbol Rule XXIV Sec. 180 c(8)     
  new  SpecialSymbol( "o",  ")" ),     
  new  SpecialSymbol( "*",  "&#x22C5;" ),  //Dot operator
  new  SpecialSymbol( ">",  "&#x221A;" ),  //Tilde (or widetilde)
  new  SpecialSymbol( "@#", "*" )         //asterisk
};

  static final SpecialSymbol [] cmprTable = {
    //Cell No. 60  Dot-5
  new  SpecialSymbol( ".k",   "="    ),      //equals
  new  SpecialSymbol( "/.k",  "&#x2260;"    ),      //not equal
  new  SpecialSymbol( "\"k",  "&lt;"    ),   //less than
  new  SpecialSymbol( "\"k:", "&#x2264;" ),  //less than or equals
  new  SpecialSymbol( "\"1",  "&#x2236;" ),  //ratio  
   new  SpecialSymbol( ";2",  "&#x2237;" ),  //Proportion 
    //Cell No. 61  Dots-46
  new  SpecialSymbol( ".1",   "&gt;" ),      //greater than
  new  SpecialSymbol( ".1:",  "&#x2265;" )   //greater than w/ bar under
 };



 static HashMap<String,SpecialSymbol> symbolTable = 
    new HashMap<String,SpecialSymbol> ();
 static HashMap<String,SpecialSymbol> ink2NemTable = 
    new HashMap<String,SpecialSymbol> ();
 static boolean tablesDone = makeTables();

 String brl;
 String htmlEntity; //Description only if ink is false.
 boolean ink = true;
 SymbolCategory sc;

 public SpecialSymbol( String brl, String htmlEntity ){
  this.brl = brl;
  this.htmlEntity = htmlEntity;
 }
 // Cases where Nemeth has symbols that AFAIK 
 //don't actually exist
 SpecialSymbol( String brl, String htmlEntity, boolean ink ){
  this( brl, htmlEntity );
  this.ink = ink;
 }
 String getBrl(){ return brl; }
 String getHtmlEntity(){ return htmlEntity; }
 void setSymbolCategory( SymbolCategory sc ){
  this.sc = sc;
 }
 SymbolCategory getSymbolCategory(){ return sc; }
 public static boolean makeTables(){
  SymbolCategory sc = SymbolCategory.MISC;
  SpecialSymbol sym;
  for (int i=0; i<miscTable.length; i++){
   sym = miscTable[i];
   sym.setSymbolCategory( sc );
   symbolTable.put( sym.getBrl(), sym );
   ink2NemTable.put( sym.getHtmlEntity(), sym );
  }
  sc = SymbolCategory.ADD_SUB;
  for (int i=0; i<addSubTable.length; i++){
   sym = addSubTable[i];
   sym.setSymbolCategory( sc );
   symbolTable.put( sym.getBrl(), sym );
   ink2NemTable.put( sym.getHtmlEntity(), sym );
  }
  sc = SymbolCategory.COMPARISON;
  for (int i=0; i<cmprTable.length; i++){
   sym = cmprTable[i];
   sym.setSymbolCategory( sc );
   symbolTable.put( sym.getBrl(), sym );
   ink2NemTable.put( sym.getHtmlEntity(), sym );
  }
  return true;
 }
 public static String getEntity( String brl ){
  String trimBrl = brl.trim();
  SpecialSymbol sym = symbolTable.get( trimBrl );
  if (sym != null){
   
   return sym.getHtmlEntity();
  }
  return null;
 }
 //
 public static String getBraille( String symOrEntity, String att,
    boolean spaceCmpr ){
  SpecialSymbol sym = ink2NemTable.get( symOrEntity );
  if (sym != null){
   SymbolCategory sc = sym.getSymbolCategory();
   if (sc == SymbolCategory.COMPARISON && spaceCmpr){
    return " "+sym.getBrl()+" ";
   } else {
   return sym.getBrl();
   }
  }
  System.out.println( "WARNING--SpecialSymbol--no braille for print: "
        +symOrEntity );
  return null;
 }
}//End Class SpecialSymbol;
