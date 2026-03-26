package tests;

import org.testng.annotations.Test;

import pages.EditServiceCategoriesPage;
import pages.LoginPage;
import utils.AssertionUtils;
import utils.BaseTest;

public class EditServiceCategoriesTest extends BaseTest {

    @Test
    public void verifyServiceCategoriesNavigation() throws InterruptedException {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("prakash.dakshina@idsnext.com", "Ids@2026");
        //loginPage.login("kalingiri.nareshkumar@idsnext.com", "Ids@1001");

        EditServiceCategoriesPage editserviceCategoriesPage = new EditServiceCategoriesPage(driver);

        // Step 2: CLICK FX REPORTS     
        editserviceCategoriesPage.clickFXSPAConfigIcon();
        editserviceCategoriesPage.switchWindow();

        // Step 3: Open 3-dot menu
        editserviceCategoriesPage.clickRandom();
        editserviceCategoriesPage.clickServiceCategories();
        editserviceCategoriesPage.clickRandom();
        editserviceCategoriesPage.clickRow();
        editserviceCategoriesPage.editServiceCategories();


        

        //  AssertionUtils.assertTrueWithMessage(
        //     servicesPage.isReportGenerated(),           // condition
        //     "Appointment Report generated successfully", // success message
        //     "Failed to generate Appointment Report"    // failure message
        // );
    }
}