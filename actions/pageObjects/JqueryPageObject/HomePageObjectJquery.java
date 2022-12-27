package src2.actions.pageObjects.JqueryPageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import src2.cores.commons.BasePage;
import src2.cores.commons.GlobalConstants;
import src2.interrface.UI.JqueryPageUI.HomePageUIJquery;

import java.util.List;

public class HomePageObjectJquery extends BasePage {

    WebDriver driver;

    public HomePageObjectJquery(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeyToTextBoxHeaderName(String headerName, String value) {
        waitElementVisibilityLocators(driver, HomePageUIJquery.DYNAMIC_LOCATOR_HEADER, headerName);
        sendKeyToElements(driver, HomePageUIJquery.DYNAMIC_LOCATOR_HEADER, value, headerName);
        sendKeyBoardToElementLocator(driver, HomePageUIJquery.DYNAMIC_LOCATOR_HEADER, Keys.ENTER, headerName);

    }

    public boolean isDisplayHeaderBox(String value1,String value2,String value3,String value4) {
        waitElementVisibilityLocators(driver,HomePageUIJquery.DYNAMIC_VERIFY_HEADER,value1,value2,value3,value4);
       return isDisplayElementLocator(driver,HomePageUIJquery.DYNAMIC_VERIFY_HEADER,value1,value2,value3,value4);

    }

    public void clickToActionByCountryName(String countryName,String actions){
        waitElementVisibilityLocators(driver,HomePageUIJquery.DYNAMIC_REMOVE_EDIT_HEADER,countryName,actions);
        clickToElements(driver,HomePageUIJquery.DYNAMIC_REMOVE_EDIT_HEADER,countryName,actions);
    }

    public void clickOpenPage(String numberPage){
        waitElementVisibilityLocators(driver,HomePageUIJquery.DYNAMIC_NUMBER_PAGE,numberPage);
        clickToElements(driver,HomePageUIJquery.DYNAMIC_NUMBER_PAGE,numberPage);
    }

    public boolean isDisplayNumberPage(String numberPage){
        waitElementVisibilityLocators(driver,HomePageUIJquery.DYNAMIC_VERIFY_NUMBER_PAGE,numberPage);
        return isDisplayElementLocator(driver,HomePageUIJquery.DYNAMIC_VERIFY_NUMBER_PAGE,numberPage);
    }

    public void enterTextBoxByHeaderNameandRowNumber(String columNamer,String row,String colum,String value) {
        waitElementVisibilityLocators(driver,HomePageUIJquery.DYNAMIC_NAME_COLUM,columNamer,row,colum);
        sendKeyToElements(driver,HomePageUIJquery.DYNAMIC_NAME_COLUM,value,columNamer,row,colum);
    }

    public void selectTextBoxByHeaderNameandRowNumber(String row,String value) {
        waitElementVisibilityLocators(driver,HomePageUIJquery.COUNTRY_SELECT_NAME,row);
        selectByTextDropDownLocator(driver,HomePageUIJquery.COUNTRY_SELECT_NAME,value,row);
    }

    public void enterTextBoxByHeaderNameandRowNumberGetList(String nameColum,String row,String value) {
      int numberColum =  getListSizeElementLocator(driver,HomePageUIJquery.DYNAMIC_NAME_COLUM_GET_INDEX,nameColum) + 1;
        waitElementVisibilityLocators(driver,HomePageUIJquery.ROW_INDEX,row,String.valueOf(numberColum));
        sendKeyToElements(driver,HomePageUIJquery.ROW_INDEX,value,row,String.valueOf(numberColum));
    }

    @Override
    public void UploadMultipleFiles(WebDriver driver, String... nameFiles) {
        for (String uploadFile: nameFiles) {
            sendKeyToElements(driver, GlobalConstants.UPLOAD_LOCATOR,GlobalConstants.UPLOAD_PATH+uploadFile);
            clickToElements(driver,HomePageUIJquery.UPLOAD_BUTTON);
        }
        List<WebElement> buttons = getAllElementLocator(driver,HomePageUIJquery.UPLOAD_BUTTON);
        for (WebElement button: buttons) {
            button.click();
        }
    }

    public boolean isImageLoadedSuccess(String...values) {
            waitElementVisibilityLocators(driver,HomePageUIJquery.IMAGE_UPLOAD_SUCCESS,values);
            return isDisplayElementLocator(driver,HomePageUIJquery.IMAGE_UPLOAD_SUCCESS,values);
    }

    //    public  void UploadMultiFiles(String... nameFiles){
//        for (String namefile:nameFiles) {
//            waitElementVisibilityLocators(driver, GlobalConstants.UPLOAD_LOCATOR);
//
//        }
//
//    }

}

