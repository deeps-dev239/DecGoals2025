package tests;

import org.testng.annotations.Test;

import pages.AdvancedSettingsPage;
import pages.LoginPage;
import utils.AssertionUtils;
import utils.BaseTest;

public class AdvancedSettingsTest extends BaseTest {

    @Test
    public void verifyAddAdvanceSettings() throws InterruptedException {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
       loginPage.login(config.getUsername(), config.getPassword());

        AssertionUtils.assertTrueWithMessage(
            loginPage.isLoginSuccessful(),   // condition
            "Login successful ",           // success message
            "Login failed "                // failure message
        );
        AdvancedSettingsPage advancedSettingsPage = new AdvancedSettingsPage(driver);

        // Step 2: CLICK FX REPORTS     
        advancedSettingsPage.clickFXSPAConfigIcon();
        advancedSettingsPage.switchWindow();

        // Step 3: Open 3-dot menu
        advancedSettingsPage.clickRandom();
        advancedSettingsPage.clickAdvanceSettings();
        advancedSettingsPage.clickRandom();
        advancedSettingsPage.clickAdd();
        advancedSettingsPage.createAdvanceSettings();


        

        //  AssertionUtils.assertTrueWithMessage(
        //     servicesPage.isReportGenerated(),           // condition
        //     "Appointment Report generated successfully", // success message
        //     "Failed to generate Appointment Report"    // failure message
        // );
    }
}