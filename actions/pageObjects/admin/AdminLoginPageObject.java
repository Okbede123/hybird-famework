package src2.actions.pageObjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import src2.actions.pageObjects.PageGeneratorManager;
import src2.cores.commons.BasePage;
import src2.interrface.UI.AdminUI.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {

    WebDriver driver;



    public AdminLoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void inPutEmailAdressTextBox(String s) {
        waitElementVisibility(driver, AdminLoginPageUI.USER_NAME_LOCATOR);
        sendKeyToElementXpath(driver, AdminLoginPageUI.USER_NAME_LOCATOR,s);

    }


    public void inPutPassAdressTextBox(String s) {
        waitElementVisibility(driver, AdminLoginPageUI.PASSWORD_LOCATOR);
        sendKeyToElementXpath(driver,AdminLoginPageUI.PASSWORD_LOCATOR,s);
    }

    public AdminHomePageObject clickToLoginHompageAdmin() {
        waitElementclick(driver,AdminLoginPageUI.CLICK_BUTTON);
        clickToElement(driver,By.xpath(AdminLoginPageUI.CLICK_BUTTON));
        return PageGeneratorManager.getAdminHomePage(driver);
    }


}
