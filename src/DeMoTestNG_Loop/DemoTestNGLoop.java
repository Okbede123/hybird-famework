package DeMoTestNG_Loop;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class DemoTestNGLoop {
    WebDriver driver;
    String webMongmuon = "https://demo.guru99.com/";
    String layUserID;
    String layMatKhau;
    String getUrl = "https://demo.guru99.com/v4/";
    String getUrl2 = "https://demo.guru99.com/v4/";
    JavascriptExecutor testJava;
    String dateOfBirth = "1950-01-31";
    String address = "halongfdfđfghdf\nghfghfgjghjfghj";
    String addressCheck = "halongfdfđfghdf ghfghfgjghjfghj";




    @BeforeClass
    public void beforeClass(){

        String chomre = "webdrive.chrome.driver";
        String tesThu = System.getProperty("user.dir");
        System.setProperty(chomre,tesThu + "\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test(invocationCount = 4)
    public void testCase_01_Register(){
        driver.get("https://demo.guru99.com/v4/");

        driver.findElement(By.xpath("//a[text() = 'here']")).click();
        if(driver.getCurrentUrl() != webMongmuon)
        {
            driver.get(webMongmuon);
        }
        Assert.assertEquals("https://demo.guru99.com/",driver.getCurrentUrl());
        //driver.findElement(By.name("emailid")).sendKeys("okbede" + getRandom()+ "@assd.com");
        String taikhoan = "okbede" + getRandom() +"@ssss.com";
        driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys(taikhoan);
        driver.findElement(By.name("btnLogin")).click();
        layUserID = driver.findElement(By.xpath("//td[text() = 'User ID :']/following-sibling::td[@align = 'center']")).getText();
        layMatKhau = driver.findElement(By.xpath("//td[text() = 'Password :']/following-sibling::td[@align = 'center']")).getText();

    }

    //@Test(priority = 2)
    public void testCase_02_Login(){
        driver.get(getUrl);
        driver.findElement(By.cssSelector("input[type = text]")).sendKeys(layUserID);
        driver.findElement(By.cssSelector("input[type = password]")).sendKeys(layMatKhau);
        driver.findElement(By.cssSelector("input[type = submit]")).click();
    }

    //@Test(priority = 3)

    public void testCase_03_NewCustomer(){
        driver.findElement(By.xpath("//ul[@class = 'menusubnav']//li[2]")).click();
        //driver.findElement(By.name("name")).sendKeys();
        driver.findElement((By.xpath("//tr//td//input[@name= 'name']"))).sendKeys("okbede");

        driver.findElement(By.xpath("//input[@type = 'radio' and @value = 'f']")).click();

        testJava = (JavascriptExecutor) driver;

        WebElement ngayThang = driver.findElement(By.xpath("//tr//td//input[@type= 'date']"));

        testJava.executeScript("arguments[0].removeAttribute('type')",ngayThang);
        //waitForSleep(6);

        ngayThang.sendKeys("1950-01-31");
        //driver.findElement(By.xpath("//tr//td//textarea")).sendKeys("ha long, cao xanh");
        driver.findElement(By.name("addr")).sendKeys(address);
        driver.findElement(By.xpath("//tr//td//input[@name = 'city']")).sendKeys("ha long");
        driver.findElement(By.xpath("//tr//td//input[@name = 'state']")).sendKeys("cao xanh");
        driver.findElement(By.xpath("//tr//td//input[@name = 'pinno']")).sendKeys("1234567");
        driver.findElement(By.xpath("//tr//td//input[@name = 'telephoneno']")).sendKeys("0988887856");
        driver.findElement(By.xpath("//tr//td//input[@name = 'emailid']")).sendKeys("dfaghgsda" + getRandom() +"@edfsd.com");
        driver.findElement(By.xpath("//tr//td//input[@name = 'password']")).sendKeys("123456");
        driver.findElement(By.xpath("//tr//td//input[@type= 'submit']")).click();

        String getName = driver.findElement(By.xpath("//td[text() = 'Address']/following-sibling::td")).getText();
        System.out.println(getName);

        Assert.assertEquals(driver.findElement(By.xpath("//tr/td[1][text() = 'Address']/following-sibling::td")).getText(),addressCheck);

        //Assert.assertEquals(getName,"okbede1233");
        //
        //driver.quit();

    }

    public int getRandom(){
        Random rand = new Random();
        int random = rand.nextInt(9999);
        return random;
    }

    public void waitForSleep(long time){
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}