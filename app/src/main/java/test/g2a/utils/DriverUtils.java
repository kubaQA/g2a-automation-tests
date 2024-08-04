package test.g2a.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class DriverUtils {

    public WebDriver driver;
    private WaitUtils waitUtils;
    private Duration timeoutInSec = Duration.ofSeconds(15);

    public DriverUtils(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    public String getText(WebElement element) {
        waitUtils.waitForVisibilityOf(element, timeoutInSec);
        return element.getText();
    }

    public void clickTheButton(WebElement element) {
        waitUtils.waitForElementToBeClickable(element, timeoutInSec);
        element.click();
    }

    public void typeText(WebElement element, String text) {
        waitUtils.waitForElementToBeClickable(element, timeoutInSec);
        element.sendKeys(text);
    }

    public void executeClick(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        waitUtils.waitForVisibilityOf(element, timeoutInSec);
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public void bringElementToViewport(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView()", element);
    }
}
