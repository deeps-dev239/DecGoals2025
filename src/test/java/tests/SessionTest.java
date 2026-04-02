package tests;

import org.testng.annotations.Test;


import pages.LoginPage;
import pages.SessionPage;
import utils.BaseTest;

public class SessionTest extends BaseTest {

    @Test
   public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getUsername(), config.getPassword());
    
        // Step 2: Open 3-dot menu
        SessionPage userDetails = new SessionPage(driver);
        userDetails.clickRandom();
        
        // Step 3: Enter name details
        userDetails.clickSession();
        // userDetails.clickRandom();
        userDetails.clickAdd();
        userDetails.createSession();

        
}
}
