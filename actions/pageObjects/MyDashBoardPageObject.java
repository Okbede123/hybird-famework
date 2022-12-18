package src2.actions.pageObjects;

import org.openqa.selenium.WebDriver;
import src2.cores.commons.BasePage;
import src2.interrface.UI.MyDashBoardUI;

public class MyDashBoardPageObject extends BasePage {
    WebDriver driver;

    public MyDashBoardPageObject(WebDriver driver){
        this.driver = driver;
    }


    public String loginDashBoard() {
        waitElementVisibility(driver, MyDashBoardUI.CONTACT_INFO_TEXT);
       return getElementTextByXpath(driver,MyDashBoardUI.CONTACT_INFO_TEXT);
    }
}
