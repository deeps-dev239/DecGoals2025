package tests;

import org.testng.annotations.Test;

import pages.EditServicesPage;
import pages.LoginPage;
import utils.AssertionUtils;
import utils.BaseTest;

public class EditServicesTest extends BaseTest {

    @Test
    public void verifyServicesNavigation() throws InterruptedException {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("prakash.dakshina@idsnext.com", "Ids@2026");
        //loginPage.login("kalingiri.nareshkumar@idsnext.com", "Ids@1001");

        EditServicesPage editservicesPage = new EditServicesPage(driver);

        // Step 2: CLICK FX REPORTS     
        editservicesPage.clickFXSPAConfigIcon();
        editservicesPage.switchWindow();

        // Step 3: Open 3-dot menu
        editservicesPage.clickRandom();
        editservicesPage.clickServices();
        editservicesPage.clickRandom();
        editservicesPage.clickAdd();
        editservicesPage.createServices();


        

        //  AssertionUtils.assertTrueWithMessage(
        //     servicesPage.isReportGenerated(),           // condition
        //     "Appointment Report generated successfully", // success message
        //     "Failed to generate Appointment Report"    // failure message
        // );
    }
}