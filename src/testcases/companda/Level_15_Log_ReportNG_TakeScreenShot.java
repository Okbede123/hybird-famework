package testcases.companda;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src2.actions.pageObjects.*;
import src2.cores.commons.BaseTest;

public class Level_15_Log_ReportNG_TakeScreenShot extends BaseTest {
    WebDriver driver;

    UserHomePageObject userHomePageObject;
    UserLoginPageObject userLoginPageObject;
    MyDashBoardPageObject myDashBoardPageObject;

    Account_Information_PageObject account_information_pageObject;



    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {

        //gan lai driver cua multibrowser cho driver cua class
        //driver = multipleBrowserEnum_SwitchCase_DriverManager(browserName);
        driver= multipleBrowserEnum_SwitchCase(browserName);
        //driver.get("http://live.techpanda.org/index.php/");
        //homePageObject = new HomePageObject(driver);
       userHomePageObject = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void TC_01_LoginWithEmptyEmailAndPassword() {
        log.info("Login_01 - Click to my account link");
        //homePageObject.clickToMyAccount();
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);

        //loginPageObject = new LoginPageObject(driver);

        userLoginPageObject.inPutEmailAdressTextBox("");
        userLoginPageObject.inPutPassAdressTextBox("");
        userLoginPageObject.clickToLogin();

        assertEqual(userLoginPageObject.getPassWordAdressEmptyMessageError(),"This is a required field.");
    }

    @Test
    public void TC_02_LoginWithInvalidEmail() {
        //homePageObject.clickToMyAccount();
        log.info("Test");

        //loginPageObject = new LoginPageObject(driver);
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);



        userLoginPageObject.inPutEmailAdressTextBox("123@456.89");
        userLoginPageObject.inPutPassAdressTextBox("123456");
        userLoginPageObject.clickToLogin();


        userLoginPageObject.InvalidMessageEmail();
        userLoginPageObject.InvalidMessagePass();

        assertEqual(userLoginPageObject.InvalidMessageEmail(),"Please enter a valid email address. For example johndoe@domain.com.");

    }

    @Test(description = "Email not exist in application")
    public void TC_03_LoginWithIncorrectEmail() {
        log.info("Login_03 - Click to my account link");
//        homePageObject.clickToMyAccount();
//        loginPageObject = new LoginPageObject(driver);
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
        userLoginPageObject.inPutEmailAdressTextBox("auto_test" + getrandomNumber() + "@live.com");
        userLoginPageObject.inPutPassAdressTextBox("123456");
        userLoginPageObject.clickToLogin();
        //assertEqual(userLoginPageObject.WrongPassOrEmail(),"Invalid login or passwordd.");
        Assert.assertEquals(userLoginPageObject.WrongPassOrEmail(),"Invalid login or passwordd.");

    }

    @Test(description = "Password less than 6 characters")
    public void TC_04_LoginWithInvalidPassword() {

//        homePageObject.clickToMyAccount();
//        loginPageObject = new LoginPageObject(driver);
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
        userLoginPageObject.inPutEmailAdressTextBox("auto_test" + getrandomNumber() + "@live.com");
        userLoginPageObject.inPutPassAdressTextBox("123");
        userLoginPageObject.clickToLogin();
        assertEqual(userLoginPageObject.InvalidMessagePass(),"Please enter 6 or more characters without leading or trailing spaces.");
    }

    //@Test
    public void TC_05_LoginWithIncorrectPassword() {

//        homePageObject.clickToMyAccount();
//        loginPageObject = new LoginPageObject(driver);
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
        userLoginPageObject.inPutEmailAdressTextBox("auto_test" + getrandomNumber() + "@live.com");
        userLoginPageObject.inPutPassAdressTextBox("");
        userLoginPageObject.clickToLogin();

        assertEqual(userLoginPageObject.getPassWordAdressEmptyMessageError(),"This is a required field.");
    }

    //@Test
    public void TC_06_LoginWithValidEmailAndPassword() {

//        homePageObject.clickToMyAccount();
//        loginPageObject = new LoginPageObject(driver);
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
        userLoginPageObject.inPutEmailAdressTextBox("selenium_11_01@gmail.com" );
        userLoginPageObject.inPutPassAdressTextBox("111111");
       myDashBoardPageObject = userLoginPageObject.getMyDashBoard(driver);
        //myDashBoardPageObject = new MyDashBoardPageObject(driver);
        //myDashBoardPageObject = loginPageObject.getMyDashBoard(driver);
        assertTrue(myDashBoardPageObject.loginDashBoardDisplay());


    }

    //@AfterClass
//    public void afterClass() {
//        driver.quit();
//    }


}
