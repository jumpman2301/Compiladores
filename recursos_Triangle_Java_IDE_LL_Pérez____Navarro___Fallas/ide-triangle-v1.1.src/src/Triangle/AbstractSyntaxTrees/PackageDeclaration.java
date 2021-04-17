/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Triangle.AbstractSyntaxTrees;
import Triangle.SyntacticAnalyzer.SourcePosition;
/**
 *
 * @author Mari�ngela
 */
public class PackageDeclaration extends Declaration {



  public PackageDeclaration (Identifier iAST, Declaration D1,  SourcePosition thePosition) {
    super (thePosition);
    I = iAST;
      D = D1;
  
}


  public Object visit(Visitor v, Object o) {
    return v.visitPackageDeclaration(this, o);
  }

  public Identifier I;
public Declaration D;
 
}
