package utils;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();

        // -------- Chrome Preferences (Disable password popups) --------
        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        chromePrefs.put("autofill.profile_enabled", false);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--start-maximized");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--incognito");

        // -------- Fresh Chrome Profile for every run --------
        String tempProfilePath =
                "C:/Temp/ChromeCleanProfile_" + System.currentTimeMillis();
        File profileDir = new File(tempProfilePath);
        if (!profileDir.exists()) {
            profileDir.mkdirs();
        }
        options.addArguments("user-data-dir=" + tempProfilePath);
        // ---------------------------------------------------

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // driver.get("https://fx1qa.idsnext.live/#/login");
        driver.get("https://fx1staging.idsnext.live/#/login");
        //driver.get("https://fx1qa.idsnext.live/#/login");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
