/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }

  public static String spell (int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  public static final int
 // literals, identifiers, operators...
            INTLITERAL = 0,
            CHARLITERAL = 1,
            IDENTIFIER = 2,
            OPERATOR = 3,

            // reserved words - must be in alphabetical order...
            AND = 4, //PROYECTO 1
            ARRAY = 5,
            //BEGIN		= 5, SE ELIMINA PROYECTO 1
            CONST = 6,
            DO = 7,
            ELSE = 8,
            ELSIF = 9,  //PROYECTO 1
            END = 10,
            FOR = 11,
            FROM = 12,
            FUNC = 13, //PROYECTO 1
            IF = 14,
            IN = 15,
            LET = 16,
            LOOP = 17, //PROYECTO 1
            NOTHING = 18, //PROYECTO 1
            OF = 19,
            PRIVATE = 20, //PROYECTO 1
            PROC = 21,
            REC = 22, //PROYECTO 1
            RECORD = 23,
            THEN = 24,
            TO = 25, //PROYECTO 1
            TYPE = 26,
            UNTIL = 27, //PROYECTO 1
            VAR = 28,
            WHILE = 29,

            // punctuation...
            DOT = 30,
            COLON = 31,
            SEMICOLON = 32,
            COMMA = 33,
            BECOMES = 34,
            IS = 35,
            DOUBLE_DOTS = 36, // PROYECTO 1

            // brackets...
            LPAREN = 37,
            RPAREN = 38,
            LBRACKET = 39,
            RBRACKET = 40,
            LCURLY = 41,
            RCURLY = 42,

            // special tokens...
            EOT = 43,
            ERROR = 44;
  private static String[] tokenTable = new String[] {
            "<int>",
            "<char>",
            "<identifier>",
            "<operator>",
            "and", //PROYECTO 1
            "array",
            //"begin", SE ELIMINA PROYECTO 1
            "const",
            "do",
            "else",
            "elsif", //PROYECTO 1
            "end",
            "for", //PROYECTO 1
            "from",
            "func",
            "if",
            "in",
            "let",
            "loop", //PROYECTO 1
            "nothing", //PROYECTO 1
            "of",
            "private", //PROYECTO 1
            "proc",
            "rec", //PROYECTO 1
            "record",
            "then",
            "to", //PROYECTO 1
            "type",
            "until", //PROYECTO 1
            "var",
            "while",
            ".",
            ":",
            ";",
            ",",
            ":=",
            "~",
            "..", //PROYECTO 1
            "(",
            ")",
            "[",
            "]",
            "{",
            "}",
            "",
            "<error>"
    };

  private final static int	firstReservedWord = Token.ARRAY,
  				lastReservedWord  = Token.WHILE;

}
