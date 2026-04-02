package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ServiceSearchPage extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ===== Locators =====

    private By fxSPAConfigIcon =
            By.xpath("//div[contains(@title,'FX SPA Configuration (FX SPA)')]");

    private By randomIcon =
            By.xpath("//i[contains(@class,'fa-random')]");

    private By servicesNav =
            By.xpath("//span[normalize-space()='Services']");

    private By searchField =
            By.xpath("//input[contains(@placeholder,'Search')]");

    private By searchIcon =
            By.cssSelector("i.fas.fa-search");

    private By loader =
            By.xpath("//div[contains(@class,'loader-outer')]");

    private By overlayBackdrop =
            By.xpath("//div[contains(@class,'cdk-overlay-backdrop')]");

    // ===== Constructor =====

    public ServiceSearchPage(WebDriver driver) {
        super(driver);
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

    private void jsClick(WebElement element) {

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    // ===== Actions =====

    public void clickFXSPAConfigIcon() {

        waitForAngularIdle();

        WebElement fx =
                wait.until(ExpectedConditions.elementToBeClickable(fxSPAConfigIcon));

        jsClick(fx);

        waitForAngularIdle();
    }

    public void switchWindow() {

        String currentWindow = driver.getWindowHandle();

        for (String windowHandle : driver.getWindowHandles()) {

            if (!windowHandle.equals(currentWindow)) {

                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void clickRandom() {

        waitForAngularIdle();

        WebElement icon =
                wait.until(ExpectedConditions.elementToBeClickable(randomIcon));

        jsClick(icon);
    }

    public void clickServices() {

        waitForAngularIdle();

        WebElement services =
                wait.until(ExpectedConditions.elementToBeClickable(servicesNav));

        jsClick(services);

        waitForAngularIdle();
    }

    public void enterSearchText(String text) {

        waitForAngularIdle();

        WebElement field =
                wait.until(ExpectedConditions.elementToBeClickable(searchField));

        field.clear();
        field.sendKeys(text);
    }

    public void clickSearchIcon() {

        waitForAngularIdle();

        WebElement icon =
                wait.until(ExpectedConditions.elementToBeClickable(searchIcon));

        jsClick(icon);

        waitForAngularIdle();
    }
}