import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class baiTapAutoTopic6 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        String chomre = "webdrive.chrome.driver";
        String tesThu = System.getProperty("user.dir");
        System.setProperty(chomre,tesThu + "\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void baiTapMot(){
        String dien = "Automation Testing";

        driver.get("https://automationfc.github.io/basic-form/index.html");
       WebElement findEmail = driver.findElement(By.cssSelector("input[name = user_email]"));
        WebElement findEdu = driver.findElement(By.cssSelector("textarea#edu"));
        WebElement findBox = driver.findElement(By.cssSelector("input#under_18"));
        WebElement findName = driver.findElement(By.xpath("//div[@class = 'figcaption']//h5[text() = 'Name: User5']"));
        if(findEmail.isDisplayed() && findEdu.isDisplayed()){
            System.out.println("Co hien thi 2 element nay");
            findEmail.sendKeys(dien);
            findEdu.sendKeys(dien);
        }
        if(findBox.isDisplayed()){
            System.out.println("Co hien thi element nay under 18");
            findBox.click();
        }

        if(!findName.isDisplayed()){
            System.out.println("khong hien thi elenment user name");
        }

        Assert.assertTrue(driver.findElement(By.cssSelector("input#number")).isDisplayed());

    }
}
