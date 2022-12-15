package Automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BaiTapFrame_Iframe {
    WebDriver driver;
    KhoiTaoDriver khoitao = new KhoiTaoDriver();
    WebDriverWait waitelement;
    JavascriptExecutor getjava;

    @BeforeClass
    public void BeforeClass(){
        System.setProperty(khoitao.khoiTaoChomre,khoitao.getProperty+khoitao.source);
        driver = new ChromeDriver();
        getjava = (JavascriptExecutor)driver;
        waitelement = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
    //@Test
    public void TC_01_Iframe(){

        driver.get("https://skills.kynaenglish.vn/");

        //lấy ra frame tại index 0
       //driver.switchTo().frame(0);
        //tìm element của iframe
        //nhớ phải có switchto
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class = 'face-content']/iframe")));
       WebElement laysolike = driver.findElement(By.xpath("//div/a[@title = 'Kyna.vn']//parent::div/following-sibling::div"));
        System.out.println(laysolike.getText());


        //sau đó muốn tương tác vs tk web cha phải switch to về defaultcontent
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//div[@class = 'row-menu-bar-mobile hidden-sm-up']//following-sibling::form/div//input")).sendKeys("okbede");

        //chuyển sang iframe của thằng chat
        driver.switchTo().frame("cs_chat_iframe");
        khoitao.SleepInTime(3);
        //waitelement.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.button_bar")));
        driver.findElement(By.cssSelector("div.button_bar")).click();
        khoitao.SleepInTime(3);
        driver.findElement(By.xpath("//label[@class = 'label label_edit_internal ng-binding']//following-sibling::input[@placeholder = 'Nhập tên của bạn']")).sendKeys("okjbede");
        driver.findElement(By.xpath("//label[@class = 'label label_edit_internal ng-binding']//following-sibling::input[@placeholder = 'Nhập số điện thoại của bạn']")).sendKeys("019232310");
        Select select =  new Select(driver.findElement(By.xpath("//select[@id = 'serviceSelect']")));
        select.selectByVisibleText("HỖ TRỢ KỸ THUẬT");
        //String laycaichondau = select.getFirstSelectedOption().getText();
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"HỖ TRỢ KỸ THUẬT");
        driver.findElement(By.xpath("//textarea[@name = 'message']")).sendKeys("day la text");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//div[@class = 'row-menu-bar-mobile hidden-sm-up']//following-sibling::form/div//input")).clear();
        driver.findElement(By.xpath("//div[@class = 'row-menu-bar-mobile hidden-sm-up']//following-sibling::form/div//input")).sendKeys("excel");
        driver.findElement(By.xpath("//button[@class = 'search-button']")).click();
        khoitao.SleepInTime(2);
        List<WebElement> layexel = driver.findElements(By.xpath("//div[@class = 'content']//h4"));
        for (WebElement duyet: layexel) {
            if(duyet.getText().contains("excel")){
                Assert.assertTrue(duyet.getText().equalsIgnoreCase("excel"));
            }
        }

    }

    @Test
    public void TC_02_Frame(){
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        driver.switchTo().frame("login_page");
        driver.findElement(By.xpath("//div[@class = 'inputfield ibvt loginData']/input")).sendKeys("okbede123");
        driver.findElement(By.xpath("//div[@class = 'inputfield ibvt loginData']/a")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'inputfield ibvt loginData']/input[@type ='password']")).isDisplayed());
    }
}
