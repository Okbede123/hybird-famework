package testcases.comsortdata;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src2.actions.pageObjects.SortLab.InventoryPageObject;
import src2.actions.pageObjects.SortLab.LoginPageObject;
import src2.actions.pageObjects.SortLab.PageGeneralManager;
import src2.cores.commons.BaseTest;

public class Level_21_SortData extends BaseTest {
    WebDriver driver;

    private LoginPageObject loginPageObject;
    private InventoryPageObject inventoryPageObject;



    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {

        driver= multipleBrowserEnum_SwitchCase_DemoSortData(browserName,url);
        loginPageObject = PageGeneralManager.openLoginPage(driver);
        inventoryPageObject = loginPageObject.loginToInventory("standard_user","secret_sauce");
    }

    @Test
    public void Sort_01_NameAscending() {
        inventoryPageObject.selectSortData("Name (A to Z)");
        Assert.assertTrue(inventoryPageObject.isProductNameSortAscending());

    }

    @Test
    public void Sort_02_NameDescending() {
        inventoryPageObject.selectSortData("Name (Z to A)");
        Assert.assertTrue(inventoryPageObject.isProductNameSortDescending());
    }

    @Test
    public void Sort_03_PriceAscending() {
        inventoryPageObject.selectSortData("Price (low to high)");
        Assert.assertTrue(inventoryPageObject.isProductPriceSortAscending());

    }

    @Test
    public void Sort_04_PriceDescending() {
        inventoryPageObject.selectSortData("Price (high to low)");
        Assert.assertTrue(inventoryPageObject.isProductPriceSortDescending());

    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //closeBrowserDriver();
    }


}
