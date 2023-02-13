package src2.actions.pageObjects;

import org.openqa.selenium.WebDriver;
import src2.actions.pageObjects.admin.AdminHomePageObject;
import src2.actions.pageObjects.admin.AdminLoginPageObject;

public class PageGeneratorManager {


    public static UserHomePageObject getHomePage(WebDriver driver){
        return new UserHomePageObject(driver);
    }

    public static UserLoginPageObject getLoginPageUser(WebDriver driver){
        return new UserLoginPageObject(driver);
    }

    public static AdminLoginPageObject getLoginPageAdmin(WebDriver driver){
        return new AdminLoginPageObject(driver);
    }

    public static AdminHomePageObject getAdminHomePage(WebDriver driver){
        return new AdminHomePageObject(driver);
    }

    public static MyDashBoardPageObject getMyDashBoard(WebDriver driver){
        return new MyDashBoardPageObject(driver);
    }

    public static Account_Information_PageObject getInfomationPage(WebDriver driver){
        return new Account_Information_PageObject(driver);
    }

    public static MyApplicationPageObject getApplicationPage(WebDriver driver){
        return new MyApplicationPageObject(driver);
    }

    public static MyProductReviewPageObject getProductPage(WebDriver driver){
        return new MyProductReviewPageObject(driver);
    }

    public static MyOrderPageObject getOrderPage(WebDriver driver){
        return new MyOrderPageObject(driver);
    }

    public static AboutUsPageObject getAboutUs(WebDriver driver){
        return new AboutUsPageObject(driver);
    }

    public static SearchTermPageObject getSearchTerm(WebDriver driver){
        return new SearchTermPageObject(driver);
    }

    public static MyAccountPageObject getMyAccount(WebDriver driver){
        return new MyAccountPageObject(driver);
    }

    public static UserRegisterPageObject openUserRegister(WebDriver driver){
        return new UserRegisterPageObject(driver);
    }

}
