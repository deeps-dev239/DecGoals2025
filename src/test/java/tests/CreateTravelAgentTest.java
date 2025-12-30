package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.CreateTravelAgentPage;
import utils.BaseTest;

public class CreateTravelAgentTest extends BaseTest {

    @Test
   public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tsc20007@idsnext.com", "Ids@1001");
    
        // Step 2: Open 3-dot menu
        CreateTravelAgentPage userDetails = new CreateTravelAgentPage(driver);
        userDetails.clickTravelAgentThreeDot();
        
        // Step 3: Enter name details
        userDetails.enterNameDetails("DevStringx", "Deepshikha", "9988776655");

        // Step 4: Click Save
        userDetails.clickSave();

    
    }
}
