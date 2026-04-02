package tests;

import org.testng.annotations.Test;

import pages.EditResourcesPage;
import pages.LoginPage;
import pages.ResourcesPage;
import utils.AssertionUtils;
import utils.BaseTest;

public class EditResourcesTest extends BaseTest {

    @Test
    public void verifyResourcesNavigation() throws InterruptedException {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getUsername(), config.getPassword());

        EditResourcesPage editresouncesPage = new EditResourcesPage(driver);

        // Step 2: CLICK FX REPORTS     
        editresouncesPage.clickFXSPAConfigIcon();
        editresouncesPage.switchWindow();

        // Step 3: Open 3-dot menu
        editresouncesPage.clickRandom();
        editresouncesPage.clickResources();
        editresouncesPage.clickRandom();
        editresouncesPage.clickRow();
        editresouncesPage.updateResources();


        

        //  AssertionUtils.assertTrueWithMessage(
        //     servicesPage.isReportGenerated(),           // condition
        //     "Appointment Report generated successfully", // success message
        //     "Failed to generate Appointment Report"    // failure message
        // );
    }
}