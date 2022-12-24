package testcases.companda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import src2.actions.pageObjects.UserHomePageObject;
import src2.actions.pageObjects.UserLoginPageObject;
import src2.actions.pageObjects.MyDashBoardPageObject;

import java.util.Random;

public class Level_03_PageObject_Pattern {
    WebDriver driver;

    UserHomePageObject userHomePageObject;
    UserLoginPageObject userLoginPageObject;
    MyDashBoardPageObject myDashBoardPageObject;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/index.php/");
        userHomePageObject = new UserHomePageObject(driver);
    }

    @Test
    public void TC_01_LoginWithEmptyEmailAndPassword() {
        userHomePageObject.clickToMyAccount();

        userLoginPageObject = new UserLoginPageObject(driver);


        userLoginPageObject.inPutEmailAdressTextBox("");
        userLoginPageObject.inPutPassAdressTextBox("");
        userLoginPageObject.clickToLogin();

        Assert.assertEquals(userLoginPageObject.getEmailAdressEmptyMessageError(),"This is a required field.");
        Assert.assertEquals(userLoginPageObject.getPassWordAdressEmptyMessageError(),"This is a required field.");
    }

    @Test
    public void TC_02_LoginWithInvalidEmail() {
        userHomePageObject.clickToMyAccount();

        userLoginPageObject = new UserLoginPageObject(driver);



        userLoginPageObject.inPutEmailAdressTextBox("123@456.89");
        userLoginPageObject.inPutPassAdressTextBox("123456");
        userLoginPageObject.clickToLogin();


        userLoginPageObject.InvalidMessageEmail();
        userLoginPageObject.InvalidMessagePass();

        Assert.assertEquals(userLoginPageObject.InvalidMessageEmail(),"Please enter a valid email address. For example johndoe@domain.com.");
        Assert.assertEquals(userLoginPageObject.InvalidMessagePass(),"Please enter a valid email address. For example johndoe@domain.com.");

    }

    @Test(description = "Email not exist in application")
    public void TC_03_LoginWithIncorrectEmail() {
        userHomePageObject.clickToMyAccount();
        userLoginPageObject = new UserLoginPageObject(driver);
        userLoginPageObject.inPutEmailAdressTextBox("auto_test" + randomNumber() + "@live.com");
        userLoginPageObject.inPutPassAdressTextBox("123456");
        userLoginPageObject.clickToLogin();
        Assert.assertEquals(userLoginPageObject.WrongPassOrEmail(),"Invalid login or password.");

    }

    @Test(description = "Password less than 6 characters")
    public void TC_04_LoginWithInvalidPassword() {

        userHomePageObject.clickToMyAccount();
        userLoginPageObject = new UserLoginPageObject(driver);
        userLoginPageObject.inPutEmailAdressTextBox("auto_test" + randomNumber() + "@live.com");
        userLoginPageObject.inPutPassAdressTextBox("123");
        userLoginPageObject.clickToLogin();
        Assert.assertEquals(userLoginPageObject.InvalidMessagePass(),"Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void TC_05_LoginWithIncorrectPassword() {

        userHomePageObject.clickToMyAccount();
        userLoginPageObject = new UserLoginPageObject(driver);
        userLoginPageObject.inPutEmailAdressTextBox("auto_test" + randomNumber() + "@live.com");
        userLoginPageObject.inPutPassAdressTextBox("");
        userLoginPageObject.clickToLogin();

        Assert.assertEquals(userLoginPageObject.getPassWordAdressEmptyMessageError(),"This is a required field.");
    }

    @Test
    public void TC_06_LoginWithValidEmailAndPassword() {

        userHomePageObject.clickToMyAccount();
        userLoginPageObject = new UserLoginPageObject(driver);
        userLoginPageObject.inPutEmailAdressTextBox("selenium_11_01@gmail.com" );
        userLoginPageObject.inPutPassAdressTextBox("111111");
        userLoginPageObject.clickToLogin();
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

