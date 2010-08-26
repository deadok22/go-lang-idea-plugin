package ro.redeul.google.go.lang.parser;

import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.DebugUtil;
import ro.redeul.google.go.lang.GoCodeInsightTestCase;
import ro.redeul.google.go.util.TestUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class GoParsingTestCase extends GoCodeInsightTestCase {
    @Override
    protected String getRelativeDataPath() {
        return "parsing" + File.separator + "go";
    }

    public void doTest() throws IOException {
        doTest(getTestName() + ".test");
    }

    private void doTest(String fileName) throws IOException {
        final List<String> list = TestUtils.readInput(getTestRootPath() + "/" + fileName);

        final String input = list.get(0);
        if ( list.size() != 2 || list.get(1).trim().length() == 0 ) {
            dumpParsingTree(input, getTestRootPath() + "/" + fileName);
        } else {
            checkParsing(input, list.get(1).trim());
        }
    }

    protected void dumpParsingTree(String input, String fileName) throws IOException {
        final PsiFile psiFile = TestUtils.createPseudoPhysicalGoFile(getProject(), input);
        String psiTree = DebugUtil.psiToString(psiFile, false);

        TestUtils.writeTestFile(input, psiTree.trim(), fileName);
    }

    protected void checkParsing(String input, String output) {
        final PsiFile psiFile = TestUtils.createPseudoPhysicalGoFile(getProject(), input);
        String psiTree = DebugUtil.psiToString(psiFile, false);
        org.testng.Assert.assertEquals(psiTree.trim(), output.trim());        
    }
}
