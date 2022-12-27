package src2.actions.pageObjects.JqueryPageObject;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagerJquery {

    public static HomePageObjectJquery getHomePageJquery(WebDriver driver){
        return new HomePageObjectJquery(driver);
    }
}
