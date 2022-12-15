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

import java.io.File;
import java.time.Duration;
import java.util.List;

public class BaiTapUploadFileSendKeys {
    WebDriver driver;
    WebDriverWait webDriverWait;

    String anh1 = "demo1.png";
    String anh2 = "demo2.jpg";
    String anh3 = "demo3.jpg";



    String locationPC = System.getProperty("user.dir");

    // cái này File.separator để thay dấu gạch \\ của hệ điều hành, nếu là window thì nó tự đổi thành \\ macmini là /
    String doidauhedieuhanh = File.separator;

    String viTriFolderAnh = locationPC + doidauhedieuhanh + "out" + doidauhedieuhanh + "UpLoadFiles" + doidauhedieuhanh;
    String vitrianh1 = locationPC + "\\out\\UpLoadFiles\\" + anh1;

    String vitrianh_1 = viTriFolderAnh + anh1;
    String vitrianh_2 = viTriFolderAnh + anh2;
    String vitrianh_3 = viTriFolderAnh + anh3;
    KhoiTaoDriver khoiTaoDriver = new KhoiTaoDriver();
    JavascriptExecutor getJava;

    @BeforeClass
    public void BeforeClass(){


        //System.setProperty(khoiTaoDriver.khoiTaoChomre,khoiTaoDriver.getProperty+khoiTaoDriver.source);
        //System.setProperty(khoiTaoDriver.khoiTaoChomre,"C:\\chromedriver.exe");
        System.out.println(khoiTaoDriver.getProperty+khoiTaoDriver.source);
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        getJava = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //@Test
    public void TC_01_UploadFile_OneFile(){

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By btnstart = By.cssSelector("input[type = 'file']");

        System.out.println(vitrianh1);
        System.out.println(vitrianh_1);
        //loadfile lên
        driver.findElement(btnstart).sendKeys(vitrianh_1);
        driver.findElement(btnstart).sendKeys(vitrianh_2);
        driver.findElement(btnstart).sendKeys(vitrianh_3);
        //upload file
        List<WebElement> buttons = driver.findElements(By.xpath("//span[text() = 'Start']"));
        for (WebElement click: buttons) {
            click.click();
            khoiTaoDriver.SleepInTime(1);
        }

        //verify
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[@title = '" + anh1 +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[@title = '" + anh2 +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[@title = '" + anh3 +"']")).isDisplayed());

    }

    //@Test
    public void TC_02_UploadFile_MultiFile(){
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By btnstart = By.cssSelector("input[type = 'file']");

        driver.findElement(btnstart).sendKeys(vitrianh_1 + "\n" + vitrianh_2 + "\n" + vitrianh_3);

        List<WebElement> buttons = driver.findElements(By.xpath("//span[text() = 'Start']"));

        for (WebElement click: buttons) {
            click.click();
            khoiTaoDriver.SleepInTime(1);
        }

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[@title = '" + anh1 +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[@title = '" + anh2 +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[@title = '" + anh3 +"']")).isDisplayed());
    }

    @Test
    public void TC_03_Multifile_2(){
        driver.get("https://gofile.io/uploadFiles");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class = 'btn btn-primary btn-lg mb-1 uploadButton']")));
        //khoiTaoDriver.SleepInTime(4);
        driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys(vitrianh_1 + "\n" + vitrianh_2 + "\n" + vitrianh_3);

        //khoiTaoDriver.SleepInTime(8);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id = 'rowUploadSuccess-showFiles']")));

        driver.findElement(By.xpath("//button[@id = 'rowUploadSuccess-showFiles']")).click();

        List<WebElement> elementsverify = driver.findElements(By.xpath("//span[@class = 'contentName']"));

        for (WebElement element: elementsverify) {
            Assert.assertTrue(element.isDisplayed());
        }
    }
}
