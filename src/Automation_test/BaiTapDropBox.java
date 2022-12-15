import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class BaiTapDropBox {
    WebDriver driver;
    Select chon;
    @BeforeClass
    public void beforeClass(){
        String chomre = "webdrive.chrome.driver";
        String tesThu = System.getProperty("user.dir");
        System.setProperty(chomre,tesThu + "\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rode.com/en/support/where-to-buy");
        //test

    }
    @Test
    public void selectCountry(){

        chon = new Select(driver.findElement(By.cssSelector("select[id = 'country']")));
        //ví dụ về tìm nhiều element
//        List<WebElement> layCountry = driver.findElements(By.xpath("//select[@name = 'country']//following-sibling::option"));
//        for(WebElement testthunhe : layCountry){
//            System.out.println(testthunhe.getText());
//        }
        chon.selectByVisibleText("Vietnam");
        String chonRa = chon.getFirstSelectedOption().getText();
        System.out.println(chonRa);
        //driver.findElement(By.xpath("//div//button[@class = 'btn btn-default']")).click();
        //lấy ra các kêt quả
        List<WebElement> testThu = driver.findElements(By.xpath("//div[@class = 'p-1']//h4"));
        for(WebElement testthunhe2 : testThu){
            System.out.println(testthunhe2.getText());
        }

    }
}
