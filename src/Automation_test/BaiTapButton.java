package Automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaiTapButton {
    WebDriver driver;
    //KhoiTaoDriver khoitao = new KhoiTaoDriver();
    WebDriverWait waitelement;
    JavascriptExecutor getjava;

    @Test
    public void BeforeClass(){
        //System.setProperty(khoitao.khoiTaoChomre,khoitao.getProperty+khoitao.source);
        driver = new ChromeDriver();
        waitelement = new WebDriverWait(driver, Duration.ofSeconds(5));
        getjava = (JavascriptExecutor) driver;

    }
    @Test
    public void Geturl(){
        driver.get("https://www.fahasa.com/customer/account/login/referer/aHR0cHM6Ly93d3cuZmFoYXNhLmNvbS9jdXN0b21lci9hY2NvdW50L2luZGV4Lw,,/");
        //tao 1 bien btndangnhap


        By btndangnhap = By.cssSelector("button[class = 'fhs-btn-login']");
        //
        driver.findElement(btndangnhap).isDisplayed();
        //verifly thằng btn đang ko đc enable, mong muốn false
        Assert.assertFalse(driver.findElement(btndangnhap).isEnabled());
        //luu 2 bien fieldtaikhoan và filematkhau
        By fieldtaikhoan = By.cssSelector("input#login_username");
        By fieldmatkhau = By.cssSelector("input#login_password");
        //dien du lieu
        driver.findElement(fieldtaikhoan).sendKeys("sfdfsdf@gmail.com");
        driver.findElement(fieldmatkhau).sendKeys("sdfrgdfg");
        //verify là đã hiển thị, mong muốn true
        Assert.assertTrue(driver.findElement(btndangnhap).isEnabled());

        //refesh trang
        driver.navigate().refresh();

        getjava.executeScript("arguments[0].removeAttribute('disabled')",driver.findElement(btndangnhap));
        //lay ra thuoc tinh mau` cua btn tai cái element btndangnhap
       String getmaubutton = driver.findElement(btndangnhap).getCssValue("background-color");
        System.out.println(getmaubutton);

        driver.findElement(btndangnhap).click();
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class = 'fhs-input-group'])[3]//following-sibling::div")).getText(),"Thông tin này không thể để trống");
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class = 'fhs-input-group'])[4]//following-sibling::div")).getText(),"Thông tin này không thể để trống");

    }
}
