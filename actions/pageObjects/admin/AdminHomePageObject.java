package src2.actions.pageObjects.admin;

import org.openqa.selenium.WebDriver;
import src2.cores.commons.BasePage;
import src2.interrface.UI.AdminUI.AdminManagerCustomerPageUI;
import src2.interrface.UI.HomePageUI;

public class AdminHomePageObject extends BasePage {

    WebDriver driver;

    //constructor, khởi tạo driver
   public AdminHomePageObject(WebDriver driver){
        this.driver = driver;
    }
    public void clickToMyAccount() {
        waitElementclick(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElementByXpath(driver,HomePageUI.MY_ACCOUNT_LINK);
    }


    public void closeIncomingPopUpDisplay() {
       waitElementVisibility(driver, AdminManagerCustomerPageUI.INCOMING_POPUP);
       waitElementclick(driver,AdminManagerCustomerPageUI.CLOSE_INCOMING_POPUP);
       clickToElementByXpath(driver,AdminManagerCustomerPageUI.CLOSE_INCOMING_POPUP);
    }



}
