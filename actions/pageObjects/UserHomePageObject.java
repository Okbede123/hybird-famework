package src2.actions.pageObjects;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import src2.cores.commons.BasePage;
import src2.interrface.UI.HomePageUI;

import java.util.Set;

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

    public void addCookieLogin(Set<Cookie> cookies){
       addCookies(driver,cookies);
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
