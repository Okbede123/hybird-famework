package src2.cores.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import src2.actions.pageObjects.UserHomePageObject;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;

   protected final Log log;
    public BaseTest(){
        log = LogFactory.getLog(getClass());
    }



    public WebDriver multipleBrowser( String browser){

        switch (browser){
            case "chrome":{
                driver = new ChromeDriver();
                break;
            }
            case "firefox":{
                driver = new FirefoxDriver();
                break;
            }
            case "edge":{
                driver = new EdgeDriver();
                break;
            }
        }
        driver.get("http://live.techpanda.org/index.php/");
        return driver;


    }

    public WebDriver multipleBrowserEnum(String browser){
        if(BrowserList.valueOf(browser.toUpperCase()) == BrowserList.FIREFOX){
            driver = new FirefoxDriver();
        } else if (BrowserList.valueOf(browser.toUpperCase())==BrowserList.EDGE) {
            driver = new EdgeDriver();
        } else if (BrowserList.valueOf(browser.toUpperCase())== BrowserList.CHROME) {
            driver = new ChromeDriver();
        }
        driver.get(GlobalConstants.USER_URL);
        return driver;
    }

    public WebDriver multipleBrowserEnum_SwitchCase(String browser){
        switch (BrowserList.valueOf(browser.toUpperCase())){
            case FIREFOX:
            {
                driver = new FirefoxDriver();
                break;
            }
            case CHROME:{
                driver = new ChromeDriver();
                break;
            }
            case EDGE:{
                driver = new EdgeDriver();
                break;
            }
        }
        driver.get("http://live.techpanda.org/index.php/");
        return driver;
    }
    public WebDriver multipleBrowserEnum_SwitchCase_DriverManager(String browser, String url){
        switch (BrowserList.valueOf(browser.toUpperCase())){
            case FIREFOX:
            {
                driver = WebDriverManager.firefoxdriver().create();
                break;
            }
            case CHROME:{
                driver = WebDriverManager.chromedriver().create();
                break;
            }
            case EDGE:{
                driver = WebDriverManager.edgedriver().create();
                break;
            }
        }
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }


    public WebDriver multipleBrowserEnum_SwitchCase_DriverManager(String browser){
        switch (BrowserList.valueOf(browser.toUpperCase())){
            case FIREFOX:
            {
                driver = WebDriverManager.firefoxdriver().create();
                break;
            }
            case CHROME:{
                driver = WebDriverManager.chromedriver().create();
                break;
            }
            case EDGE:{
                driver = WebDriverManager.edgedriver().create();
                break;
            }
        }
        //getHomePage(driver);
        driver.get("http://live.techpanda.org/index.php/");
        return driver;
    }

    public UserHomePageObject getHomePage(WebDriver driver){
        return new UserHomePageObject(driver);
    }

    protected int getrandomNumber() {
        Random rand = new Random();
        return rand.nextInt(999999);
    }

    protected void SleepinTime(int time){
        try {
            Thread.sleep(time*4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean assertTrue(boolean actual){
        boolean status = true;
        try {
            Assert.assertTrue(actual);
        }catch (Throwable e){
            status = false;
            System.out.println(e);
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    public boolean assertEqual(Object actual,Object expected){
        boolean check = true;
        try {
            Assert.assertEquals(actual,expected);
        }catch (Throwable e){
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
            check = false;
        }
        return check;
    }

    public boolean assertFalse(boolean actual){
        boolean status;
        try {
            Assert.assertFalse(actual);
            status = false;
        }catch (Throwable e){
            status = true;
            System.out.println(e);
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }


    public WebDriver getDriver(){
        return this.driver;
    }


    @BeforeSuite
    public void beforeSuite(){
        deleteFilesInReportNGFolder();
    }

    private void deleteFilesInReportNGFolder(){
        try {
            File file = new File(GlobalConstants.REPORTNG_PATH);
            //lấy ra tất cả list files
            File[] listOfFiles = file.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                //nếu cái nào la file thì xóa
                if(listOfFiles[i].isFile())
                    new File(listOfFiles[i].toString()).delete();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

//    protected WebDriver getDriverInstance() {
//
//    }
}
