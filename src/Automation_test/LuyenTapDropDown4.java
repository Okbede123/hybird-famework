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
import java.util.concurrent.TimeUnit;

public class LuyenTapDropDown4 {
    WebDriver driver;
    WebDriverWait waitelement;
    KhoiTaoDriver khoitao = new KhoiTaoDriver();

    //khai báo biến java kiểu JavascriptExecutor (dùng để lấy ra text bị ẩn)
    JavascriptExecutor java;

    @BeforeClass
    public void BeforeClass(){
        System.setProperty(khoitao.khoiTaoChomre,khoitao.getProperty + khoitao.source);
        driver = new ChromeDriver();
        waitelement = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        java = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void GetUrlCongThongTinCovid(){
        driver.get("https://tiemchungcovid19.gov.vn/portal/register-person");
        RegisterTiemVacxin("//ng-select[@bindvalue = 'provinceCode']//span[@class = 'ng-arrow-wrapper']","//div[@role= 'option']//span","Thành phố Hà Nội");
        //Assert.assertEquals(java.executeScript("return document.querySelector(\"ng-select[bindvalue = 'provinceCode']\").innerText.replace(\"×\",\"\").trim()"),"Thành phố Hà Nội");
        //dùng để lay ra text bị ẩn ở element bang cách dùng java.executeScript
        //đoạn return document.querySelector("ng-select[bindvalue = 'provinceCode']").innerText.replace("×","").trim()  này là để lấy ra text bị ẩn và bỏ dấu "×" và dùng trim để cắt khoảng trắng

        //String ketqua = (String) java.executeScript("return document.querySelector(\"ng-select[bindvalue = 'provinceCode']\").innerText");

        //Assert.assertEquals(ketqua.replace("×","").trim(),"Thành phố Hà Nội");

        sleepIn(5);
        //waitelement.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ng-select[@bindvalue= 'provinceCode']//span[contains(@class, 'ng-value-label')]")));
        System.out.println(driver.findElement(By.xpath("//ng-select[@bindvalue= 'provinceCode']//span[contains(@class, 'ng-value-label')]")).getText());

        Assert.assertEquals(driver.findElement(By.xpath("//ng-select[@bindvalue= 'provinceCode']//following-sibling::div//following-sibling::span[2]")).getText(),"Thành phố Hà Nội");


        //RegisterTiemVacxin("//ng-select[@bindvalue = 'districtCode']","//div[@role= 'option']//span","Quận Ba Đình");

    }

    public void RegisterTiemVacxin(String listThanhPho, String chonThanhPho, String mycity){
        driver.findElement(By.xpath(listThanhPho)).click();

        waitelement.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(chonThanhPho)));

        List<WebElement> getall = driver.findElements(By.xpath(chonThanhPho));
        for (WebElement gettp: getall) {
            if(gettp.getText().equals(mycity));
            gettp.click();
            break;
        }
    }

    public long sleepIn(long num){
        try {
            Thread.sleep(num*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return num;
    }
}
