package tests;

import org.testng.annotations.Test;

import pages.DiscountPage;
import pages.LoginPage;
import utils.BaseTest;

public class DiscountTest extends BaseTest {

    @Test
   public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("prakash.dakshina@idsnext.com", "Ids@2025");
    
        // Step 2: Open 3-dot menu
        DiscountPage userDetails = new DiscountPage(driver);
        userDetails.clickRandom();
        
        // Step 3: Enter name details
        userDetails.clickDiscount();
        // userDetails.clickRandom();
        userDetails.clickAdd();
        userDetails.createDiscount();

        
}
}
