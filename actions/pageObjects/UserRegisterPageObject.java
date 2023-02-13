package src2.actions.pageObjects;

import org.openqa.selenium.WebDriver;
import src2.cores.commons.BasePage;
import src2.interrface.UI.AdminUI.AdminBasePageUI;
import src2.interrface.UI.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
    WebDriver driver;

    public UserRegisterPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void inputInformation(String information,String value){
        sendKeyToElements(driver, UserRegisterPageUI.INPUT_INFORMATION_REGISTER,value,information);
    }

    public MyDashBoardPageObject clickToRegister(){
        clickToElements(driver, AdminBasePageUI.BUTTON_BY_SPAN,"Register");
        return PageGeneratorManager.getMyDashBoard(driver);
    }
}
