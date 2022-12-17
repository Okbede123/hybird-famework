package Automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class BaiTapHandleWindowTab {
    WebDriver driver;
    WebDriverWait waitelement;
    KhoiTaoDriver khoitao = new KhoiTaoDriver();
    JavascriptExecutor getjava;

    @BeforeClass
    public void BeforeClass(){
        System.setProperty(khoitao.khoiTaoChomre,khoitao.getProperty+khoitao.source);
        driver = new ChromeDriver();
        waitelement = new WebDriverWait(driver, Duration.ofSeconds(5));
        getjava = (JavascriptExecutor) driver;

    }

    @Test
    public void TC_01_Windows_Tab(){

        //vào url cha
        driver.get("https://automationfc.github.io/basic-form/index.html");
        //kiểm tra title
        //System.out.println(driver.getTitle());
        // lưu biến cha là parentTab để tí so sánh
        String parentTab = driver.getWindowHandle();
        //click sang tab mới
        driver.findElement(By.xpath("//a[text() = 'GOOGLE']")).click();
        //lấy ra tất cả id của các tab
        Set<String> allid = driver.getWindowHandles();
        for (String getallid:allid) {
            //nếu thằng getallid nào ko giống thằng cha
            if(!getallid.contains(parentTab)){
                //thì chuyển sang nó
                driver.switchTo().window(getallid);
            }
        }
        //kiểm tra xem đã chuyển thành công chưa
        System.out.println(driver.getTitle());

        String getidgoolge = driver.getWindowHandle();

        //SwitchTab(getidgoolge);
        switchWindowByID();
        System.out.println(driver.getTitle());

    }

    //@Test
    public void TC_02_Window_Tab_ALL(){

        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//a[text() = 'GOOGLE']")).click();
        driver.findElement(By.xpath("//a[text() = 'LAZADA']")).click();
        //System.out.println(driver.getTitle());
        SwitchTabAllCase("Google");
        System.out.println(driver.getTitle());
    }

    @Test
    public void TC_03_Window_Tab_ALL(){

        driver.get("http://live.techpanda.org/index.php/");
        driver.findElement(By.xpath("//a[text() = 'Mobile']")).click();

        driver.findElement(By.xpath("//a[text() = 'IPhone']//parent::h2//following-sibling::div[@class = 'actions']//ul//li//a[text() = 'Add to Compare']")).click();

        driver.findElement(By.xpath("//li[@class = 'success-msg']//li/span[text() = 'The product IPhone has been added to comparison list.']")).isDisplayed();

        driver.findElement(By.xpath("//a[text() = 'Samsung Galaxy']//parent::h2//following-sibling::div[@class = 'actions']//ul//li//a[text() = 'Add to Compare']")).click();

        driver.findElement(By.xpath("//li[@class = 'success-msg']//li/span[text() = 'The product Samsung Galaxy has been added to comparison list.']")).isDisplayed();

        driver.findElement(By.xpath("//button/span/span[text() = 'Compare']")).click();

        SwitchTabAllCase("Products");

        Assert.assertEquals(driver.getTitle(),"Products Comparison List - Magento Commerce");
        driver.close();
        SwitchTabAllCase("Mobile");
        Assert.assertEquals(driver.getTitle(),"Mobile");

    }

    @Test
    public void TC_04_Window(){

        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//a[text() = 'GOOGLE']")).click();
        driver.findElement(By.xpath("//a[text() = 'LAZADA']")).click();
        Set<String> allid = driver.getWindowHandles();
        
    }

    //hàm này là để check so sánh vs tk id hiện tại
    //neesu la id hiện tại thì bỏ qua, còn nếu khác id hiện tại thì switch vào
    public void SwitchTab(String bienhientai){
        Set<String> allid = driver.getWindowHandles();
        for (String id:allid) {
            if(!id.equals(bienhientai)){
                driver.switchTo().window(id);
            }
        }
    }

    public void SwitchTabAllCase(String titlemongmuon){
        //duyệt tất cả các tab
        Set<String> allid = driver.getWindowHandles();
        for (String id:allid) {
            //đi sang từng tab
            //System.out.println("so 1" + driver.getTitle());
            driver.switchTo().window(id);
            //lưu title tab
            String titlehientai = driver.getTitle();
            //System.out.println("so 2" + driver.getTitle());
            if(titlehientai.equals(titlemongmuon)){
                //đến title nào có title mong muốn thì dừng
                //System.out.println(driver.getTitle());
                break;
            }
        }
    }

    public void switchWindowByID(){
        String Idpresent = driver.getWindowHandle();
        Set<String> allWindowID = driver.getWindowHandles();
        for (String IDwindow : allWindowID) {
            if(!IDwindow.equals(Idpresent)){
                driver.switchTo().window(IDwindow);
            }
        }
    }
}
