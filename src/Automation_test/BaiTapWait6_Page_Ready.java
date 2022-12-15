package Automation_test;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BaiTapWait6_Page_Ready {
    WebDriver driver;
    WebDriverWait webDriverWait;
    FluentWait<WebDriver> fluentWait;
    JavascriptExecutor getjs;
    KhoiTaoDriver khoiTaoDriver = new KhoiTaoDriver();
    Actions action;

    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        //webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Orange_Page_Ready(){
        driver.get("https://blog.testproject.io/");
        action = new Actions(driver);

        action.moveToElement(driver.findElement(By.xpath("//section[@id = 'search-2']//label//input"))).perform();
        Assert.assertTrue(isPageLoadSuccess());
        driver.findElement(By.xpath("//section[@id = 'search-2']//label//input")).sendKeys("selenium");
        driver.findElement(By.xpath("//section[@id = 'search-2']//label//input")).sendKeys(Keys.ENTER);
        //khoiTaoDriver.SleepInTime(4);
        driver.navigate().refresh();
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class = 'page-title']/span")));
        Assert.assertTrue(isPageLoadSuccess());
        List<WebElement> allelement = driver.findElements(By.xpath("//div[@class = 'post-content']/h3/a[contains(text(),'Selenium')]"));
        for (WebElement element:allelement) {
            Assert.assertTrue(element.getText().contains("Selenium"));

        }

    }

    public boolean isPageLoadSuccess(){
        webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(15));
        getjs = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) getjs.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return getjs.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return webDriverWait.until(jQueryLoad) && webDriverWait.until(jsLoad);
    }

//    public boolean jsQueryAndPageLoad(){
//        webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(15));
//        getjs = (JavascriptExecutor) driver;
//        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                try {
//                    return ((Long) getjs.executeScript("return jQuery.active") == 0);
//                }catch (Exception e){
//                    return true;
//                }
//            }
//
//        };
//        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                return getjs.executeScript("return document.readystate").toString().equals("complete");
//            }
//        };
//        return webDriverWait.until(jQueryLoad) && webDriverWait.until(jsLoad);
//    }
}
