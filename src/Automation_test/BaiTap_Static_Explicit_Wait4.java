package Automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaiTap_Static_Explicit_Wait4 {
    WebDriver driver;
    WebDriverWait webDriverWait;
    JavascriptExecutor getjava;

    KhoiTaoDriver khoiTaoDriver = new KhoiTaoDriver();

    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();

    }

    @Test
    public void TC_01_Equal(){
        //trường hợp đủ 5s
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        By waitbutton = By.cssSelector("div#start>button");
       // WebElement waitbutton = driver.findElement(By.cssSelector("div#start>button"));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(waitbutton));
        driver.findElement(By.cssSelector("div#start>button")).click();
        // chờ đến khi elenment loading biến mất 5s
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));
        webDriverWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div#loading"),1));
        //chờ element dưới đc hiển thị
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish")));

    }

    @Test
    public void TC_02_LessThan(){
        //trường hợp nhỏ hơn 5s
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        By waitbutton = By.cssSelector("div#start>button");
        // WebElement waitbutton = driver.findElement(By.cssSelector("div#start>button"));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(waitbutton));
        driver.findElement(By.cssSelector("div#start>button")).click();
        // chờ đến khi elenment loading biến mất 3s
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));
        //chờ element dưới đc hiển thị
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish")));
    }

    @Test
    public void TC_03_MoreThan(){
        //trường hợp lớn hơn 5s
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        By waitbutton = By.cssSelector("div#start>button");
        // WebElement waitbutton = driver.findElement(By.cssSelector("div#start>button"));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(waitbutton));
        driver.findElement(By.cssSelector("div#start>button")).click();
        // chờ đến khi elenment loading biến mất 30s
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));
        //chờ element dưới đc hiển thị
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish")));
    }
}
