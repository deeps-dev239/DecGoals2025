package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductsSearchPage;
import utils.BaseTest;

public class ProductsSearchTest extends BaseTest {

    @Test
    public void verifyProductsSearch() {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getUsername(), config.getPassword());

        ProductsSearchPage productsSearchPage =
                new ProductsSearchPage(driver);

        // Step 2: Open FX SPA
        productsSearchPage.clickFXSPAConfigIcon();
        productsSearchPage.switchWindow();

        // Step 3: Navigate to Products
        productsSearchPage.clickRandom();
        productsSearchPage.clickProducts();

        // Step 4: Search Product
        productsSearchPage.enterSearchText("Test");
        productsSearchPage.clickSearchIcon();
    }
}