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
    } 



else
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
            CHOOSE =7,
            DO = 8,
            DOLLAR=9,
            ELSE = 10,
            ELSIF = 11,  //PROYECTO 1
            END = 12,
            FOR = 13,
            FROM = 14,
            FUNC = 15, //PROYECTO 1
            IF = 16,
            IN = 17,
            LET = 18,
            LOOP = 19, //PROYECTO 1
            NOTHING = 20, //PROYECTO 1
            OF = 21,
            PACKAGE = 22,
            PRIVATE = 23, //PROYECTO 1
            PROC = 24,
            REC = 25, //PROYECTO 1
            RECORD = 26,
            THEN = 27,
            TO = 28, //PROYECTO 1
            TYPE = 29,
            UNTIL = 30, //PROYECTO 1
            VAR = 31,
            WHEN =32,
            WHILE = 33,

            // punctuation...
            DOT = 34,
            COLON = 35,
            SEMICOLON = 36,
            COMMA = 37,
            BECOMES = 38,
            IS = 39,
            DOUBLE_DOTS = 40, // PROYECTO 1

            // brackets...
            LPAREN = 41,
            RPAREN = 42,
            LBRACKET = 43,
            RBRACKET = 44,
            LCURLY = 45,
            RCURLY = 46,

            // special tokens...
            EOT = 47,
            ERROR = 48;
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
            "dollar",
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
            "|",
            "$",
            "..",
            "<error>"
    };

  private final static int	firstReservedWord = Token.ARRAY,
  				lastReservedWord  = Token.WHILE;

}
