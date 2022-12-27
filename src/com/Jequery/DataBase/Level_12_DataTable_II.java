package com.Jequery.DataBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src2.actions.pageObjects.JqueryPageObject.HomePageObjectJquery;
import src2.actions.pageObjects.JqueryPageObject.PageGeneratorManagerJquery;
import src2.cores.commons.BaseTest;

public class Level_12_DataTable_II extends BaseTest {
    WebDriver driver;

    HomePageObjectJquery homePageObjectJquery;


    @Parameters({"browser", "Url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver = multipleBrowserEnum_SwitchCase_DriverManager(browserName,url);
        homePageObjectJquery = PageGeneratorManagerJquery.getHomePageJquery(driver);
    }
    @Test
    public void TC_01_(){
    //làm sao để thao tác vs 1 ô nào đó
        //dựa vào thứ tự cột nằm ở thứ mấy
        // dựa vào thứ tự hàng nằm ở thứ mấy
        //giao giữa hàng và cột là thứ mình cần lấy


        //nhập liệu vào ô Contact Person

        //homePageObjectJquery.enterTextBoxByHeaderNameandRowNumberGetList("Contact Person","2","autotest");
        homePageObjectJquery.enterTextBoxByHeaderNameandRowNumber("Contact Person","1","3","autotest");
        //SleepinTime(3);
        //homePageObjectJquery.enterTextBoxByHeaderNameandRowNumberGetList("Company","1","vietnam");
        homePageObjectJquery.enterTextBoxByHeaderNameandRowNumber("Company","1","2","vietnam");
        homePageObjectJquery.selectTextBoxByHeaderNameandRowNumber("1","Hong Kong");
        homePageObjectJquery.enterTextBoxByHeaderNameandRowNumber("Member Since","1","7","12345623");
        SleepinTime(3);

    }



    //@AfterClass
//    public void afterClass() {
//        driver.quit();
//    }


}
