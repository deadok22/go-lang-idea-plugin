package ro.redeul.google.go.lang.psi.impl.toplevel;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import ro.redeul.google.go.lang.lexer.GoTokenTypes;
import ro.redeul.google.go.lang.psi.impl.GoPsiElementImpl;
import ro.redeul.google.go.lang.psi.toplevel.GoFunctionDeclaration;

/**
 * Created by IntelliJ IDEA.
 * User: mtoader
 * Date: Aug 26, 2010
 * Time: 2:33:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class GoFunctionDeclarationImpl extends GoPsiElementImpl implements GoFunctionDeclaration {

    public GoFunctionDeclarationImpl(@NotNull ASTNode node) {
        super(node);
    }

    public String getFunctionName() {
        PsiElement identifier = findChildByType(GoTokenTypes.mIDENT);

        return identifier != null ? identifier.getText() : "";
    }

    public boolean isMain() {
        return getFunctionName().equals("main");
    }

    public String toString() {
      return "FunctionDeclaration(" + getFunctionName() + ")";
    }

}
