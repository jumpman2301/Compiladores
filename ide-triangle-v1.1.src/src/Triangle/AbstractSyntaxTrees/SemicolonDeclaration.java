
package Triangle.AbstractSyntaxTrees;
import Triangle.SyntacticAnalyzer.SourcePosition;
/**
 *
 * @author Mariángela
 */
public class SemicolonDeclaration extends Declaration {



  public SemicolonDeclaration (Identifier iAST,
                    SourcePosition thePosition) {
    super (thePosition);
    I = iAST;

}


  public Object visit(Visitor v, Object o) {
    return v.visitSemicolonDeclaration(this, o);
  }

  public Identifier I;

}