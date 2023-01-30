package testcases.pandaCookies;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src2.actions.pageObjects.*;
import src2.cores.commons.BaseTest;

public class Payment_Order_Product extends BaseTest {
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
        for (Cookie cookie :Commons_Logins.loginCookies) {
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh();
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
