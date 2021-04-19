

package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class SimpleTypeLongDenoter extends TypeDenoter {

  public SimpleTypeLongDenoter (LongIdentifier iAST, SourcePosition thePosition) {
    super (thePosition);
    I = iAST;
  }

  public Object visit (Visitor v, Object o) {
    return v.visitSimpleTypeLongDenoter(this, o);
  }

  public boolean equals (Object obj) {
    return false; // should not happen
  }

  public LongIdentifier I;
}
