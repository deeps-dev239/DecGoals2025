package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DiscountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ===== Locators =====

    private By randomIcon = By.xpath("//i[contains(@class,'fa-random')]");
    private By outletNav = By.xpath("//span[normalize-space()='Discount']");
    private By plusButton = By.xpath("//button[normalize-space()='+']");

    private By discountCodeInput = By.xpath("//input[@formcontrolname='Code']");
    private By discountNameInput = By.xpath("//input[@formcontrolname='Name']");
    private By discountValueInput = By.xpath("//input[@formcontrolname='Value']");
    private By discountDescriptionInput = By.xpath("//input[@formcontrolname='Description']");

    private By categoryDropdown =
            By.xpath("//mat-select[.//span[normalize-space()='Category']]");
    private By typeDropdown =
            By.xpath("//mat-select[.//span[normalize-space()='Type']]");
    private By taxAppliedOnDropdown =
            By.xpath("//mat-select[.//span[normalize-space()='Tax Applied On']]");

    private By createButton =
            By.xpath("//button[.//span[normalize-space()='Save']]");

    private By verifyAddSession = By.xpath("//th[contains(text(),'Outlet')]");

    private By loader =
            By.xpath("//div[contains(@class,'loader-outer')]");

    private By overlayBackdrop =
            By.xpath("//div[contains(@class,'cdk-overlay-backdrop')]");

    // ===== Constructor =====
    public DiscountPage(WebDriver driver) {
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
        wait.until(ExpectedConditions.elementToBeClickable(randomIcon)).click();
    }

    public void clickDiscount() {
        waitForAngularIdle();
        wait.until(ExpectedConditions.elementToBeClickable(outletNav)).click();
    }

    public void clickAdd() {
        waitForAngularIdle();

        WebElement plus =
                wait.until(ExpectedConditions.elementToBeClickable(plusButton));
        jsClick(plus);
    }

    public void createDiscount() {

        String randomName = RandomStringUtils.randomAlphabetic(6);
        String randomNumeric = RandomStringUtils.randomNumeric(4);

        waitForAngularIdle();

        wait.until(ExpectedConditions.visibilityOfElementLocated(discountCodeInput))
                .sendKeys(randomNumeric);
        wait.until(ExpectedConditions.visibilityOfElementLocated(discountNameInput))
                .sendKeys("New Name " + randomName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(discountValueInput))
                .sendKeys("New Value" + randomName);

        driver.findElement(discountDescriptionInput)
                .sendKeys("New Description " + randomName);

        selectFromMatDropdown(categoryDropdown, "Prmotional");
        selectFromMatDropdown(typeDropdown, "Amount");
        selectFromMatDropdown(taxAppliedOnDropdown, "On Value");

        waitForAngularIdle();

        WebElement create =
                wait.until(ExpectedConditions.visibilityOfElementLocated(createButton));
        jsClick(create);

        wait.until(ExpectedConditions.visibilityOfElementLocated(verifyAddSession)).click();
    }
}
