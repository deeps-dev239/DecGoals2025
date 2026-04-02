package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ServiceCategoriesPage;
import utils.AssertionUtils;
import utils.BaseTest;

public class ServiceCategoriesTest extends BaseTest {

    @Test
    public void verifyServiceCategoriesNavigation() throws InterruptedException {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getUsername(), config.getPassword());

        ServiceCategoriesPage serviceCategoriesPage = new ServiceCategoriesPage(driver);

        // Step 2: CLICK FX REPORTS     
        serviceCategoriesPage.clickFXSPAConfigIcon();
        serviceCategoriesPage.switchWindow();

        // Step 3: Open 3-dot menu
        serviceCategoriesPage.clickRandom();
        serviceCategoriesPage.clickServiceCategories();
        serviceCategoriesPage.clickRandom();
        serviceCategoriesPage.clickAdd();
        serviceCategoriesPage.createServiceCategories();


        

        //  AssertionUtils.assertTrueWithMessage(
        //     servicesPage.isReportGenerated(),           // condition
        //     "Appointment Report generated successfully", // success message
        //     "Failed to generate Appointment Report"    // failure message
        // );
    }
}