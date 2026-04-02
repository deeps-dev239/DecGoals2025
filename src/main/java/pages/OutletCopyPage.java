// package pages;

// import org.openqa.selenium.*;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;

// import java.time.Duration;

// public class OutletCopyPage {

//     private WebDriver driver;
//     private WebDriverWait wait;

//     // ===== Locators =====

//     private By randomIcon = By.xpath("//i[contains(@class,'fa-random')]");
//     private By randomIconAgain= By.xpath("//*[@id=\"rotatespan\"]/i");
//     private By outletNav = By.xpath("//span[normalize-space()='Outlet']");
//     private By fxPosImage = By.xpath("//img[@alt='FX POS']");
//     private By checkBox = By.xpath("//mat-checkbox[@id='mat-checkbox-2']");


//     private By copyButton = By.xpath("//button[normalize-space(text())='Copy']");

//     private By outletNameInput = By.xpath("//input[@formcontrolname='OutletName']");
//     private By outletDescriptionInput = By.xpath("//input[@formcontrolname='OutletDescription']");

//     private By outletTypeDropdown =
//             By.xpath("//mat-select[.//span[normalize-space()='Select Outlet Type']]");
//     private By sessionDropdown =
//             By.xpath("//mat-select[.//span[normalize-space()='Select Session']]");
//     private By currencyDropdown =
//             By.xpath("//mat-select[.//span[normalize-space()='Currency']]");

//     private By createButton =
//             By.xpath("//button[.//span[normalize-space()='Create']]");

//     private By loader =
//             By.xpath("//div[contains(@class,'loader-outer')]");

//     private By overlayBackdrop =
//             By.xpath("//div[contains(@class,'cdk-overlay-backdrop')]");

//     // ===== Constructor =====
//     public OutletCopyPage(WebDriver driver) {
//         this.driver = driver;
//         this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//     }

//     // ===== Common Waits =====

//     private void waitForAngularIdle() {
//         try {
//             wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
//         } catch (Exception ignored) {}

//         try {
//             wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayBackdrop));
//         } catch (Exception ignored) {}
//     }

//     private void jsClick(WebElement element) {
//         ((JavascriptExecutor) driver)
//                 .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
//         ((JavascriptExecutor) driver)
//                 .executeScript("arguments[0].click();", element);
//     }

//     // ===== Angular mat-select handler =====

//     private void selectFromMatDropdown(By dropdown, String optionText) {
//         waitForAngularIdle();

//         WebElement dd =
//                 wait.until(ExpectedConditions.elementToBeClickable(dropdown));
//         jsClick(dd);

//         By option =
//                 By.xpath("//mat-option//span[normalize-space()='" + optionText + "']");
//         WebElement opt =
//                 wait.until(ExpectedConditions.elementToBeClickable(option));
//         jsClick(opt);

//         waitForAngularIdle();
//     }

//     // ===== Actions =====

//     public void clickRandom() {
//         wait.until(ExpectedConditions.elementToBeClickable(fxPosImage)).click();
//         wait.until(ExpectedConditions.elementToBeClickable(randomIcon)).click();
//     }

//      public void clickRandomAgain() {
//         wait.until(ExpectedConditions.elementToBeClickable(randomIconAgain)).click();
//     }

//     public void clickOutlet() {
//         waitForAngularIdle();
//         wait.until(ExpectedConditions.elementToBeClickable(outletNav)).click();
//     }

//     public void clickCheckBox() {
//         wait.until(ExpectedConditions.elementToBeClickable(randomIcon)).click();
//         waitForAngularIdle();
//         wait.until(ExpectedConditions.elementToBeClickable(checkBox)).click();
//     }

//     public void clickAdd() {
//         waitForAngularIdle();

//         WebElement plus =
//                 wait.until(ExpectedConditions.elementToBeClickable(copyButton));
//         jsClick(plus);
//     }

//     public void createOutlet() {

//         waitForAngularIdle();
//         driver.findElement(outletNameInput).clear();
//         driver.findElement(outletDescriptionInput).clear();

//         wait.until(ExpectedConditions.visibilityOfElementLocated(outletNameInput))
//                 .sendKeys("New Copy Outlet");

//         driver.findElement(outletDescriptionInput)
//                 .sendKeys("Copy Descp");

//         //selectFromMatDropdown(outletTypeDropdown, "Restaurant");
//         //selectFromMatDropdown(sessionDropdown, "Breakfast");
//         //selectFromMatDropdown(currencyDropdown, "Euro");

//        // waitForAngularIdle();

//         WebElement create =
//                 wait.until(ExpectedConditions.visibilityOfElementLocated(createButton));
//         jsClick(create);
//     }
// }


package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OutletCopyPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ===== Locators =====

    private By randomIcon = By.xpath("//i[contains(@class,'fa-random')]");
    private By randomIconAgain = By.xpath("//*[@id='rotatespan']/i");
    private By outletNav = By.xpath("//span[normalize-space()='Outlet']");
    private By fxPosImage = By.xpath("//img[@alt='FX POS']");
    private By checkBox = By.xpath("//mat-checkbox[contains(@id,'mat-checkbox')]");

    // ⭐ MORE FLEXIBLE COPY BUTTON LOCATOR
    private By copyButton = By.xpath("//button[.//span[contains(text(),'Copy')]]");

    private By outletNameInput = By.xpath("//input[@formcontrolname='OutletName']");
    private By outletDescriptionInput = By.xpath("//input[@formcontrolname='OutletDescription']");

    private By createButton = By.xpath("//button[.//span[contains(text(),'Create')]]");

    private By loader = By.xpath("//div[contains(@class,'loader-outer')]");
    private By overlayBackdrop = By.xpath("//div[contains(@class,'cdk-overlay-backdrop')]");

    // ===== Constructor =====

    public OutletCopyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    // ===== Common Wait =====

    private void waitForAngularIdle() {

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        } catch (Exception ignored) {}

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayBackdrop));
        } catch (Exception ignored) {}
    }

    // ===== JS Click =====

    private void jsClick(WebElement element) {

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    // ===== Safe Click Method =====

    private void safeClick(By locator) {

        waitForAngularIdle();

        WebElement element =
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        jsClick(element);

        waitForAngularIdle();
    }

    // ===== Actions =====

    public void clickRandom() {

        safeClick(fxPosImage);
        safeClick(randomIcon);
    }

    public void clickRandomAgain() {

        safeClick(randomIconAgain);
    }

    public void clickOutlet() {

        safeClick(outletNav);
    }

    public void clickCheckBox() {

    waitForAngularIdle();

    WebElement checkbox =
            wait.until(ExpectedConditions.elementToBeClickable(checkBox));

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", checkbox);

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", checkbox);

    waitForAngularIdle();
}

    public void clickAdd() {

    waitForAngularIdle();

    By copyButton = By.xpath("//span[normalize-space()='Copy']");

    WebElement copy =
            wait.until(ExpectedConditions.presenceOfElementLocated(copyButton));

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", copy);

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", copy);

    waitForAngularIdle();
}

    public void createOutlet() {

        waitForAngularIdle();

        wait.until(ExpectedConditions.visibilityOfElementLocated(outletNameInput))
                .sendKeys("New Copy Outlet");

        driver.findElement(outletDescriptionInput)
                .sendKeys("Copy Descp");

        safeClick(createButton);
    }
}