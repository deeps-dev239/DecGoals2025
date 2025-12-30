package tests;

import org.testng.annotations.Test;


import pages.LoginPage;
import pages.ShiftPage;
import utils.BaseTest;

public class ShiftTest extends BaseTest {

    @Test
   public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("prakash.dakshina@idsnext.com", "Ids@2025");
    
        // Step 2: Open 3-dot menu
        ShiftPage userDetails = new ShiftPage(driver);
        userDetails.clickRandom();
        
        // Step 3: Enter name details
        userDetails.clickShift();
        // userDetails.clickRandom();
        userDetails.clickAdd();
        userDetails.createShift();

        
}
}
