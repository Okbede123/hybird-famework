package src2.actions.pageObjects;

import org.openqa.selenium.WebDriver;
import src2.actions.pageObjects.pageObjectNavigation.SideBarAccountPageObject;
import src2.interrface.UI.MyDashBoardUI;

public class MyDashBoardPageObject extends SideBarAccountPageObject {
    WebDriver driver;

    public MyDashBoardPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    public String loginDashBoard() {
        waitElementVisibility(driver, MyDashBoardUI.CONTACT_INFO_TEXT);
       return getElementTextByXpath(driver,MyDashBoardUI.CONTACT_INFO_TEXT);
    }

    public boolean loginDashBoardDisplay() {
        waitElementVisibility(driver, MyDashBoardUI.CONTACT_INFO_TEXT);
        return isDisplayElement(driver,MyDashBoardUI.CONTACT_INFO_TEXT);
    }


    public String displayInformationDisplay(){
        waitElementVisibility(driver,MyDashBoardUI.DISPLAY_SAVE_INFORMATION);
       return getElementTextByXpath(driver,MyDashBoardUI.DISPLAY_SAVE_INFORMATION);
    }

}
