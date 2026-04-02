package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductCategoriesPage;
import utils.AssertionUtils;
import utils.BaseTest;

public class ProductCategoriesTest extends BaseTest {

    @Test
    public void verifyServiceCategoriesNavigation() throws InterruptedException {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getUsername(), config.getPassword());

        ProductCategoriesPage productCategoriesPage = new ProductCategoriesPage(driver);

        // Step 2: CLICK FX REPORTS     
        productCategoriesPage.clickFXSPAConfigIcon();
        productCategoriesPage.switchWindow();

        // Step 3: Open 3-dot menu
        productCategoriesPage.clickRandom();
        productCategoriesPage.clickProductCategories();
        productCategoriesPage.clickRandom();
        productCategoriesPage.clickAdd();
        productCategoriesPage.createProductCategories();


        

        //  AssertionUtils.assertTrueWithMessage(
        //     servicesPage.isReportGenerated(),           // condition
        //     "Appointment Report generated successfully", // success message
        //     "Failed to generate Appointment Report"    // failure message
        // );
    }
}