package src2.actions.pageObjects.SortLab;

import org.openqa.selenium.WebDriver;
import src2.cores.commons.BasePage;
import src2.interrface.UI.SortLab.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public InventoryPageObject loginToInventory(String userName,String password){
        sendKeyToElements(driver, LoginPageUI.INPUT_PLACEHOLDER,userName,"Username");
        sendKeyToElements(driver,LoginPageUI.INPUT_PLACEHOLDER,password,"Password");
        clickToElements(driver,LoginPageUI.BUTTON_LOGIN);
        return PageGeneralManager.openInventoryPage(driver);
    }
}
