//package testcases.companda;
//
//import com.relevantcodes.extentreports.LogStatus;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//import src2.actions.pageObjects.*;
//import src2.actions.pageObjects.reportConfig.ExtentManager;
//import src2.cores.commons.BaseTest;
//
//import java.lang.reflect.Method;
//
//public class Level_16_Log_ExtentReport_Version2_ScreenShot extends BaseTest {
//    WebDriver driver;
//
//    UserHomePageObject userHomePageObject;
//    UserLoginPageObject userLoginPageObject;
//    MyDashBoardPageObject myDashBoardPageObject;
//
//    Account_Information_PageObject account_information_pageObject;
//
//
//
//    @Parameters({"browser"})
//    @BeforeClass
//    public void beforeClass(String browserName) {
//
//        //gan lai driver cua multibrowser cho driver cua class
//        //driver = multipleBrowserEnum_SwitchCase_DriverManager(browserName);
//        driver= multipleBrowserEnum_SwitchCase(browserName);
//        //driver.get("http://live.techpanda.org/index.php/");
//        //homePageObject = new HomePageObject(driver);
//       userHomePageObject = PageGeneratorManager.getHomePage(driver);
//    }
//
//    @Test
//    public void TC_01_LoginWithEmptyEmailAndPassword(Method method) {
//        ExtentManager.startTest(method.getName(),"test1 TC_01_LoginWithEmptyEmailAndPassword");
//        ExtentManager.getTest().log(LogStatus.INFO,"testcase 1");
//        //homePageObject.clickToMyAccount();
//        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
//
//        //loginPageObject = new LoginPageObject(driver);
//
//        userLoginPageObject.inPutEmailAdressTextBox("");
//        userLoginPageObject.inPutPassAdressTextBox("");
//        userLoginPageObject.clickToLogin();
//
//        assertEqual(userLoginPageObject.getPassWordAdressEmptyMessageError(),"This is a required field.");
//    }
//
//    @Test
//    public void TC_02_LoginWithInvalidEmail(Method method) {
//        ExtentManager.startTest(method.getName(),"test1 TC_02_LoginWithInvalidEmail");
//        //homePageObject.clickToMyAccount();
//
//        //loginPageObject = new LoginPageObject(driver);
//        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
//        ExtentManager.getTest().log(LogStatus.INFO,"testcase 2");
//
//
//        userLoginPageObject.inPutEmailAdressTextBox("123@456.89");
//        userLoginPageObject.inPutPassAdressTextBox("123456");
//        userLoginPageObject.clickToLogin();
//
//
//        userLoginPageObject.InvalidMessageEmail();
//        userLoginPageObject.InvalidMessagePass();
//
//        assertEqual(userLoginPageObject.InvalidMessageEmail(),"Please enter a valid email address. For example johndoe@domain.com.");
//
//    }
//
//    @Test(description = "Email not exist in application")
//    public void TC_03_LoginWithIncorrectEmail(Method method) {
//        ExtentManager.startTest(method.getName(),"test1 TC_03_LoginWithIncorrectEmail");
////        homePageObject.clickToMyAccount();
////        loginPageObject = new LoginPageObject(driver);
//        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
//        userLoginPageObject.inPutEmailAdressTextBox("auto_test" + getrandomNumber() + "@live.com");
//        ExtentManager.getTest().log(LogStatus.INFO,"testcase 3");
//        userLoginPageObject.inPutPassAdressTextBox("123456");
//        userLoginPageObject.clickToLogin();
//        //assertEqual(userLoginPageObject.WrongPassOrEmail(),"Invalid login or passwordd.");
//        Assert.assertEquals(userLoginPageObject.WrongPassOrEmail(),"Invalid login or passwordd.");
//
//    }
//
//    @Test(description = "Password less than 6 characters")
//    public void TC_04_LoginWithInvalidPassword(Method method) {
//        ExtentManager.startTest(method.getName(),"test1 TC_04_LoginWithInvalidPassword");
//
////        homePageObject.clickToMyAccount();
////        loginPageObject = new LoginPageObject(driver);
//        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
//        userLoginPageObject.inPutEmailAdressTextBox("auto_test" + getrandomNumber() + "@live.com");
//        userLoginPageObject.inPutPassAdressTextBox("123");
//        ExtentManager.getTest().log(LogStatus.INFO,"testcase 4");
//        userLoginPageObject.clickToLogin();
//        assertEqual(userLoginPageObject.InvalidMessagePass(),"Please enter 6 or more characters without leading or trailing spaces.");
//    }
//
//    //@Test
//    public void TC_05_LoginWithIncorrectPassword(Method method) {
//
//        ExtentManager.startTest(method.getName(),"test1 TC_05_LoginWithIncorrectPassword");
////        homePageObject.clickToMyAccount();
////        loginPageObject = new LoginPageObject(driver);
//        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
//        userLoginPageObject.inPutEmailAdressTextBox("auto_test" + getrandomNumber() + "@live.com");
//        userLoginPageObject.inPutPassAdressTextBox("");
//        userLoginPageObject.clickToLogin();
//        ExtentManager.getTest().log(LogStatus.INFO,"testcase 5");
//
//        assertEqual(userLoginPageObject.getPassWordAdressEmptyMessageError(),"This is a required field.");
//    }
//
//    //@Test
//    public void TC_06_LoginWithValidEmailAndPassword(Method method) {
//
//        ExtentManager.startTest(method.getName(),"test1 TC_06_LoginWithValidEmailAndPassword");
////        homePageObject.clickToMyAccount();
////        loginPageObject = new LoginPageObject(driver);
//        ExtentManager.getTest().log(LogStatus.INFO,"testcase 6");
//        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
//        userLoginPageObject.inPutEmailAdressTextBox("selenium_11_01@gmail.com" );
//        userLoginPageObject.inPutPassAdressTextBox("111111");
//       myDashBoardPageObject = userLoginPageObject.getMyDashBoard(driver);
//        //myDashBoardPageObject = new MyDashBoardPageObject(driver);
//        //myDashBoardPageObject = loginPageObject.getMyDashBoard(driver);
//        assertTrue(myDashBoardPageObject.loginDashBoardDisplay());
//
//
//    }
//
//    @AfterClass
//    public void afterClass() {
//        driver.quit();
//    }
//
//
//}
