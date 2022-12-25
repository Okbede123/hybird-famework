package src2.cores.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import src2.actions.pageObjects.UserHomePageObject;

import java.util.Random;

public class BaseTest {

    WebDriver driver;



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
        //getHomePage(driver);
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
}
