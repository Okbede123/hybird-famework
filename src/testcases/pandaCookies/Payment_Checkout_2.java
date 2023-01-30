package testcases.pandaCookies;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src2.actions.pageObjects.*;
import src2.cores.commons.BaseTest;

public class Payment_Checkout_2 extends BaseTest {
    WebDriver driver;

    UserHomePageObject userHomePageObject;
    UserLoginPageObject userLoginPageObject;
    MyDashBoardPageObject myDashBoardPageObject;

    Account_Information_PageObject account_information_pageObject;



    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        //gan lai driver cua multibrowser cho driver cua class
        driver= multipleBrowserEnum_SwitchCase(browserName);
       userHomePageObject = PageGeneratorManager.getHomePage(driver);
       //set cookie- refresh page
//        for (Cookie cookies:Commons_Logins.loginCookies) {
//            driver.manage().addCookie(cookies);
//        }
//        driver.navigate().refresh();
        userHomePageObject.addCookies(driver,Commons_Logins.loginCookies);



    }

    @Test
    public void TC_01_Order() {
    }

    @Test
    public void TC_02_Order() {

    }

    @Test
    public void TC_03_Order() {

    }


}
