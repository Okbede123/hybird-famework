package Automation_test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaiTapHandlePopup {
    WebDriver driver;
    WebDriverWait waitelement;
    JavascriptExecutor getjava;
    KhoiTaoDriver khoitao = new KhoiTaoDriver();

    @BeforeClass
    public void BeforeClass(){
        System.setProperty(khoitao.khoiTaoChomre,khoitao.getProperty+khoitao.source);
        driver = new ChromeDriver();
        waitelement = new WebDriverWait(driver, Duration.ofSeconds(30));
        getjava = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    //@Test
    public void TC_01_Fix_Popup(){
        driver.get("https://ngoaingu24h.vn/");
        // dùng biến By sẽ cập nhập trạng thái của element liên tục, trong trường hợp cần verifly
        By LoginPopup = By.xpath("(//div[@id = 'modal-login-v1'])[1]");
        // nếu dùng Webelement sẽ lưu cái biến đó tại thời điểm đó và khi lôi nó ra để verifly hiển thị nó sẽ lấy cái biến tại thời điểm đó và ko verify đc
        //WebElement LoginPopup = driver.findElement(By.xpath("(//div[@id = 'modal-login-v1'])[1]"));
        Assert.assertFalse(driver.findElement(LoginPopup).isDisplayed());
        //Assert.assertFalse(LoginPopup.isDisplayed());
        driver.findElement(By.xpath("(//div[@id = 'button-login-dialog']/button)[1]")).click();
        khoitao.SleepInTime(2);
        Assert.assertTrue(driver.findElement(LoginPopup).isDisplayed());
        //Assert.assertFalse(LoginPopup.isDisplayed());
        driver.findElement(By.xpath("(//div//i[@class = 'fal fa-user-circle']//following-sibling::input[@placeholder = 'Tài khoản đăng nhập (*)'])[1]")).sendKeys("okbede");
        driver.findElement(By.xpath("(//div[@class = 'input']//input[@placeholder = 'Mật khẩu (*)'])[1]")).sendKeys("123123");
        driver.findElement(By.xpath("(//button[@data-text = 'Đăng nhập'])[1]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'row error-login-panel' and text() = 'Tài khoản không tồn tại!']")).getText(),"Tài khoản không tồn tại!");


    }

    //@Test
    public void TC_02_Fix_Popup(){
        driver.get("https://tiki.vn/");

        driver.findElement(By.xpath("//span[@class = 'Userstyle__ItemText-sc-6e6am-3 kYZPng']/span[contains(text(),'Đăng Nhập / Đăng Ký')]")).click();
        driver.findElement(By.xpath("//p[@class = 'login-with-email']"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'styles__StyledLoginWithPhone-sc-si1ros-0 jdahxv']")).isDisplayed());


    }

    //@Test
    public void TC_03_Fix_Popup(){
        driver.get("https://bizbooks.vn/");

        By findsignin = By.xpath("//div[@id = 'md-signin']");
        //check popup ko hiển thị
        Assert.assertFalse(driver.findElement(findsignin).isDisplayed());
        //click đăng nhập
        driver.findElement(By.xpath("//a//span[text() = 'ĐĂNG NHẬP']")).click();
        driver.findElement(By.xpath("//a[contains(@class,'h-dropdown__toggle js-header-dropdown')]//following-sibling::div//a[text() = 'Đăng nhập']")).click();
        khoitao.SleepInTime(2);
        //kiểm tra có hiển thị
        Assert.assertTrue(driver.findElement(findsignin).isDisplayed());
        //ấn thoát khỏi popup
        driver.findElement(By.xpath("//a[contains(@class,'h-dropdown__toggle js-header-dropdown')]//following-sibling::div//a[text() = 'Đăng nhập']")).sendKeys(Keys.ESCAPE);
        // kiểm tra popup ko hiển thị
        khoitao.SleepInTime(2);
        Assert.assertFalse(driver.findElement(findsignin).isDisplayed());

    }
    @Test
    public void TC_04_Fix_Popup(){
        driver.get("https://jtexpress.vn/vi");

        By getpopup = By.xpath("//div[@class = 'flex flex-col lg:flex-row items-center']");

        waitelement.until(ExpectedConditions.visibilityOfElementLocated(getpopup));
        Assert.assertTrue(driver.findElement(getpopup).isDisplayed());
        driver.findElement(By.xpath("//div[@class = 'w-auto mx-auto relative ']/button")).click();
        khoitao.SleepInTime(2);
        Assert.assertFalse(driver.findElement(getpopup).isDisplayed());
        //driver.findElement(By.xpath("//div[@class = 'w-auto mx-auto relative ']/button")).click();

    }

    //@Test
    public void TC_05_Fix_Popup(){
        driver.get("https://www.javacodegeeks.com/");
        By getpopup = By.xpath("//div[contains(@class, 'lepopup-popup-overlay')]");
        //waitelement.until(ExpectedConditions.visibilityOfElementLocated(getpopup));
        //khoitao.SleepInTime(6);
        Assert.assertTrue(driver.findElement(getpopup).isDisplayed());

        driver.findElement(By.xpath("//div[@class = 'lepopup-element-html-content']/a[text()='×']")).click();
       // waitelement.until(ExpectedConditions.visibilityOfElementLocated(getpopup));
        khoitao.SleepInTime(2);
        Assert.assertFalse(driver.findElement(getpopup).isDisplayed());


    }

    //@Test
    public void TC_06_Fix_Popup(){
        //vỏ sò ko làm đc theo cách này
        driver.get("https://voso.vn/#");
        By getpopup = By.xpath("//body[contains(@class,'v3-page-body body-home-page ng-scope')]");
        Assert.assertFalse(driver.findElement(getpopup).isDisplayed());
        driver.findElement(By.xpath("//div[@class = 'action-item-name d-flex align-items-center']/a[contains(text(), 'Đăng ký')]")).click();
        khoitao.SleepInTime(2);
        Assert.assertTrue(driver.findElement(getpopup).isDisplayed());


    }

    //@Test
    public void TC_07_Fix_Popup(){
        driver.get("https://www.zingpoll.com/about");
        By getpopup = By.xpath("//div[@id= 'Login']");
        Assert.assertFalse(driver.findElement(getpopup).isDisplayed());
        driver.findElement(By.xpath("//li/a[@id = 'Loginform']")).click();
        khoitao.SleepInTime(2);
        Assert.assertTrue(driver.findElement(getpopup).isDisplayed());
    }

    //@Test
    public void TC_08_Fix_Popup(){
        driver.get("https://skills.kynaenglish.vn/");
        By getpopup = By.xpath("//div[@id = 'k-popup-account-login']");
        Assert.assertFalse(driver.findElement(getpopup).isDisplayed());
        driver.findElement(By.xpath("//a[@class = 'login-btn']")).click();
        //khoitao.SleepInTime(2);
        //chờ cho nó hiển thị r verify
        waitelement.until(ExpectedConditions.visibilityOfElementLocated(getpopup));
        Assert.assertTrue(driver.findElement(getpopup).isDisplayed());
    }

    //@Test
    public void TC_02_Random_Popup_Indom(){
        driver.get("https://www.javacodegeeks.com/");
        By timpopup = By.xpath("//div[contains(@class, 'lepopup-popup-overlay')]");
        if(driver.findElement(timpopup).isDisplayed()){
        driver.findElement(By.xpath("//div[@class = 'lepopup-input']//input")).sendKeys("okbede123@gmail.com");
        driver.findElement(By.xpath("//a[@data-label = 'Get the Books']//span")).click();
        }
        else{
            driver.findElement(By.xpath("//button[@class = 'search-button']//following-sibling::input")).sendKeys("agile testing Explained");
            driver.findElement(By.xpath("//button[@class = 'search-button']")).click();
            Assert.assertEquals(driver.findElement(By.xpath("//h2[@class = 'post-title']//a[text() = 'Agile Testing Explained']")).getText(),"Agile Testing Explained");
        }

    }

    //@Test
    public void TC_03_Random_Popup_Indom(){
        driver.get("https://vnk.edu.vn/");
        By timpopup = By.xpath("//div[@class = 'thrv_wrapper tve_image_caption']");
        waitelement.until(ExpectedConditions.visibilityOfElementLocated(timpopup));
        if(driver.findElement(timpopup).isDisplayed()){
            khoitao.SleepInTime(3);
            driver.findElement(By.xpath("//div[@class = 'thrv_wrapper thrv_icon tcb-icon-display tve_evt_manager_listen tve_et_click tve_ea_thrive_leads_form_close tcb-local-vars-root']")).click();
//            driver.findElement(By.xpath("//a[@data-label = 'Get the Books']//span")).click();
       }
//        else{
//            driver.findElement(By.xpath("//a[@title = 'Khóa học ONLINE']")).click();
////            driver.findElement(By.xpath("//button[@class = 'search-button']")).click();
////            Assert.assertEquals(driver.findElement(By.xpath("//h2[@class = 'post-title']//a[text() = 'Agile Testing Explained']")).getText(),"Agile Testing Explained");
//        }

    }

    //@Test
    public void TC_04_Random_Popup_Indom(){
        driver.get("https://www.kmplayer.com/home");
        By timpopup = By.xpath("//div[@class = 'pop-container']");
        waitelement.until(ExpectedConditions.visibilityOfElementLocated(timpopup));
        if(driver.findElement(timpopup).isDisplayed()){
            getjava.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[@class = 'pop-conts']//map/area[@id = 'btn-r']")));
            //driver.findElement(By.xpath("//div[@class = 'pop-conts']//map/area[@id = 'btn-r']")).click();
        }
        khoitao.SleepInTime(3);
        Assert.assertFalse(driver.findElement(timpopup).isDisplayed());
//        else{
//            driver.findElement(By.xpath("//a[@title = 'Khóa học ONLINE']")).click();
////            driver.findElement(By.xpath("//button[@class = 'search-button']")).click();
////            Assert.assertEquals(driver.findElement(By.xpath("//h2[@class = 'post-title']//a[text() = 'Agile Testing Explained']")).getText(),"Agile Testing Explained");
//        }

    }

    //@Test
    public void TC_01_Random_Popup_NotIndom(){
        driver.get("https://dehieu.vn/");

        //cho delay lâu để tắt cái popup demo case ko hiển thị
        khoitao.SleepInTime(8);
       List <WebElement> timpopup = driver.findElements(By.xpath("//section[@id = 'popup']//following-sibling::div[@class = 'popup-content']"));

        System.out.println("element = " + timpopup.size());
       //trường hợp popup hiển thị, tức là size > 0
       if(timpopup.size() > 0){
           //click tắt no đi
           driver.findElement(By.cssSelector("div.popup-content button#close-popup")).click();
           System.out.println("đã tắt");
       }
       //trường hợp popup ko hiển thị
       else{
        driver.findElement(By.xpath("//a[@href = 'https://dehieu.vn/khoa-hoc/khoa-hoc-thiet-ke-he-thong-me-toa-nha-']")).click();
       }

    }

    //@Test
    public void TC_02_Random_Popup_NotIndom(){
        driver.get("https://tiki.vn/");

        //click bật popup
        driver.findElement(By.xpath("//span[@class = 'account-label']")).click();
        //test trường hợp ko bật element, tắt bằng tay
        khoitao.SleepInTime(5);
        //tạo ra cái list lưu popup
        List <WebElement> timpopup = driver.findElements(By.xpath("//div [@class = 'styles__Root-sc-2hr4xa-0 jyAQAr']"));

        //check nếu popup hiển thị
        if(timpopup.size() > 0){
            //sendkey và click tắt popup
            driver.findElement(By.xpath("//div[@class = 'input ']/input")).sendKeys("123123");
            driver.findElement(By.xpath("//button[@class = 'btn-close']")).click();
        }
        //chạy tiếp vào link này
        driver.findElement(By.xpath("//span//a[@href = 'https://tiki.vn/nha-cua-doi-song/c1883']/div")).click();
        //System.out.println("element = " + timpopup.size());

    }
    //@Test
    public void TC_03_Random_Popup_NotIndom(){
        driver.get("https://jtexpress.vn/vi");

        khoitao.SleepInTime(4);
        List<WebElement> timpoup = driver.findElements(By.xpath("//a[@target= '_blank']/img[@x-data-link = 'https://jtexpress.vn/vi/news-detail/ra-mat-tinh-nang-moi-chu-dong-thong-bao-trang-thai-don-hang-qua-tin-nhan-zalo-zns']"));
        if(timpoup.size() > 0){
            driver.findElement(By.xpath("//div[@class = 'w-auto mx-auto relative ']/button")).click();
        }
        driver.findElement(By.xpath("//button[@type = 'submit']//following-sibling::input")).sendKeys("okbede");

    }
    //@Test
    public void TC_04_Random_Popup_NotIndom(){
        driver.get("https://voso.vn/#");
        driver.findElement(By.xpath("//div[@class = 'action-item-name d-flex align-items-center']/a[contains(text(), 'Đăng ký')]")).click();
        khoitao.SleepInTime(4);
        List<WebElement> timpopup = driver.findElements(By.xpath("//div[@class = 'modal-body ng-scope']"));
        if(timpopup.size() > 0){
            driver.findElement(By.xpath("//span[@class = 'close-pc']/i")).click();
        }
        driver.findElement(By.xpath("//div[@class = 'search-box']/input")).sendKeys("okbede");




    }
}
