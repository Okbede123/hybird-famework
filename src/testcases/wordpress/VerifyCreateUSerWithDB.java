package testcases.wordpress;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src2.actions.pageObjects.wordpress.ConfigUserPageObject;
import src2.actions.pageObjects.wordpress.LoginPageObject;
import src2.actions.pageObjects.wordpress.MyDashBoardPageObject;
import src2.actions.pageObjects.wordpress.PageGeneralManager;
import src2.cores.commons.BaseTest;

import java.sql.SQLException;

public class VerifyCreateUSerWithDB extends BaseTest {

    WebDriver driver;
    LoginPageObject loginPageObject;
    MyDashBoardPageObject myDashBoardPageObject;
    ConfigUserPageObject configUserPageObject;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browser,String url){
        driver = multipleBrowserEnum_SwitchCase_DemoSortData(browser,url);
        loginPageObject = PageGeneralManager.goToLogin(driver);
        myDashBoardPageObject = loginPageObject.inPutUserNameAndPassAndLogin("automationduc","halong123");
    }

    @Test
    public void TC_01_GoToCreateUser() throws SQLException {
        configUserPageObject = myDashBoardPageObject.openMenuAdminNavigation().openConfigUser();

        Assert.assertTrue(configUserPageObject.getNumberUserAdmin() == configUserPageObject.getNumberUserDb());
    }

    @AfterClass
    public void afterClass(){
        closeBrowserDriver();
    }

}
