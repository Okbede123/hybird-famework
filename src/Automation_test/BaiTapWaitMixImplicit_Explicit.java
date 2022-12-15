package Automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class BaiTapWaitMixImplicit_Explicit {
    WebDriver driver;
    WebDriverWait webDriverWait;
    JavascriptExecutor getjs;
    KhoiTaoDriver khoiTaoDriver = new KhoiTaoDriver();

    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();

    }

    @Test
    public void TC_01_Element_Found(){
        driver.get("https://www.facebook.com/");

        By Email = By.cssSelector("input#email");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("start implicity " + getTimeNow());
        driver.findElement(Email).isDisplayed();
        System.out.println("end implicity " + getTimeNow());
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        System.out.println("start explicity " + getTimeNow());
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(Email));
        System.out.println("end explicity " + getTimeNow());
    }

    //@Test
    public void TC_02_Element_Not_Found_Only_Implicit(){
        driver.get("https://www.facebook.com/");

        By Email = By.cssSelector("input#emailsad");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("start implicity " + getTimeNow());
        try {
            driver.findElement(Email).isDisplayed();
        }
        catch (Exception c){

        }

        System.out.println("end implicity " + getTimeNow());
    }

    @Test
    public void TC_03_Element_Not_Found_Only_Explicit(){
        driver.get("https://www.facebook.com/");

        By Email = By.cssSelector("input#emailsad");
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("start implicity " + getTimeNow());

        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(Email));
        }
        catch (Exception c){

        }

        System.out.println("end implicity " + getTimeNow());
    }

    @Test
    public void TC_04_Element_Not_Found_Expli_Impli(){
        driver.get("https://www.facebook.com/");

        By Email = By.cssSelector("input#emailsad");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("start implicity " + getTimeNow());


        //1 implicit < Explicit

        try {
            driver.findElement(Email).isDisplayed();
        }catch (Exception exception){

        }
        System.out.println("end implicity " + getTimeNow());


        System.out.println("start expplicity " + getTimeNow());
        try {
            //impiclity sẽ ảnh hưởng đến wait, vì hàm visibilityOfElementLocated có findelement
            //mà findelement ảnh hưởng bởi implicity. cho nên ban đầu nó sẽ chạy implicty trước
            //chạy đc 0.5 giay thì expplicity bắt dầu chạy
            //trong ví dụ này khi set implicity = 5 và wait = 10
            //impli chạy đc 0.5 giây khi đến giây thứ 5 là xong còn lúc đó wait đang ở giây 4.5
            //thằng impli hết timeout trc
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(Email));
        }catch (Exception e){

        }
        System.out.println("end expplicity " + getTimeNow());




        //2 implicit  = Explicit
        //3 implicit > Explicit

    }


    @Test
    public void TC_05_Element_Not_Found_Expli_Impli(){
        driver.get("https://www.facebook.com/");

        By Email = By.cssSelector("input#emailsad");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        System.out.println("start implicity " + getTimeNow());
//
//
//        //1 implicit = Explicit
//
//        try {
//            driver.findElement(Email).isDisplayed();
//        }catch (Exception exception){
//
//        }
//        System.out.println("end implicity " + getTimeNow());


        System.out.println("start expplicity " + getTimeNow());
        try {
            //impiclity sẽ ảnh hưởng đến wait, vì hàm visibilityOfElementLocated có findelement
            //mà findelement ảnh hưởng bởi implicity. cho nên ban đầu nó sẽ chạy implicty trước
            //chạy đc 0.5 giay thì expplicity bắt dầu chạy
            //trong ví dụ này khi set implicity = 10 và wait = 10
            //impli chạy đc 0.5 giây khi đến giây thứ 10 là xong còn lúc đó wait đang ở giây 9.5 hoặc sấp sỉ 10
            //thằng impli hết timeout trc
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(Email));
        }catch (Exception e){

        }
        System.out.println("end expplicity " + getTimeNow());

        //3 implicit > Explicit

    }

    @Test
    public void TC_06_Element_Not_Found_Expli_Impli(){
        driver.get("https://www.facebook.com/");

        By Email = By.cssSelector("input#emailsad");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        System.out.println("start implicity " + getTimeNow());
//
//
//        //1 implicit = Explicit
//
//        try {
//            driver.findElement(Email).isDisplayed();
//        }catch (Exception exception){
//
//        }
//        System.out.println("end implicity " + getTimeNow());

        //implicit > Explicit
        System.out.println("start expplicity " + getTimeNow());
        try {
            //impiclity sẽ ảnh hưởng đến wait, vì hàm visibilityOfElementLocated có findelement
            //mà findelement ảnh hưởng bởi implicity. cho nên ban đầu nó sẽ chạy implicty trước
            //chạy đc 0.5 giay thì expplicity bắt dầu chạy
            //trong ví dụ này khi set implicity = 10 và wait = 10
            //impli chạy đc 0.5 giây khi đến giây thứ 10 là xong còn lúc đó wait đang ở giây 9.5 hoặc sấp sỉ 10
            //thằng impli hết timeout trc
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(Email));
        }catch (Exception e){

        }
        System.out.println("end expplicity " + getTimeNow());


    }

    public void TC_07_Expliciti_Webelement(){

        driver.get("https://www.facebook.com/");

        WebElement emailID = driver.findElement(By.xpath("okbede"));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        System.out.println("start expplicity " + getTimeNow());
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(emailID));
        }catch (Exception exception){

        }
        System.out.println("end expplicity " + getTimeNow());

    }

    public String getTimeNow(){
        Date date = new Date();
        return date.toString();
    }
}
