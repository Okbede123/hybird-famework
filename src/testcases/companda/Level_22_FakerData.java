package testcases.companda;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src2.actions.pageObjects.*;
import src2.cores.commons.BaseTest;
import src2.cores.ultilities.DataFaker;

public class Level_22_FakerData extends BaseTest {
    WebDriver driver;

    DataFaker faker = DataFaker.getDataFaker();

    String userName = faker.getEmailAddress();
    String passWord = faker.getPassword();

    String firstName = faker.getFirstNameUser();

    String lastName = faker.getLastNameUser();

    UserHomePageObject userHomePageObject;
    UserLoginPageObject userLoginPageObject;
    MyDashBoardPageObject myDashBoardPageObject;

    Account_Information_PageObject account_information_pageObject;

    UserRegisterPageObject userRegisterPageObject;



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

    //@Test
    public void TC_01_LoginWithEmptyEmailAndPassword() {
        log.info("Login_01 - Click to my account link");
        //homePageObject.clickToMyAccount();
        userLoginPageObject = userHomePageObject.getFooterContainPage(driver).getMyAccountNotLogged();

        //loginPageObject = new LoginPageObject(driver);

        userLoginPageObject.enterToTextBoxById(driver,"","email");
        userLoginPageObject.enterToTextBoxById(driver,"","pass");
//        userLoginPageObject.inPutEmailAdressTextBox("");
//        userLoginPageObject.inPutPassAdressTextBox("");
        userLoginPageObject.clickToButtonByTitle(driver,"Login");
//        userLoginPageObject.clickToLogin();

        Assert.assertEquals(userLoginPageObject.getFieldErrorById(driver,"advice-required-entry-email"),"This is a required field.");
        Assert.assertEquals(userLoginPageObject.getFieldErrorById(driver,"advice-required-entry-pass"),"This is a required field.");
//        assertEqual(userLoginPageObject.getPassWordAdressEmptyMessageError(),"This is a required field.");
    }

    //@Test
    public void TC_02_LoginWithInvalidEmail() {
        //homePageObject.clickToMyAccount();
        log.info("Test");

        userLoginPageObject = userHomePageObject.getFooterContainPage(driver).getMyAccountNotLogged();

        userLoginPageObject.enterToTextBoxById(driver,"123@456.89","email");
        //userLoginPageObject.inPutEmailAdressTextBox("123@456.89");
        //userLoginPageObject.inPutPassAdressTextBox("123456");
        userLoginPageObject.enterToTextBoxById(driver,passWord,"pass");
//        userLoginPageObject.clickToLogin();
        userLoginPageObject.clickToButtonByTitle(driver,"Login");


        userLoginPageObject.InvalidMessageEmail();
        userLoginPageObject.InvalidMessagePass();
        Assert.assertEquals(userLoginPageObject.getFieldErrorById(driver,"advice-validate-email-email"),"Please enter a valid email address. For example johndoe@domain.com.");
        //assertEqual(userLoginPageObject.InvalidMessageEmail(),"Please enter a valid email address. For example johndoe@domain.com.");

    }

    //@Test(description = "Email not exist in application")
    public void TC_03_LoginWithIncorrectEmail() {
        log.info("Login_03 - Click to my account link");
        userLoginPageObject = userHomePageObject.getFooterContainPage(driver).getMyAccountNotLogged();
        userLoginPageObject.enterToTextBoxById(driver,userName,"email");
        //userLoginPageObject.inPutEmailAdressTextBox("auto_test" + getrandomNumber() + "@live.com");
        userLoginPageObject.enterToTextBoxById(driver,"123456","pass");
        //userLoginPageObject.inPutPassAdressTextBox("123456");
//        userLoginPageObject.clickToLogin();
        userLoginPageObject.clickToButtonByTitle(driver,"Login");
        Assert.assertEquals(userLoginPageObject.getPageError(driver),"Invalid login or password.");
//        assertEqual(userLoginPageObject.WrongPassOrEmail(),"Invalid login or password.");

    }

    //@Test(description = "Password less than 6 characters")
    public void TC_04_LoginWithInvalidPassword() {

//        homePageObject.clickToMyAccount();
//        loginPageObject = new LoginPageObject(driver);
        userLoginPageObject = userHomePageObject.getFooterContainPage(driver).getMyAccountNotLogged();
        userLoginPageObject.enterToTextBoxById(driver,userName,"email");
        //userLoginPageObject.inPutEmailAdressTextBox("auto_test" + getrandomNumber() + "@live.com");
        userLoginPageObject.enterToTextBoxById(driver,"123","pass");
        //userLoginPageObject.inPutPassAdressTextBox("123");
//        userLoginPageObject.clickToLogin();
        userLoginPageObject.clickToButtonByTitle(driver,"Login");
        Assert.assertEquals(userLoginPageObject.getFieldErrorById(driver,"advice-validate-password-pass"),"Please enter 6 or more characters without leading or trailing spaces.");
        //assertEqual(userLoginPageObject.InvalidMessagePass(),"Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void TC_05_Register_Success(){
        userLoginPageObject = userHomePageObject.getFooterContainPage(driver).getMyAccountNotLogged();
       userLoginPageObject.clickToButtonByTitle(driver,"Create an Account");
        userRegisterPageObject = PageGeneratorManager.openUserRegister(driver);
        userRegisterPageObject.enterToTextBoxById(driver,firstName,"firstname");
        userRegisterPageObject.enterToTextBoxById(driver,lastName,"lastname");
        userRegisterPageObject.enterToTextBoxById(driver,userName,"email_address");
        userRegisterPageObject.enterToTextBoxById(driver,passWord,"password");
        userRegisterPageObject.enterToTextBoxById(driver,passWord,"confirmation");
        userRegisterPageObject.clickToRegister();
        userHomePageObject = userRegisterPageObject.clickLogOutHomePageAdmin(driver);
    }

    @Test
    public void TC_06_LoginWithIncorrectPassword() {

//        homePageObject.clickToMyAccount();
//        loginPageObject = new LoginPageObject(driver);
        userLoginPageObject = userHomePageObject.getFooterContainPage(driver).getMyAccountNotLogged();
        userLoginPageObject.enterToTextBoxById(driver,userName,"email");
        //userLoginPageObject.inPutEmailAdressTextBox("auto_test" + getrandomNumber() + "@live.com");
        userLoginPageObject.enterToTextBoxById(driver,"","pass");
        //userLoginPageObject.inPutPassAdressTextBox("");
//        userLoginPageObject.clickToLogin();
        userLoginPageObject.clickToButtonByTitle(driver,"Login");
        Assert.assertEquals(userLoginPageObject.getFieldErrorById(driver,"advice-required-entry-pass"),"This is a required field.");
        //assertEqual(userLoginPageObject.getPassWordAdressEmptyMessageError(),"This is a required field.");
    }

    //@Test
    public void TC_07_LoginWithValidEmailAndPassword() {

//        homePageObject.clickToMyAccount();
//        loginPageObject = new LoginPageObject(driver);
        userLoginPageObject = userHomePageObject.getFooterContainPage(driver).getMyAccountNotLogged();
        userLoginPageObject.enterToTextBoxById(driver,userName,"email");
        userLoginPageObject.enterToTextBoxById(driver,passWord,"pass");
        //userLoginPageObject.inPutEmailAdressTextBox("selenium_11_01@gmail.com" );
        //userLoginPageObject.inPutPassAdressTextBox("111111");
        userLoginPageObject.clickToButtonByTitle(driver,"Login");
        myDashBoardPageObject = PageGeneratorManager.getMyDashBoard(driver);
//       myDashBoardPageObject = userLoginPageObject.getMyDashBoard(driver);
        //myDashBoardPageObject = new MyDashBoardPageObject(driver);
        //myDashBoardPageObject = loginPageObject.getMyDashBoard(driver);
        assertTrue(myDashBoardPageObject.loginDashBoardDisplay());


    }

    //@AfterClass
//    public void afterClass() {
//        driver.quit();
//    }


}
