package src2.actions.pageObjects.SortLab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import src2.cores.commons.BasePage;
import src2.interrface.UI.SortLab.InventoryPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryPageObject extends BasePage {
    WebDriver driver;


    public InventoryPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void selectSortData(String value){
        selectByTextDropDownLocator(driver, InventoryPageUI.SORT_DATA,value);
    }

    public boolean isProductNameSortAscending(){
        ArrayList<String> listData = new ArrayList<>();
        waitElementVisibilityAllLocators(driver,InventoryPageUI.LIST_NAME_DATA);
        List<WebElement> listWebElement = getAllElementLocator(driver,InventoryPageUI.LIST_NAME_DATA);
        for (WebElement element: listWebElement) {
            listData.add(element.getText());
        }
        ArrayList<String> listDataCopy = new ArrayList<>(listData);
        Collections.sort(listDataCopy);
        return listDataCopy.equals(listData);
    }

    public boolean isProductNameSortDescending(){
        ArrayList<String> listData = new ArrayList<>();
        waitElementVisibilityAllLocators(driver,InventoryPageUI.LIST_NAME_DATA);
        List<WebElement> listWebElement = getAllElementLocator(driver,InventoryPageUI.LIST_NAME_DATA);
        for (WebElement element: listWebElement) {
            listData.add(element.getText());
        }
        ArrayList<String> listDataCopy = new ArrayList<>(listData);
        Collections.sort(listDataCopy);
        Collections.reverse(listDataCopy);
        return listDataCopy.equals(listData);
    }

    public boolean isProductPriceSortDescending(){
        ArrayList<Float> listDataPrice = new ArrayList<>();
        waitElementVisibilityAllLocators(driver,InventoryPageUI.LIST_PRICE_DATA);
        List<WebElement> listWebElementPrice = getAllElementLocator(driver,InventoryPageUI.LIST_PRICE_DATA);
        for (WebElement element: listWebElementPrice) {
            String priceText = element.getText().replace("$","");
            Float priceFloat = Float.valueOf(priceText);
            listDataPrice.add(priceFloat);
        }
        ArrayList<Float> listDataCopy = new ArrayList<Float>(listDataPrice);
        Collections.sort(listDataCopy);
        Collections.reverse(listDataCopy);
        return listDataCopy.equals(listDataPrice);
    }

    public boolean isProductPriceSortAscending(){
        ArrayList<Float> listDataPrice = new ArrayList<Float>();
        waitElementVisibilityAllLocators(driver,InventoryPageUI.LIST_PRICE_DATA);
        List<WebElement> listWebElementPrice = getAllElementLocator(driver,InventoryPageUI.LIST_PRICE_DATA);
        for (WebElement element: listWebElementPrice) {
            listDataPrice.add(Float.valueOf(element.getText().replace("$","")));
        }
        ArrayList<Float> listDataCopy = new ArrayList<Float>(listDataPrice);
        Collections.sort(listDataCopy);
        return listDataCopy.equals(listDataPrice);
    }
}
