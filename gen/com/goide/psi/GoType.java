// This is a generated file. Not intended for manual editing.
package com.goide.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import com.goide.stubs.GoTypeStub;

public interface GoType extends GoCompositeElement, StubBasedPsiElement<GoTypeStub> {

  @Nullable
  GoTypeReferenceExpression getTypeReferenceExpression();

  @NotNull
  GoType getUnderlyingType();

}
