package Automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_01_ToiUuCode {
    WebDriver driver;
    KhoiTaoDriver khoiTaoDriver = new KhoiTaoDriver();
    WebDriverWait wait;
    JavascriptExecutor getjs;

    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        getjs = (JavascriptExecutor) driver;
        driver.get("https://www.google.com/");
    }

    @BeforeMethod
    public void BeforeMethod(){

        driver.navigate().back();
        //driver.findElement(By.cssSelector("input[type = 'text']")).clear();
    }

    @Test
    public void TC_01_Search(){
        Sendkeys(By.cssSelector("input[type = 'text']"),"quangcaogiatot.com");
        Click(By.xpath("//div[@class = 'FPdoLc lJ9FBc']/center/input[@value = 'Tìm trên Google']"));
    }

    @Test
    public void TC_02_Search(){
        Sendkeys(By.cssSelector("input[type = 'text']"),"duc than tai");
        Click(By.xpath("//div[@class = 'FPdoLc lJ9FBc']/center/input[@value = 'Tìm trên Google']"));
    }

    public void Sendkeys(By element,String timkiem){
        driver.findElement(element).sendKeys(timkiem);
    }

    public void Click(By element){
        driver.findElement(element).click();
    }
}
