package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;
import utils.AssertionUtils;

public class LoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        // Step 1: Perform login
        loginPage.login("prakash.dakshina@idsnext.com", "Ids@2025");

        // Step 2: Assertion using AssertionUtils
        AssertionUtils.assertTrueWithMessage(
            loginPage.isLoginSuccessful(),   // condition
            "Login successful ",           // success message
            "Login failed "                // failure message
        );
    }
}
