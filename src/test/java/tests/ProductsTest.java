package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductsPage;
import utils.AssertionUtils;
import utils.BaseTest;

public class ProductsTest extends BaseTest {

    @Test
    public void verifyProductsNavigation() throws InterruptedException {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
       loginPage.login(config.getUsername(), config.getPassword());

        ProductsPage productsPage = new ProductsPage(driver);

        // Step 2: CLICK FX REPORTS     
        productsPage.clickFXSPAConfigIcon();
        productsPage.switchWindow();

        // Step 3: Open 3-dot menu
        productsPage.clickRandom();
        productsPage.clickProducts();
        productsPage.clickRandom();
        productsPage.clickAdd();
        productsPage.createProducts();


        

        //  AssertionUtils.assertTrueWithMessage(
        //     servicesPage.isReportGenerated(),           // condition
        //     "Appointment Report generated successfully", // success message
        //     "Failed to generate Appointment Report"    // failure message
        // );
    }
}