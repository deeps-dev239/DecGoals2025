package utils;

import org.testng.Assert;

public class AssertionUtils {

    public static void assertTrueWithMessage(boolean condition,
                                             String successMsg,
                                             String failureMsg) {
        if (condition) {
            System.out.println("Test Passed - " + successMsg);
        } else {
            Assert.fail("Test Failed - " + failureMsg);
        }
    }
}
