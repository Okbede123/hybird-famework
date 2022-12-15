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

public class LuyenTapDropDown5 {
    WebDriver driver;
    KhoiTaoDriver khoitao = new KhoiTaoDriver();
    WebDriverWait waitelment;
    JavascriptExecutor getjava;

    @BeforeClass
    public void BeforeClass(){
        System.setProperty(khoitao.khoiTaoChomre,khoitao.getProperty + khoitao.source);
        driver = new ChromeDriver();
        waitelment = new WebDriverWait(driver, Duration.ofSeconds(5));
        getjava = (JavascriptExecutor) driver;
    }

    //@Test
    public void getUrl(){

        //Cach cua Duc
        String savechoice;
        driver.get("https://indrimuska.github.io/jquery-editable-select/");
        driver.findElement(By.xpath("//div[@id = 'default-place']//input")).sendKeys("Audi");
        List<WebElement> getlist = driver.findElements(By.xpath("//div[@id = 'default-place']//ul//li"));
        for (WebElement countlist: getlist) {
            if(countlist.getText().equals("Audi")){
                savechoice = countlist.getText();
                Assert.assertEquals(savechoice,"Audi");
            }
        }

    }

    @Test
    public void getUrl_2(){

        driver.get("https://indrimuska.github.io/jquery-editable-select/");
        driver.findElement(By.xpath("//div[@id = 'default-place']//input")).sendKeys("Audi");
        Assert.assertEquals(getjava.executeScript("return document.querySelector(\"div[id = 'default-place']>input\").value"),"Audi");
        //Assert.assertEquals(getjava.executeScript("return document.querySelector(\"div[id = 'default-place']>ul>li[class = 'es-visible']\").innerText "),"Audi");
        khoitao.SleepInTime(5);
        //Assert.assertEquals(driver.findElement(By.cssSelector("div[id = 'default-place'] li[class = 'es-visible selected']")).getText(),"Audi");
        //Assert.assertEquals(driver.findElement(By.xpath("//div[@id = 'default-place']//following-sibling::li[@class = 'es-visible selected']")).getText(),"Audi");
        driver.findElement(By.xpath("//div[@id = 'default-place']//input")).sendKeys("BMW");
    }
}
