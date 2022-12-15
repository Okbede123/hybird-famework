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

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.List;

public class BaiTapUpLoadFileRoBot {
    WebDriver driver;
    WebDriverWait webDriverWait;
    JavascriptExecutor getjava;
    KhoiTaoDriver khoiTaoDriver = new KhoiTaoDriver();

    String locatorPC = khoiTaoDriver.getProperty;


    // láy ra tên ảnh
    String anh1 = "demo1.png";
    String anh2 = "demo2.jpg";
    String anh3 = "demo3.jpg";

    //dùng để chuyển đổi \\ với window và / với mac
    String doidaudieuhanh = File.separator;

    //tạo ra vịtrí foloder chứa file
    String viTriFolderAnh = locatorPC + doidaudieuhanh + "out" + doidaudieuhanh + "UpLoadFiles" + doidaudieuhanh;

    //vị trí đường link file
    String vitrianh1 = viTriFolderAnh + anh1;
    String vitrianh2 = viTriFolderAnh + anh2;
    String vitrianh3 = viTriFolderAnh + anh3;

    @BeforeClass
    public void BeforeClass(){
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        getjava = (JavascriptExecutor) driver;
    }

    //@Test
    public void TC_01_Robot() throws AWTException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");


        //lấy ra đường dẫn file
        StringSelection selection = new StringSelection(vitrianh1);
        //copy vào clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

        driver.findElement(By.xpath("//span[@class = 'btn btn-success fileinput-button']")).click();

        //Load File
        Robot robot = new Robot();
        khoiTaoDriver.SleepInTime(2);

        //nhấn ctrl-V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);


        //thả ctrl-v
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        khoiTaoDriver.SleepInTime(2);

        //nhấn enter

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        //khoiTaoDriver.SleepInTime(2);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Start']")));
        List<WebElement> buttons = driver.findElements(By.xpath("//span[text() = 'Start']"));
        for (WebElement click: buttons) {
            click.click();
        }

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class = 'name']/a[@title = '" + anh1 +"']")));
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[@title = '" + anh1 +"']")).isDisplayed());
    }

    @Test
    public void TC_02_RobotMultiFile(){

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        //lấy ra đường dẫn file
        StringSelection selection = new StringSelection(vitrianh1);
        //copy vào clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
        System.out.println("anh1 " +vitrianh1);

        driver.findElement(By.xpath("//span[@class = 'btn btn-success fileinput-button']")).click();

        ThaoTacPhim();
        khoiTaoDriver.SleepInTime(2);

        //lấy ra đường dẫn file
        StringSelection selection2 = new StringSelection(vitrianh2);
        //copy vào clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection2,null);
        System.out.println("anh2 " +vitrianh2);
        driver.findElement(By.xpath("//span[@class = 'btn btn-success fileinput-button']")).click();
        khoiTaoDriver.SleepInTime(2);
        ThaoTacPhim();
        khoiTaoDriver.SleepInTime(2);

        //lấy ra đường dẫn file
        StringSelection selection3 = new StringSelection(vitrianh3);
        //copy vào clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection3,null);
        System.out.println("anh3 " +vitrianh3);
        driver.findElement(By.xpath("//span[@class = 'btn btn-success fileinput-button']")).click();
        khoiTaoDriver.SleepInTime(2);
        ThaoTacPhim();
        khoiTaoDriver.SleepInTime(2);

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

    public void ThaoTacPhim(){
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        //khoiTaoDriver.SleepInTime(2);

        //nhấn ctrl-V dán vào
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);


        //thả ctrl-v thả nút ra
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        //khoiTaoDriver.SleepInTime(2);

        //nhấn enter

        robot.keyPress(KeyEvent.VK_ENTER);
        //thả enter
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
