package com.Jequery.DataBase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src2.actions.pageObjects.JqueryPageObject.HomePageObjectJquery;
import src2.actions.pageObjects.JqueryPageObject.PageGeneratorManagerJquery;
import src2.cores.commons.BaseTest;

public class Level_12_DataTable extends BaseTest {
    WebDriver driver;

    HomePageObjectJquery homePageObjectJquery;


    @Parameters({"browser", "Url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver = multipleBrowserEnum_SwitchCase_DriverManager(browserName,url);
        homePageObjectJquery = PageGeneratorManagerJquery.getHomePageJquery(driver);
    }

    //@Test
    public void TC_01_Header_TextBox(){

    homePageObjectJquery.sendKeyToTextBoxHeaderName("Country","Angola");
    Assert.assertTrue(homePageObjectJquery.isDisplayHeaderBox("276880","Angola","276472","553353"));
    homePageObjectJquery.refeshPage(driver);
    homePageObjectJquery.sendKeyToTextBoxHeaderName("Total","49397");
    Assert.assertTrue(homePageObjectJquery.isDisplayHeaderBox("24128","Albania","25266","49397"));
    homePageObjectJquery.refeshPage(driver);


    }

    //@Test
    public void TC_02_Action_Icon(){
        //homePageObjectJquery.clickToActionByCountryName( "Albania", "remove");
        //homePageObjectJquery.clickToActionByCountryName( "Afghanistan", "remove");
        //homePageObjectJquery.refeshPage(driver);
        homePageObjectJquery.clickToActionByCountryName( "Afghanistan", "edit");
        SleepinTime(3);
    }

    @Test
    public void TC_03_Paging(){
        homePageObjectJquery.clickOpenPage("5");

        Assert.assertTrue(homePageObjectJquery.isDisplayNumberPage("5"));
    }



    //@AfterClass
//    public void afterClass() {
//        driver.quit();
//    }


}
