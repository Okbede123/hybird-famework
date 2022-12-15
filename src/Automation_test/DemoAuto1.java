import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DemoAuto1 {

    public static void main(String[] args) {

        DemoAuto1 so1 = new DemoAuto1();
        so1.test1();
        so1.findCount();
    }

    WebDriver driver;

    public void test1(){

        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://vnexpress.net/");
        //driver.findElement(By.xpath("//input[@id = 'keywordHeader']")).getSize();
    }
    public void findCount(){
        int dem = driver.findElements(By.tagName("input")).size();
        System.out.println(dem);
        System.out.println("hôm nay bạn khỏe không");
    }
}
