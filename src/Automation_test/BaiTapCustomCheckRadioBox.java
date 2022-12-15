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

public class BaiTapCustomCheckRadioBox {
    WebDriver driver;
    WebDriverWait waitelement;
    KhoiTaoDriver khoitao = new KhoiTaoDriver();
    JavascriptExecutor getjava;

    @BeforeClass
    public void BeforeClass(){
        System.setProperty(khoitao.khoiTaoChomre,khoitao.getProperty+khoitao.source);
        driver = new ChromeDriver();
        waitelement = new WebDriverWait(driver, Duration.ofSeconds(5));
        getjava = (JavascriptExecutor) driver;
    }

    //@Test
    public void GetUrl_Radiobox(){

        driver.get("https://material.angular.io/components/radio/examples");
        By season = By.xpath("//input[@value = 'Spring']");
        //getjava.executeScript("arguments[0].click()",driver.findElement(season));
        driver.findElement(season).click();
        Assert.assertTrue(driver.findElement(season).isSelected());
        //input[@value = 'Spring']//following-sibling::div[@class = 'mdc-radio__background']
        //getjava.executeScript("arguments[0].click()",driver.findElement(By.xpath("//input[@value = 'Spring']//following-sibling::div[@class = 'mdc-radio__background']")));
    }

    @Test
    public void GetUrl_Checkbox(){
        driver.get("https://material.angular.io/components/checkbox/examples");
        By checkbox = By.xpath("(//input[@class = 'mdc-checkbox__native-control'])[1]");
        By checkbox2 = By.xpath("(//div[@class = 'mdc-form-field']//div//input)[1]");
        //driver.findElement(checkbox2).click();
        //getjava.executeScript("arguments[0].click()",driver.findElement(checkbox2));

        getjava.executeScript("arguments[0].scrollIntoView(false);",driver.findElement(By.xpath("//example-viewer[@id = 'checkbox-overview']")));

        Checkbox(checkbox2);
        Assert.assertTrue(driver.findElement(checkbox2).isSelected());
        khoitao.SleepInTime(5);

        //unCheckbox(checkbox2);
        //Assert.assertFalse(driver.findElement(checkbox2).isSelected());


    }

    public void Checkbox(By click){
        WebElement element = driver.findElement(click);
        if(!element.isSelected()){
            getjava.executeScript("arguments[0].click()",driver.findElement(click));
        }
    }

    public void unCheckbox(By click){
        WebElement element = driver.findElement(click);
        if(element.isSelected()){
            getjava.executeScript("arguments[0].click()",driver.findElement(click));
        }
    }

}
