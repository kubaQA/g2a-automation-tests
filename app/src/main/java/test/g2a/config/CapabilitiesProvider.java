package test.g2a.config;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import test.g2a.enums.OsFamily;

public class CapabilitiesProvider {
    private static OsFamily osFamilyDetect() {
        if (SystemUtils.IS_OS_LINUX) {
            return OsFamily.LINUX;
        }
        if (SystemUtils.IS_OS_MAC) {
            return OsFamily.MAC;
        }
        if (SystemUtils.IS_OS_WINDOWS) {
            return OsFamily.WINDOWS;
        }
        return OsFamily.OTHER;
    }

    public static ChromeOptions getChromeCapabilities() {
        String driverBinName = switch (osFamilyDetect()) {
            case WINDOWS -> Constants.WIN_DRIVER_BINARY_NAME;
            case LINUX -> Constants.LINUX_DRIVER_BINARY_NAME;
            case MAC -> Constants.MAC_DRIVER_BINARY_NAME;
            default -> "";
        };

        System.setProperty(
                "webdriver.chrome.driver",
                "src/test/resources/driver-binaries/" + driverBinName
        );

        ChromeOptions chromeOptions = new ChromeOptions();
        // Accept SSL certificates
        chromeOptions.setAcceptInsecureCerts(true);

        // Add headless option if needed (and any other arguments you require)
//        chromeOptions.addArguments("--headless", "--disable-gpu", "--no-sandbox");
//        chromeOptions.addArguments("--no-default-browser-check");
//        chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.5790.170 Safari/537.36");
//
////        chromeOptions.addArguments("--disable-http2");
//        chromeOptions.addArguments("--no-first-run");
//        chromeOptions.addArguments("--disable-default-apps");
//        chromeOptions.addArguments("--disable-infobars");
////        chromeOptions.addArguments("--disable-features=NetworkService");

        // Suppress first run experience
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-infobars");

        // Set the profile directory to a new temporary directory
        chromeOptions.addArguments("user-data-dir=/tmp/test_profile2"); // Change this path as needed for Windows

//         Disable pop-up blocking
        chromeOptions.addArguments("--disable-popup-blocking");
        return chromeOptions;
    }
}