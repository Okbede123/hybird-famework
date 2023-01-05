package Automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageObject {
    WebDriver driver;
    WebDriverWait webDriverWait;
    String urlWeb = "https://test-hr.stringeex.com/login";
    String userName = "test-hr@stringee.com";
    String passWord = "TestHr@2022";
    String logOut = "//a[contains(text(),'Đăng xuất')]";
    String infoText = "div[class = 'infoText']";


    @BeforeClass
    public void BeforeClass(){
       driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Login(){
        driver.get(urlWeb);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(userName);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(passWord);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type = submit]"))).click();
        waitLogOut(20);
    }
    @Test
    public void TC_02_Logout(){
        driver.findElement(By.cssSelector(infoText)).click();
        driver.findElement(By.xpath(logOut)).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
    }

    @AfterClass
    public void AfterClass(){
        driver.quit();
    }
    public void waitLogOut(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
