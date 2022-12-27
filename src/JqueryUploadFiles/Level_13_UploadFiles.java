package JqueryUploadFiles;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src2.actions.pageObjects.JqueryPageObject.HomePageObjectJquery;
import src2.actions.pageObjects.JqueryPageObject.PageGeneratorManagerJquery;
import src2.cores.commons.BaseTest;

public class Level_13_UploadFiles extends BaseTest {
    WebDriver driver;
    String demo1 = "demo1.png";
    String demo2 = "demo2.jpg";

    HomePageObjectJquery homePageObjectJquery;


    @Parameters({"browser", "Url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver = multipleBrowserEnum_SwitchCase_DriverManager(browserName,url);
        homePageObjectJquery = PageGeneratorManagerJquery.getHomePageJquery(driver);
    }
    @Test
    public void TC_01_One_Files(){
        boolean check;
        homePageObjectJquery.UploadMultipleFiles(driver,demo1);
        check = homePageObjectJquery.isImageLoadedSuccess(demo1);
        Assert.assertTrue(check);
        SleepinTime(3);
    }

    @Test
    public void TC_02_Multiple_Files(){
        homePageObjectJquery.refeshPage(driver);
        boolean check;
        homePageObjectJquery.UploadMultipleFiles(driver,demo1,demo2);
       check = homePageObjectJquery.isImageLoadedSuccess(demo1,demo2);
        Assert.assertTrue(check);
        SleepinTime(3);

    }

    //@AfterClass
//    public void afterClass() {
//        driver.quit();
//    }


}
