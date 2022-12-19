package src2.cores.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        return driver;
    }
}
