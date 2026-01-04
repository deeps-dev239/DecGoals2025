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
        loginPage.login("prakash.dakshina@idsnext.com", "Ids@2025");
        //loginPage.login("kalingiri.nareshkumar@idsnext.com", "Ids@1001");
        BussinessRefusalPage reportPage = new BussinessRefusalPage(driver);

        reportPage.clickFXReport();
        reportPage.clickRandom();
        reportPage.clickReportSLabel();
        reportPage.clickSPAReport();
        reportPage.clickbRefusal();
        reportPage.clickGenerate();
    }
}
