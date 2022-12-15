package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoTestNGProvider {
    WebDriver driver;
    By emailTextbox = By.xpath("//input[@id = 'email']");
    By password = By.xpath("//input[@id = 'pass']");
    By login = By.xpath("//button[@id = 'send2']");

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
    }

    @Test(dataProvider = "user_pass")
    public void TC_01_LoginToSystem(String username,String pass){

        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(emailTextbox).sendKeys(username);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(login).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'col-1']//p")).getText().contains(username));
        driver.findElement(By.xpath("//span[@class = 'icon']//following-sibling::span[text() = 'Account']")).click();
        driver.findElement(By.xpath("//li/a[text() = 'Log Out']")).click();
    }

    @DataProvider(name = "user_pass")
    public String[][]UserAndPassword(){
        return new String[][]{
                {"selenium_11_01@gmail.com","111111"},
                {"selenium_11_02@gmail.com","111111"},
                {"selenium_11_03@gmail.com","111111"}
        };
    }
}
