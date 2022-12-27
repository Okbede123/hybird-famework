package src2.actions.pageObjects;

import org.openqa.selenium.WebDriver;
import src2.actions.pageObjects.pageObjectNavigation.FooterContainPageObject;

public class AboutUsPageObject extends FooterContainPageObject {
    WebDriver driver;

    public AboutUsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }
}
