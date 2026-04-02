package tests;

import org.testng.annotations.Test;
import pages.BussinessRefusalPage;
import pages.LoginPage;
import utils.BaseTest;

public class BusinessRefusalTest extends BaseTest {

    @Test
    public void verifyAppointmentReportNavigation() {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getUsername(), config.getPassword());
        BussinessRefusalPage reportPage = new BussinessRefusalPage(driver);

        reportPage.clickFXReport();
        reportPage.clickRandom();
        reportPage.clickReportSLabel();
        reportPage.clickSPAReport();
        reportPage.clickbRefusal();
        reportPage.clickGenerate();
    }
}
