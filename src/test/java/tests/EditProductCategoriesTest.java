package tests;

import org.testng.annotations.Test;

import pages.EditProductCategoriesPage;
import pages.LoginPage;
import pages.ProductCategoriesPage;
import utils.AssertionUtils;
import utils.BaseTest;

public class EditProductCategoriesTest extends BaseTest {

    @Test
    public void verifyServiceCategoriesNavigation() throws InterruptedException {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getUsername(), config.getPassword());

        EditProductCategoriesPage editproductCategoriesPage = new EditProductCategoriesPage(driver);

        // Step 2: CLICK FX REPORTS     
        editproductCategoriesPage.clickFXSPAConfigIcon();
        editproductCategoriesPage.switchWindow();

        // Step 3: Open 3-dot menu
        editproductCategoriesPage.clickRandom();
        editproductCategoriesPage.clickProductCategories();
        editproductCategoriesPage.clickRandom();
        editproductCategoriesPage.clickRow();
        editproductCategoriesPage.editProductCategories();


        

        //  AssertionUtils.assertTrueWithMessage(
        //     servicesPage.isReportGenerated(),           // condition
        //     "Appointment Report generated successfully", // success message
        //     "Failed to generate Appointment Report"    // failure message
        // );
    }
}