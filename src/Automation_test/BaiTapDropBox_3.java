package Automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaiTapDropBox_3 {

    KhoiTaoDriver khoitao = new KhoiTaoDriver();
    WebDriver driver;
    Select chonNgay,chonThang,chonNam;
    String myPassword = "123123";

    String day = "3";
    String firstName = "Vu";

    @BeforeClass
    public void BeforeClass(){
        System.setProperty(khoitao.khoiTaoChomre,khoitao.getProperty + khoitao.source);
        driver = new ChromeDriver();
        //driver.get("https://dantri.com.vn/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void TC_01_getUrl(){

        //vào website
        driver.get("https://demo.nopcommerce.com/");
        //click đăng ký
        driver.findElement(By.cssSelector("li>a[class = ico-register]")).click();

        // nhập thông tin
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("Van Phay");
        //chonNgay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        //khởi tạo các biến select tìm các element và gán vào biến chonNgay,chonThang,chonNam
        chonNgay = new Select(driver.findElement(By.xpath("//select[@name = 'DateOfBirthDay']")));
        chonThang = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        chonNam = new Select(driver.findElement(By.name("DateOfBirthYear")));
        //chọn các thông tin mong muốn
        chonNgay.selectByVisibleText(day);
        chonThang.selectByVisibleText("March");
        chonNam.selectByVisibleText("1985");
        driver.findElement(By.cssSelector("input#Email")).sendKeys("okbede" + getRandomNum() + "@add.com");
        driver.findElement(By.cssSelector("input#Password")).sendKeys(myPassword);
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(myPassword);
        //System.out.println(chonNgay.getFirstSelectedOption().getText());
        //click button register

        driver.findElement(By.cssSelector("button#register-button")).click();

        driver.findElement(By.xpath("//a[@class = 'ico-account']")).click();









    }

    @Test
    public void TC_02_checkVerify(){

        Assert.assertEquals(driver.findElement(By.name("FirstName")).getAttribute("value"),firstName);

        //dùng tiếp biến chonNgay và tìm lại element
        chonNgay = new Select(driver.findElement(By.xpath("//select[@name = 'DateOfBirthDay']")));
        //System.out.println(chonNgay.getFirstSelectedOption().getText());
        Assert.assertEquals(chonNgay.getFirstSelectedOption().getText(),day);

        //1 cách để lấy ra các item trong dropdown box

        chonThang = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        List<WebElement> get = chonThang.getOptions();
        for(WebElement list :get){
            System.out.println(list.getText());
        }
        // 1 cách để lấy ra các item trong dropdown box
        List<WebElement> getMonth = driver.findElements(By.xpath("//select[@name = 'DateOfBirthMonth']//following-sibling::option"));
        for(WebElement gett : getMonth){
            System.out.println(gett.getText());
        }



    }

    public int getRandomNum(){
        Random rand = new Random();
        int num = rand.nextInt(9999);
                return num;
    }

    public void sleepInTime(long time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
