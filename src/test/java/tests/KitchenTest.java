package tests;

import org.testng.annotations.Test;

import pages.KitchenPage;
import pages.LoginPage;
import utils.BaseTest;

public class KitchenTest extends BaseTest {

    @Test
   public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("prakash.dakshina@idsnext.com", "Ids@2025");
        //loginPage.login("kalingiri.nareshkumar@idsnext.com", "Ids@1001");

        // Step 2: Open 3-dot menu
        KitchenPage userDetails = new KitchenPage(driver);
        userDetails.clickRandom();
        
        // Step 3: Enter name details
        userDetails.clickKitchen();
        // userDetails.clickRandom();
        userDetails.clickAdd();
        userDetails.createKitchen();

        
}
}
