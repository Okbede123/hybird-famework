package src2.actions.pageObjects.Facebook;

import org.openqa.selenium.WebDriver;
import src2.cores.commons.BasePage;
import src2.interrface.UI.Facebook.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void clickToNewAccount(){
        clickToElements(driver, LoginPageUI.OPEN_CREATE_ACCOUNT);
    }

    public void textBoxEmail(String email){
        waitElementVisibilityLocators(driver,LoginPageUI.TEXTBOX_EMAIL);
        sendKeyToElements(driver,LoginPageUI.TEXTBOX_EMAIL,email);
    }

    public void waitForReEnterEmailVisibilityInDom(){
        waitElementVisibilityLocators(driver,LoginPageUI.REENTER_EMAIL_LOCATOR);
    }

    public void waitForReEnterEmailInvisibility_NotInDom(){
        waitElementInvisibiltyLocatorsNotInDom(driver,LoginPageUI.REENTER_EMAIL_LOCATOR);
    }

    public boolean isReEnterEmailDisplay(){
        return isDisplayElementLocator(driver,LoginPageUI.REENTER_EMAIL_LOCATOR);
    }

    public boolean isReEnterUndisplayed(){
        return  isElementUndisplayed(driver,LoginPageUI.REENTER_EMAIL_LOCATOR);
    }

    public void closeCreateNewAccount(){
        clickToElements(driver,LoginPageUI.OFF_CREATE_ACCOUNT);
    }
}
