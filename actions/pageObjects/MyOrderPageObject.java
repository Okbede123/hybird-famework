package src2.actions.pageObjects;

import org.openqa.selenium.WebDriver;
import src2.actions.pageObjects.pageObjectNavigation.SideBarAccountPageObject;

public class MyOrderPageObject extends SideBarAccountPageObject {
    WebDriver driver;


    public MyOrderPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
