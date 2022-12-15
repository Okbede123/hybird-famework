package Automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LuyenTapJavaScriptExp {
    WebDriver driver;
    WebDriverWait waitelment;
    JavascriptExecutor getjava;
    KhoiTaoDriver khoitao = new KhoiTaoDriver();
    @BeforeClass
    public void BeforeClass(){
        System.setProperty(khoitao.khoiTaoChomre,khoitao.getProperty+khoitao.source);
        driver = new ChromeDriver();
        waitelment = new WebDriverWait(driver, Duration.ofSeconds(5));
        getjava = (JavascriptExecutor) driver;
    }
    @Test
    public void GetUrl(){
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        driver.findElement(By.xpath("//span[@id = 'number-button']//span[1]")).click();
        //scroll bang javascrpit
        //getjava.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//div[@class = 'ui-selectmenu-menu ui-front ui-selectmenu-open']")));
        //click bang javascrpit

        waitelment.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li [@class = 'ui-menu-item']")));
        //List<WebElement> getlist = driver.findElements(By.xpath("//li [@class = 'ui-menu-item']"));
        List<WebElement> getlist = driver.findElements(By.xpath("//li//div"));
        for (WebElement list: getlist) {
            System.out.println(list.getText());
            if(list.getText().equals("19")){
                //list.click();
                getjava.executeScript("arguments[0].click()",driver.findElement(By.xpath("//li//div")).getText());

            }
        }
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id= 'number-button']//span[2]")).getText(),"19");

    }
}
