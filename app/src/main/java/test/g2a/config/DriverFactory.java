package test.g2a.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static test.g2a.config.Constants.DRIVER_TYPE;
import static test.g2a.config.DriverTypes.CHROME;


public class DriverFactory {

    public WebDriver webDriver;

    WebDriver startBrowser() {
        switch (DRIVER_TYPE) {
            case CHROME:
                webDriver = new ChromeDriver(CapabilitiesProvider.getChromeCapabilities());
                webDriver.manage().window().maximize();
                break;
        }
        webDriver.manage().deleteAllCookies();
        return webDriver;
    }
}
