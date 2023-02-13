package src2.actions.pageObjects.SortLab;

import org.openqa.selenium.WebDriver;

public class PageGeneralManager {

    public static LoginPageObject openLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static InventoryPageObject openInventoryPage(WebDriver driver){
        return new InventoryPageObject(driver);
    }
}
