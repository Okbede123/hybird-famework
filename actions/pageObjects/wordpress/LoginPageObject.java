package src2.actions.pageObjects.wordpress;

import org.openqa.selenium.WebDriver;
import src2.cores.commons.BasePage;
import src2.interrface.UI.wordpress.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public MyDashBoardPageObject inPutUserNameAndPassAndLogin(String userName,String password){
        sendKeyToElements(driver, LoginPageUI.INPUT_INFORMATION_LOGIN,userName,"user_login");
        sendKeyToElements(driver, LoginPageUI.INPUT_INFORMATION_LOGIN,password,"user_pass");
        clickToElements(driver,LoginPageUI.INPUT_INFORMATION_LOGIN,"wp-submit");
        return PageGeneralManager.goToMyDashBoard(driver);
    }
}
