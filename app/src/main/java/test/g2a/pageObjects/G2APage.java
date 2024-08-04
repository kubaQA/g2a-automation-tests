package test.g2a.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Getter;

import java.util.List;

@Getter
public class G2APage {
    private final WebDriver driver;

    // Constructor
    public G2APage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Web elements with @FindBy annotation
    @FindBy(xpath = "//button[contains(text(), 'Accept all')]")
    private WebElement cookiesButton;

    @FindBy(xpath = "//input[@placeholder='What are you looking for?']")
    private WebElement searchBox;

    @FindBy(css = "div[class*='IconContainer'] svg[class*='search_icon']")
    private WebElement searchButton;

    @FindBy(xpath = "//ul[contains(@class, 'indexes__ItemsListContainer')]/li")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//ul[contains(@class, 'StyledListMobile')]/li[1]")
    private WebElement firstProduct;

    @FindBy(xpath = "//div/span[@data-locator='zth-price']")
    private WebElement priceElement;

    @FindBy(xpath = "//div/span[@data-locator='zth-price']/span")
    private WebElement currencyElement;

    @FindBy(xpath = "//input[@type='radio' and @name='priceVariant' and @checked]/following-sibling::span[contains(@class, 'Radiostyles__Description')]/span[@data-locator='zth-price']")
    private WebElement priceElementOnProductPageWithoutDiscount;

    @FindBy(xpath = "//input[@type='radio' and @name='priceVariant' and @checked]/following-sibling::span[contains(@class, 'Radiostyles__Description')]/span[@data-locator='zth-price']/span")
    private WebElement currencyElementOnProductPageWithoutDiscount;

    @FindBy(xpath = "//div[contains(@class, 'PaymentsRadiostyles')]/following-sibling::button[contains(text(), 'Add to cart')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[@data-test-id='primary-button']")
    private WebElement addToCartButtonOnTheDialog;

    @FindBy(xpath = "//h1")
    private WebElement yourCartHeader;

    @FindBy(xpath = "//div[contains(@class, 'PriceDetails')]/span[@data-locator='zth-price']")
    private WebElement priceElementInCart;

    @FindBy(xpath = "//div[contains(@class, 'PriceDetails')]/span[@data-locator='zth-price']/span")
    private WebElement currencyElementInCart;

    @FindBy(xpath = "//span[contains(text(), 'Total price')]/following-sibling::span[@data-locator='zth-price']")
    private WebElement priceElementInCartTotal;

    @FindBy(xpath = "//span[contains(text(), 'Total price')]/following-sibling::span[@data-locator='zth-price']/span")
    private WebElement currencyElementInCartTotal;

    // Define methods to interact with elements
    public void acceptCookies() {
        try {
            cookiesButton.click();
        } catch (Exception e) {
            System.out.println("Cookies button not found, continuing...");
        }
    }

    public void searchForProduct(String productName) {
        searchBox.sendKeys(productName);
        searchButton.click();
    }

    public void clickFirstProduct() {
        firstProduct.click();
    }

    public void addToCart() {
        addToCartButton.click();
        addToCartButtonOnTheDialog.click();
    }

    public String getCartHeader() {
        return yourCartHeader.getText();
    }
}
