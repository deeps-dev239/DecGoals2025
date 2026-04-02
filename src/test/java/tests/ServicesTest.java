package tests;

import org.testng.annotations.Test;

import pages.ServicesPage;
import pages.LoginPage;
import utils.AssertionUtils;
import utils.BaseTest;

public class ServicesTest extends BaseTest {

    @Test
    public void verifyServicesNavigation() throws InterruptedException {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getUsername(), config.getPassword());

        ServicesPage servicesPage = new ServicesPage(driver);

        // Step 2: CLICK FX REPORTS     
        servicesPage.clickFXSPAConfigIcon();
        servicesPage.switchWindow();

        // Step 3: Open 3-dot menu
        servicesPage.clickRandom();
        servicesPage.clickServices();
        servicesPage.clickRandom();
        servicesPage.clickAdd();
        servicesPage.createServices();


        

        //  AssertionUtils.assertTrueWithMessage(
        //     servicesPage.isReportGenerated(),           // condition
        //     "Appointment Report generated successfully", // success message
        //     "Failed to generate Appointment Report"    // failure message
        // );
    }
}