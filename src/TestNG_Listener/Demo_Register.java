package TestNG_Listener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//listener để check nếu testcase pass hoặc fail thì sẽ làm gì tiếp theo
//phải tạo 1 class mới
//ví dụ class là ReportListener
//khi dùng sẽ ghi ReportListener.class

@Listeners(ReportListener.class)
public class Demo_Register {

    WebDriver driver;

    ReportListener reportListener = new ReportListener();
    By emailTextbox = By.xpath("//input[@id = 'email']");
    By password = By.xpath("//input[@id = 'pass']");
    By login = By.xpath("//button[@id = 'send2']");


    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();


    }

    @Test

    public void TC_01_LoginToSystem(){

        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(emailTextbox).sendKeys("selenium_11_01@gmail.com");
        driver.findElement(password).sendKeys("111111");
        Assert.assertTrue(false);


    }
}
