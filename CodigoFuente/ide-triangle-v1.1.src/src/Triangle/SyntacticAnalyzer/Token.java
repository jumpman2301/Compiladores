
package Triangle.SyntacticAnalyzer;

import Triangle.SyntacticAnalyzer.SourcePosition;

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
    INTLITERAL  = 0,
    CHARLITERAL = 1,
    IDENTIFIER  = 2,
    OPERATOR    = 3,

    // reserved words - must be in alphabetical order...
    // Se cambio la numeracion
    ARRAY       = 4,

    // Se elimino la palabra reservada begin
    CHOOSE  = 5,   // Se agrego palabra reservada choose
    CONST   = 6,
    DO      = 7,
    ELSE    = 8,
    ELSIF    = 9,
    END     = 10,   // Se agrego palabra reservada for
    FOR    = 11,   // Se agrego palabra reservada from
    FROM    = 12,
    FUNC       = 13,
    IF      = 14,
    IN      = 15,
    LET     = 16,   // Se agrego palabra reservada loop
    LOOP    = 17,
    NOTHING        = 18,
    OF     = 19,   // Se agrego palabra reservada par
    PACKAGE     = 20,   // Se agrego palabra reservada pass      //no
    PRIVATE = 21,   // Se agrego palabra reservada private
    PROC    = 22,
    RECORD  = 23,
    RECURSIVE   = 24,   // Se agrego palabra reservada recursive
          
    THEN        = 25,
    TO      = 26,   // Se agrego palabra reservada to
    TYPE    = 27,
    UNTIL   = 28,   // Se agreg?? palabra reservada until
    VAR     = 29,
    WHEN    = 30,   // Se agreg?? palabra reservada when
    WHILE   = 31,
  
    // punctuation...
    DOT         = 32,
    COLON       = 33,
    SEMICOLON   = 34,
    COMMA       = 35,
    BECOMES     = 36,
    IS          = 37,
    PIPE        = 38,   // Se agreg?? simbolo |
    INITIALIZE  = 39,   // Se agreg?? simbolo ::=
    DOLLAR      = 40,   // Se agreg?? simbolo $
    RANGE       = 41,   // Se agreg?? simbolo ..

    // brackets...
    LPAREN      = 42,
    RPAREN      = 43,
    LBRACKET    = 44,
    RBRACKET    = 45,
    LCURLY      = 46,
    RCURLY      = 47,

    // special tokens...
    EOT         = 48,
    ERROR       = 49;
  
    // package

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "array",
    "choose",   // Se agreg?? el caracter de la palabra reservada choose
    "const",
    "do",
    "else",
    "elsif",
    "end",
    "for",   // Se agreg?? el caracter de la palabra reservada for
    "from",   // Se agreg?? el caracter de la palabra reservada from
    "func",
    "if",
    "in",
    "let",
    "loop",   // Se agreg?? el caracter de la palabra reservada loop
    "nothing",
    "of",
    "package",   // Se agreg?? el caracter de la palabra reservada par
    "private",   // Se agreg?? el caracter de la palabra reservada private
    "proc",
    "record",
    "recursive",   // Se agreg?? el caracter de la palabra reservada recursive
    "then",
    "to",   // Se agreg?? el caracter de la palabra reservada to
    "type",
    "until",   // Se agreg?? el caracter de la palabra reservada until
    "var",
    "when",   // Se agreg?? el caracter de la palabra reservada when
    "while",
    ".",
    ":",
    ";",
    ",",
    ":=",
    "~",
    "|",   // Se agreg?? el caracter del simbolo |
    "::=",   // Se agreg?? el caracter del simbolo ::=
    "$",   // Se agreg?? el caracter del simbolo $
    "..",   // Se agreg?? el caracter del simbolo ..
    "(",
    ")",
    "[",
    "]",
    "{",
    "}",
    "",
    "<error>"
  };

  private final static int  firstReservedWord = Token.ARRAY,
                lastReservedWord  = Token.WHILE;

}