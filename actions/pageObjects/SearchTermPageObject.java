package src2.actions.pageObjects;

import org.openqa.selenium.WebDriver;
import src2.actions.pageObjects.pageObjectNavigation.FooterContainPageObject;

public class SearchTermPageObject extends FooterContainPageObject {

    WebDriver driver;

    public SearchTermPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

}
