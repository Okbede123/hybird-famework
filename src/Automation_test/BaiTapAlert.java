package Automation_test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaiTapAlert {
    WebDriver driver;
    
    
    WebDriverWait waitElement;
    KhoiTaoDriver khoitao = new KhoiTaoDriver();

    String AuthenChorme = khoitao.getProperty + "\\out\\production\\autoIT\\authen_chrome.exe";

    //khởi tạo kiểu dữ liệu Alert biến là canhbao
    Alert canhbao;
    JavascriptExecutor getjava;
    @BeforeClass
    public void BeforeClass(){
        System.setProperty(khoitao.khoiTaoChomre,khoitao.getProperty+khoitao.source);
        driver = new ChromeDriver();
        waitElement = new WebDriverWait(driver, Duration.ofSeconds(5));
        getjava = (JavascriptExecutor) driver;
    }

    //@Test
    public void TC_01_Accpet_Alert(){
        By click  = By.xpath("//div[@class = 'example']//button[@onclick = 'jsAlert()']");
        driver.get("https://automationfc.github.io/basic-form/index.html");

        //getjava.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//legend//following-sibling::button")));
        driver.findElement(click).click();

        //gán biến cảnh bảo cho hàm swithTo vì nó trả về kiểu dữ liệu Alert
        //canhbao = driver.switchTo().alert(); //Cách 1

        //chờ cho tới khi Alert xuất hiện roi switch to
        canhbao = waitElement.until(ExpectedConditions.alertIsPresent()); //cách 2 (ưu tiên)
        //gettext của cái alert
        Assert.assertEquals(canhbao.getText(),"I am a JS Alert");
        //ấn đồng ý
        canhbao.accept();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'example']//p[contains(text(),'You clicked an alert successfully')]")).getText(),"You clicked an alert successfully");
        //System.out.println(driver.findElement(By.xpath("//div[@class = 'example']//p[contains(text(),'You clicked an alert successfully')]")).getText());

    }

    //@Test
    public void TC_02_Confirm_Alert(){
        By clickconfirm  = By.xpath("//div[@class = 'example']//button[@onclick = 'jsConfirm()']");
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(clickconfirm).click();
        //chờ cho alert xuất hiện
        canhbao = waitElement.until(ExpectedConditions.alertIsPresent());
        canhbao.dismiss();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'example']//p")).getText(),"You clicked: Cancel");
    }
    //@Test
    public void TC_03_Prompt_Alert(){
        String nhapvao = "okbede";
        By clickprompt  = By.xpath("//div[@class = 'example']//button[@onclick = 'jsPrompt()']");
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(clickprompt).click();

        canhbao = waitElement.until(ExpectedConditions.alertIsPresent()); //chờ alert xuất hiện
        System.out.println(canhbao.getText());
        canhbao.sendKeys(nhapvao);
        canhbao.dismiss();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'example']//p")).getText(),"You entered: null");
        khoitao.SleepInTime(3);
        driver.findElement(clickprompt).click();
        canhbao.sendKeys(nhapvao);
        canhbao.accept();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'example']//p")).getText(),"You entered: " + nhapvao);
    }

    //@Test
    public void TC_04_Authentication_Alert(){
            driver.get("http://the-internet.herokuapp.com/");
            String taikhoan = "admin";
            String matkhau = "admin";
          String getatt =  driver.findElement(By.xpath("//a[contains(text(),'Basic Auth')]")).getAttribute("href");


        //System.out.println(getatt.split("//")[0] + "//" + taikhoan + ":" + matkhau + "@" + getatt.split("//")[1]);

        //String truycapauthen = (getatt.split("//")[0] + "//" + taikhoan + ":" + matkhau + "@" + getatt.split("//")[1]);

        //driver.get(truycapauthen);
        //TruyCapAuthen("http://the-internet.herokuapp.com/",taikhoan,matkhau);
        driver.get(TruyCapAuthen(getatt,taikhoan,matkhau));
    }

    @Test
    public void TC_05_Authentication_Alert_AutoIt() throws Exception{
        // dùng throws để trong trường hợp ko chạy đc cái runtime hoặc ko tìm ra cảnh báo


        //đây là phương thức runtime để chuẩn bị cho cảnh báo xuất hiện thì sẽ điền tài khoản mk vào theo username password
        // hàm exc nhận vào 1 mảng string

        String [] test = {AuthenChorme,"admin","admin" };
        java.lang.Runtime.getRuntime().exec(new String[]{test[0],test[1],test[2]});


        driver.get("http://the-internet.herokuapp.com/basic_auth");

    }

    public String TruyCapAuthen(String url,String tk,String mk){
        String [] chiaurl = url.split("//");
        url = chiaurl[0] + "//" + tk + ":" + mk + "@" + chiaurl[1];
        return url;


    }
}
