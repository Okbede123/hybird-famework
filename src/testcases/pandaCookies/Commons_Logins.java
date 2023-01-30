package testcases.pandaCookies;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import src2.actions.pageObjects.*;
import src2.cores.commons.BaseTest;

import java.util.Set;

public class Commons_Logins extends BaseTest {
    WebDriver driver;

    UserHomePageObject userHomePageObject;
    UserLoginPageObject userLoginPageObject;
    MyDashBoardPageObject myDashBoardPageObject;

    Account_Information_PageObject account_information_pageObject;

    static Set<Cookie> loginCookies;



    @Parameters({"browser"})
    @BeforeTest
    public void beforeTest(String browserName) {

        //gan lai driver cua multibrowser cho driver cua class
        driver= multipleBrowserEnum_SwitchCase(browserName);
       userHomePageObject = PageGeneratorManager.getHomePage(driver);
        userLoginPageObject = userHomePageObject.ClickgetloginPageObjectManager(driver);
        userLoginPageObject.inPutEmailAdressTextBox("selenium_11_01@gmail.com" );
        userLoginPageObject.inPutPassAdressTextBox("111111");
        myDashBoardPageObject = userLoginPageObject.getMyDashBoard(driver);
        assertTrue(myDashBoardPageObject.loginDashBoardDisplay());
        //loginCookies = driver.manage().getCookies();
        loginCookies = myDashBoardPageObject.getCookies(driver);
        driver.quit();

    }


}
