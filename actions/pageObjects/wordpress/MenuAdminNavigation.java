package src2.actions.pageObjects.wordpress;

import org.openqa.selenium.WebDriver;
import src2.cores.commons.BasePage;
import src2.interrface.UI.wordpress.MenuAdminNaviPageUI;

public class MenuAdminNavigation extends BasePage {

    WebDriver driver;

    public MenuAdminNavigation openMenuAdminNavigation(){
        return new MenuAdminNavigation(driver);
    }

    public MenuAdminNavigation(WebDriver driver){
        this.driver = driver;
    }

    public ConfigUserPageObject openConfigUser(){
        clickToElements(driver, MenuAdminNaviPageUI.GO_TO_MENU_CONFIG,"Users");
        return PageGeneralManager.goToConfigPage(driver);
    }

}
