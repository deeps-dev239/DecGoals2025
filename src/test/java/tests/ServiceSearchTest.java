package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ServiceSearchPage;
import utils.BaseTest;

public class ServiceSearchTest extends BaseTest {

    @Test
    public void verifyServiceSearch() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getUsername(), config.getPassword());

        ServiceSearchPage serviceSearch = new ServiceSearchPage(driver);

        serviceSearch.clickFXSPAConfigIcon();
        serviceSearch.switchWindow();

        serviceSearch.clickRandom();
        serviceSearch.clickServices();

        serviceSearch.enterSearchText("Test");
        serviceSearch.clickSearchIcon();
    }
}