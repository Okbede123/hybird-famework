package testcases.companda;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src2.actions.pageObjects.*;
import src2.cores.commons.BaseTest;

public class Level_07_SwitchPage extends BaseTest {
    WebDriver driver;

    UserHomePageObject userHomePageObject;
    UserLoginPageObject userLoginPageObject;
    MyDashBoardPageObject myDashBoardPageObject;

    Account_Information_PageObject account_information_pageObject;

    MyOrderPageObject myOrderPageObject;

    MyProductReviewPageObject myProductReviewPageObject;
    MyApplicationPageObject myApplicationPageObject;



    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {

        //gan lai driver cua multibrowser cho driver cua class
        driver = multipleBrowserEnum_SwitchCase_DriverManager(browserName);
        //driver.get("http://live.techpanda.org/index.php/");
        //homePageObject = new HomePageObject(driver);
       userHomePageObject = PageGeneratorManager.getHomePage(driver);
    }

    //@Test
    public void TC_01_LoginWithEmptyEmailAndPassword() {
        //homePageObject.clickToMyAccount();
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);

        //loginPageObject = new LoginPageObject(driver);

        userLoginPageObject.inPutEmailAdressTextBox("");
        userLoginPageObject.inPutPassAdressTextBox("");
        userLoginPageObject.clickToLogin();

        Assert.assertEquals(userLoginPageObject.getEmailAdressEmptyMessageError(),"This is a required field.");
        Assert.assertEquals(userLoginPageObject.getPassWordAdressEmptyMessageError(),"This is a required field.");
    }

    //@Test
    public void TC_02_LoginWithInvalidEmail() {
        //homePageObject.clickToMyAccount();

        //loginPageObject = new LoginPageObject(driver);
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);



        userLoginPageObject.inPutEmailAdressTextBox("123@456.89");
        userLoginPageObject.inPutPassAdressTextBox("123456");
        userLoginPageObject.clickToLogin();


        userLoginPageObject.InvalidMessageEmail();
        userLoginPageObject.InvalidMessagePass();

        Assert.assertEquals(userLoginPageObject.InvalidMessageEmail(),"Please enter a valid email address. For example johndoe@domain.com.");
        Assert.assertEquals(userLoginPageObject.InvalidMessagePass(),"Please enter a valid email address. For example johndoe@domain.com.");

    }

    //@Test(description = "Email not exist in application")
    public void TC_03_LoginWithIncorrectEmail() {
//        homePageObject.clickToMyAccount();
//        loginPageObject = new LoginPageObject(driver);
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
        userLoginPageObject.inPutEmailAdressTextBox("auto_test" + getrandomNumber() + "@live.com");
        userLoginPageObject.inPutPassAdressTextBox("123456");
        userLoginPageObject.clickToLogin();
        Assert.assertEquals(userLoginPageObject.WrongPassOrEmail(),"Invalid login or password.");

    }

    //@Test(description = "Password less than 6 characters")
    public void TC_04_LoginWithInvalidPassword() {

//        homePageObject.clickToMyAccount();
//        loginPageObject = new LoginPageObject(driver);
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
        userLoginPageObject.inPutEmailAdressTextBox("auto_test" + getrandomNumber() + "@live.com");
        userLoginPageObject.inPutPassAdressTextBox("123");
        userLoginPageObject.clickToLogin();
        Assert.assertEquals(userLoginPageObject.InvalidMessagePass(),"Please enter 6 or more characters without leading or trailing spaces.");
    }

    //@Test
    public void TC_05_LoginWithIncorrectPassword() {

//        homePageObject.clickToMyAccount();
//        loginPageObject = new LoginPageObject(driver);
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
        userLoginPageObject.inPutEmailAdressTextBox("auto_test" + getrandomNumber() + "@live.com");
        userLoginPageObject.inPutPassAdressTextBox("");
        userLoginPageObject.clickToLogin();

        Assert.assertEquals(userLoginPageObject.getPassWordAdressEmptyMessageError(),"This is a required field.");
    }

    @Test
    public void TC_06_LoginWithValidEmailAndPassword() {

//        homePageObject.clickToMyAccount();
//        loginPageObject = new LoginPageObject(driver);
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
        userLoginPageObject.inPutEmailAdressTextBox("selenium_11_01@gmail.com" );
        userLoginPageObject.inPutPassAdressTextBox("111111");
       myDashBoardPageObject = userLoginPageObject.getMyDashBoard(driver);
        //myDashBoardPageObject = new MyDashBoardPageObject(driver);
        //myDashBoardPageObject = loginPageObject.getMyDashBoard(driver);
        Assert.assertTrue(myDashBoardPageObject.loginDashBoardDisplay());
       account_information_pageObject = myDashBoardPageObject.clickToInformation();



    }

    @Test
    public void TC_07_UpdateAccount_Infomation(){

        account_information_pageObject.inputTextBoxFirstName("Auto");
        account_information_pageObject.inputTextBoxLastName("test");
        account_information_pageObject.inputTextBoxEmail("selenium_11_01@gmail.com");
        account_information_pageObject.inputTextBoxPassword("111111");
        account_information_pageObject.clickSave();
       String verifyInformation = myDashBoardPageObject.displayInformationDisplay();
       Assert.assertEquals(verifyInformation,"The account information has been saved.");



    }

    @Test
    public void TC_08_Navigate_Page(){

        //My dashboard to My order

        myOrderPageObject = myDashBoardPageObject.getToMyOrder();


        //my order to my application
        myApplicationPageObject = myOrderPageObject.getToMyApplicationPage();
        //my application to my product

        myProductReviewPageObject = myApplicationPageObject.getToMyProductReviewPage();
        //my product to my order
        myOrderPageObject = myProductReviewPageObject.getToMyOrder();
        //my order to my product
        myProductReviewPageObject = myOrderPageObject.getToMyProductReviewPage();
        //my product to my application
        myApplicationPageObject = myProductReviewPageObject.getToMyApplicationPage();



    }

    //@AfterClass
//    public void afterClass() {
//        driver.quit();
//    }


}
