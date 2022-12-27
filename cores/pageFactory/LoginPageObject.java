package src2.cores.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src2.cores.commons.BasePageFactory;
import src2.interrface.UI.LoginPageUI;

public class LoginPageObject extends BasePageFactory {

    WebDriver driver;

    @FindBy(xpath = "//input[@id = 'email']")
    WebElement emailAddressTextbox;
    @FindBy(xpath = "//input[@id = 'pass']")
    WebElement passwordAddressTextbox;
    @FindBy(xpath = "//button[@id = 'send2']")
    WebElement loginButton;
    @FindBy(xpath = "//div[@id = 'advice-required-entry-email']")
    WebElement emailAdressEmptyErrorMessage;
    @FindBy(xpath = "//div[@id = 'advice-required-entry-pass']")
    WebElement passwordEmptyErrorMessage;
    @FindBy(xpath = "//div[@id = 'advice-validate-email-email']")
    WebElement emailAdressInvalidErrorMessage;
    @FindBy(xpath = "//div[@class = 'validation-advice']")
    WebElement passwordAdressInvalidErrorMessage;
    @FindBy(xpath = "//li[@class='error-msg']//span")
    WebElement passOrEmailWrong;


    public LoginPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void inPutEmailAdressTextBox(String s) {
        waitElement(driver, emailAddressTextbox);
        sendKeyFactory(driver, emailAddressTextbox,s);

    }


    public void inPutPassAdressTextBox(String s) {
        waitElement(driver,passwordAddressTextbox);
        sendKeyFactory(driver,passwordAddressTextbox,s);
    }

    public void clickToLogin() {
        waitElementClick(driver,loginButton);
        clickToElement(driver,loginButton);
    }


    public String getEmailAdressEmptyMessageError() {
        waitElement(driver,emailAdressEmptyErrorMessage);
        return getElementText(driver,By.xpath(LoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE));
    }



    public String getPassWordAdressEmptyMessageError() {
        waitElement(driver,passwordEmptyErrorMessage);
        return getElementFactory(driver,passwordEmptyErrorMessage);
    }


    public String InvalidMessageEmail() {
        waitElement(driver,emailAdressInvalidErrorMessage);
        return getElementFactory(driver,emailAdressInvalidErrorMessage);
    }

    public String InvalidMessagePass() {
        waitElement(driver,passwordAdressInvalidErrorMessage);
        return getElementFactory(driver,passwordAdressInvalidErrorMessage);
    }

    public String WrongPassOrEmail(){
        waitElement(driver,passOrEmailWrong);
        return getElementFactory(driver,passOrEmailWrong);
    }
}

