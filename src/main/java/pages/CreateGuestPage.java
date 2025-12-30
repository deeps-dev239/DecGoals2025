package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateGuestPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By threedotbtn = By.xpath("//i[contains(@class,'fa-ellipsis-v')]/parent::button");
    private By firstNameField = By.id("mat-input-21");
    private By middleNameField = By.id("mat-input-22");
    private By lastNameField = By.id("mat-input-23");
    private By saveBtn = By.xpath("//button[text()='Save']");
    private By crossBtn = By.cssSelector("button.cross-button");


    public CreateGuestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    // Methods to perform actions

    public void clickThreeDot() {
    By threeDot = By.xpath("//i[contains(@class,'fa-ellipsis-v')]/parent::button");

    WebElement element = wait.until(
            ExpectedConditions.presenceOfElementLocated(threeDot));

    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});", element);

    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();", element);
}

    public void enterNameDetails(String first, String middle, String last) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).clear();
        driver.findElement(firstNameField).sendKeys(first);

        wait.until(ExpectedConditions.visibilityOfElementLocated(middleNameField)).clear();
        driver.findElement(middleNameField).sendKeys(middle);

        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).clear();
        driver.findElement(lastNameField).sendKeys(last);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
    }

    public void clickCross() {
        wait.until(ExpectedConditions.elementToBeClickable(crossBtn)).click();
    }
}
