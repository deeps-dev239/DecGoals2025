package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ServiceCategoriesSearchPage;
import utils.BaseTest;

public class ServiceCategoriesSearchTest extends BaseTest {

    @Test
    public void verifyServiceCategoriesSearch() {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("prakash.dakshina@idsnext.com", "Ids@2026");

        ServiceCategoriesSearchPage serviceCategoriesSearchPage =
                new ServiceCategoriesSearchPage(driver);

        // Step 2: Open FX SPA
        serviceCategoriesSearchPage.clickFXSPAConfigIcon();
        serviceCategoriesSearchPage.switchWindow();

        // Step 3: Navigate to Service Categories
        serviceCategoriesSearchPage.clickRandom();
        serviceCategoriesSearchPage.clickServiceCategories();

        // Step 4: Search
        serviceCategoriesSearchPage.enterSearchText("Test");
        serviceCategoriesSearchPage.clickSearchIcon();
    }
}