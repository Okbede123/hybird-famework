package Automation_test;

import org.openqa.selenium.By;
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

public class BaiTapDropDown {
    KhoiTaoDriver callDriver = new KhoiTaoDriver();
    WebDriver driver;
    // là 1 dạng wait , chờ các trạng thái của element
    WebDriverWait explicitWait;

    @BeforeClass
    public void BeforeClass(){

        System.setProperty(callDriver.khoiTaoChomre,callDriver.getProperty + callDriver.source);
        driver = new ChromeDriver();

        // chờ cho element đc hiển thị theo trạng thái
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // chờ cho element xuất hiện
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    //@Test

    public void getUrl(){
        // vào url
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        // click vào button của dropdown
        //driver.findElement(By.id("#number-button")).click();
        driver.findElement(By.xpath("//span[@id = 'number-button']")).click();
        // chờ cho các element hiển thị/load
        //chờ cho tất cả các item bên trong đc hiển thị trong vòng 5 giây
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id = 'number-menu']//li//div")));

        //get ra các item trong list

        //List<WebElement> luuTru = driver.findElements(By.xpath("//ul[@id = 'number-menu']//li//div"));
        List<WebElement> luuTru = driver.findElements(By.xpath("//ul[@id = 'number-menu']//li//div"));
        //System.out.println(luuTru.get(1).getText());
        for(WebElement get : luuTru){
            //tìm ra giá trị item = 7, nếu tìm ra thì click vào
            if(get.getText().equals("7")){
                System.out.println("đã tìm ra item "+ get.getText());
                get.click();

                //khi tìm ra rồi và đến 7 thì thoát khỏi vòng lặp
                break;
            }
        }
    }
    @Test
    public void TestHam(){
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        checkItem("//span[@id = 'number-button']","//ul[@id = 'number-menu']//li//div","5");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id = 'number-button']//span[@class = 'ui-selectmenu-text']")).getText(),"5");
        //callDriver.SleepInTime(3);
        checkItem("//span[@id = 'number-button']","//ul[@id = 'number-menu']//li//div","16");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id = 'number-button']//span[@class = 'ui-selectmenu-text']")).getText(),"16");
        //callDriver.SleepInTime(3);
        checkItem("//span[@id = 'number-button']","//ul[@id = 'number-menu']//li//div","3");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id = 'number-button']//span[@class = 'ui-selectmenu-text']")).getText(),"3");
        //callDriver.SleepInTime(3);


    }

    //viết lại thành hàm
    public void checkItem(String ParentXpath,String ChildXpath, String ExpItem){

        driver.findElement(By.xpath(ParentXpath)).click();
        Sleepin(4);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ChildXpath)));
        List<WebElement>luuTru = driver.findElements(By.xpath(ChildXpath));
        for (WebElement get: luuTru) {
            if(get.getText().equals(ExpItem)){
                System.out.println(get.getText());
                get.click();
                break;
            }
        }
    }

    public void Sleepin(long num){
        try {
            Thread.sleep(num * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
