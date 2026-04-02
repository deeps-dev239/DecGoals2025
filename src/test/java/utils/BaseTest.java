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

//         // -------- COMMON OPTIONS --------
//         options.addArguments("--incognito");
//         options.addArguments("--disable-save-password-bubble");

//         // -------- CI / LINUX SAFE OPTIONS --------
//         // These are REQUIRED for GitHub Actions & Linux runners
//         options.addArguments("--headless=new");          // headless mode
//         options.addArguments("--no-sandbox");
//         options.addArguments("--disable-dev-shm-usage");


//         driver = new ChromeDriver(options);

//         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//         // driver.get("https://fx1staging.idsnext.live/#/login");
//         driver.get("https://fx1qa.idsnext.live/#/login");
//     }

//     // @AfterMethod
//     // public void tearDown(ITestResult result) {

//     //     if (result.getStatus() == ITestResult.FAILURE) {
//     //         String screenshotPath =
//     //                 ScreenshotUtils.captureScreenshot(driver, result.getName());

//     //         ExtentTestManager.getTest()
//     //                 .fail(result.getThrowable())
//     //                 .fail("Screenshot") 
//     //                 .addScreenCaptureFromPath(screenshotPath);
//     //     }

//     //     if (result.getStatus() == ITestResult.SUCCESS) {
//     //         ExtentTestManager.getTest().pass("Test Passed");
//     //     }

//     //     if (result.getStatus() == ITestResult.SKIP) {
//     //         ExtentTestManager.getTest().skip("Test Skipped");
//     //     }

//     //     if (driver != null) {
//     //         driver.quit();
//     //     }
//     // }

//     @AfterMethod
// public void tearDown(ITestResult result) {

//     if (result.getStatus() == ITestResult.FAILURE) {

//         String screenshotPath =
//                 ScreenshotUtils.captureScreenshot(driver, result.getName());

//         ExtentTestManager.getTest()
//                 .fail(result.getThrowable())
//                 .addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
//     }

//     if (result.getStatus() == ITestResult.SUCCESS) {
//         ExtentTestManager.getTest().pass("Test Passed");
//     }

//     if (result.getStatus() == ITestResult.SKIP) {
//         ExtentTestManager.getTest().skip("Test Skipped");
//     }

//     if (driver != null) {
//         driver.quit();
//     }
// }

//     @AfterSuite
//     public void flushExtentReport() {
//         extent.flush();
//     }
// }


package utils;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;

    // ===== Extent Report Objects =====
    protected static ExtentReports extent;
    protected ExtentTest test;

    // ===== Config Reader =====
    protected ConfigReader config = new ConfigReader();

    @BeforeSuite
    public void startExtentReport() {
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void setup(Method method) {

        // ===== Create Extent Test =====
        test = extent.createTest(method.getName());
        ExtentTestManager.setTest(test);

        WebDriverManager.chromedriver().setup();

        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        chromePrefs.put("autofill.profile_enabled", false);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        options.addArguments("--incognito");
        options.addArguments("--disable-save-password-bubble");

        // CI Safe Options
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // ===== URL from config file =====
        driver.get(config.getUrl());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            String screenshotPath =
                    ScreenshotUtils.captureScreenshot(driver, result.getName());

            ExtentTestManager.getTest()
                    .fail(result.getThrowable())
                    .addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
        }

        if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentTestManager.getTest().pass("Test Passed");
        }

        if (result.getStatus() == ITestResult.SKIP) {
            ExtentTestManager.getTest().skip("Test Skipped");
        }

        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void flushExtentReport() {
        extent.flush();
    }
}


