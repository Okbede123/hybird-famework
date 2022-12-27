package src2.actions.pageObjects.pageObjectNavigation;

import org.openqa.selenium.WebDriver;
import src2.actions.pageObjects.AboutUsPageObject;
import src2.actions.pageObjects.MyAccountPageObject;
import src2.actions.pageObjects.PageGeneratorManager;
import src2.actions.pageObjects.SearchTermPageObject;
import src2.cores.commons.BasePage;
import src2.interrface.UI.FooterContainerPageUI;

public class FooterContainPageObject extends BasePage {

    WebDriver driver;

    public FooterContainPageObject(WebDriver driver){
        this.driver = driver;
    }

    public AboutUsPageObject getAboutUs(){
        waitElementVisibility(driver, FooterContainerPageUI.ABOUT_US_LOCATOR);
        clickToElementByXpath(driver,FooterContainerPageUI.ABOUT_US_LOCATOR);
        return PageGeneratorManager.getAboutUs(driver);
    }

    public MyAccountPageObject getMyAccount(){
        waitElementVisibility(driver,FooterContainerPageUI.MY_ACCOUNT_LOCATOR);
        clickToElementByXpath(driver,FooterContainerPageUI.MY_ACCOUNT_LOCATOR);
        return PageGeneratorManager.getMyAccount(driver);
    }

    public SearchTermPageObject getSearhTerms(){
        waitElementVisibility(driver,FooterContainerPageUI.SEARCH_TERMS_LOCATOR);
        clickToElementByXpath(driver,FooterContainerPageUI.SEARCH_TERMS_LOCATOR);
        return PageGeneratorManager.getSearchTerm(driver);
    }

}
