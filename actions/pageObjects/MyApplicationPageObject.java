package src2.actions.pageObjects;

import org.openqa.selenium.WebDriver;
import src2.actions.pageObjects.pageObjectNavigation.SideBarAccountPageObject;

public class MyApplicationPageObject extends SideBarAccountPageObject {
    WebDriver driver;
    public MyApplicationPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
