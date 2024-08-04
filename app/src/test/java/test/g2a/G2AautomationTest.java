package test.g2a;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.g2a.config.TestBase;
import test.g2a.pageObjects.G2APage;
import test.g2a.utils.WaitUtils;

import java.time.Duration;
import java.util.List;

public class G2AautomationTest extends TestBase {

    private G2APage g2APage;

    @BeforeClass
    public void initOperations() {
        g2APage = new G2APage(driver);
        waitUtils = new WaitUtils(driver);

        // Accept cookies
        g2APage.acceptCookies();
    }

    @Parameters({"productName"})
    @Test
    public void testG2A(@Optional("Cyberpunk 2077 & Phantom Liberty Bundle (PC) - Steam Account - GLOBAL") String productName) {
        extentTest = extentReports.createTest("G2A Price Verification Test - " + productName);

        try {
            // Search for the product
            extentTest.log(Status.INFO, "Searching for product: " + productName);
            g2APage.searchForProduct(productName);

            // Wait for search results to load and select the first result
            List<WebElement> searchResults = g2APage.getSearchResults();
            Assert.assertFalse(searchResults.isEmpty(), "Search results are empty!");
            extentTest.log(Status.PASS, "Search results found.");

            // Click on the first product
            extentTest.log(Status.INFO, "Clicking on the first product.");
            WebElement firstProduct = g2APage.getFirstProduct();
            String price = g2APage.getPriceElement().getText();
            String currency = g2APage.getCurrencyElement().getText();
            extentTest.log(Status.INFO, "Product Price: " + price + " " + currency);

            g2APage.clickFirstProduct();

            String priceOnProductPageWithoutDiscount = g2APage.getPriceElementOnProductPageWithoutDiscount().getText();
            String currencyOnProductPageWithoutDiscount = g2APage.getCurrencyElementOnProductPageWithoutDiscount().getText();
            extentTest.log(Status.INFO, "Price on product page: " + priceOnProductPageWithoutDiscount + " " + currencyOnProductPageWithoutDiscount);

            Assert.assertEquals(price, priceOnProductPageWithoutDiscount, "Prices do not match on product page");
            Assert.assertEquals(currency, currencyOnProductPageWithoutDiscount, "Currencies do not match on product page");
            extentTest.log(Status.PASS, "Price and currency match on product page.");

            // Add to cart
            extentTest.log(Status.INFO, "Adding product to cart.");
            g2APage.addToCart();

            // Verify cart contents
            waitUtils.waitForVisibilityOf(g2APage.getYourCartHeader(), Duration.ofSeconds(10));
            Assert.assertEquals("Your cart", g2APage.getCartHeader(), "Cart header does not match");
            extentTest.log(Status.PASS, "Navigated to cart page.");

            String priceInCart = g2APage.getPriceElementInCart().getText();
            String currencyInCart = g2APage.getCurrencyElementInCart().getText();
            extentTest.log(Status.INFO, "Price in cart: " + priceInCart + " " + currencyInCart);

            Assert.assertEquals(price, priceInCart, "Prices do not match in cart");
            Assert.assertEquals(currency, currencyInCart, "Currencies do not match in cart");
            extentTest.log(Status.PASS, "Price and currency match in cart.");

            String priceInCartTotal = g2APage.getPriceElementInCartTotal().getText();
            String currencyInCartTotal = g2APage.getCurrencyElementInCartTotal().getText();
            extentTest.log(Status.INFO, "Total price in cart: " + priceInCartTotal + " " + currencyInCartTotal);

            Assert.assertEquals(price, priceInCartTotal, "Total prices do not match in cart");
            Assert.assertEquals(currency, currencyInCartTotal, "Total currencies do not match in cart");
            extentTest.log(Status.PASS, "Total price and currency match in cart.");
        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Test failed: " + e.getMessage());
            String screenshotPath = screenshotUtil.takeScreenshot(productName);
            extentTest.addScreenCaptureFromPath(screenshotPath);
            Assert.fail("Test failed with exception: " + e.getMessage());
        }
    }
}
