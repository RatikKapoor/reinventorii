/**
 * From: https://stackoverflow.com/questions/2036750/how-to-run-all-junit-tests-of-a-given-package/36702048
 */

package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ DatabaseTest.class })
public class AllTests {
}
