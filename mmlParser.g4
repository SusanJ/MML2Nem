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

/** XML parser derived from ANTLR v4 ref guide book example */

parser grammar mmlParser;
@parser::header{ package mml; }
options { tokenVocab = mmlLexer; }
tokens {MATH, MSQRT }

document    :   prolog? misc* element misc*;

prolog      :   XMLDeclOpen attribute* SPECIAL_CLOSE ;

rcontent     :   chardata?
                ((rowment)
                 chardata?)+ ;

content     :   chardata?
                ((fracment|supment|subment|layment|rowment|tokment| element 
                  | reference | CDATA | PI | COMMENT)
                 chardata?)* ;

fraccontent:  justWS? (fracment | supment |subment| layment|rowment|tokment| element ) justWS? ;
                              

   //Just for now not allowing attributes on my new elements

supment     : msupStart (fraccontent fraccontent) msupEnd;
msupStart   : OPEN MSUP attribute* '>' ;
msupEnd     : OPEN SLASH MSUP '>' ;

subment     : msubStart (fraccontent fraccontent) msubEnd;
msubStart   : OPEN MSUB attribute* '>' ;
msubEnd     : OPEN SLASH MSUB '>' ;



layment     :   OPEN LAY attribute* '>' content OPEN SLASH LAY '>'
            //|   '<' Name attribute* '/>'
            ;

fracment     : mfracStart (fraccontent fraccontent) mfracEnd;
mfracStart   : OPEN MFRAC attribute* '>' ;
mfracEnd     : OPEN SLASH MFRAC '>' ;


rowment     :   mrowStart (rcontent|content) mrowEnd
            //|   '<' Name attribute* '/>'
            ;
mrowStart   : OPEN ROW attribute* '>' ;
mrowEnd     : OPEN SLASH ROW '>' ;

//Token elements can only have chardata as a child
tokment     :   OPEN tok attribute* '>' chardata OPEN SLASH tok '>'
            //|   '<' Name attribute* '/>'
            ;


//element     :   (OPEN|MY_OPEN) Name attribute* '>' content OPEN  SLASH Name '>'
           // |   (OPEN|MY_OPEN) Name attribute* '/>'
            //|   
//APLUSstag content UEB_DONE
            //;
element     :   OPEN Name attribute* '>' content OPEN  SLASH Name '>'
            |   OPEN Name attribute* '/>'
            ;


//opara mtext epara

reference   :   EntityRef | CharRef ;

attribute   :   Name '=' STRING ; // Our STRING is AttValue in spec

/** ``All text that is not markup constitutes the character data of
 *  the document.''
 */
//justWS      :   SEA_WS|XSEA_WS  ;
justWS      :   SEA_WS;

tok: MI|MN|MO;

//chardata    :   TEXT | justWS |brlstuff;
chardata    :  INTEG # integer
               | TEXT # text
               | justWS  # whitespace
               ;

misc : COMMENT | PI | SEA_WS ;

//brlstuff: (THE| LETTERA );