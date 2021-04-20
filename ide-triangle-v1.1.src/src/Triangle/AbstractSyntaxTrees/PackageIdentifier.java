
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class PackageIdentifier extends Terminal {

  public PackageIdentifier (String theSpelling, SourcePosition thePosition) {
    super (theSpelling, thePosition);
    type = null;
    decl = null;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitPackageIdentifier(this, o);
  }

  public TypeDenoter type;
  public AST decl; // Either a Declaration or a FieldTypeDenoter
}