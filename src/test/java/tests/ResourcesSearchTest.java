package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ResourcesSearchPage;
import utils.BaseTest;

public class ResourcesSearchTest extends BaseTest {

    @Test
    public void verifyResourcesSearch() {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getUsername(), config.getPassword());

        ResourcesSearchPage resourcesSearchPage =
                new ResourcesSearchPage(driver);

        // Step 2: Open FX SPA
        resourcesSearchPage.clickFXSPAConfigIcon();
        resourcesSearchPage.switchWindow();

        // Step 3: Navigate to Resources
        resourcesSearchPage.clickRandom();
        resourcesSearchPage.clickResources();

        // Step 4: Search
        resourcesSearchPage.enterSearchText("Test");
        resourcesSearchPage.clickSearchIcon();
    }
}