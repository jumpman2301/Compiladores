/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Triangle.AbstractSyntaxTrees;
import Triangle.SyntacticAnalyzer.SourcePosition;
/**
 *
 * @author Mariángela
 */
public class DollarDeclaration extends Declaration {



  public DollarDeclaration (Identifier iAST,
                    SourcePosition thePosition) {
    super (thePosition);
    I = iAST;
  
}


  public Object visit(Visitor v, Object o) {
    return v.visitDollarDeclaration(this, o);
  }

  public Identifier I;
 
}
