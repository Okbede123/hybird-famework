package testcases.companda;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src2.actions.pageObjects.*;
import src2.actions.pageObjects.pageObjectNavigation.SideBarAccountPageObject;
import src2.cores.commons.BaseTest;

public class Level_10_DynamicLocator_II extends BaseTest {
    WebDriver driver;

    UserHomePageObject userHomePageObject;
    UserLoginPageObject userLoginPageObject;
    MyDashBoardPageObject myDashBoardPageObject;

    SideBarAccountPageObject sideBarAccountPageObject;

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

        //gan lai driver cua multibrowser cho driver cua class
        driver = multipleBrowserEnum_SwitchCase_DriverManager(browserName);
        //driver.get("http://live.techpanda.org/index.php/");
        //homePageObject = new HomePageObject(driver);
       userHomePageObject = PageGeneratorManager.getHomePage(driver);
       driver.manage().window().maximize();
    }


    @Test
    public void TC_01_LoginWithValidEmailAndPassword() {

//        homePageObject.clickToMyAccount();
//        loginPageObject = new LoginPageObject(driver);
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
        userLoginPageObject.inPutEmailAdressTextBox("selenium_11_01@gmail.com" );
        userLoginPageObject.inPutPassAdressTextBox("111111");
       myDashBoardPageObject = userLoginPageObject.getMyDashBoard(driver);

        //myDashBoardPageObject = new MyDashBoardPageObject(driver);
        //myDashBoardPageObject = loginPageObject.getMyDashBoard(driver);
        Assert.assertTrue(myDashBoardPageObject.loginDashBoardDisplay());


    }


    @Test
    public void TC_02_Navigate_Page(){

        //My dashboard to My order

        //myOrderPageObject = myDashBoardPageObject.getToMyOrder();
       account_information_pageObject = (Account_Information_PageObject) myDashBoardPageObject.openSideBarLinkByPageNames("Account Information");

        //account infomation to my dashboard

       myDashBoardPageObject = (MyDashBoardPageObject) account_information_pageObject.openSideBarLinkByPageNames("Account Dashboard");


        // my dashboard -> my order
        myOrderPageObject = (MyOrderPageObject) myDashBoardPageObject.openSideBarLinkByPageNames("My Orders");


        //my order -> my application
        myApplicationPageObject = (MyApplicationPageObject) myOrderPageObject.openSideBarLinkByPageNames("My Applications");



    }

    //@Test
    public void TC_09_Footer(){
        //tat ca cac  ham ke thua basepage co the su dung cac ham cua basepage
       aboutUsPageObject = myOrderPageObject.getFooterContainPage(driver).getAboutUs();
       searchTermPageObject = aboutUsPageObject.getSearhTerms();
       myAccountPageObject = searchTermPageObject.getMyAccount();


    }

    //@AfterClass
//    public void afterClass() {
//        driver.quit();
//    }


}
