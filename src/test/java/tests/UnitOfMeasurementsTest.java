package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.UnitOfMeasurementsPage;
import utils.BaseTest;
import utils.CSVUtils;

public class UnitOfMeasurementsTest extends BaseTest {

    @DataProvider(name = "uomData")
    public Object[][] getUomData() {
        return CSVUtils.readCSV(
                "src/test/resources/testdata/uom_data.csv"
        );
    }

    @Test(dataProvider = "uomData")
    public void createUomFromCSV(String uomCode, String uomName) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("prakash.dakshina@idsnext.com", "Ids@2025");

        UnitOfMeasurementsPage uomPage =
                new UnitOfMeasurementsPage(driver);

        uomPage.clickRandom();
        uomPage.clickUnitOfMeasurements();
        uomPage.clickAdd();

        uomPage.createUnitOfMeasurements(uomCode, uomName);
    }
}

