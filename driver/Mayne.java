package org.dotlessbraille.driver;

//Needs Translator class! Also my parser and lexer if not in this package
import org.dotlessbraille.antlr4.uebMathLexer;
import org.dotlessbraille.antlr4.uebMathParser;
//import org.dotlessbraille.antlr4.BackPR;
import org.dotlessbraille.transtables.KeepTrack;
import org.dotlessbraille.indicatoruse.PendingCapInds;
import org.dotlessbraille.manifold.KeepTrack2;
import org.dotlessbraille.utilities.Tape6;
import org.dotlessbraille.jsonInput.ReadJS;


//import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;//
import org.antlr.v4.runtime.CharStreams;//
import org.antlr.v4.runtime.CodePointCharStream;//
import org.antlr.v4.runtime.CommonTokenStream; //
//import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStreamRewriter;

import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.ParseTree;
//import org.antlr.v4.runtime.tree.ParseTreeProperty;
//import org.antlr.v4.runtime.tree.TerminalNode
import java.util.regex.Pattern;
import java.io.File; //
//import java.io.FileInputStream;
//import java.io.InputStream;
import java.io.InputStreamReader;//
import java.io.Reader; //
//import java.util.List;
//import java.util.ArrayList;

class Mayne{

 static String[] ruleNames;
 static boolean showRuleNames = false;
 Lexer lexer;
 Parser parser;
 boolean inputFromFile = false;
 static boolean printTree = false;
 String inputFile; 
 public static Tape6 myOutput = new Tape6("UEBbaktrans.txt");

Mayne( Lexer uebMathLexer, Parser uebMathParser){
 this.lexer = lexer;
 this.parser = parser;
};
void setInputFile( String inputFile){
 inputFromFile = true;
 this.inputFile = inputFile;
}

 static void setRuleNames( Mayne mayne ){
    ruleNames = uebMathParser.ruleNames;
    if (!showRuleNames) return;
    for (int rn=0; rn<ruleNames.length; rn++){
      System.out.println( "Rule: "+rn+" "+ruleNames[rn] );
    }
  }
public static void explain(){
 myOutput.out( "<p>This webpage and the"+
  " MathML-based backtranslation"+
  " of the braille math"+
  " were produced automatically by new software,"+
 // " <a href=\"https://github.com/SusanJ/Baknem\">BackNem 3.0</a>.</p>"+
  " <p>BackUEB is a new  Java application which "+
  " uses a  two-step process"+
  " to convert UEB braille math to MathML."+
  " The first step analyzes the braille input"+
  " using an ANTLR 4 parser generated from"+
  " a UEB with UEB math grammar developed specifically for"+
  " BackUEB.  The second step backtranslates "+
  " the parser output using a custom procedure "+  
  " implemented in Java. (This webpage utilizes the free"+
  " <a href=\"https://www.mathjax.org/\">MathJax<a> app for"+
  " rendering since MathJax can display MathML mathematics"+
  " in any browser.)</p>"); 
}
//===========================================================
public static void main( String[] args ) throws Exception {
//===========================================================

 System.out.println( "\n    Welcome to UEB backtranslator with some Math!" );
 System.out.println( "      Uses ANTLR 4.9.2 parser generator." );

 String inputFile = null;
 CharStream input = null;
 if ( args.length > 0 ) inputFile = args[0];

 //User input from terminal
 if (inputFile == null){
    System.out.println( "\n    -->Enter North Am. ASCII Braille; "+
                        "using either small or large letters." );
    System.out.println( "    -->End input with CTRL-z "+
                      "as only symbol on last line.\n" );
    Reader myReader = new InputStreamReader( System.in, "UTF-8");
    CodePointCharStream cpcs = CharStreams.fromReader( myReader );
    input = cpcs;

 //File input
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

/**  I. Connect lexer and parser and instruct parser to
        build a parse tree.  
*/
        uebMathLexer lexer = new uebMathLexer( input );
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        uebMathParser parser = new uebMathParser( tokens ); 
        parser.setBuildParseTree( true );
        Mayne mayne = new Mayne( lexer, parser );
        Mayne.setRuleNames( mayne );
        mayne.setInputFile( inputFile );
		
/**  II. Start tree with the topmost rule in the Parser 
         grammar.  (Rule #0 if grammar starts with that one.
         Rule name "text" currently hard-wired.)
*/
         ParseTree tree = parser.text();
         if (printTree){
           System.out.println( "     PARSE TREE: ");
           System.out.println( 
	                 tree.toStringTree( parser ));
           System.out.println();
           String x = tree.toStringTree( parser);
           System.out.println( wrap( x, 40) );
         }

    //System.out.println( "(text\n "+" (line\n "+"  (item\n " );
    // Optionally print tree in text form
    //if (printTree) System.out.println( "      "+
	               //tree.toStringTree(parser).substring(17));
    //prettyPrint( tree.toStringTree( parser ));

/**  III. Insert logic to walk and annotate tree here....*/

          PendingCapInds capInfo = new PendingCapInds();
          boolean uncontracted = false;   //SHOULD BE AN OPTION SOON

       //Communication point for backtranslation
          KeepTrack kt = new KeepTrack( capInfo, uncontracted, 0 );
          kt.makeTables( false, false );
           //Back translator, i.e. annotator, must extend baseListener 
         
          myOutput.mjHeader( "UEB Maths" );
          //myOutput.setAddFooter( true );
          NewBack bt = new NewBack( kt, tokens, myOutput );
          KeepTrack2 kt2 = new KeepTrack2( bt );
          //BackPR.setRuleNames();
     
     ParseTreeWalker walker = new ParseTreeWalker();
     walker.walk(bt, tree);

/**  IV. Display backtranslation  */

     System.out.println();
     System.out.println( "      ***Backtranslation***" );
     System.out.println(" Back-translated print input from annotated tree: ");
//+++++++++++++++++++++++++++ TEMPORARY COMMENT out
     //System.out.println( bt.getInk( tree ) );
     //myOutput.println( bt.getInk( tree ) );
     explain();
     myOutput.finishTape6( );
 }//End Main.//
private static final String linebreak = "\n"; // or "\r\n";

  //Found on stack (lost link, thanks whoever!)
public static String wrap(String string, int lineLength) {
    StringBuilder b = new StringBuilder();
    for (String line : string.split(Pattern.quote(linebreak))) {
        b.append(wrapLine(line, lineLength));
    }
    return b.toString();
}
private static String wrapLine(String line, int lineLength) {
    if (line.length() == 0) return linebreak;
    if (line.length() <= lineLength) return line + linebreak;
    String[] words = line.split(" ");
    StringBuilder allLines = new StringBuilder();
    StringBuilder trimmedLine = new StringBuilder();
    for (String word : words) {
        if (trimmedLine.length() + 1 + word.length() <= lineLength) {
            trimmedLine.append(word).append(" ");
        } else {
            if (trimmedLine.toString().startsWith( "(item" )){
              trimmedLine = trimmedLine.insert( 0, " " );
            }
            allLines.append(trimmedLine).append(linebreak);
            trimmedLine = new StringBuilder();
            trimmedLine.append(word).append(" ");
        }
    }
    if (trimmedLine.length() > 0) {
        allLines.append(trimmedLine);
    }
    allLines.append(linebreak);
    
    
    return allLines.toString();
}
}//End Mayne