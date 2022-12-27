package src2.actions.pageObjects;

import org.openqa.selenium.WebDriver;
import src2.actions.pageObjects.pageObjectNavigation.SideBarAccountPageObject;

public class MyProductReviewPageObject extends SideBarAccountPageObject {
    WebDriver driver;

    public MyProductReviewPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }



}
