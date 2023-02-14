package testcases.companda;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src2.cores.commons.BaseTest;

public class Level_25_Mutlple_Environment extends BaseTest {
    WebDriver driver;



    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver= multipleBrowserEnum_SwitchCase_DemoSortData(browserName,url);

    }

    @Test
    public void TC_01_LoginWithEmptyEmailAndPassword() {

        System.out.println("tesst1");
    }

    @Test
    public void TC_02_LoginWithInvalidEmail() {
        System.out.println("tesst1");
    }


    //@AfterClass
//    public void afterClass() {
//        driver.quit();
//    }


}
