package testcases.companda;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src2.cores.pageFactory.HomePageObject;
import src2.cores.pageFactory.LoginPageObject;
import src2.cores.pageFactory.MyDashBoardPageObject;
import src2.cores.commons.BaseTest;

import java.util.Random;

public class Level_05_Selenium_Page_Factory extends BaseTest {
    WebDriver driver;

    HomePageObject homePageObject;
    LoginPageObject loginPageObject;
    MyDashBoardPageObject myDashBoardPageObject;



    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {


        //gan lai driver cua multibrowser cho driver cua class
        driver = multipleBrowserEnum_SwitchCase_DriverManager(browserName);
        //driver.get("http://live.techpanda.org/index.php/");
        homePageObject = new HomePageObject(driver);
    }

    @Test
    public void TC_01_LoginWithEmptyEmailAndPassword() {
        homePageObject.clickToMyAccount();

        loginPageObject = new LoginPageObject(driver);


        loginPageObject.inPutEmailAdressTextBox("");
        loginPageObject.inPutPassAdressTextBox("");
        loginPageObject.clickToLogin();

        Assert.assertEquals(loginPageObject.getEmailAdressEmptyMessageError(),"This is a required field.");
        Assert.assertEquals(loginPageObject.getPassWordAdressEmptyMessageError(),"This is a required field.");
    }

    @Test
    public void TC_02_LoginWithInvalidEmail() {
        homePageObject.clickToMyAccount();

        loginPageObject = new LoginPageObject(driver);



        loginPageObject.inPutEmailAdressTextBox("123@456.89");
        loginPageObject.inPutPassAdressTextBox("123456");
        loginPageObject.clickToLogin();


        loginPageObject.InvalidMessageEmail();
        loginPageObject.InvalidMessagePass();

        Assert.assertEquals(loginPageObject.InvalidMessageEmail(),"Please enter a valid email address. For example johndoe@domain.com.");
        Assert.assertEquals(loginPageObject.InvalidMessagePass(),"Please enter a valid email address. For example johndoe@domain.com.");

    }

    @Test(description = "Email not exist in application")
    public void TC_03_LoginWithIncorrectEmail() {
        homePageObject.clickToMyAccount();
        loginPageObject = new LoginPageObject(driver);
        loginPageObject.inPutEmailAdressTextBox("auto_test" + randomNumber() + "@live.com");
        loginPageObject.inPutPassAdressTextBox("123456");
        loginPageObject.clickToLogin();
        Assert.assertEquals(loginPageObject.WrongPassOrEmail(),"Invalid login or password.");

    }

    @Test(description = "Password less than 6 characters")
    public void TC_04_LoginWithInvalidPassword() {

        homePageObject.clickToMyAccount();
        loginPageObject = new LoginPageObject(driver);
        loginPageObject.inPutEmailAdressTextBox("auto_test" + randomNumber() + "@live.com");
        loginPageObject.inPutPassAdressTextBox("123");
        loginPageObject.clickToLogin();
        Assert.assertEquals(loginPageObject.InvalidMessagePass(),"Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void TC_05_LoginWithIncorrectPassword() {

        homePageObject.clickToMyAccount();
        loginPageObject = new LoginPageObject(driver);
        loginPageObject.inPutEmailAdressTextBox("auto_test" + randomNumber() + "@live.com");
        loginPageObject.inPutPassAdressTextBox("");
        loginPageObject.clickToLogin();

        Assert.assertEquals(loginPageObject.getPassWordAdressEmptyMessageError(),"This is a required field.");
    }

    @Test
    public void TC_06_LoginWithValidEmailAndPassword() {

        homePageObject.clickToMyAccount();
        loginPageObject = new LoginPageObject(driver);
        loginPageObject.inPutEmailAdressTextBox("selenium_11_01@gmail.com" );
        loginPageObject.inPutPassAdressTextBox("111111");
        loginPageObject.clickToLogin();
        myDashBoardPageObject = new MyDashBoardPageObject(driver);
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

