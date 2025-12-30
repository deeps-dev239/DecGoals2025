package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OutletPage;
import utils.BaseTest;

public class OutletTest extends BaseTest {

    @Test
   public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("prakash.dakshina@idsnext.com", "Ids@2025");
    
        // Step 2: Open 3-dot menu
        OutletPage userDetails = new OutletPage(driver);
        userDetails.clickRandom();
        
        // Step 3: Enter name details
        userDetails.clickOutlet();
        // userDetails.clickRandom();
        userDetails.clickAdd();
        userDetails.createOutlet();

        
}
}
