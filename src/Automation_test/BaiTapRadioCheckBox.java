package Automation_test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BaiTapRadioCheckBox {
    WebDriver driver;
    WebDriverWait waitelement;
    JavascriptExecutor getjava;
    KhoiTaoDriver khoitao = new KhoiTaoDriver();
    @BeforeClass
    public void BeforeClass(){
         System.setProperty(khoitao.khoiTaoChomre,khoitao.getProperty +khoitao.source);
         driver = new ChromeDriver();
         waitelement = new WebDriverWait(driver, Duration.ofSeconds(5));
         getjava = (JavascriptExecutor) driver;
         driver.manage().window().setSize(new Dimension(1366,768));
    }
    //@Test
    public void Geturl(){

        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        By chontextbox = By.xpath("//li//label[contains(text(),'Dual-zone air conditioning')]//preceding-sibling::input");
        //click checkbox
        driver.findElement(chontextbox).click();
        //verifly đã đc chọn hay chưa
        Assert.assertTrue(driver.findElement(chontextbox).isSelected());

        driver.findElement(chontextbox).click();
        Assert.assertFalse(driver.findElement(chontextbox).isSelected());

        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");

        By chonradiobox = By.xpath("//li//label[contains(text(),'2.0 Petrol, 147kW')]//preceding-sibling::input");
        driver.findElement(chonradiobox).click();
        if(!driver.findElement(chonradiobox).isSelected()){
            driver.findElement(chonradiobox).click();
        }
    }
    @Test
    public void MultiField(){
        driver.get("https://automationfc.github.io/multiple-fields/");
        List<WebElement> getallcheckbox = driver.findElements(By.xpath("//input[@type = 'checkbox']"));


        Random rand = new Random();
        int random = rand.nextInt(getallcheckbox.size());

        driver.findElement(By.xpath("(//input[@type = 'checkbox'])[" + random +"]")).click();

        //driver.findElement(By.xpath("(//input[@type = 'checkbox'])[" + random +"]")).click();

        for (WebElement selectall:getallcheckbox) {
            if(selectall.isSelected()){
                continue;
            }
            selectall.click();
        }
        for (WebElement selectall:getallcheckbox) {
            Assert.assertTrue(selectall.isSelected());
        }
    }
}
