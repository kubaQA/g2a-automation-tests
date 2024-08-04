package test.g2a.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class G2aHomePage {

    @FindBy(xpath = "//div[@class='bundle-wrap']//h2")
    private WebElement heyahOfferName;
//
//    @FindBy(xpath = "//button[@data-event-id='proceed to checkout']")
//    private WebElement nextButton;
//
//    @FindBy(id = "text")
//    private WebElement emailField;
//
//    @FindBy(css = "button[data-event-id='next']")
//    private WebElement nextButtonOnEmailStep;
//
//    @FindBy(xpath = "//form//button")
//    private WebElement nextButtonOnConfirmEmailStep;
//
//    @FindBy(xpath = "//div[contains(text(),'Podaj jeszcze raz swój adres e-mail')]//following-sibling::input")
//    private WebElement confirmEmailField;
//
//    @FindBy(xpath = "//div[contains(text(),'Jak chcesz zweryfikować swoją tożsamość?')]/following-sibling::div")
//    private WebElement verifyingSelectList;
//
//    @FindBy(xpath = "//div[@title='Kurier']")
//    private WebElement courierButton;
//
    @FindBy(css = "button[data-event-id='verfication next']")
    private WebElement nextButtonOnVerificationStep;

    public G2aHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

//    public WebElement getHeyahOfferName() {
//        return heyahOfferName;
//    }
//
//    public WebElement getNextButton() {
//        return nextButton;
//    }
//
//    public WebElement getEmailField() {
//        return emailField;
//    }
//
//    public WebElement getNextButtonOnEmailStep() {
//        return nextButtonOnEmailStep;
//    }
//
//    public WebElement getNextButtonOnConfirmEmailStep() {
//        return nextButtonOnConfirmEmailStep;
//    }
//
//    public WebElement getConfirmEmailField() {
//        return confirmEmailField;
//    }
//
//    public WebElement getVerifyingSelectList() {
//        return verifyingSelectList;
//    }
//
//    public WebElement getCourierButton() {
//        return courierButton;
//    }
//
//    public WebElement getNextButtonOnVerificationStep() {
//        return nextButtonOnVerificationStep;
//    }
}
