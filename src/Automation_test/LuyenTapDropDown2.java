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

public class LuyenTapDropDown2 {
    WebDriver driver;
    WebDriverWait loadingelement;
    KhoiTaoDriver khoitao = new KhoiTaoDriver();

    @BeforeClass
    public void BeforeClass(){
        System.setProperty(khoitao.khoiTaoChomre,khoitao.getProperty + khoitao.source);
        driver = new ChromeDriver();
        loadingelement = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void GetUrl(){

        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        //tạo hòm getfriend, không cần viết từng dòng 1 nếu sau này dùng lại
        GetFriend("//div[@role ='listbox']","//div[@role = 'listbox']//div[@role = 'option']","Jenny Hess");
        //kiểm tra xem cái mình vừa click chọn có đúng với cái mong muốn hay ko
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'divider text']")).getText(),"Jenny Hess");

        GetFriend("//div[@role ='listbox']","//div[@role = 'listbox']//div[@role = 'option']","Matt");
        //kiểm tra xem cái mình vừa click chọn có đúng với cái mong muốn hay ko
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'divider text']")).getText(),"Matt");
        GetFriend("//div[@role ='listbox']","//div[@role = 'listbox']//div[@role = 'option']","Christian");
        //div[@role ='listbox']

        //div[@role = 'listbox']//div[@role = 'option']
    }

    public void GetFriend(String clicklist, String getlist, String searchfriend){

        // tìm đoạn element dropdown
        driver.findElement(By.xpath(clicklist)).click();
        // load chờ ra hết item trong 5 giây
        loadingelement.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(getlist)));
        // lấy ra hết các item bên trong cho vào thằng List listfriend
        List<WebElement> listfriend = driver.findElements(By.xpath(getlist));
        //tạo vòng lặp quét tất cả danh sách bạn
        for (WebElement get: listfriend) {
            // in ra thằng bạn
            //System.out.println(get.getText());
            // nếu  tìm ra thằng bạn searchfriend thì in ra và click vào
            if(get.getText().equals(searchfriend)){
                System.out.println("your friend you choice is " + get.getText());
                // click vào thằng bạn đó
                get.click();

            }
        }
    }
}
