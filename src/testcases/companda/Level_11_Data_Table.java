package testcases.companda;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src2.actions.pageObjects.*;
import src2.actions.pageObjects.admin.AdminHomePageObject;
import src2.actions.pageObjects.admin.AdminLoginPageObject;
import src2.cores.commons.BaseTest;
import src2.cores.commons.GlobalConstants;

public class Level_11_Data_Table extends BaseTest {
    WebDriver driver;

    String userUrl,adminUrl;
    UserHomePageObject userHomePageObject;

    AdminHomePageObject adminHomePageObject;
    AdminLoginPageObject adminLoginPageObject;
    UserLoginPageObject userLoginPageObject;
    MyDashBoardPageObject myDashBoardPageObject;

    Account_Information_PageObject account_information_pageObject;

    MyOrderPageObject myOrderPageObject;

    MyProductReviewPageObject myProductReviewPageObject;
    MyApplicationPageObject myApplicationPageObject;

    AboutUsPageObject aboutUsPageObject;
    SearchTermPageObject searchTermPageObject;
    MyAccountPageObject myAccountPageObject;



    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
           this.userUrl = GlobalConstants.USER_URL;
            this.adminUrl = GlobalConstants.ADMIN_URL;
        driver = multipleBrowserEnum_SwitchCase_DriverManager(browserName,userUrl);
       userHomePageObject = PageGeneratorManager.getHomePage(driver);
    }


    @Test
    public void TC_01_Switch_Role(){
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
        userLoginPageObject.inPutEmailAdressTextBox("selenium_11_01@gmail.com" );
        userLoginPageObject.inPutPassAdressTextBox("111111");
        myDashBoardPageObject = userLoginPageObject.getMyDashBoard(driver);
        Assert.assertTrue(myDashBoardPageObject.loginDashBoardDisplay());

        //logout userpage

       userHomePageObject = myDashBoardPageObject.logOutUserPage();
       

    //user -> Admin
       adminLoginPageObject = myDashBoardPageObject.openAdminPage(driver,adminUrl);
        adminLoginPageObject = PageGeneratorManager.getLoginPageAdmin(driver);
        adminLoginPageObject.inPutEmailAdressTextBox("user01");
        adminLoginPageObject.inPutPassAdressTextBox("guru99com");
       adminHomePageObject = adminLoginPageObject.clickToLoginHompageAdmin();
       adminHomePageObject.closeIncomingPopUpDisplay();

        //Logout
      adminLoginPageObject.clickLogOutHomePageAdmin(driver);


    //admin -> user

        userHomePageObject = adminLoginPageObject.openUserPage(driver,userUrl);

        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
        userLoginPageObject.inPutEmailAdressTextBox("selenium_11_01@gmail.com" );
        userLoginPageObject.inPutPassAdressTextBox("111111");
        myDashBoardPageObject = userLoginPageObject.getMyDashBoard(driver);
        Assert.assertTrue(myDashBoardPageObject.loginDashBoardDisplay());
        myApplicationPageObject = myDashBoardPageObject.getToMyApplicationPage();
        userHomePageObject = myApplicationPageObject.logOutUserPage();
       adminLoginPageObject = userHomePageObject.openAdminPage(driver,adminUrl);
        userHomePageObject = adminLoginPageObject.openUserPage(driver,userUrl);
        adminLoginPageObject = userHomePageObject.openAdminPage(driver,adminUrl);


    }



    //@AfterClass
//    public void afterClass() {
//        driver.quit();
//    }


}
