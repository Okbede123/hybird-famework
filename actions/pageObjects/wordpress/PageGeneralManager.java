package src2.actions.pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneralManager {


    public static MyDashBoardPageObject goToMyDashBoard(WebDriver driver){
        return new MyDashBoardPageObject(driver);
    }

    public static LoginPageObject goToLogin(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static ConfigUserPageObject goToConfigPage(WebDriver driver){
        return new ConfigUserPageObject(driver);
    }
}
