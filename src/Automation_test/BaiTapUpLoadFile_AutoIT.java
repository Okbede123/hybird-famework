package Automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BaiTapUpLoadFile_AutoIT {
    WebDriver driver;
    KhoiTaoDriver khoiTaoDriver = new KhoiTaoDriver();

    // láy ra tên ảnh
    String anh1 = "demo1.png";
    String anh2 = "demo2.jpg";
    String anh3 = "demo3.jpg";

    //lấy ra đoạn link của foloder
    String locatorPC = khoiTaoDriver.getProperty;


    //dùng để chuyển đổi \\ với window và / với mac
    String doidaudieuhanh = File.separator;

    //tạo ra vịtrí foloder chứa file
    String viTriFolderAnh = locatorPC + doidaudieuhanh + "out" + doidaudieuhanh + "UpLoadFiles" + doidaudieuhanh;

    //tạo ra vị trí foloder chứa bản build autoit
    String viTriFolderAutoIt = locatorPC + doidaudieuhanh + "out" + doidaudieuhanh + "production" + doidaudieuhanh + "autoIT" + doidaudieuhanh;

    //vị trí đường link file
    String vitrianh1 = viTriFolderAnh + anh1;
    String vitrianh2 = viTriFolderAnh + anh2;
    String vitrianh3 = viTriFolderAnh + anh3;

    //vị trí autoIT exe
    String autoit_firefox = viTriFolderAutoIt + "firefox.exe";
    String autoit_chorme = viTriFolderAutoIt + "chormeedg.exe";

    //vị trí autoIT exe multi
    String autoit_multifirefox = viTriFolderAutoIt + "firefoxMultiUpLoad.exe";
    String autoit_multichorme = viTriFolderAutoIt + "ChomreEdgeMultiUpLoad.exe";
    WebDriverWait webDriverWait;
    JavascriptExecutor getjava;


    @BeforeClass

    public void BeforeClass(){
       driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        
        
        
        
        
        
        

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        getjava = (JavascriptExecutor) driver;
    }
    //@Test
    public void TC_01_Robot() throws IOException {
        //vào url
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        //click bật cửa sổ upfile
        driver.findElement(By.xpath("//span[@class = 'btn btn-success fileinput-button']")).click();

        //chạy ham runtime truyền link chứa bản build autoit_firefox và vitrianh1 vị trí của file
        Runtime.getRuntime().exec(new String[]{autoit_firefox,vitrianh1});
        khoiTaoDriver.SleepInTime(2);

        //chạy ham runtime truyền link chứa bản build autoit_firefox và vitrianh2 vị trí của file
        driver.findElement(By.xpath("//span[@class = 'btn btn-success fileinput-button']")).click();
        Runtime.getRuntime().exec(new String[]{autoit_firefox,vitrianh2});
        khoiTaoDriver.SleepInTime(2);
    //chạy ham runtime truyền link chứa bản build autoit_firefox và vitrianh3 vị trí của file
        driver.findElement(By.xpath("//span[@class = 'btn btn-success fileinput-button']")).click();
        Runtime.getRuntime().exec(new String[]{autoit_firefox,vitrianh3});
        khoiTaoDriver.SleepInTime(2);




        //khoiTaoDriver.SleepInTime(1);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Start']")));
        List<WebElement> buttons = driver.findElements(By.xpath("//span[text() = 'Start']"));
        for (WebElement click: buttons) {
            click.click();
        }
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class = 'name']/a[@title = '" + anh1 +"']")));
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[@title = '" + anh1 +"']")).isDisplayed());
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class = 'name']/a[@title = '" + anh2 +"']")));
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[@title = '" + anh2 +"']")).isDisplayed());
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class = 'name']/a[@title = '" + anh3 +"']")));
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[@title = '" + anh3 +"']")).isDisplayed());
    }
    @Test
    public void TC_02_MultiFile() throws IOException{

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        driver.findElement(By.xpath("//span[@class = 'btn btn-success fileinput-button']")).click();

        if(driver.toString().contains("chorme")){
            Runtime.getRuntime().exec(new String[]{autoit_multichorme,vitrianh1,vitrianh2,vitrianh3});
        }
        else{
            Runtime.getRuntime().exec(new String[]{autoit_multifirefox,vitrianh1,vitrianh2,vitrianh3});
        }


        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Start']")));
        List<WebElement> buttons = driver.findElements(By.xpath("//span[text() = 'Start']"));
        for (WebElement click: buttons) {
            //System.out.println(buttons);
            click.click();
        }
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class = 'name']/a[@title = '" + anh1 +"']")));
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[@title = '" + anh1 +"']")).isDisplayed());
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class = 'name']/a[@title = '" + anh2 +"']")));
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[@title = '" + anh2 +"']")).isDisplayed());
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class = 'name']/a[@title = '" + anh3 +"']")));
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[@title = '" + anh3 +"']")).isDisplayed());
    }
}
