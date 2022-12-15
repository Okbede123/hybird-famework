package Automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BaitapCustomCheckbox_Radio {
    WebDriver driver;
    WebDriverWait waitelement;
    JavascriptExecutor getjava;
    KhoiTaoDriver khoitao = new KhoiTaoDriver();

    @BeforeClass
    public void BeforeClass(){
        System.setProperty(khoitao.khoiTaoChomre,khoitao.getProperty+khoitao.source);
        driver = new ChromeDriver();
        waitelement = new WebDriverWait(driver, Duration.ofSeconds(5));
        getjava = (JavascriptExecutor)driver;
    }
    @Test
    public void GetUrl(){
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        List<WebElement> getall = driver.findElements(By.xpath("//div[@role = 'checkbox']"));
        for (WebElement selectall: getall) {
            selectall.click();
            Assert.assertTrue(driver.findElement(By.xpath("//div[@role = 'checkbox' and @aria-checked = 'true']")).isDisplayed());
        }
    }
}
