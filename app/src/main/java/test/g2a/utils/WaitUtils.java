package test.g2a.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class WaitUtils {

    private final WebDriver driver;
    private int defaultMaxTimeoutForAllWaits = 200;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilOnUrl(Duration timeoutInSeconds, String url) {
        new WebDriverWait(driver, timeoutInSeconds)
                .pollingEvery(Duration.ofMillis(2))
                .ignoring(WebDriverException.class)
                .until(urlContains(url));
    }

    public void waitForElementToBeClickable(WebElement element, Duration timeoutInSeconds) {
        new WebDriverWait(driver, timeoutInSeconds)
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(WebDriverException.class)
                .until(elementToBeClickable(element));
    }

    public void waitForVisibilityOf(WebElement element, Duration maxTimeInSeconds) {
        new WebDriverWait(driver, maxTimeInSeconds)
                .until(visibilityOf(element));
    }

    public void waitForInvisibilityOfElement(WebElement element, Duration timeoutInSeconds) {
        new WebDriverWait(driver, timeoutInSeconds)
                .until(invisibilityOf(element));
    }

}
