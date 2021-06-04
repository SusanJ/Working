package org.dotlessbraille.transtables;

/**Parameters that indicate where a part-word may
   be used within a word.  Note that UEB does not have
   any contractions that are restricted to the end of a word.
   However, that parameter is included here to support
   the pseudo-partwords used in the DotSys algorithm.
*/
public enum PartWordUse{
 NOT_DEFINED,
 WORD_ONLY, //Shortforms with no part-word use
 ANYWHERE,
 BEG_WORD,
 MID_WORD,
 MID_END_WORD,
 END_WORD,
 NOT_BACK;    //Omit from backtranslation table?
}//End Enum.
 
