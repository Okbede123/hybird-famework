package testcases.companda;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src2.actions.pageObjects.*;
import src2.actions.pageObjects.reportConfig.ExtentManager;
import src2.cores.commons.BaseTest;

import java.lang.reflect.Method;

public class Level_16_Log_ExtentReport_Version5_ScreenShot extends BaseTest {
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
    public void TC_01_LoginWithEmptyEmailAndPassword(Method method) {
        ExtentManager.startTest(method.getName(),"TC_01_LoginWithEmptyEmailAndPassword");
        ExtentManager.getTest().log(Status.INFO,"test 1");
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);

        //loginPageObject = new LoginPageObject(driver);

        userLoginPageObject.inPutEmailAdressTextBox("");
        userLoginPageObject.inPutPassAdressTextBox("");
        userLoginPageObject.clickToLogin();

        assertEqual(userLoginPageObject.getPassWordAdressEmptyMessageError(),"This is a required field.");
    }

    @Test
    public void TC_02_LoginWithInvalidEmail(Method method) {
        ExtentManager.startTest(method.getName(),"TC_02_LoginWithInvalidEmail");
        ExtentManager.getTest().log(Status.INFO,"test 2");
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);


        userLoginPageObject.inPutEmailAdressTextBox("123@456.89");
        userLoginPageObject.inPutPassAdressTextBox("123456");
        userLoginPageObject.clickToLogin();


        userLoginPageObject.InvalidMessageEmail();
        userLoginPageObject.InvalidMessagePass();

        assertEqual(userLoginPageObject.InvalidMessageEmail(),"Please enter a valid email address. For example johndoe@domain.com.");

    }

    @Test(description = "Email not exist in application")
    public void TC_03_LoginWithIncorrectEmail(Method method) {
        ExtentManager.startTest(method.getName(),"TC_03_LoginWithIncorrectEmail");
        ExtentManager.getTest().log(Status.INFO,"test 3");
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
        userLoginPageObject.inPutEmailAdressTextBox("auto_test" + getrandomNumber() + "@live.com");
        userLoginPageObject.inPutPassAdressTextBox("123456");
        userLoginPageObject.clickToLogin();
        Assert.assertEquals(userLoginPageObject.WrongPassOrEmail(),"Invalid login or passwordd.");

    }

    @Test(description = "Password less than 6 characters")
    public void TC_04_LoginWithInvalidPassword(Method method) {
        ExtentManager.startTest(method.getName(),"TC_04_LoginWithInvalidPassword");
        ExtentManager.getTest().log(Status.INFO,"test 4");
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
        userLoginPageObject.inPutEmailAdressTextBox("auto_test" + getrandomNumber() + "@live.com");
        userLoginPageObject.inPutPassAdressTextBox("123");
        userLoginPageObject.clickToLogin();
        assertEqual(userLoginPageObject.InvalidMessagePass(),"Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void TC_05_LoginWithIncorrectPassword(Method method) {
        ExtentManager.startTest(method.getName(),"TC_05_LoginWithIncorrectPassword");
        ExtentManager.getTest().log(Status.INFO,"test 5");
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
        userLoginPageObject.inPutEmailAdressTextBox("auto_test" + getrandomNumber() + "@live.com");
        userLoginPageObject.inPutPassAdressTextBox("");
        userLoginPageObject.clickToLogin();
        assertEqual(userLoginPageObject.getPassWordAdressEmptyMessageError(),"This is a required field.");
    }

    @Test
    public void TC_06_LoginWithValidEmailAndPassword(Method method) {
        ExtentManager.startTest(method.getName(),"TC_06_LoginWithValidEmailAndPassword");
        ExtentManager.getTest().log(Status.INFO,"test 6");
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
        userLoginPageObject.inPutEmailAdressTextBox("selenium_11_01@gmail.com" );
        userLoginPageObject.inPutPassAdressTextBox("111111");
       myDashBoardPageObject = userLoginPageObject.getMyDashBoard(driver);
        assertTrue(myDashBoardPageObject.loginDashBoardDisplay());


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
