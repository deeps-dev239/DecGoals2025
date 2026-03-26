package tests;

import org.testng.annotations.Test;

import pages.EditProductsPage;
import pages.LoginPage;
import utils.AssertionUtils;
import utils.BaseTest;

public class EditProductsTest extends BaseTest {

    @Test
    public void verifyProductsNavigation() throws InterruptedException {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("prakash.dakshina@idsnext.com", "Ids@2026");
        //loginPage.login("kalingiri.nareshkumar@idsnext.com", "Ids@1001");

        EditProductsPage editproductsPage = new EditProductsPage(driver);

        // Step 2: CLICK FX REPORTS     
        editproductsPage.clickFXSPAConfigIcon();
        editproductsPage.switchWindow();

        // Step 3: Open 3-dot menu
        editproductsPage.clickRandom();
        editproductsPage.clickProducts();
        editproductsPage.clickRandom();
        editproductsPage.clickRow();
        editproductsPage.editProducts();


        

        //  AssertionUtils.assertTrueWithMessage(
        //     servicesPage.isReportGenerated(),           // condition
        //     "Appointment Report generated successfully", // success message
        //     "Failed to generate Appointment Report"    // failure message
        // );
    }
}