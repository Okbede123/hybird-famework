package Automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LuyenTapDropDown3 {
    KhoiTaoDriver khoitao = new KhoiTaoDriver();
    WebDriver driver;
    WebDriverWait waitelement;

    @BeforeClass
    public void BeforeClass(){
        System.setProperty(khoitao.khoiTaoChomre,khoitao.getProperty+khoitao.source);
        driver = new ChromeDriver();
        waitelement = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void Geturl(){
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        TestDropDown("//li[@class = 'dropdown-toggle']","//ul//li//a","Third Option");
        //li[@class = 'dropdown-toggle']
        //ul//li//a
    }
    public void TestDropDown(String elementCha, String elementCon, String myoptions){

        driver.findElement(By.xpath(elementCha)).click();
        waitelement.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(elementCon)));
        List<WebElement> savelist = driver.findElements(By.xpath(elementCon));
        for (WebElement getlist: savelist) {
            if(getlist.getText().equals(myoptions)){
                System.out.println(getlist.getText());
                getlist.click();

            }
        }
    }
}
