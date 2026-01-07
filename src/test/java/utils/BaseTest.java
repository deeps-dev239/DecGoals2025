package utils;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    // ===== Thread Safe Driver =====
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    protected WebDriver driver;

    // ===== Extent Report Objects =====
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void startExtentReport() {
        extent = ExtentManager.getInstance();
    }

    @Parameters("browser")
    @BeforeMethod
    public void setup(Method method, String browser) {

        // ===== Create Extent Test =====
        test = extent.createTest(method.getName() + " - " + browser);
        ExtentTestManager.setTest(test);

        if (browser.equalsIgnoreCase("chrome")) {

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

            tlDriver.set(new ChromeDriver(options));
        }

        else if (browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();

            EdgeOptions options = new EdgeOptions();
            options.addArguments("-inprivate");
            options.addArguments("--start-maximized");

            tlDriver.set(new EdgeDriver(options));
        }

        else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");

            tlDriver.set(new FirefoxDriver(options));
        }

        driver = tlDriver.get();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // driver.get("https://fx1qa.idsnext.live/#/login");
        driver.get("https://fx1staging.idsnext.live/#/login");
        //driver.get("https://fx1qa.idsnext.live/#/login");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath =
                    ScreenshotUtils.captureScreenshot(tlDriver.get(), result.getName());

            ExtentTestManager.getTest()
                    .fail(result.getThrowable())
                    .addScreenCaptureFromPath(screenshotPath);
        }

        if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentTestManager.getTest().pass("Test Passed");
        }

        if (result.getStatus() == ITestResult.SKIP) {
            ExtentTestManager.getTest().skip("Test Skipped");
        }

        if (driver != null) {
            driver.quit();
            tlDriver.remove();
        }
    }

    @AfterSuite
    public void flushExtentReport() {
        extent.flush();
    }
}





// package utils;

// import java.io.File;
// import java.lang.reflect.Method;
// import java.time.Duration;
// import java.util.HashMap;
// import java.util.Map;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.testng.ITestResult;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.AfterSuite;
// import org.testng.annotations.BeforeMethod;
// import org.testng.annotations.BeforeSuite;

// import com.aventstack.extentreports.ExtentReports;
// import com.aventstack.extentreports.ExtentTest;

// import io.github.bonigarcia.wdm.WebDriverManager;

// public class BaseTest {

//     protected WebDriver driver;

//     // ===== Extent Report Objects =====
//     protected static ExtentReports extent;
//     protected ExtentTest test;

//     @BeforeSuite
//     public void startExtentReport() {
//         extent = ExtentManager.getInstance();
//     }

//     @BeforeMethod
//     public void setup(Method method) {

//         // ===== Create Extent Test =====
//         test = extent.createTest(method.getName());
//         ExtentTestManager.setTest(test);

//         WebDriverManager.chromedriver().setup();

//         // -------- Chrome Preferences (Disable password popups) --------
//         Map<String, Object> chromePrefs = new HashMap<>();
//         chromePrefs.put("credentials_enable_service", false);
//         chromePrefs.put("profile.password_manager_enabled", false);
//         chromePrefs.put("autofill.profile_enabled", false);

//         ChromeOptions options = new ChromeOptions();
//         options.setExperimentalOption("prefs", chromePrefs);
//         options.addArguments("--start-maximized");
//         options.addArguments("--disable-save-password-bubble");
//         options.addArguments("--incognito");

//         // -------- Fresh Chrome Profile for every run --------
//         String tempProfilePath =
//                 "C:/Temp/ChromeCleanProfile_" + System.currentTimeMillis();
//         File profileDir = new File(tempProfilePath);
//         if (!profileDir.exists()) {
//             profileDir.mkdirs();
//         }
//         options.addArguments("user-data-dir=" + tempProfilePath);
//         // ---------------------------------------------------

//         driver = new ChromeDriver(options);

//         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//         // driver.get("https://fx1qa.idsnext.live/#/login");
//         driver.get("https://fx1staging.idsnext.live/#/login");
//         //driver.get("https://fx1qa.idsnext.live/#/login");
//     }

//     @AfterMethod
//     public void tearDown(ITestResult result) {

//         if (result.getStatus() == ITestResult.FAILURE) {
//             String screenshotPath =
//                     ScreenshotUtils.captureScreenshot(driver, result.getName());

//             ExtentTestManager.getTest()
//                     .fail(result.getThrowable())
//                     .addScreenCaptureFromPath(screenshotPath);
//         }

//         if (result.getStatus() == ITestResult.SUCCESS) {
//             ExtentTestManager.getTest().pass("Test Passed");
//         }

//         if (result.getStatus() == ITestResult.SKIP) {
//             ExtentTestManager.getTest().skip("Test Skipped");
//         }

//         if (driver != null) {
//             driver.quit();
//         }
//     }

//     @AfterSuite
//     public void flushExtentReport() {
//         extent.flush();
//     }
// }





