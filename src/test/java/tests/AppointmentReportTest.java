package tests;

import org.testng.annotations.Test;

import pages.AppointmentReportPage;
import pages.LoginPage;
import utils.BaseTest;

public class AppointmentReportTest extends BaseTest {

    @Test
    public void verifyAppointmentReportNavigation() {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("prakash.dakshina@idsnext.com", "Ids@2025");
        //loginPage.login("kalingiri.nareshkumar@idsnext.com", "Ids@1001");

        AppointmentReportPage reportPage = new AppointmentReportPage(driver);

        // Step 2: CLICK FX REPORTS 
        reportPage.clickFXReport();

        // Step 3: Open 3-dot menu
        reportPage.clickRandom();

        // Step 4: Navigate Reports → SPA → Appointment
        reportPage.clickReportSLabel();
        reportPage.clickSPAReport();
        reportPage.clickAppoitmentReport();
        reportPage.clickCalender();
        reportPage.clickCalenderDate();
        reportPage.clickGenerate();
    }
}
