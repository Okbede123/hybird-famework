package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaiTap_Wait_Findelement_Findelements3_TestNG {
    WebDriver driver;
    WebDriverWait webDriverWait;
    JavascriptExecutor getjs;
    KhoiTaoDriver_TestNg khoiTaoDriver = new KhoiTaoDriver_TestNg();

    @BeforeSuite
    public void BeforeClass(){
        driver = new FirefoxDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com/");
    }
    public void TC_01_Find_element(){

        driver.findElement(By.xpath("//input[@id = 'email']"));
    }
    @AfterSuite
    public void TC_02_Find_elements(){

        int numberElement = 0;

        numberElement = driver.findElements(By.xpath("//input[@id = 'email']")).size();
        System.out.println("so element = " + numberElement);

        numberElement = driver.findElements(By.xpath("//div[@id = 'pageFooterChildren']//li")).size();
        System.out.println("so element = " + numberElement);


    }
}
