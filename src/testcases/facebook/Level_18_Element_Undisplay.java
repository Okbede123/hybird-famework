package testcases.facebook;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src2.actions.pageObjects.Facebook.LoginPageObject;
import src2.actions.pageObjects.Facebook.PageGeneratorManager;
import src2.cores.commons.BaseTest;

public class Level_18_Element_Undisplay extends BaseTest {
    WebDriver driver;

    LoginPageObject loginPageObject;



    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName,String appUrl) {

       driver = multipleBrowserEnum_SwitchCase_DriverManager(browserName,appUrl);
       loginPageObject = PageGeneratorManager.getLoginPage(driver);

    }

    @Test
    public void TC_01_Visible() {
        loginPageObject.clickToNewAccount();
        loginPageObject.textBoxEmail("okbede123@gmail.com");
        //SleepinTime(1);
        loginPageObject.waitForReEnterEmailVisibilityInDom();
        Assert.assertTrue(loginPageObject.isReEnterUndisplayed());
    }

    @Test
    public void TC_02_Invisible() {
    loginPageObject.textBoxEmail("");
    //SleepinTime(1);
    loginPageObject.waitForReEnterEmailInvisibility_NotInDom();
    Assert.assertTrue(loginPageObject.isReEnterUndisplayed());
    }

    @Test
    public void TC_03_Invisible_Not_InDom() {
        loginPageObject.closeCreateNewAccount();
        //SleepinTime(1);
        loginPageObject.waitForReEnterEmailInvisibility_NotInDom();
        //hàm isReEnterUndisplayed check đc element ko hiển thị trong dom
        Assert.assertTrue(loginPageObject.isReEnterUndisplayed());
    }


    //@AfterClass
    public void afterClass() {
        driver.quit();
    }


}

