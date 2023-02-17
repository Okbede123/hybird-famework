package src2.actions.pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

public class MyDashBoardPageObject extends MenuAdminNavigation {
    WebDriver driver;

    public MyDashBoardPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

}
