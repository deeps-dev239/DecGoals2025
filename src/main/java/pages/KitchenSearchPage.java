package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KitchenSearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ===== Locators =====

    private By randomIcon = By.xpath("//i[contains(@class,'fa-random')]");
    private By kitchenNav = By.xpath("//span[normalize-space()='Kitchen']");
    private By searchField = By.xpath("//mat-form-field//input[contains(@class,'mat-input-element')]"); 
    private By searchIcon = By.cssSelector("i.fas.fa-search");
    private By fxPosImage = By.xpath("//img[@alt='FX POS']");


    // private By plusButton = By.xpath("//button[normalize-space()='+']");

    // private By shortNameInput = By.xpath("//input[@formcontrolname='ShortName']");
    // private By longNameInput = By.xpath("//input[@formcontrolname='LongName']");
    // private By kitchenPathInput = By.xpath("//input[@formcontrolname='KitchenPath']");
    
    // private By verifyAddKitchen = By.xpath("//mat-header-cell[contains(text(),'Kitchen Short')]");

    // private By createButton =
    //         By.xpath("//button[.//span[normalize-space()='Create']]");

    private By loader =
            By.xpath("//div[contains(@class,'loader-outer')]");

    private By overlayBackdrop =
            By.xpath("//div[contains(@class,'cdk-overlay-backdrop')]");

    // ===== Constructor =====
    public KitchenSearchPage(WebDriver driver) {
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
        wait.until(ExpectedConditions.elementToBeClickable(fxPosImage)).click();
        wait.until(ExpectedConditions.elementToBeClickable(randomIcon)).click();
    }

    public void clickKitchen() {
        waitForAngularIdle();
        wait.until(ExpectedConditions.elementToBeClickable(kitchenNav)).click();
    }

    public void enterSearchText() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    WebElement field = wait.until(
        ExpectedConditions.elementToBeClickable(searchField)
    );
    field.clear();
    field.sendKeys("Test");
}

public void clickSearchIcon() {
    driver.findElement(searchIcon).click();
    waitForAngularIdle();
}


}




    // public void clickAdd() {
    //     waitForAngularIdle();

    //     WebElement plus =
    //             wait.until(ExpectedConditions.elementToBeClickable(plusButton));
    //     jsClick(plus);
    // }

    // public void createKitchen() {

    //     waitForAngularIdle();

    //     wait.until(ExpectedConditions.visibilityOfElementLocated(shortNameInput))
    //             .sendKeys("New Kitchen");

    //     driver.findElement(longNameInput)
    //             .sendKeys("New");

    //     driver.findElement(kitchenPathInput)
    //             .sendKeys("New Path");

        

    //     waitForAngularIdle();

    //     WebElement create =
    //             wait.until(ExpectedConditions.visibilityOfElementLocated(createButton));
    //     jsClick(create);

    //     wait.until(ExpectedConditions.visibilityOfElementLocated(verifyAddKitchen)).click();

    

