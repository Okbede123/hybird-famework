package testcases.companda;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src2.actions.pageObjects.UserHomePageObject;
import src2.actions.pageObjects.UserLoginPageObject;
import src2.actions.pageObjects.MyDashBoardPageObject;
import src2.cores.commons.BaseTest;

import java.util.Random;

public class Level_06_Page_Generator_II extends BaseTest {
    WebDriver driver;

    UserHomePageObject userHomePageObject;
    UserLoginPageObject userLoginPageObject;
    MyDashBoardPageObject myDashBoardPageObject;



    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {

        //gan lai driver cua multibrowser cho driver cua class
        driver = multipleBrowserEnum_SwitchCase_DriverManager(browserName);
        //driver.get("http://live.techpanda.org/index.php/");
        //homePageObject = new HomePageObject(driver);
       userHomePageObject = getHomePage(driver);
    }

    @Test
    public void TC_01_LoginWithEmptyEmailAndPassword() {
        //homePageObject.clickToMyAccount();
        userLoginPageObject = userHomePageObject.ClickgetloginPageObject(driver);

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
        userLoginPageObject = userHomePageObject.ClickgetloginPageObject(driver);



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
        userLoginPageObject = userHomePageObject.ClickgetloginPageObject(driver);
        userLoginPageObject.inPutEmailAdressTextBox("auto_test" + randomNumber() + "@live.com");
        userLoginPageObject.inPutPassAdressTextBox("123456");
        userLoginPageObject.clickToLogin();
        Assert.assertEquals(userLoginPageObject.WrongPassOrEmail(),"Invalid login or password.");

    }

    //@Test(description = "Password less than 6 characters")
    public void TC_04_LoginWithInvalidPassword() {

//        homePageObject.clickToMyAccount();
//        loginPageObject = new LoginPageObject(driver);
        userLoginPageObject = userHomePageObject.ClickgetloginPageObject(driver);
        userLoginPageObject.inPutEmailAdressTextBox("auto_test" + randomNumber() + "@live.com");
        userLoginPageObject.inPutPassAdressTextBox("123");
        userLoginPageObject.clickToLogin();
        Assert.assertEquals(userLoginPageObject.InvalidMessagePass(),"Please enter 6 or more characters without leading or trailing spaces.");
    }

    //@Test
    public void TC_05_LoginWithIncorrectPassword() {

//        homePageObject.clickToMyAccount();
//        loginPageObject = new LoginPageObject(driver);
        userLoginPageObject = userHomePageObject.ClickgetloginPageObject(driver);
        userLoginPageObject.inPutEmailAdressTextBox("auto_test" + randomNumber() + "@live.com");
        userLoginPageObject.inPutPassAdressTextBox("");
        userLoginPageObject.clickToLogin();

        Assert.assertEquals(userLoginPageObject.getPassWordAdressEmptyMessageError(),"This is a required field.");
    }

    @Test
    public void TC_06_LoginWithValidEmailAndPassword() {

//        homePageObject.clickToMyAccount();
//        loginPageObject = new LoginPageObject(driver);
        userLoginPageObject = userHomePageObject.ClickgetloginPageObject(driver);
        userLoginPageObject.inPutEmailAdressTextBox("selenium_11_01@gmail.com" );
        userLoginPageObject.inPutPassAdressTextBox("111111");
       myDashBoardPageObject = userLoginPageObject.clickToLoginMyDoashBoard();
        //myDashBoardPageObject = new MyDashBoardPageObject(driver);
        //myDashBoardPageObject = loginPageObject.getMyDashBoard(driver);
        Assert.assertEquals(myDashBoardPageObject.loginDashBoard(),"user01 account\n" + "selenium_11_01@gmail.com\n" + "Change Password");
    }

    //@AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(999999);
    }
}
