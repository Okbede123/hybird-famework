package Automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaiTapWait {
    WebDriver driver;
    WebDriverWait webDriverWait;
    JavascriptExecutor getjs;
    KhoiTaoDriver khoiTaoDriver = new KhoiTaoDriver();

    @BeforeClass
    public void BeforeClass(){
        System.setProperty(khoiTaoDriver.khoiTaoChomre,khoiTaoDriver.getProperty+khoiTaoDriver.source);
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.facebook.com/");
    }

    //@Test
    public void TC_01_Visible(){
        //Visible: có trên UI và có trong DOM/HTML
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
        Assert.assertTrue(driver.findElement(By.cssSelector("input#email")).isDisplayed());

    }
    @Test
    public void TC_02_Invisible_InDom(){

        //ko có trên UI nhưng có trong DOM/Html

        driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']")).click();

        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'reg_email_confirmation__']")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = 'Sign Up']")));


        Assert.assertFalse(driver.findElement(By.xpath("//input[@name = 'reg_email_confirmation__']")).isDisplayed());

    }
    //@Test
    public void TC_02_Invisible_NotInDom(){
        //ko có trên UI nhưng ko có trong DOM/Html
        driver.findElement(By.xpath("//div[@class = '_8ien']/img")).click();
        khoiTaoDriver.SleepInTime(2);

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@name = 'reg_email_confirmation__']")));

    }
    //@Test
    public void TC_03_Presence(){
        //có trên dom và có trên UI
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#email")));

        driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']")).click();

        //có trên dom và ko có trên UI

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name = 'reg_email_confirmation__']")));



    }
    @Test
    public void TC_04_Stalness(){

        //bật form đăng ký lên
        driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']")).click();

        if(driver.toString().contains("chorme"))
        {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = 'Sign Up']")));
        }
        else{
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = 'Đăng ký']")));
        }

        //tại thời điểm này element còn
        WebElement confirm = driver.findElement(By.xpath("//input[@name = 'reg_email_confirmation__']"));

        //tắt form đăng ký
        driver.findElement(By.xpath("//div[@class = '_8ien']/img")).click();

        //chờ cho element đó biến mất
        webDriverWait.until(ExpectedConditions.stalenessOf(confirm));
    }

}
