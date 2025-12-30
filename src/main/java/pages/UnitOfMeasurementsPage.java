package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UnitOfMeasurementsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ===== Locators =====

    private By randomIcon = By.xpath("//i[contains(@class,'fa-random')]");
    private By unitOfMeasurementNav = By.xpath("//span[normalize-space()='Unit Of Measurement']");
    private By plusButton = By.xpath("//button[normalize-space()='+']");

    private By uomCode = By.xpath("//input[@formcontrolname='UomCode']");
    private By uomName = By.xpath("//input[@formcontrolname='UomName']");
    
    private By verifyAddUnitOfMeasurement = By.xpath("//mat-header-cell[contains(text(),'Code')]");

    private By createButton =
            By.xpath("//button[.//span[normalize-space()='Create']]");

    private By loader =
            By.xpath("//div[contains(@class,'loader-outer')]");

    private By overlayBackdrop =
            By.xpath("//div[contains(@class,'cdk-overlay-backdrop')]");

    // ===== Constructor =====
    public UnitOfMeasurementsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    // ===== Common Waits =====

    private void waitForAngularIdle() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        } catch (Exception ignored) {}

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayBackdrop));
        } catch (Exception ignored) {}
    }

    private void jsClick(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    // ===== Angular mat-select handler =====

    // private void selectFromMatDropdown(By dropdown, String optionText) {
    //     waitForAngularIdle();

    //     WebElement dd =
    //             wait.until(ExpectedConditions.elementToBeClickable(dropdown));
    //     jsClick(dd);

    //     By option =
    //             By.xpath("//mat-option//span[normalize-space()='" + optionText + "']");
    //     WebElement opt =
    //             wait.until(ExpectedConditions.elementToBeClickable(option));
    //     jsClick(opt);

    //     waitForAngularIdle();
    // }

    // ===== Actions =====

    public void clickRandom() {
        wait.until(ExpectedConditions.elementToBeClickable(randomIcon)).click();
    }

    public void clickUnitOfMeasurements() {
        waitForAngularIdle();
        wait.until(ExpectedConditions.elementToBeClickable(unitOfMeasurementNav)).click();
    }

    public void clickAdd() {
        waitForAngularIdle();

        WebElement plus =
                wait.until(ExpectedConditions.elementToBeClickable(plusButton));
        jsClick(plus);
    }

    public void createUnitOfMeasurements() {

        String randomName = RandomStringUtils.randomAlphabetic(6);
        String randomNumeric = RandomStringUtils.randomNumeric(3);

        waitForAngularIdle();

        wait.until(ExpectedConditions.visibilityOfElementLocated(uomCode))
                .sendKeys(randomNumeric);

        driver.findElement(uomName)
                .sendKeys("New Name " + randomName);

        

        waitForAngularIdle();

        WebElement create =
                wait.until(ExpectedConditions.visibilityOfElementLocated(createButton));
        jsClick(create);

        wait.until(ExpectedConditions.visibilityOfElementLocated(verifyAddUnitOfMeasurement)).click();

    }
}
