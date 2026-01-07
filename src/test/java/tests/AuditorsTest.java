package tests;

import org.testng.annotations.Test;
import pages.AuditorsPage;
import pages.LoginPage;
import utils.AssertionUtils;
import utils.BaseTest;

public class AuditorsTest extends BaseTest {

    @Test
    public void verifyAppointmentReportNavigation() {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("prakash.dakshina@idsnext.com", "Ids@2025");
        //loginPage.login("kalingiri.nareshkumar@idsnext.com", "Ids@1001");
        AuditorsPage reportPage = new AuditorsPage(driver);

        // Step 2: CLICK FX REPORTS (THIS WAS MISSING)
        reportPage.clickFXReport();

        // Step 3: Open 3-dot menu
        reportPage.clickRandom();

        // Step 4: Navigate Reports → SPA → Appointment
        reportPage.clickReportSLabel();
        reportPage.clickSPAReport();
        reportPage.clickAuditorReport();
        reportPage.clickCalender();
        reportPage.clickCalenderDate();
        reportPage.clickGenerate();

        // AssertionUtils.assertTrueWithMessage(
        //     reportPage.isAuditReportGenerated(),           // condition
        //     "Audit Report generated successfully", // success message
        //     "Failed to generate Aduit Report"    // failure message
        // );

        AssertionUtils.assertTrueWithMessage(
            reportPage.isAuditReportGenerated(),           // condition
            "Audit Report generated successfully", // success message
            "Failed to generate Audit Report"    // failure message
        );
    }
}
