package testcases.companda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import src2.actions.pageObjects.HomePageObject;
import src2.actions.pageObjects.LoginPageObject;
import src2.actions.pageObjects.MyDashBoardPageObject;

import java.util.Random;

public class Level_03_PageObject_Pattern {
    WebDriver driver;

    HomePageObject homePageObject;
    LoginPageObject loginPageObject;
    MyDashBoardPageObject myDashBoardPageObject;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/index.php/");
        homePageObject = new HomePageObject();
    }

    @Test
    public void TC_01_LoginWithEmptyEmailAndPassword() {
    }

    @Test
    public void TC_02_LoginWithInvalidEmail() {
    }

    @Test(description = "Email not exist in application")
    public void TC_03_LoginWithIncorrectEmail() {
    }

    @Test(description = "Password less than 6 characters")
    public void TC_04_LoginWithInvalidPassword() {
    }

    @Test
    public void TC_05_LoginWithIncorrectPassword() {
    }

    @Test
    public void TC_06_LoginWithValidEmailAndPassword() {
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

