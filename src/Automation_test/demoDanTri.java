package Automation_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class demoDanTri {
    WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdrive.chrome.driver","C:\\chromedriver.exe");
        demoDanTri so1 = new demoDanTri();
        so1.getTitle();
        
        
        
        
        //test 


    }
    public void getTitle(){
        driver = new ChromeDriver();
        driver.get("https://dantri.com.vn/");
        String element = driver.getTitle();
        String sosanh = "Tin tức Việt Nam và quốc tế nóng, nhanh, cập nhật 24h | Báo Dân tríuu";
        //System.out.println(element);
        Assert.assertEquals(element,sosanh);



    }
}
