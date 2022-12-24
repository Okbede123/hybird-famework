package src2.actions.pageObjects;

import org.openqa.selenium.WebDriver;
import src2.cores.commons.BasePage;
import src2.interrface.UI.HomePageUI;

public class UserHomePageObject extends BasePage {

    WebDriver driver;

    //constructor, khởi tạo driver
   public UserHomePageObject(WebDriver driver){
        this.driver = driver;
    }
    public void clickToMyAccount() {
        waitElementclick(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElementByXpath(driver,HomePageUI.MY_ACCOUNT_LINK);
    }

    public UserLoginPageObject ClickgetloginPageObject(WebDriver driver){
        waitElementclick(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElementByXpath(driver,HomePageUI.MY_ACCOUNT_LINK);
        return new UserLoginPageObject(driver);
    }

    public UserLoginPageObject ClickgetloginPageObjectManager(WebDriver driver){
        waitElementclick(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElementByXpath(driver,HomePageUI.MY_ACCOUNT_LINK);
        return new PageGeneratorManager().getLoginPageUser(driver);
    }
}
