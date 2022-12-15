package Automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LuyenTapDropDown {
    WebDriver driver;
    KhoiTaoDriver khoiTao = new KhoiTaoDriver();
    WebDriverWait loadingElement;
    Select select;

    @BeforeClass
    public void BeforeClass(){
        System.setProperty(khoiTao.khoiTaoChomre,khoiTao.getProperty + khoiTao.source);
        driver = new ChromeDriver();
        loadingElement = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void GetUrl(){
        driver.get("https://www.honda.com.vn/o-to/du-toan-chi-phi");
        //button[@class = 'btn dropdown-toggle']

        //div[@class = 'dropdown-menu show']//a
        GetExploaixe("//button[@class = 'btn dropdown-toggle']","//div[@class = 'dropdown-menu show']//a","CITY RS");
        //select[@name = 'province']
        GetTinhThanh("//select[@name = 'province']","Bắc Kạn");
        //select[@name = 'registration_fee']
        GetKhuVuc("//select[@name = 'registration_fee']","Khu vực III");


    }

    public void GetExploaixe(String chonloaixe,String chonxe,String loaixemuon){

        driver.findElement(By.xpath(chonloaixe)).click();
        loadingElement.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(chonxe)));

        List<WebElement> listXe = driver.findElements(By.xpath(chonxe));
        for (WebElement tempXe: listXe) {
            if(tempXe.getText().equals(loaixemuon)){
                tempXe.click();
                break;
            }
        }
    }

    public void GetTinhThanh(String selectxe, String diachi){
        select = new Select(driver.findElement(By.xpath(selectxe)));
        select.selectByVisibleText(diachi);
    }
    public void GetKhuVuc(String khuvuc, String mykhuvuc){
        select = new Select(driver.findElement(By.xpath(khuvuc)));
        select.selectByVisibleText(mykhuvuc);
    }
}
