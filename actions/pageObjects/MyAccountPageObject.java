package src2.actions.pageObjects;

import org.openqa.selenium.WebDriver;
import src2.actions.pageObjects.pageObjectNavigation.FooterContainPageObject;

public class MyAccountPageObject extends FooterContainPageObject {

    WebDriver driver;

    public MyAccountPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

}
