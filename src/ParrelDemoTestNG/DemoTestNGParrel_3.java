package ParrelDemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DemoTestNGParrel_3 {
    WebDriver driver;
    By emailTextbox = By.xpath("//input[@id = 'email']");
    By password = By.xpath("//input[@id = 'pass']");
    By login = By.xpath("//button[@id = 'send2']");

    //duyet từng browser name, xem ở file demoTestNGParameterMultiplePage
    //nếu value tại file đó là chorme hoặc firefox thì sẽ chạy trình duyệt tương ứng
    //dùng switch case hay if else đều đc

    @BeforeClass
    public void beforeClass(){
            driver = new FirefoxDriver();


    }

    @Test
    public void TC_01_3_LoginToSystem(){

        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(emailTextbox).sendKeys("selenium_11_01@gmail.com");
        driver.findElement(password).sendKeys("111111");

    }

    @Test
    public void TC_02_3_LoginToSystem(){

        driver.findElement(login).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'col-1']//p")).getText().contains("selenium_11_01@gmail.com"));
        driver.findElement(By.xpath("//span[@class = 'icon']//following-sibling::span[text() = 'Account']")).click();
        driver.findElement(By.xpath("//li/a[text() = 'Log Out']")).click();
    }

}

