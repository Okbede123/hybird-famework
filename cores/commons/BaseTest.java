package src2.cores.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import src2.actions.pageObjects.UserHomePageObject;

import java.io.File;
import java.io.IOException;
import java.util.List;
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

    public WebDriver multipleBrowserEnum_SwitchCase_DemoSortData(String browser,String url){
        switch (BrowserList.valueOf(browser.toUpperCase())){
            case FIREFOX:
            {
                FirefoxProfile ffProfile = new FirefoxProfile();
                File firefoxTranslateFile = new File(GlobalConstants.BROWSER_EXTENTSION_PATH + "firefox_to_google_translate-4.2.0.xpi");
                ffProfile.addExtension(firefoxTranslateFile);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(ffProfile);
                //firefoxOptions.addPreference("intl.accept_languages","vi-vn,vi,en-us,en");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
            case FIREFOX_HEADLESS:
            {
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(true);
                driver = new FirefoxDriver(options);
                break;
            }
            case CHROME:{
//                File file = new File(GlobalConstants.BROWSER_EXTENTSION_PATH + "chrome_extension_2_0_12_0.crx");
//                ChromeOptions chromeOptions =new ChromeOptions();
//                chromeOptions.addExtensions(file);
//                chromeOptions.addArguments("--lang=en");
                driver = new ChromeDriver();
                break;
            }
            case CHROME_HEADLESS:{
                ChromeOptions chromeOptions_Headless = new ChromeOptions();
                chromeOptions_Headless.setHeadless(true);
                driver = new ChromeDriver(chromeOptions_Headless);
                break;
            }
            case EDGE:{
                driver = new EdgeDriver();
                break;
            }
        }
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver multipleBrowserEnum_SwitchCase(String browser){
        switch (BrowserList.valueOf(browser.toUpperCase())){
            case FIREFOX:
            {
                FirefoxProfile ffProfile = new FirefoxProfile();
                File firefoxTranslateFile = new File(GlobalConstants.BROWSER_EXTENTSION_PATH + "firefox_to_google_translate-4.2.0.xpi");
                ffProfile.addExtension(firefoxTranslateFile);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(ffProfile);
                //firefoxOptions.addPreference("intl.accept_languages","vi-vn,vi,en-us,en");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
            case FIREFOX_HEADLESS:
            {
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(true);
                driver = new FirefoxDriver(options);
                break;
            }
            case CHROME:{
//                File file = new File(GlobalConstants.BROWSER_EXTENTSION_PATH + "chrome_extension_2_0_12_0.crx");
//                ChromeOptions chromeOptions =new ChromeOptions();
////                chromeOptions.addExtensions(file);
////                chromeOptions.addArguments("--lang=en");
//                chromeOptions.addArguments("--user-data-dir=C:\\Users\\Admin\\AppData\\Local\\Google\\Chrome\\User Data\\");
//                chromeOptions.addArguments("--profile-directory=Profile 1");
                driver = new ChromeDriver();
                break;
            }
            case CHROME_HEADLESS:{
                ChromeOptions chromeOptions_Headless = new ChromeOptions();
                chromeOptions_Headless.setHeadless(true);
                driver = new ChromeDriver(chromeOptions_Headless);
                break;
            }
            case EDGE:{
                driver = new EdgeDriver();
                break;
            }
        }
        driver.manage().window().maximize();
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

    public void showBrowserConsoleLog(WebDriver driver){
        if(driver.toString().contains("chrome")){
            LogEntries logs = driver.manage().logs().get("browser");
            List<LogEntry> logList = logs.getAll();
            for (LogEntry logging: logList) {
                if(logging.getLevel().toString().contains("error")){
                    log.info("--------" + logging.getLevel().toString()+ "---------\n" + logging.getMessage());
                }
            }
        }
    }

    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = GlobalConstants.OS_NAME;
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("Windows")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
