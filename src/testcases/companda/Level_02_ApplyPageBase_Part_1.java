package testcases.companda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import src2.cores.commons.BasePage;

import java.util.Random;

public class Level_02_ApplyPageBase_Part_1 {
    WebDriver driver;


    BasePage basePage = new BasePage();



    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();


    }

    //cứ moi lần chạy testcase(hàm) sẽ chạy vào hàm beforemethod này
    @BeforeMethod
    public void beforeMethod() {
        basePage.openUrl(driver,"http://live.techpanda.org/");
        basePage.clickToElementByXpath(driver,"//div[@class='footer']//a[text()='My Account']");
        //driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
    }

    @Test
    public void TC_01_LoginWithEmptyEmailAndPassword() {

        basePage.sendKeyToElement(driver,basePage.getByXpath("//input[@id = 'email']"),"");
        basePage.sendKeyToElement(driver,basePage.getByXpath("//input[@id = 'pass']"),"");
        basePage.clickToElementByXpath(driver,"//button[@id = 'send2']");
        basePage.waitElementVisibility(driver,"//div[@id = 'advice-required-entry-email']");
        Assert.assertEquals(basePage.getElementText(driver,basePage.getByXpath("//div[@id = 'advice-required-entry-email']")),"This is a required field.");
        Assert.assertEquals(basePage.getElementText(driver,basePage.getByXpath("//div[@id = 'advice-required-entry-pass']")),"This is a required field.");
    }

    @Test
    public void TC_02_LoginWithInvalidEmail() {
        basePage.sendKeyToElement(driver,basePage.getByXpath("//input[@id = 'email']"),"123@456.789");
        basePage.sendKeyToElement(driver,basePage.getByXpath("//input[@id = 'pass']"),"123456");

        basePage.clickToElementByXpath(driver,"//button[@id = 'send2']");

        basePage.waitElementVisibility(driver,"//div[@id = 'advice-validate-email-email']");
        Assert.assertEquals(basePage.getElementText(driver,basePage.getByXpath("//div[@id = 'advice-validate-email-email']")),"Please enter a valid email address. For example johndoe@domain.com.");

    }

    @Test(description = "Email not exist in application")
    public void TC_03_LoginWithIncorrectEmail() {
        basePage.sendKeyToElement(driver,basePage.getByXpath("//input[@id = 'email']"),"auto_test" + randomNumber() + "@live.com");
        basePage.sendKeyToElement(driver,basePage.getByXpath("//input[@id = 'pass']"),"123456");
        basePage.clickToElementByXpath(driver,"//button[@id = 'send2']");
        basePage.waitElementVisibility(driver,"//li[@class='error-msg']//span");
        Assert.assertEquals(basePage.getElementText(driver,basePage.getByXpath("//li[@class='error-msg']//span")),"Invalid login or password.");
    }

    @Test(description = "Password less than 6 characters")
    public void TC_04_LoginWithInvalidPassword() {
        basePage.sendKeyToElement(driver,basePage.getByXpath("//input[@id = 'email']"),"auto_test" + randomNumber() + "@live.com");
        basePage.sendKeyToElement(driver,basePage.getByXpath("//input[@id = 'pass']"),"123");
        basePage.clickToElementByXpath(driver,"//button[@id = 'send2']");
        basePage.waitElementVisibility(driver,"//div[@class = 'validation-advice']");
        Assert.assertEquals(basePage.getElementText(driver,basePage.getByXpath("//div[@class = 'validation-advice']")),"Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void TC_05_LoginWithIncorrectPassword() {
        basePage.sendKeyToElement(driver,basePage.getByXpath("//input[@id = 'email']"),"auto_test" + randomNumber() + "@live.com");
        basePage.sendKeyToElement(driver,basePage.getByXpath("//input[@id = 'pass']"),"");
        basePage.clickToElementByXpath(driver,"//button[@id = 'send2']");
        basePage.waitElementVisibility(driver,"//div[@class = 'validation-advice']");
        Assert.assertEquals(basePage.getElementText(driver,basePage.getByXpath("//div[@class = 'validation-advice']")),"This is a required field.");

    }

    @Test
    public void TC_06_LoginWithValidEmailAndPassword() {

        basePage.sendKeyToElement(driver,basePage.getByXpath("//input[@id = 'email']"),"selenium_11_01@gmail.com");
        basePage.sendKeyToElement(driver,basePage.getByXpath("//input[@id = 'pass']"),"111111");
        basePage.clickToElementByXpath(driver,"//button[@id = 'send2']");
        //basePage.waitElementVisibility(driver,"//div[@class = 'validation-advice']");

        Assert.assertTrue(basePage.searchElementByXpath(driver,"//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p[contains(text(),'user01')]").isDisplayed());
        Assert.assertTrue(basePage.searchElementByXpath(driver,"//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p[contains(.,'selenium_11_01@gmail.com')]").isDisplayed());

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(999999);
    }

}