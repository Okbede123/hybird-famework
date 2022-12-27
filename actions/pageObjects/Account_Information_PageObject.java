package src2.actions.pageObjects;

import org.openqa.selenium.WebDriver;
import src2.actions.pageObjects.pageObjectNavigation.SideBarAccountPageObject;
import src2.interrface.UI.AccountInformationUI;

public class Account_Information_PageObject extends SideBarAccountPageObject {
    WebDriver driver;

    public Account_Information_PageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void inputTextBoxFirstName(String s){
        waitElementVisibility(driver, AccountInformationUI.FIRST_NAME);
        sendKeyToElementXpath(driver,AccountInformationUI.FIRST_NAME,s);
    }
    public void inputTextBoxLastName(String s){
        waitElementVisibility(driver, AccountInformationUI.LAST_NAME);
        sendKeyToElementXpath(driver,AccountInformationUI.LAST_NAME,s);
    }
    public void inputTextBoxEmail(String s){
        waitElementVisibility(driver, AccountInformationUI.EMAIL_NAME);
        sendKeyToElementXpath(driver,AccountInformationUI.EMAIL_NAME,s);
    }
    public void inputTextBoxPassword(String s){
        waitElementVisibility(driver, AccountInformationUI.PASSWORD);
        sendKeyToElementXpath(driver,AccountInformationUI.PASSWORD,s);
    }

    public void clickSave(){
        waitElementVisibility(driver, AccountInformationUI.BUTTON_SAVE);
        clickToElementByXpath(driver,AccountInformationUI.BUTTON_SAVE);
    }

}
