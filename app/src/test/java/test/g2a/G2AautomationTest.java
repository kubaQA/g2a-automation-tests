package test.g2a;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.g2a.config.TestBase;

import java.time.Duration;
import java.util.List;

public class G2AautomationTest extends TestBase {

    @BeforeClass
    public void initOperations() {
        try {
            WebElement cookiesButton = driver.findElement(By.xpath("//button[contains(text(), 'Accept all')]"));
            cookiesButton.click();
        } catch (Exception e) {
            System.out.println("Cookies button not found, continuing...");
        }
    }

    @Parameters({"productName"})
    @Test
    public void testG2A() {
        // Search for the product
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='What are you looking for?']"));

        WebElement searchButton = driver.findElement(By.cssSelector("div[class*='IconContainer'] svg[class*='search_icon']"));
        searchBox.sendKeys("Cyberpunk 2077 & Phantom Liberty Bundle (PC) - Steam Account - GLOBAL");
        // Wait for search results to load and select the first result

        List<WebElement> searchResults = driver.findElements(By.xpath("//ul[contains(@class, 'indexes__ItemsListContainer'])/li"));
        Assert.assertFalse(searchResults.isEmpty(), "Search results are empty!");
        searchButton.click();

        // Click on the first product
        WebElement firstProduct = driver.findElement(By.xpath("//ul[contains(@class, 'StyledListMobile')]/li[1]"));
        WebElement priceElement = firstProduct.findElement(By.xpath("//div/span[@data-locator = 'zth-price']"));

        String price = priceElement.getText();
        String currency = priceElement.findElement(By.xpath("/span")).getText();

        firstProduct.click();

        WebElement priceElementOnProductPageWithoutDiscount = firstProduct.findElement(By.xpath("//input[@type='radio' and @name='priceVariant' and @checked]/following-sibling::span[contains(@class, 'Radiostyles__Description')]/span[@data-locator = 'zth-price']"));
        String priceOnProductPageWithoutDiscount = priceElementOnProductPageWithoutDiscount.getText();
        WebElement currencyElementOnProductPageWithoutDiscount = priceElementOnProductPageWithoutDiscount.findElement(By.xpath("/span"));
        String currencyOnProductPageWithoutDiscount = currencyElementOnProductPageWithoutDiscount.getText();

        Assert.assertEquals(price, priceOnProductPageWithoutDiscount);
        Assert.assertEquals(currency, currencyOnProductPageWithoutDiscount);

        WebElement addToCartButton = firstProduct.findElement(By.xpath("//div[contains(@class, 'PaymentsRadiostyles')]/following-sibling::button[contains(text(), 'Add to cart')]"));

        addToCartButton.click();
        WebElement addToCartButtonOnTheDialog = firstProduct.findElement(By.xpath("//button[@data-test-id='primary-button']"));
        addToCartButtonOnTheDialog.click();

        WebElement yourCartHeader = firstProduct.findElement(By.xpath("//h1"));
        waitUtils.waitForVisibilityOf(yourCartHeader, Duration.ofSeconds(10));
        Assert.assertEquals("Your cart", yourCartHeader.getText());

        WebElement priceElementInCart = firstProduct.findElement(By.xpath("//div[contains(@class, 'PriceDetails')]/span[@data-locator = 'zth-price']"));
        String priceInCart = priceElementInCart.getText();
        WebElement currencyElementInCart = priceElementOnProductPageWithoutDiscount.findElement(By.xpath("/span"));
        String currencyInCart = currencyElementInCart.getText();

        Assert.assertEquals(price, priceInCart);
        Assert.assertEquals(currency, currencyInCart);

        WebElement priceElementInCartTotal = firstProduct.findElement(By.xpath("//span[contains(text(), 'Total price')]/following-sibling::span[@data-locator= 'zth-price']"));
        String priceInCartTotal = priceElementInCartTotal.getText();
        WebElement currencyElementInCartTotal = priceElementOnProductPageWithoutDiscount.findElement(By.xpath("/span"));
        String currencyInCartTotal = currencyElementInCartTotal.getText();

        Assert.assertEquals(price, priceInCartTotal);
        Assert.assertEquals(currency, currencyInCartTotal);

//
//        // Capture the product price from the product details page
//        WebElement priceElement = driver.findElement(By.cssSelector(".Card-sc-1p6lqxk-0"));
//        String productPriceText = priceElement.getText().replaceAll("[^\\d.,]", "");
//        double productPrice = Double.parseDouble(productPriceText.replace(',', '.'));
//
////        extentTest.log(Status.INFO, "Product price on the product page: " + productPrice);
//
//        // Add the product to the cart
//        WebElement addToCartButton = driver.findElement(By.cssSelector(".jsx-2515979734"));
//        addToCartButton.click();
//
//        // Navigate to the cart
//        WebElement cartButton = driver.findElement(By.cssSelector("a[href='/cart']"));
//        cartButton.click();
//
//        // Capture the product price from the cart
//        WebElement cartPriceElement = driver.findElement(By.cssSelector(".cart-summary-prices__total__amount"));
//        String cartPriceText = cartPriceElement.getText().replaceAll("[^\\d.,]", "");
//        double cartPrice = Double.parseDouble(cartPriceText.replace(',', '.'));
//
////        extentTest.log(Status.INFO, "Product price in the cart: " + cartPrice);
//
//        // Assert that the price on the product page matches the price in the cart
//        Assert.assertEquals(cartPrice, productPrice, "The price in the cart does not match the product page price!");

//        extentTest.log(Status.PASS, "Price verified successfully!");
    }
}
