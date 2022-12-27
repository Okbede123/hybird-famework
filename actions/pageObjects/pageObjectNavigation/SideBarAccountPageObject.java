package src2.actions.pageObjects.pageObjectNavigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import src2.actions.pageObjects.*;
import src2.cores.commons.BasePage;
import src2.interrface.UI.SideBarPageUI;

public class SideBarAccountPageObject extends BasePage {

    WebDriver driver;
    public SideBarAccountPageObject(WebDriver driver){
        this.driver = driver;
    }

    public MyOrderPageObject getToMyOrder(){
        waitElementVisibility(driver, SideBarPageUI.MY_ORDER_PAGE_LOCATOR);
        clickToElementByXpath(driver, SideBarPageUI.MY_ORDER_PAGE_LOCATOR);
        return new PageGeneratorManager().getOrderPage(driver);
    }

    public MyApplicationPageObject getToMyApplicationPage(){
        waitElementVisibility(driver, SideBarPageUI.MY_APPLICATION_LOCATOR);
        clickToElementByXpath(driver, SideBarPageUI.MY_APPLICATION_LOCATOR);
        return new PageGeneratorManager().getApplicationPage(driver);
    }


    public MyProductReviewPageObject getToMyProductReviewPage(){
        waitElementVisibility(driver, SideBarPageUI.PRODUCT_REVIEW_LOCATOR);
        clickToElementByXpath(driver, SideBarPageUI.PRODUCT_REVIEW_LOCATOR);
        return new PageGeneratorManager().getProductPage(driver);
    }


    public MyDashBoardPageObject clickToLoginMyDoashBoardPageManager() {
        waitElementclick(driver, SideBarPageUI.LOGIN_MYDASHBOARD);
        clickToElement(driver, By.xpath(SideBarPageUI.LOGIN_MYDASHBOARD));
        return new PageGeneratorManager().getMyDashBoard(driver);
    }

    public Account_Information_PageObject clickToInformation(){

        waitElementVisibility(driver, SideBarPageUI.ACCOUNT_INFORMATION);
        clickToElementByXpath(driver, SideBarPageUI.ACCOUNT_INFORMATION);
        return new PageGeneratorManager().getInfomationPage(driver);

    }

    public UserHomePageObject logOutUserPage() {
        waitElementclick(driver, SideBarPageUI.MY_ACCOUT_LOCATOR);
        clickToElementByXpath(driver,SideBarPageUI.MY_ACCOUT_LOCATOR);
        waitElementclick(driver,SideBarPageUI.LOG_OUT_LOCATOR);
        clickToElementByXpath(driver,SideBarPageUI.LOG_OUT_LOCATOR);
        return new PageGeneratorManager().getHomePage(driver);
    }

    public void openSideBarLinkByPageName(String pageName){
        waitElementclickLocator(driver,SideBarPageUI.DYNAMIC_SIDEBAR_LOCATOR,pageName);
        clickToElements(driver,SideBarPageUI.DYNAMIC_SIDEBAR_LOCATOR,pageName);
    }

    //có return
    //dùng trong trường hợp ít page
    public SideBarAccountPageObject openSideBarLinkByPageNames(String pageName){

        waitElementclickLocator(driver,SideBarPageUI.DYNAMIC_SIDEBAR_LOCATOR,pageName);
        clickToElements(driver,SideBarPageUI.DYNAMIC_SIDEBAR_LOCATOR,pageName);

        if(pageName.equals("My Applications")){
            return PageGeneratorManager.getApplicationPage(driver);
        }
        else if(pageName.equals("My Orders")){
            return PageGeneratorManager.getOrderPage(driver);
        }
        else if(pageName.equals("Account Information")){
            return PageGeneratorManager.getInfomationPage(driver);
        }
        else if(pageName.equals("My Product Reviews")){
            return PageGeneratorManager.getProductPage(driver);
        }
        else if(pageName.equals("Account Dashboard")){
            return PageGeneratorManager.getMyDashBoard(driver);
        }
        else{
            return null;
        }

    }
}
