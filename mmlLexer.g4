
/*
 [The "BSD licence"]
 Copyright (c) 2013 Terence Parr
 All rights reserved.
 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.
 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

/** XML lexer derived from ANTLR v4 ref guide book example */
lexer grammar mmlLexer;
@lexer::header{ package mml; 
import java.util.HashMap;
import java.util.Map;
}
@lexer::members {   // place this class member only in lexer
Map<String,Integer> mmltags = new HashMap<String,Integer>() {{
    put("math",  mmlParser.MATH);
    put("msqrt", mmlParser.MSQRT);
    put("mn",    mmlParser.MN);
    put("mo",    mmlParser.MO);
    put("mi",    mmlParser.MI);
}};
}


// Default "mode": Everything OUTSIDE of a tag
COMMENT     :   '<!--' .*? '-->' ;
CDATA       :   '<![CDATA[' .*? ']]>' ;
/** Scarf all DTD stuff, Entity Declarations like <!ENTITY ...>,
 *  and Notation Declarations <!NOTATION ...>
 */
DTD         :   '<!' .*? '>'            -> skip ;
EntityRef   :   '&' Name ';' ;
CharRef     :   '&#' DIGIT+ ';'
            |   '&#x' HEXDIGIT+ ';'
            ;
fragment WHITE_SPACE: (' '|'\t'|'\r'? '\n')+ ;
SEA_WS: WHITE_SPACE;
//SEA_WS      :   (' '|'\t'|'\r'? '\n')+ ;

//START_PARA   :   '<p>' -> pushMode(APLUS) ;
// :   '</p>' -> popMode;

//APLUS: '<aplus>' -> pushMode(UEB);
fragment LESS_THAN: '<';
OPEN        :   LESS_THAN                    -> pushMode(INSIDE) ;

//OPEN        :   '<'                     -> pushMode(INSIDE) ;
XMLDeclOpen :   '<?xml' S               -> pushMode(INSIDE) ;
SPECIAL_OPEN:   '<?' Name               -> more, pushMode(PROC_INSTR) ;

INTEG : DIGIT+;
TEXT        :   ~[<&]+ ;        // match any 16 bit char other than < and &
//ASC_TEXT ???

// ----------------- Everything INSIDE of a tag ---------------------
mode INSIDE;

CLOSE       :   '>'                     -> popMode ;
SPECIAL_CLOSE:  '?>'                    -> popMode ; // close <?xml...?>
SLASH_CLOSE :   '/>'                    -> popMode ;
SLASH       :   '/' ;
EQUALS      :   '=' ;
STRING      :   '"' ~[<"]* '"'
            |   '\'' ~[<']* '\''
            ;
MFRAC       :   'mfrac';
MSUP        :   'msup';
MSUBSUP     :   'msubsup' ;
MSUB        :   'msub';
MSQRT       :   'msqrt';
MROOT       :   'mroot';
MUNDER      :   'munder';
LAY         :   'mover'|'munderover';
ROW         :   'mrow';
MO          :   'mo';
MN          :   'mn';
MI          :   'mi'; 
Name        :   NameStartChar NameChar* ;
S           :   [ \t\r\n]               -> skip ;

fragment
HEXDIGIT    :   [a-fA-F0-9] ;

fragment
DIGIT       :   [0-9] ;

fragment
NameChar    :   NameStartChar
            |   '-' | '_' | '.' | DIGIT
            |   '\u00B7'
            |   '\u0300'..'\u036F'
            |   '\u203F'..'\u2040'
            ;

fragment
NameStartChar
            :   [:a-zA-Z]
            |   '\u2070'..'\u218F'
            |   '\u2C00'..'\u2FEF'
            |   '\u3001'..'\uD7FF'
            |   '\uF900'..'\uFDCF'
            |   '\uFDF0'..'\uFFFD'
            ;

// ----------------- Handle <? ... ?> ---------------------
mode PROC_INSTR;

PI          :   '?>'                    -> popMode ; // close <?...?>
IGNORE : . -> more ;

//mode UEB;
//UEB_DONE: '</aplus>' -> popMode ;
//THE: 'the'|'The';
//A: 'a';
//C: 'c';
//T: 't';
//XSEA_WS: WHITE_SPACE;
//MY_OPEN        :   '<'  -> pushMode(INSIDE) ;

