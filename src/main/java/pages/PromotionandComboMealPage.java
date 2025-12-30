package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PromotionandComboMealPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ===== Locators =====

    private By randomIcon = By.xpath("//i[contains(@class,'fa-random')]");
    private By outletNav = By.xpath("//span[normalize-space()='Promotion and Combo Meal']");
    private By plusButton = By.xpath("//button[normalize-space()='+']");

    private By comboMealCodeInput = By.xpath("//input[@formcontrolname='ComboMealCode']");
    private By comboMealNameInput = By.xpath("//input[@formcontrolname='ComboMealName']");
    private By priceInput = By.xpath("//input[@formcontrolname='Price']");
    private By coverInput = By.xpath("//input[@formcontrolname='Covers']");
    private By fxPosImage = By.xpath("//img[@alt='FX POS']");

    private By outletDropdown =
            By.xpath("//mat-select[.//span[normalize-space()='Outlet']]");
    private By taxStructureDropdown =
            By.xpath("//mat-select[.//span[normalize-space()='TaxStructure']]");
    // private By taxAppliedOnDropdown =
    //         By.xpath("//mat-select[.//span[normalize-space()='Tax Applied On']]");

    private By createButton =
            By.xpath("//button[.//span[normalize-space()='Create']]");

    private By verifyAddPromotion = By.xpath("//mat-select[.//span[normalize-space()='Active']]");

    private By loader =
            By.xpath("//div[contains(@class,'loader-outer')]");

    private By overlayBackdrop =
            By.xpath("//div[contains(@class,'cdk-overlay-backdrop')]");

    // ===== Constructor =====
    public PromotionandComboMealPage(WebDriver driver) {
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

    private void selectFromMatDropdown(By dropdown, String optionText) {
        waitForAngularIdle();

        WebElement dd =
                wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        jsClick(dd);

        By option =
                By.xpath("//mat-option//span[normalize-space()='" + optionText + "']");
        WebElement opt =
                wait.until(ExpectedConditions.elementToBeClickable(option));
        jsClick(opt);

        waitForAngularIdle();
    }

    // ===== Actions =====

    public void clickRandom() {
        wait.until(ExpectedConditions.elementToBeClickable(fxPosImage)).click();
        wait.until(ExpectedConditions.elementToBeClickable(randomIcon)).click();
    }

    public void clickPromotionandComboMeal() {
        waitForAngularIdle();
        wait.until(ExpectedConditions.elementToBeClickable(outletNav)).click();
    }

    public void clickAdd() {
        waitForAngularIdle();

        WebElement plus =
                wait.until(ExpectedConditions.elementToBeClickable(plusButton));
        jsClick(plus);
    }

    public void createPromotionandComboMeal() {

        String randomName = RandomStringUtils.randomAlphabetic(6);
        String randomNumeric = RandomStringUtils.randomNumeric(3);

        waitForAngularIdle();

        wait.until(ExpectedConditions.visibilityOfElementLocated(comboMealCodeInput))
                .sendKeys(randomNumeric);
        wait.until(ExpectedConditions.visibilityOfElementLocated(comboMealNameInput))
                .sendKeys("New Name " + randomName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(priceInput))
                .sendKeys(randomNumeric);

        driver.findElement(coverInput)
                .sendKeys(randomNumeric);

        selectFromMatDropdown(outletDropdown, "Banquets");
        selectFromMatDropdown(taxStructureDropdown, "Ras");

        waitForAngularIdle();

        WebElement create =
                wait.until(ExpectedConditions.visibilityOfElementLocated(createButton));
        jsClick(create);

        wait.until(ExpectedConditions.visibilityOfElementLocated(verifyAddPromotion)).click();
    }
}
