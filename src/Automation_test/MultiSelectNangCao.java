package Automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MultiSelectNangCao {
    WebDriver driver;
    WebDriverWait waitelement;
    JavascriptExecutor getjava;
    KhoiTaoDriver khoitao = new KhoiTaoDriver();


    String element3month = "//div[@class = 'ms-drop bottom']//li[2]//label//span//parent::label//parent::li//preceding-sibling::li//parent::ul//parent::div//parent::div[@class = 'ms-parent multiple-select']//button//span";


    String [] ThreeofMonth = {"July","March","May"};
    String thangcha = "//div[@class = 'ms-drop bottom']//li[2]//label//span//parent::label//parent::li//preceding-sibling::li//parent::ul//parent::div//parent::div[@class = 'ms-parent multiple-select']";
    String month = "//div[@class = 'ms-drop bottom']//li[2]//label//span//parent::label//parent::li//preceding-sibling::li//parent::ul//parent::div//parent::div[@class = 'ms-parent multiple-select']//button//following-sibling::div[@class = 'ms-drop bottom']//li//following-sibling::li//label";
    @BeforeClass
    public void BeforeClass(){
        System.setProperty(khoitao.khoiTaoChomre,khoitao.getProperty+khoitao.source);
        driver = new ChromeDriver();
        waitelement = new WebDriverWait(driver, Duration.ofSeconds(5));
        getjava = (JavascriptExecutor) driver;
    }
    @Test
    public void SelectAll(){
        //vao url
        driver.get("https://multiple-select.wenzhixin.net.cn/templates/template.html?v=189&url=basic.html");

        //khoitao.SleepInTime(2);
        // chờ element xuất hiện
        waitelement.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class = 'ms-drop bottom']//li[2]//label//span//parent::label//parent::li//preceding-sibling::li//parent::ul//parent::div//parent::div[@class = 'ms-parent multiple-select']")));
        //bật cho xổ các item ra
        driver.findElement(By.xpath("//div[@class = 'ms-drop bottom']//li[2]//label//span//parent::label//parent::li//preceding-sibling::li//parent::ul//parent::div//parent::div[@class = 'ms-parent multiple-select']")).click();
        //click vào chon select all
        driver.findElement(By.xpath("//div[@class = 'ms-drop bottom']//li[2]//label//span//parent::label//parent::li//parent::ul//label//span[contains(text(),\"[Select all]\")]")).click();

        //click lại vào thằng cha tiếp
        driver.findElement(By.xpath(thangcha)).click();
        // kiem tra xem cai element nay co hien thi hay ko
        driver.findElement(By.xpath("//div[@class = 'ms-drop bottom']//li[2]//label//span//parent::label//parent::li//preceding-sibling::li//parent::ul//parent::div//parent::div[@class = 'ms-parent multiple-select']//button//span[text() = 'All selected']")).isDisplayed();
        driver.findElement(By.xpath(thangcha)).click();
        //khoitao.SleepInTime(3);
        driver.findElement(By.xpath("//div[@class = 'ms-drop bottom']//li[2]//label//span//parent::label//parent::li//parent::ul//label//span[contains(text(),\"[Select all]\")]")).click();
        driver.findElement(By.xpath(thangcha)).click();
    }

    @Test
    public void Selectlonhonbang3(){

        //click tiếp vào thằng cha
        driver.findElement(By.xpath(thangcha)).click();
        // lấy ra tất cả các tháng luu vào allofmonth
        List<WebElement> allofmonth = driver.findElements(By.xpath(month));
        //duyệt từng checkmonth 1
        for (WebElement checkmonth: allofmonth) {
            // duyệt mảng String ThreeofMonth
            for (String getmonth3 : ThreeofMonth) {
                //nếu  đến month nào chứa giá trị của getmonth3 trong mảng Threeofmoth thì click vào
                if(checkmonth.getText().equals(getmonth3)){
                    checkmonth.click();
                }
            }
            }
        //lấy ra những cái mình đã chọn
        String nhungcaidachon = driver.findElement(By.xpath(element3month)).getText();
        //System.out.println(nhungcaidachon);
        //tạo ra 1 cái list luudachon
        List<WebElement> luudachon;
        //lấy ra  tất cả những tickbox đã chọn
        luudachon = driver.findElements(By.xpath("//li[@class = 'selected']"));
        //lay ra so luong tickbox da chon
        System.out.println(luudachon.size());
        //gán biến laysodachon bằng với size của luudachon
        int laysodachon = luudachon.size();
        //nếu chọn nhỏ hơn 3 và lớn hơn 0 của tháng
        if(laysodachon <=3 && laysodachon > 0){
            //duyệt vòng lặp lấy ra item của mảng ThreeofMonth
            for (String items: ThreeofMonth) {
                //nếu trong những cái đã chọn chứa các String của items
                if(nhungcaidachon.contains(items));
                //thì check xem nó có hiển thị hay không
                driver.findElement(By.xpath("//div[@class = 'ms-drop bottom']//li[2]//label//span//parent::label//parent::li//preceding-sibling::li//parent::ul//parent::div//parent::div[@class = 'ms-parent multiple-select']//button//span[contains(text(),'" + items +"')]")).isDisplayed();
            }
        }
        //lấy lớn hơn 3 tháng và nhỏ hơn 12
        else if (laysodachon > 3 && laysodachon < 12){
            //cắt String và in ra thử
            System.out.println(laysodachon + driver.findElement(By.xpath("//div[@class = 'ms-drop bottom']//li[2]//label//span//parent::label//parent::li//preceding-sibling::li//parent::ul//parent::div//parent::div[@class = 'ms-parent multiple-select']//button//span")).getText().substring(1));
            //check xem hiển thị hay ko
            driver.findElement(By.xpath("//div[@class = 'ms-drop bottom']//li[2]//label//span//parent::label//parent::li//preceding-sibling::li//parent::ul//parent::div//parent::div[@class = 'ms-parent multiple-select']//button//span[text() = '" + laysodachon + " of 12 selected']")).isDisplayed();
        }
    }
}