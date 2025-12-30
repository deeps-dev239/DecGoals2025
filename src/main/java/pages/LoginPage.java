package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // private By username = By.xpath("//input[@type='text']");
    private By username = By.id("md-input-0-input");
    // private By password = By.id("md-input-1-input");
    private By password = By.id("md-input-1-input");
    // private By loginButton   = By.xpath("//button[.//span[text()='Login']]");
    private By loginButton   = By.xpath("//button[.//span[normalize-space()='Login']]");
    // private By reservationBtn = By.xpath("//app-home//img");
    private By fxPosImage = By.xpath("//img[@alt='FX POS']");

    private By guestBtn = By.xpath("//img[@alt='FX Reservation']");
    private By randomIcon = By.xpath("//i[contains(@class,'fa-random')]");





    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(reservationBtn)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(fxPosImage)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(guestBtn)).click();
       // wait.until(ExpectedConditions.elementToBeClickable(randomIcon)).click();


    }
}
