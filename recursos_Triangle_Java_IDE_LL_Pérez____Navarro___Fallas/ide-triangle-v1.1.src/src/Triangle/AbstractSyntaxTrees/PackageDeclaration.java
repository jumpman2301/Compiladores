
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class PackageDeclaration extends Declaration {

  public PackageDeclaration (PackageIdentifier fpsAST,
  		   Declaration cAST, SourcePosition thePosition) {
    super (thePosition);

    FPS = fpsAST;
    D = cAST;
  }

  public Object visit (Visitor v, Object o) {
    return v.visitPackageDeclaration(this, o);
  }

  public  PackageIdentifier FPS;
  public Declaration D;
}
