package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BillSeriesSetupPage extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    
    private By fxSPAConfigIcon =
            By.xpath("//div[contains(@title,'FX SPA Configuration (FX SPA)')]");

    private By loader =
            By.xpath("//div[contains(@class,'loader-outer')]");

    private By overlayBackdrop =
            By.xpath("//div[contains(@class,'cdk-overlay-backdrop')]");

    private By randomIcon =
           By.xpath("/html/body/app-root/div[1]/nav/ul/li/a/span[1]");

    private By resources=
            By.xpath("//span[normalize-space()='Bill Series Setup']");

            private By plusButton = By.xpath("//button[normalize-space()='+']");

    private By kotNum= By.xpath("//input[@formcontrolname='kotNumber']");
    private By billNum= By.xpath("//input[@formcontrolname='billNumber']");
    private By outlets= By.xpath("//mat-select[@formcontrolname='outletCode']");
  

    
    private By createButton =
            By.xpath("//button[contains(text(),' Save ')]");


    // ===== Constructor =====
    public BillSeriesSetupPage(WebDriver driver) {
        super(driver);
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


    public void clickFXSPAConfigIcon() {
        waitForAngularIdle();
        WebElement fx =
                wait.until(ExpectedConditions.elementToBeClickable(fxSPAConfigIcon));
        jsClick(fx);
        waitForAngularIdle();
    }

    public void switchWindow(){
        String currentWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

       public void clickRandom() throws InterruptedException {
        waitForAngularIdle();
        wait.until(ExpectedConditions.elementToBeClickable(randomIcon)).click();
       // Thread.sleep(10000); // Temporary wait to observe the click action, replace with proper wait if needed
    }


    public void clickBillServiceSetup() {
        waitForAngularIdle();
        wait.until(ExpectedConditions.elementToBeClickable(resources)).click();
        waitForAngularIdle();
    }

     public void clickAdd() {
        waitForAngularIdle();

        WebElement plus =
                wait.until(ExpectedConditions.elementToBeClickable(plusButton));
        jsClick(plus);
    }

    public void createBillServiceSetup() {

        String randomName = RandomStringUtils.randomAlphabetic(4);
        String randomNumeric = RandomStringUtils.randomNumeric(2);

        waitForAngularIdle();

        selectFromMatDropdown(outlets, "Zen Spa");

        wait.until(ExpectedConditions.visibilityOfElementLocated(kotNum))
                .sendKeys(randomNumeric);

        wait.until(ExpectedConditions.visibilityOfElementLocated(billNum))
                .sendKeys(randomNumeric);
        

        waitForAngularIdle();

        WebElement create =
                wait.until(ExpectedConditions.visibilityOfElementLocated(createButton));
        jsClick(create);
        waitForAngularIdle();


    
}
}