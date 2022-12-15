package Automation_test;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class BaiTapFluentWait_5 {
    WebDriver driver;
    //khoi tao fluent wait dau vao WebElement
    FluentWait<WebElement> fluentWait;

    //khoi tao fluent wait dau vao webdriver
    FluentWait<WebDriver> fluentWaitdriver;
    WebDriverWait webDriverWait;
    JavascriptExecutor getjava;
    KhoiTaoDriver khoiTaoDriver = new KhoiTaoDriver();
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //@Test
    public void TC_01_FluentWait(){

        driver.get("gettexttest");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div")));
        WebElement test = driver.findElement(By.xpath("//div"));
        //set dau vao la webelement
        fluentWait = new FluentWait<WebElement>(test);
        //set timeout
        fluentWait.withTimeout(Duration.ofSeconds(15));
        //set time moi lan tìm lại
        fluentWait.pollingEvery(Duration.ofMillis(100));
        //nếu ko tìm thấy bỏ qua lỗi này. cái này phải set nếu ko fail
        fluentWait.ignoring(NoSuchElementException.class);

        //set until để tìm và Boolean là kiểu trả ve, se luu lại o fluentWait
       fluentWait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement webElement) {

                return webElement.getText().startsWith("00");
            }
        });
    }
    @Test
    public void TC_02(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        fluentWaitdriver = new FluentWait<WebDriver>(driver);
        driver.findElement(By.xpath("//button")).click();

        fluentWaitdriver.withTimeout(Duration.ofSeconds(10));
        fluentWaitdriver.pollingEvery(Duration.ofMillis(100));
        fluentWaitdriver.ignoring(NoSuchElementException.class);
        fluentWaitdriver.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {

                boolean test2 = driver.findElement(By.xpath("//h4")).isDisplayed();
                return test2;
            }
        });

    }
    @Test
    public void TC_03(){

        driver.get("https://automationfc.github.io/dynamic-loading/");
        getElement(By.xpath("//button"));
        ClickElement(By.xpath("//button"));
       // test(driver.findElement(By.xpath("//button")));
        CheckDisplay(By.xpath("//h4"));
    }

    //viet ham`
    public WebElement getElement(By element){
        //kieu nhan vao driver
        FluentWait<WebDriver> get = new FluentWait<>(driver);
        //set timeout
        get.withTimeout(Duration.ofSeconds(10));
        //set time moi lan tim lai
        get.pollingEvery(Duration.ofMillis(100));
        //set bo qua loi nosuch element
        get.ignoring(NoSuchElementException.class);
        //tao ra 1 cai webelement luu
        WebElement luu;
        //khi element dc tra ve no se lưu vao biến luu
        luu =  get.until(new Function<WebDriver, WebElement>() {
            @Override
            //tham số là webdriver
            public WebElement apply(WebDriver webDriver) {
                //trả về dạng element
                WebElement trave = driver.findElement(element);
                return trave;
            }
        });
        //trả về luu
        return luu;
    }

    public void ClickElement(By element){
        //set đầu vo webdriver
        FluentWait<WebDriver> gett = new FluentWait<>(driver);
        gett.withTimeout(Duration.ofSeconds(10));
        gett.pollingEvery(Duration.ofMillis(100));
        gett.ignoring(NoSuchElementException.class);
        //luu cái element vua đc trả về vào click
       WebElement click = gett.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(element);
            }
        });
       //thực hiện click
       click.click();
    }

    public boolean CheckDisplay(By element){
        //set đầu vào webdriver
        FluentWait<WebDriver> getdisplay = new FluentWait<>(driver);
        getdisplay.withTimeout(Duration.ofSeconds(10));
        getdisplay.pollingEvery(Duration.ofMillis(100));
        getdisplay.ignoring(NoSuchElementException.class);
        //tạo 1 cái b
       boolean check = getdisplay.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                boolean check = driver.findElement(element).isDisplayed();
                return check;
            }
        });
       return check;
    }
    public WebElement test(WebElement element){

        //hầu nhưu là hay dùng dầu vào driver
        FluentWait<WebElement> test = new FluentWait<>(element);
        test.withTimeout(Duration.ofSeconds(10));
        test.pollingEvery(Duration.ofMillis(100));
        test.ignoring(NoSuchElementException.class);
        WebElement test11;
        test11 = test.until(new Function<WebElement, WebElement>() {
            @Override
            public WebElement apply(WebElement element) {
                return element;
            }
        });
        return test11;
    }

    //hàm chờ wait element
    public WebElement waitelement(By element){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(100));
        wait.ignoring(NoSuchElementException.class);
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return result;
    }
}
