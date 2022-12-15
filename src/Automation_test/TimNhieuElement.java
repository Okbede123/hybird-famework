import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TimNhieuElement {


    public static void main(String[] args) {

        WebDriver driver;

        String chomre = "webdrive.chrome.driver";
        String tesThu = System.getProperty("user.dir");
        System.setProperty(chomre,tesThu + "\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
        WebElement element = driver.findElement(By.cssSelector("p.required"));
        System.out.println(element.getTagName());
        //String traVe = element.getAttribute("placeholder");
        //Assert.assertEquals(traVe,"Search entire store here...");
        //List<WebElement> luutru = driver.findElements(By.xpath("//a[@title = '\"Hoàng tử nhạc Pop\" Aaron Carter qua đời ở tuổi 34, dòng chia sẻ cuối cùng gây chấn động']"));

    }
}
