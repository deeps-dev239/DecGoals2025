package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OutletCopyPage;
import utils.BaseTest;

public class OutletCopyTest extends BaseTest {

    @Test
   public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("prakash.dakshina@idsnext.com", "Ids@2025");
    
        // Step 2: Open 3-dot menu
        OutletCopyPage userDetails = new OutletCopyPage(driver);
        userDetails.clickRandom();
                    
        // Step 3: Enter name details
        userDetails.clickOutlet();
        userDetails.clickCheckBox();
        // userDetails.clickRandom();
        userDetails.clickAdd();
        userDetails.createOutlet();

        
}
}
