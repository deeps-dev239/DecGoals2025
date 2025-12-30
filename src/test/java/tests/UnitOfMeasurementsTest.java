package tests;

import org.testng.annotations.Test;


import pages.LoginPage;
import pages.UnitOfMeasurementsPage;
import utils.BaseTest;

public class UnitOfMeasurementsTest extends BaseTest {

    @Test
   public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("prakash.dakshina@idsnext.com", "Ids@2025");
    
        // Step 2: Open 3-dot menu
        UnitOfMeasurementsPage userDetails = new UnitOfMeasurementsPage(driver);
        userDetails.clickRandom();
        
        // Step 3: Enter name details
        userDetails.clickUnitOfMeasurements();
        // userDetails.clickRandom();
        userDetails.clickAdd();
        userDetails.createUnitOfMeasurements();

        
}
}
