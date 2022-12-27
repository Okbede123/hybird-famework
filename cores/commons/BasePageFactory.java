package src2.cores.commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;


//các hàm thao tác vs browser
public class BasePageFactory {

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
        searchElementByXpath(driver,element).click();
    }

    public void sendKeyToElement(WebDriver driver,By element,String valueInPut){

        WebElement element1 = searchElementBy(driver,element);
        element1.clear();
        element1.sendKeys(valueInPut);
    }

    public void sendKeyFactory(WebDriver driver,WebElement element,String value){
        element.sendKeys(value);
    }

    public void sendKeyToElementXpath(WebDriver driver,String element,String valueInPut){

        WebElement element1 = searchElementByXpath(driver,element);
        element1.clear();
        element1.sendKeys(valueInPut);
    }

    public String getElementText(WebDriver driver,By element){
        return searchElementBy(driver,element).getText();
    }

    public String getElementFactory(WebDriver driver,WebElement element){
        return element.getText();
    }

    public String getElementTextByXpath(WebDriver driver,String element){
        return searchElementByXpath(driver,element).getText();
    }

    public WebElement searchElementBy(WebDriver driver, By element){
        return driver.findElement(element);
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

    public By getByXpath(String locator){
        return By.xpath(locator);
    }

    public List<WebElement> getAllElement(WebDriver driver,String element){
        List<WebElement> allelement = driver.findElements(getByXpath(element));
        return allelement;
    }

    public void selectByTextDropDown(WebDriver driver,String element, String value){

       Select select = new Select(searchElementByXpath(driver,element));
        select.selectByVisibleText(value);
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

    public boolean isDisplayElement(WebDriver driver,String locator){
        return searchElementByXpath(driver,locator).isDisplayed();
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

    public void waitElementInvisibilty(WebDriver driver, String locator){
        new WebDriverWait(driver,Duration.ofSeconds(timeOut)).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitElementclick(WebDriver driver, String locator){
        new WebDriverWait(driver,Duration.ofSeconds(timeOut)).until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

    public void clickToElement(WebDriver driver,WebElement element){
        element.click();
    }

    public void waitElement(WebDriver driver,WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementClick(WebDriver driver,WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(element));
    }


    public long SleepInTime(long num){
        try {
            Thread.sleep(num*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return num;
    }


    private long timeOut = 30;
}
