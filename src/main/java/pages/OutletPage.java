package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OutletPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ===== Locators =====

    private By randomIcon = By.xpath("//i[contains(@class,'fa-random')]");
    private By outletNav = By.xpath("//span[normalize-space()='Outlet']");
    private By plusButton = By.xpath("//button[normalize-space()='+']");
    private By fxPosImage = By.xpath("//div[@title='FX POS (Restaurant order taking app)']");

    private By outletNameInput = By.xpath("//input[@formcontrolname='OutletName']");
    private By outletDescriptionInput = By.xpath("//input[@formcontrolname='OutletDescription']");

    private By outletTypeDropdown =
            By.xpath("//mat-select[.//span[normalize-space()='Select Outlet Type']]");
    private By sessionDropdown =
            By.xpath("//mat-select[.//span[normalize-space()='Select Session']]");
    private By currencyDropdown =
            By.xpath("//mat-select[.//span[normalize-space()='Currency']]");

    private By createButton =
            By.xpath("//button[.//span[normalize-space()='Create']]");

    private By loader =
            By.xpath("//div[contains(@class,'loader-outer')]");

    private By overlayBackdrop =
            By.xpath("//div[contains(@class,'cdk-overlay-backdrop')]");

    // ===== Constructor =====
    public OutletPage(WebDriver driver) {
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

    public void clickOutlet() {
        waitForAngularIdle();
        wait.until(ExpectedConditions.elementToBeClickable(outletNav)).click();
    }

    public void clickAdd() {
        waitForAngularIdle();

        WebElement plus =
                wait.until(ExpectedConditions.elementToBeClickable(plusButton));
        jsClick(plus);
    }

    public void createOutlet() {

        waitForAngularIdle();

        wait.until(ExpectedConditions.visibilityOfElementLocated(outletNameInput))
                .sendKeys("New Outlet");

        driver.findElement(outletDescriptionInput)
                .sendKeys("New");

        selectFromMatDropdown(outletTypeDropdown, "Restaurant");
        selectFromMatDropdown(sessionDropdown, "Breakfast");
        selectFromMatDropdown(currencyDropdown, "Indian Rupee");

        waitForAngularIdle();

        WebElement create =
                wait.until(ExpectedConditions.visibilityOfElementLocated(createButton));
        jsClick(create);
    }
}
