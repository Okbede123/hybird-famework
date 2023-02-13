package src2.cores.commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import src2.actions.pageObjects.PageGeneratorManager;
import src2.actions.pageObjects.UserHomePageObject;
import src2.actions.pageObjects.admin.AdminLoginPageObject;
import src2.actions.pageObjects.pageObjectNavigation.FooterContainPageObject;
import src2.interrface.UI.AdminUI.AdminBasePageUI;
import src2.interrface.UI.MyDashBoardUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


//các hàm thao tác vs browser
public class BasePage {

    /**
     * Open and page url
     * @param driver
     * @param url
     */
    public void openUrl(WebDriver driver,String url){
        driver.get(url);
    }

    /**
     * get string of url
     * @param driver
     * @return
     */
    public String getPageUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }

    /**
     * get title of page
     * @param driver
     * @return
     */
    public String getTitlePage(WebDriver driver){
        return driver.getTitle();
    }

    /**
     * get source page
     * @param driver
     * @return
     */
    public String getSourcePage(WebDriver driver){
        return driver.getPageSource();
    }

    /**
     * back page
     * @param driver
     */
    public void getBackPage(WebDriver driver){
        driver.navigate().back();
    }

    /**
     * forward to page
     * @param driver
     */
    public void forwardPage(WebDriver driver){
        driver.navigate().forward();
    }

    public void refeshPage(WebDriver driver){
        driver.navigate().refresh();
    }

    /**
     * accept alert
     * @param driver
     */

    public Alert waitAlertPresent(WebDriver driver){
        return new WebDriverWait(driver,Duration.ofSeconds(timeOut)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver){
        waitAlertPresent(driver).accept();
    }

    /**
     * cancel alert
     * @param driver
     */
    public void dismissAlert(WebDriver driver){
        waitAlertPresent(driver).dismiss();
    }

    public void sendKeyAlerts(WebDriver driver, String keys){
        waitAlertPresent(driver).sendKeys(keys);
    }

    public String getAlertText(WebDriver driver){
       return waitAlertPresent(driver).getText();
    }

    /**
     * swith window by url
     * @param driver
     * @param Url
     */
    public void switchWindowByUrl(WebDriver driver,String Url){
        Set<String> allWindowUrl = driver.getWindowHandles();
        for (String Urlofwindow:allWindowUrl) {
            driver.switchTo().window(Urlofwindow);
            String urlid = getPageUrl(driver);
            if(urlid.contains(Url)){
                break;
            }
        }
    }

    /**
     * switch window by id
     * @param driver
     */
    public void switchWindowByID(WebDriver driver){
        String Idpresent = driver.getWindowHandle();
        Set<String> allWindowID = driver.getWindowHandles();
        for (String IDwindow : allWindowID) {
            if(!IDwindow.equals(Idpresent)){
                driver.switchTo().window(IDwindow);
                break;
            }
        }
    }

    /**
     * close all tab without parentUrl
     * @param driver
     * @param parentUrl
     */
    public void closeAllWindowTabWithOutParentUrl(WebDriver driver,String parentUrl){
        Set<String> allWindowUrl = driver.getWindowHandles();
        for (String Urlofwindow:allWindowUrl) {
            if(!Urlofwindow.equals(parentUrl)){
                driver.switchTo().window(Urlofwindow).close();
            }
        }
        driver.switchTo().window(parentUrl);
    }

    //các hàm tương tác với element

    /**
     * click to element
     * @param driver
     * @param element
     */
    public void clickToElement(WebDriver driver, By element){
        searchElementBy(driver,element).click();
    }

    public void clickToElementByXpath(WebDriver driver, String element){
        waitElementclick(driver,element);
        searchElementByXpath(driver,element).click();
    }

    public void sendKeyToElement(WebDriver driver,By element,String valueInPut){

        WebElement element1 = searchElementBy(driver,element);
        element1.clear();
        element1.sendKeys(valueInPut);
    }

    public void sendKeyToElements(WebDriver driver,String element,String valueInPut,String... values){
        System.out.println(castRestParameter(element,values));
        WebElement element1 = searchElementByLocator(driver,castRestParameter(element,values));
        element1.clear();
        element1.sendKeys(valueInPut);
    }

    public void sendKeyToElementXpath(WebDriver driver,String element,String valueInPut){

        WebElement element1 = searchElementByXpath(driver,element);
        element1.clear();
        element1.sendKeys(valueInPut);
    }

    public String getElementText(WebDriver driver,By element){
        return searchElementBy(driver,element).getText();
    }

    public String getElementTextLocator(WebDriver driver,String element,String... locator){
        return searchElementByLocator(driver,castRestParameter(element,locator)).getText();
    }

    public String getElementTextByXpath(WebDriver driver,String element){
        return searchElementByXpath(driver,element).getText();
    }

    public WebElement searchElementBy(WebDriver driver, By element){
        return driver.findElement(element);
    }

    public WebElement searchElementByLocator(WebDriver driver, String element){
        return driver.findElement(getByLocator(element));
    }

    public void clickToElementByWebelement(WebDriver driver, WebElement element){
        searchElementByElement(driver,element).click();
    }


    public WebElement searchElementByElement(WebDriver driver, WebElement element){
        return element;
    }


    public WebElement searchElementByXpath(WebDriver driver, String xpath){
        return driver.findElement(getByXpath(xpath));
    }



    //nhận tham số đầu vào xpath,css,id.classname
    //quy ước của locator xpath =, id =, css =, name =
    public By getByXpath(String locator){
        return By.xpath(locator);
    }

    private By getByLocator(String locator){

     By locatorcut = null;

        if(locator.startsWith("ID=") || locator.startsWith("Id=") || locator.startsWith("iD=") || locator.startsWith("id=")){
            locatorcut = By.id(locator.substring(3));
        }
        else if(locator.startsWith("name=") || locator.startsWith("Name=") || locator.startsWith("NAME=")){
            locatorcut = By.name(locator.substring(5));
        }
        else if(locator.startsWith("xpath=") || locator.startsWith("XPATH=") || locator.startsWith("Xpath=")){
            locatorcut = By.xpath(locator.substring(6));
        }
        else if(locator.startsWith("CSS=") || locator.startsWith("Css=") || locator.startsWith("css=")){
            locatorcut = By.cssSelector(locator.substring(4));
        }
        else if(locator.startsWith("class=") || locator.startsWith("CLASS=") || locator.startsWith("Class=")){
            locatorcut = By.className(locator.substring(6));
        }
        else {
            throw new RuntimeException("Locator is not valild");
        }
        return locatorcut;
    }

    public List<WebElement> getAllElement(WebDriver driver,String element){
        List<WebElement> allelement = driver.findElements(getByXpath(element));
        return allelement;
    }

    public List<WebElement> getAllElementLocator(WebDriver driver,String element){
        List<WebElement> allelement = driver.findElements(getByLocator(element));
        return allelement;
    }

    public void selectByTextDropDown(WebDriver driver,String element, String value){

       Select select = new Select(searchElementByXpath(driver,element));
        select.selectByVisibleText(value);
    }

    public void selectByTextDropDownLocator(WebDriver driver,String element, String value, String...values){
        Select select = new Select(searchElementByLocator(driver,castRestParameter(element,values)));
        select.selectByVisibleText(castRestParameter(value,values));
    }

    public void selectByTextDropDownLocatorMulti(WebDriver driver,String element, String value, String...values){
        waitElementclickLocator(driver,element);
        waitElementclickLocator(driver,value);
        new Select(searchElementByLocator(driver,element)).selectByVisibleText(value);
    }
    public String getFirstSelectDropDown(WebDriver driver,By element){
        Select select = new Select(searchElementBy(driver,element));
       return select.getFirstSelectedOption().getText();
    }

    public boolean isMultipleDropDown(WebDriver driver,String element){
        Select select = new Select(searchElementByXpath(driver, element));
        return select.isMultiple();
    }

    public void checkItem(WebDriver driver, String ParentXpath,String ChildXpath, String ExpItem){
        clickToElement(driver,By.xpath(ParentXpath));

        List<WebElement>luuTru =  new WebDriverWait(driver, Duration.ofSeconds(timeOut)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ChildXpath)));
        for (WebElement get: luuTru) {
            if(searchElementByElement(driver,get).getText().equals(ExpItem)) {
                clickToElementByWebelement(driver,get);
                break;
            }
        }
    }

    public String getAttributeElement(WebDriver driver, String locator,String value){
       return searchElementByXpath(driver,locator).getAttribute(value);
    }

    public String getAttributeElementBylocator(WebDriver driver, String locator,String value,String ... values){
        return searchElementByLocator(driver,castRestParameter(locator,values)).getAttribute(value);
    }

    public String getCssValue(WebDriver driver,String locator,String value){
       return  searchElementByXpath(driver,locator).getCssValue(value);
    }

    public String getHexaColor(WebDriver driver,String rgbaValue){
        return Color.fromString(rgbaValue).asHex();

    }

    public void checkTheCheckBoxRadio(WebDriver driver,String locator){
        if(!searchElementByXpath(driver,locator).isSelected()){
            clickToElementByXpath(driver,locator);
        }
    }

    public void unCheckTheCheckBox(WebDriver driver,String locator){
        if(searchElementByXpath(driver,locator).isSelected()){
            clickToElementByXpath(driver,locator);
        }
    }

    public int getListSizeElement(WebDriver driver,String locator){
       return getAllElement(driver,locator).size();
    }

    public int getListSizeElementLocator(WebDriver driver,String locator,String...values){
        return getAllElementLocator(driver,castRestParameter(locator,values)).size();
    }
    //element in dom
    public boolean isDisplayElement(WebDriver driver,String locator){
        return searchElementByXpath(driver,locator).isDisplayed();
    }

    //element in dom
    public boolean isDisplayElementLocator(WebDriver driver,String locator,String...value){
        return searchElementByLocator(driver,castRestParameter(locator,value)).isDisplayed();
    }


    //element not in dom
    public boolean isElementUndisplayed(WebDriver driver, String locator){
        setImplicityTime(driver,shortTimeOut);
        if(getAllElementLocator(driver,locator).size() == 0){
            setImplicityTime(driver,timeOut);
            System.out.println("element not in DOM");
            return true;
        }
        else if(getAllElementLocator(driver,locator).size() > 0 && !getAllElementLocator(driver,locator).get(0).isDisplayed()){
            setImplicityTime(driver,timeOut);
            System.out.println("element in dom but not visibilty / display");
            return true;
        }
        else {
            System.out.println("element in dom and displayed");
            setImplicityTime(driver,timeOut);
            return false;
        }

    }

    public boolean isEnableElement(WebDriver driver,String locator){
        return searchElementByXpath(driver,locator).isEnabled();
    }

    public boolean isSelectElement(WebDriver driver,String locator){
        return searchElementByXpath(driver,locator).isSelected();
    }

    public void switchToIframeInHTML(WebDriver driver,String locator){
        if(searchElementByXpath(driver,locator).isDisplayed()){
            driver.switchTo().frame(searchElementByXpath(driver,locator));
        }
    }

    public void swithToDefaultContent(WebDriver driver,String locator){
        driver.switchTo().defaultContent();
    }

    public void doubleClickElement(WebDriver driver,String locator){
        new Actions(driver).doubleClick(searchElementByXpath(driver,locator)).perform();
    }

    public void moveToElement(WebDriver driver,String locator){
        new Actions(driver).moveToElement(searchElementByXpath(driver,locator)).perform();
    }

    public void rightClickElement(WebDriver driver,String locator){
        new Actions(driver).contextClick(searchElementByXpath(driver,locator)).perform();
    }

    public void dragAndDropElement(WebDriver driver,String drag,String drop){
        new Actions(driver).dragAndDrop(searchElementByXpath(driver,drag),searchElementByXpath(driver,drop));
    }

    public void sendKeyBoardToElement(WebDriver driver, String target, Keys key){
        new Actions(driver).sendKeys(searchElementByXpath(driver,target),key).perform();
    }

    public void sendKeyBoardToElementLocator(WebDriver driver, String target, Keys key,String...values){
        new Actions(driver).sendKeys(searchElementByLocator(driver,castRestParameter(target,values)),key).perform();
    }

    public Object executeForBrowser(WebDriver driver, String javaScript) {


        return ((JavascriptExecutor)driver).executeScript(javaScript);
    }

    public String getInnerText(WebDriver driver) {
        return (String) ((JavascriptExecutor)driver).executeScript("return document.documentElement.innerText;");
    }

    public boolean areExpectedTextInInnerText(WebDriver driver,String textExpected) {
        String textActual = (String) ((JavascriptExecutor)driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(WebDriver driver) {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver,String url) {
        ((JavascriptExecutor)driver).executeScript("window.location = '" + url + "'");
    }

    public void hightlightElement(WebDriver driver,String locator) {
        WebElement element = searchElementByXpath(driver,locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        SleepInTime(1);
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver,String locator) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", searchElementByXpath(driver,locator));
    }

    public void scrollToElementOnTop(WebDriver driver,String locator) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", searchElementByXpath(driver,locator));
    }

    public void scrollToElementOnDown(WebDriver driver,String locator) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", searchElementByXpath(driver,locator));
    }

    public void sendkeyToElementByJS(WebDriver driver,String locator, String value) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", searchElementByXpath(driver,locator));
    }

    public void removeAttributeInDOM(WebDriver driver,String locator, String attributeRemove) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", searchElementByXpath(driver,locator));
    }

    public String getElementValidationMessage(WebDriver driver,String locator) {
        return (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].validationMessage;", searchElementByXpath(driver,locator));
    }

    public boolean isImageLoaded(WebDriver driver,String locator) {
        boolean status = (boolean) ((JavascriptExecutor)driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                searchElementByXpath(driver,locator));
        return status;
    }

    public void waitElementVisibility(WebDriver driver, String locator){
        new WebDriverWait(driver,Duration.ofSeconds(timeOut)).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitElementVisibilityLocators(WebDriver driver, String locator,String... values){
        new WebDriverWait(driver,Duration.ofSeconds(timeOut)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castRestParameter(locator,values))));
    }

    public void waitElementVisibilityAllLocators(WebDriver driver, String locator,String... values){
        new WebDriverWait(driver,Duration.ofSeconds(timeOut)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(castRestParameter(locator,values))));
    }

    public void waitElementInvisibilty(WebDriver driver, String locator){
        new WebDriverWait(driver,Duration.ofSeconds(timeOut)).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitElementInvisibiltyLocators(WebDriver driver, String locator,String... values){
        new WebDriverWait(driver,Duration.ofSeconds(timeOut)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castRestParameter(locator,values))));
    }

    public void waitElementInvisibiltyLocatorsNotInDom(WebDriver driver, String locator,String... values){
        //vì wait ảnh hưởng bởi impli nên set cả implicitytime luôn
        setImplicityTime(driver,shortTimeOut);
        new WebDriverWait(driver,Duration.ofSeconds(shortTimeOut)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castRestParameter(locator,values))));
        setImplicityTime(driver,timeOut);
    }


    public void waitElementclick(WebDriver driver, String locator){
        new WebDriverWait(driver,Duration.ofSeconds(timeOut)).until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

    public void waitElementclickLocator(WebDriver driver, String locator,String...values){
        new WebDriverWait(driver,Duration.ofSeconds(timeOut)).until(ExpectedConditions.elementToBeClickable(getByLocator(castRestParameter(locator,values))));
    }

    public void waitElementStaless(WebDriver driver,String locator){
        WebElement element = searchElementByLocator(driver,locator);
        new WebDriverWait(driver,Duration.ofSeconds(timeOut)).until(ExpectedConditions.stalenessOf(element));
    }

    public FooterContainPageObject getFooterContainPage(WebDriver driver){
        return new FooterContainPageObject(driver);
    }

    public UserHomePageObject clickLogOutHomePageAdmin(WebDriver driver){
        clickToElements(driver, MyDashBoardUI.LOGOUTHOVE);
        clickToElements(driver,AdminBasePageUI.LOG_OUT_LOCATOR);
        return PageGeneratorManager.getHomePage(driver);
    }

    public AdminLoginPageObject openAdminPage(WebDriver driver, String adminUrl){
        openUrl(driver,adminUrl);
        return PageGeneratorManager.getLoginPageAdmin(driver);
    }

    public UserHomePageObject openUserPage(WebDriver driver, String userUrl){
        openUrl(driver,userUrl);
        return PageGeneratorManager.getHomePage(driver);
    }

    public String castRestParameter(String locator,String... values){
        locator = String.format(locator, (Object[]) values);
        return locator;
    }

    public void clickToElements(WebDriver driver, String locator, String... values){
        waitElementclickLocator(driver,castRestParameter(locator,values));
        searchElementByLocator(driver,castRestParameter(locator,values)).click();
    }

    public void UploadMultipleFiles(WebDriver driver, String...nameFiles){
        for (String nameOfFile:nameFiles) {
            sendKeyToElements(driver,GlobalConstants.UPLOAD_LOCATOR,GlobalConstants.UPLOAD_PATH+nameOfFile);
        }
    }

    public void setImplicityTime(WebDriver driver, long timeout){
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public long SleepInTime(long num){
        try {
            Thread.sleep(num*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return num;
    }

    public Set<Cookie> getCookies(WebDriver driver){
        return driver.manage().getCookies();
    }

    public void addCookies(WebDriver driver, Set<Cookie> cookies){
        for (Cookie cookie:cookies) {
            driver.manage().addCookie(cookie);
            driver.navigate().refresh();
        }
    }

    /**function component dùng chung**/
    public void enterToTextBoxById(WebDriver driver,String valueInput,String...valuesToElement){
        waitElementVisibilityLocators(driver,AdminBasePageUI.DYNAMIC_TEXTBOX_BY_ID,valuesToElement);
        sendKeyToElements(driver,AdminBasePageUI.DYNAMIC_TEXTBOX_BY_ID,valueInput,valuesToElement);
    }

    public void clickToButtonByTitle(WebDriver driver,String nameValue){
        waitElementVisibilityLocators(driver,AdminBasePageUI.DYNAMIC_BUTTON_TITLE,nameValue);
        clickToElements(driver,AdminBasePageUI.DYNAMIC_BUTTON_TITLE,nameValue);
    }

    public String getFieldErrorById(WebDriver driver,String feildId){
        waitElementVisibilityLocators(driver,AdminBasePageUI.DYNAMIC_FIELD_ERROR_MESSAGE_BY_ID,feildId);
       return getElementTextLocator(driver,AdminBasePageUI.DYNAMIC_FIELD_ERROR_MESSAGE_BY_ID,feildId);
    }

    public String getPageError(WebDriver driver){
        waitElementVisibilityLocators(driver,AdminBasePageUI.PAGE_ERROR_MESSAGE);
        return getElementTextLocator(driver,AdminBasePageUI.PAGE_ERROR_MESSAGE);
    }

    public String getPageSuccess(WebDriver driver){
        return getElementTextLocator(driver,AdminBasePageUI.PAGE_SUCCESS_MESSAGE);
    }

    public void selectDropDownById(WebDriver driver,String dropDownId,String dropDownItem){
        waitElementclickLocator(driver,AdminBasePageUI.DYNAMIC_DROPDOWN_BY_ID,dropDownId);
        selectByTextDropDownLocator(driver,AdminBasePageUI.DYNAMIC_DROPDOWN_BY_ID,dropDownItem,dropDownId);
    }


    private long timeOut = GlobalConstants.LONG_TIMEOUT;
    private long shortTimeOut = GlobalConstants.SHORT_TIMEOUT;
}
