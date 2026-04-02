package tests;

import org.testng.annotations.Test;

import pages.BillSeriesSetupPage;
import pages.LoginPage;
import utils.AssertionUtils;
import utils.BaseTest;

public class BillSeriesSetupTest extends BaseTest {

    @Test
    public void verifyServiceCategoriesNavigation() throws InterruptedException {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
         loginPage.login(config.getUsername(), config.getPassword());

        BillSeriesSetupPage billServiceSetupPage = new BillSeriesSetupPage(driver);

        // Step 2: CLICK FX REPORTS     
        billServiceSetupPage.clickFXSPAConfigIcon();
        billServiceSetupPage.switchWindow();

        // Step 3: Open 3-dot menu
        billServiceSetupPage.clickRandom();
        billServiceSetupPage.clickBillServiceSetup();
        billServiceSetupPage.clickRandom();
        billServiceSetupPage.clickAdd();
        billServiceSetupPage.createBillServiceSetup();


        

        //  AssertionUtils.assertTrueWithMessage(
        //     servicesPage.isReportGenerated(),           // condition
        //     "Appointment Report generated successfully", // success message
        //     "Failed to generate Appointment Report"    // failure message
        // );
    }
}