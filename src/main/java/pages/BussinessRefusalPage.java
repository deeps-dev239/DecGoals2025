package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BussinessRefusalPage {

    private WebDriver driver;
    private WebDriverWait wait;

    
    private By fxReportsIcon =
            By.xpath("//div[contains(@title,'FX Reports (FX Reports)')]");

    private By randomIcon =
            By.xpath("(//span[contains(@class,'icon-shuffle shuffle-ico')])[1]");

    private By reportsLabel =
            By.xpath("//a[@id='Reports']");

    private By spaReports =
            By.xpath("//span[normalize-space()='SPA Reports']");

    private By bRefusal =
            By.xpath("(//span[normalize-space()='Business Refusal Report'])");

          private By calendar = By.xpath("(//button[@aria-label=\"Open calendar\"])[1]");

           private By calendarDate = By.xpath("//button[@aria-label=\"2 December 2025\"]");
        private By generateButton = By.xpath("//button[contains(text(),'Generate Report')]");


    private By loader =
            By.xpath("//div[contains(@class,'loader-outer')]");

    private By overlayBackdrop =
            By.xpath("//div[contains(@class,'cdk-overlay-backdrop')]");

    // ===== Constructor =====
    public BussinessRefusalPage(WebDriver driver) {
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

    // ===== Actions =====


    public void clickFXReport() {
        waitForAngularIdle();
        WebElement fx =
                wait.until(ExpectedConditions.elementToBeClickable(fxReportsIcon));
        jsClick(fx);
        waitForAngularIdle();
    }

    public void clickRandom() {
        wait.until(ExpectedConditions.elementToBeClickable(randomIcon)).click();
    }

    public void clickReportSLabel() {
        waitForAngularIdle();
        wait.until(ExpectedConditions.elementToBeClickable(reportsLabel)).click();
    }

    public void clickSPAReport() {
        waitForAngularIdle();
        wait.until(ExpectedConditions.elementToBeClickable(spaReports)).click();
    }

    public void clickbRefusal() {
        waitForAngularIdle();
        wait.until(ExpectedConditions.elementToBeClickable(bRefusal)).click();
    }

    public void clickCalender() {
        waitForAngularIdle();
        wait.until(ExpectedConditions.elementToBeClickable(calendar)).click();
    }

    public void clickCalenderDate() {
        waitForAngularIdle();
        wait.until(ExpectedConditions.elementToBeClickable(calendarDate)).click();
    }

    public void clickGenerate() {
        waitForAngularIdle();
        wait.until(ExpectedConditions.elementToBeClickable(generateButton)).click();
        waitForAngularIdle();
    }
}
