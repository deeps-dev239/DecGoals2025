package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ResourcesPage;
import utils.AssertionUtils;
import utils.BaseTest;

public class ResourcesTest extends BaseTest {

    @Test
    public void verifyResourcesNavigation() throws InterruptedException {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("prakash.dakshina@idsnext.com", "Ids@2026");
        //loginPage.login("kalingiri.nareshkumar@idsnext.com", "Ids@1001");

        ResourcesPage resouncesPage = new ResourcesPage(driver);

        // Step 2: CLICK FX REPORTS     
        resouncesPage.clickFXSPAConfigIcon();
        resouncesPage.switchWindow();

        // Step 3: Open 3-dot menu
        resouncesPage.clickRandom();
        resouncesPage.clickResources();
        resouncesPage.clickRandom();
        resouncesPage.clickAdd();
        resouncesPage.createResources();


        

        //  AssertionUtils.assertTrueWithMessage(
        //     servicesPage.isReportGenerated(),           // condition
        //     "Appointment Report generated successfully", // success message
        //     "Failed to generate Appointment Report"    // failure message
        // );
    }
}