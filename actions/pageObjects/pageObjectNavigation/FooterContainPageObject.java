package src2.actions.pageObjects.pageObjectNavigation;

import org.openqa.selenium.WebDriver;
import src2.actions.pageObjects.*;
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

    public MyAccountPageObject getMyAccountLogged(){
        waitElementVisibility(driver,FooterContainerPageUI.MY_ACCOUNT_LOCATOR);
        clickToElementByXpath(driver,FooterContainerPageUI.MY_ACCOUNT_LOCATOR);
        return PageGeneratorManager.getMyAccount(driver);
    }

    public UserLoginPageObject getMyAccountNotLogged(){
        waitElementVisibility(driver,FooterContainerPageUI.MY_ACCOUNT_LOCATOR);
        clickToElementByXpath(driver,FooterContainerPageUI.MY_ACCOUNT_LOCATOR);
        return PageGeneratorManager.getLoginPageUser(driver);
    }

    public SearchTermPageObject getSearhTerms(){
        waitElementVisibility(driver,FooterContainerPageUI.SEARCH_TERMS_LOCATOR);
        clickToElementByXpath(driver,FooterContainerPageUI.SEARCH_TERMS_LOCATOR);
        return PageGeneratorManager.getSearchTerm(driver);
    }

}
