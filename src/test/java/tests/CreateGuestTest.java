package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.CreateGuestPage;
import utils.BaseTest;

public class CreateGuestTest extends BaseTest {

    @Test
   public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tsc20007@idsnext.com", "Ids@1001");
    
        // Step 2: Open 3-dot menu
        CreateGuestPage userDetails = new CreateGuestPage(driver);
        userDetails.clickThreeDot();
        
        // Step 3: Enter name details
        userDetails.enterNameDetails("Chandler", "M", "Bing");

        // Step 4: Click Save
        userDetails.clickSave();

        // Step 5: Click Cross to close modal
        userDetails.clickCross();
    }
}
