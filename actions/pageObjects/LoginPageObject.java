package src2.actions.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import src2.cores.commons.BasePage;
import src2.interrface.UI.LoginPageUI;

public class LoginPageObject extends BasePage {

    WebDriver driver;


    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void inPutEmailAdressTextBox(String s) {
        waitElementVisibility(driver,LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendKeyToElementXpath(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX,s);

    }

    public void inPutEmailAdressTextBoxBy(String s) {
        waitElementVisibility(driver,LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendKeyToElement(driver, By.xpath(LoginPageUI.EMAIL_ADDRESS_TEXTBOX),s);
    }

    public void inPutPassAdressTextBox(String s) {
        waitElementVisibility(driver,LoginPageUI.PASSWORD_ADDRESS_TEXTBOX);
        sendKeyToElementXpath(driver,LoginPageUI.PASSWORD_ADDRESS_TEXTBOX,s);
    }

    public void clickToLogin() {
        waitElementclick(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,By.xpath(LoginPageUI.LOGIN_BUTTON));
    }

    public void clickToLoginByXpath() {
        waitElementclick(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElementByXpath(driver,LoginPageUI.LOGIN_BUTTON);
    }

    public String getEmailAdressEmptyMessageError() {
        waitElementVisibility(driver,LoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE);
       return getElementText(driver,By.xpath(LoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE));
    }

    public String getEmailAdressEmptyMessageErrorByXpath() {
        waitElementVisibility(driver,LoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE);
        return getElementTextByXpath(driver,LoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE);
    }

    public String getPassWordAdressEmptyMessageError() {
        waitElementVisibility(driver,LoginPageUI.PASSWORD_ADDRESS_EMPTY_ERROR_MESSAGE);
        return getElementText(driver,By.xpath(LoginPageUI.PASSWORD_ADDRESS_EMPTY_ERROR_MESSAGE));
    }

    public String getPassWordAdressEmptyMessageErrorByXpath() {
        waitElementVisibility(driver,LoginPageUI.PASSWORD_ADDRESS_EMPTY_ERROR_MESSAGE);
        return getElementTextByXpath(driver,LoginPageUI.PASSWORD_ADDRESS_EMPTY_ERROR_MESSAGE);
    }


    public String InvalidMessageEmail() {
        waitElementVisibility(driver,LoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MESSAGE);
        return getElementTextByXpath(driver,LoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MESSAGE);
    }

    public String InvalidMessagePass() {
        waitElementVisibility(driver,LoginPageUI.PASSWORD_ADDRESS_INVALID_ERROR_MESSAGE);
        return getElementTextByXpath(driver,LoginPageUI.PASSWORD_ADDRESS_INVALID_ERROR_MESSAGE);
    }

    public String WrongPassOrEmail(){
        waitElementVisibility(driver,LoginPageUI.PASSWORD_OR_EMAIL_WRONG);
        return getElementTextByXpath(driver,LoginPageUI.PASSWORD_OR_EMAIL_WRONG);
    }
}
