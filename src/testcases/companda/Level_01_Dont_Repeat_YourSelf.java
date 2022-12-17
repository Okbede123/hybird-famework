package testcases.companda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Level_01_Dont_Repeat_YourSelf {
    WebDriver driver;



    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://live.techpanda.org/");
    }

    //cứ moi lần chạy testcase(hàm) sẽ chạy vào hàm beforemethod này
    @BeforeMethod
    public void beforeMethod() {
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
    }

    @Test
    public void TC_01_LoginWithEmptyEmailAndPassword() {
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("pass")).sendKeys("");
        driver.findElement(By.id("send2")).click();

        assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
        assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
    }

    @Test
    public void TC_02_LoginWithInvalidEmail() {
        driver.findElement(By.id("email")).sendKeys("123@456.789");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();

        assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test(description = "Email not exist in application")
    public void TC_03_LoginWithIncorrectEmail() {
        driver.findElement(By.id("email")).sendKeys("auto_test" + randomNumber() + "@live.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();

        assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(), "Invalid login or password.");
    }

    @Test(description = "Password less than 6 characters")
    public void TC_04_LoginWithInvalidPassword() {
        driver.findElement(By.id("email")).sendKeys("auto_test" + randomNumber() + "@live.com");
        driver.findElement(By.id("pass")).sendKeys("123");
        driver.findElement(By.id("send2")).click();

        assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void TC_05_LoginWithIncorrectPassword() {
        driver.findElement(By.id("email")).sendKeys("auto_test" + randomNumber() + "@live.com");
        driver.findElement(By.id("pass")).sendKeys(randomNumber() + "");
        driver.findElement(By.id("send2")).click();

        assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(), "Invalid login or password.");
    }

    @Test
    public void TC_06_LoginWithValidEmailAndPassword() {
        driver.findElement(By.id("email")).sendKeys("selenium_11_01@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("111111");
        driver.findElement(By.id("send2")).click();

        assertTrue(driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p[contains(text(),'user01')]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p[contains(.,'selenium_11_01@gmail.com')]")).isDisplayed());
    }

    //@AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(999999);
    }

}