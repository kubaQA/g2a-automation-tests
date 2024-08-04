package test.g2a.config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import test.g2a.utils.ScreenshotUtil;
import test.g2a.utils.WaitUtils;

import java.time.Duration;

import static test.g2a.config.Constants.BASE_URL;

public abstract class TestBase {

    public WebDriver driver;
    public WaitUtils waitUtils;
    protected ExtentReports extentReports;
    protected ExtentTest extentTest;
    protected ScreenshotUtil screenshotUtil;

    @BeforeClass(alwaysRun = true)
    public void prepareSuite() {
        driver = new DriverFactory().startBrowser();
        waitUtils = new WaitUtils(driver);
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
        waitUtils.waitUntilOnUrl(Duration.ofSeconds(10), BASE_URL);

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("G2ATestReport.html");
        sparkReporter.config().setDocumentTitle("G2A Automation Test Report");
        sparkReporter.config().setReportName("G2A Product Price Verification");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);

        // Set system information for the report
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        extentReports.flush();
    }
}
