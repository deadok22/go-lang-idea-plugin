/*
 * Copyright 2013-2015 Sergey Ignatov, Alexander Zolotov, Florin Patan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.goide.runconfig.testing;

import com.goide.runconfig.testing.frameworks.gotest.GotestFramework;
import org.jetbrains.annotations.NotNull;

public class GotestEventsConverterTest extends GoEventsConverterTestCase {
  public void testSingleTestFailed() throws Exception {
    doTest();
  }

  public void testSingleTestOk() throws Exception {
    doTest();
  }

  public void testMultipleTestsFailed() throws Exception {
    doTest();
  }

  public void testMultipleTestsOk() throws Exception {
    doTest();
  }

  public void testSingleTestLeadingSpaceOk() throws Exception {
    doTest();
  }
  
  public void testSkipTest() throws Exception {
    doTest();
  }
  
  public void testStdOut() throws Exception {
    doTest();
  }
  
  public void testOneLineEvents() throws Exception {
    doTest();
  }

  @NotNull
  @Override
  protected String getBasePath() {
    return "testing/gotest";
  }
  
  @NotNull
  @Override
  protected GoTestFramework getTestFramework() {
    return GotestFramework.INSTANCE;
  }
}
