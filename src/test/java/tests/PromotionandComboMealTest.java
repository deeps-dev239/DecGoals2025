package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.PromotionandComboMealPage;
import utils.BaseTest;

public class PromotionandComboMealTest extends BaseTest {

    @Test
   public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("prakash.dakshina@idsnext.com", "Ids@2025");
        //loginPage.login("kalingiri.nareshkumar@idsnext.com", "Ids@1001");
    
        // Step 2: Open 3-dot menu
        PromotionandComboMealPage userDetails = new PromotionandComboMealPage(driver);
        userDetails.clickRandom();
        
        // Step 3: Enter name details
        userDetails.clickPromotionandComboMeal();
        // userDetails.clickRandom();
        userDetails.clickAdd();
        userDetails.createPromotionandComboMeal();

        
}
}
