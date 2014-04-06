package com.goide.codeInsight.imports;

import com.goide.GoCodeInsightFixtureTestCase;
import com.intellij.codeInsight.actions.OptimizeImportsAction;
import com.intellij.ide.DataManager;
import com.intellij.testFramework.LightProjectDescriptor;

public class GoImportOptimizerTest extends GoCodeInsightFixtureTestCase {

  public void testUnusedImports() { doTest(); }
  public void testUnusedImportsWithSemicolon() { doTest(); }
  public void testUnusedImplicitImports() { doTest(); }
  public void testUsedImplicitImports() { doTest(); }
  public void testUsedDuplicatedImports() { doTest(); } 
  public void testDuplicatedImportsWithSameString() { doTest(); } 
  public void testDuplicatedImportsWithDifferentString() { doTest(); } 
  public void testUnusedDuplicatedImports() { doTest(); }
  public void testImportWithSameIdentifier() { doTest(); }

  @Override
  protected boolean isWriteActionRequired() {
    return false;
  }

  private void doTest() {
    myFixture.configureByFile(getTestName(true) + ".go");
    myFixture.doHighlighting();
    OptimizeImportsAction.actionPerformedImpl(DataManager.getInstance().getDataContext(myFixture.getEditor().getContentComponent()));
    myFixture.checkResultByFile(getTestName(true) + "_after.go");
  }
  
  @Override
  public void setUp() throws Exception {
    super.setUp();
    setUpProjectSdk();
  }

  @Override
  protected LightProjectDescriptor getProjectDescriptor() {
      return createMockProjectDescriptor();
    }
  

  @Override
  protected String getBasePath() {
    return "imports/optimize";
  }
}
