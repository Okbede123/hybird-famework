package techpanda_farmework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Account_01_Register {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new EdgeDriver();

    }

    @Test
    public void Register_01_Empty_Data(){

        driver.get("https://dantri.com.vn/");
    }

    public void Register_02_Invalid_Email(){

    }

    public void Register_03_Invalid_Password(){

    }

    public void afterClass(){

    }
}
