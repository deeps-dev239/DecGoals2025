package pages; 
import org.openqa.selenium.By; 
import org.openqa.selenium.JavascriptExecutor; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.ui.ExpectedConditions; 
import org.openqa.selenium.support.ui.WebDriverWait; 
import java.time.Duration; 

public class CreateTravelAgentPage 
{ 
    
    private WebDriver driver; private WebDriverWait wait;
     // Locators 
     private By threeDot = By.xpath("//i[contains(@class,'fa-ellipsis-v')]/parent::button"); 
     private By companyNameInput =By.xpath("//input[@formcontrolname='CompanyName']"); 
     private By contactNameInput = By.xpath("//input[@formcontrolname='ContactName']"); 
     private By mobileInput = By.xpath("//input[@formcontrolname='Mobile']"); 
     private By saveButton =By.xpath("//button[normalize-space()='Save']"); 
     private By guestBtn = By.xpath("//img[@alt='FX Reservation']");
     
     public CreateTravelAgentPage(WebDriver driver) 
     { 
        this.driver = driver; 
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50)); } 

    private void jsClick(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }  
      
      
        // Methods to perform actions 
     
     public void clickFX(){
        wait.until(ExpectedConditions.elementToBeClickable(guestBtn)).click();
     }
     
        public void clickTravelAgentThreeDot() {

    By travelAgentThreeDot = By.xpath(
        "(//button[contains(@class,'input-close')]//i[contains(@class,'fa-ellipsis-v')])[2]/parent::button"
    );

    WebElement element = wait.until(
            ExpectedConditions.presenceOfElementLocated(travelAgentThreeDot));
    jsClick(element);

    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});", element);

    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();", element);
}

             public void enterNameDetails(String companyName, String contactName, String mobile) 
             {
                 wait.until(ExpectedConditions.visibilityOfElementLocated(companyNameInput)).clear(); 
                 driver.findElement(companyNameInput).sendKeys(companyName); 
                 wait.until(ExpectedConditions.visibilityOfElementLocated(contactNameInput)).clear(); 
                 driver.findElement(contactNameInput).sendKeys(contactName); 
                 wait.until(ExpectedConditions.visibilityOfElementLocated(mobileInput)).clear(); 
                 driver.findElement(mobileInput).sendKeys(mobile); } 
                 
                 public void clickSave() { 
                    wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click(); 
                } 
                }