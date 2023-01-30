package Automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Element_Status_KnowLedge {
    WebDriver driver;
    WebDriverWait webDriverWait;

    By reEnterEmail = By.xpath("//input[@name = 'reg_email_confirmation__']");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.facebook.com/");
    }


    @Test
    public void TC_01_Visible() {
        //co trong html,co trong UI
        driver.findElement(By.xpath("//a[@data-testid= 'open-registration-form-button']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name= 'reg_email__']"))).sendKeys("okbede123@gmail.com");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(reEnterEmail)).sendKeys("okbede123");
        Assert.assertTrue(driver.findElement(reEnterEmail).isDisplayed());
    }

    @Test
    public void TC_02_Invisible() {
        //co tren html, ko co tren ui
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name= 'reg_email__']"))).clear();
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(reEnterEmail));
        Assert.assertFalse(driver.findElement(reEnterEmail).isDisplayed());
    }

    @Test
    public void TC_02_Invisible_Not_InDom() {

        //hàm invisibilityOfElementLocated vẫn file element hết timeout, hết time sẽ đánh fail testcase

        driver.findElement(By.xpath("//img[@id= 'u_e_9_Ji']")).click();
        driver.findElement(By.xpath("//div[@class = '_8ien']"));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(reEnterEmail));
        Assert.assertFalse(driver.findElement(reEnterEmail).isDisplayed());
    }

    //@AfterClass
    public void afterClass() {
        driver.quit();
    }


}