package src2.cores.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import src2.cores.commons.BasePageFactory;

import java.util.List;

public class HomePageObject extends BasePageFactory {
    WebDriver driver;

    //constructor, khởi tạo driver
    public HomePageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        //hoặc PageFactory.initElements(driver, HomePageObject.class);

    }


    //cách định nghĩa 1 element(1)
    @FindBy(xpath = "//div[@class = 'footer-container']//div//li/a[@title = 'My Account']")
    WebElement myAccountLink;

    @FindBy(how = How.XPATH, using = "//div[@class = 'footer-container']//div//li/a[@title = 'My Account']")
    List<WebElement> footLinks;

    //FindBy chỉ nhận 1 tham số locator
    //FindBys nhận 2 tham số locator(AND)
    //FindAll nhận 2 tham số locator(OR)



    public void clickToMyAccount() {
        waitElement(driver, myAccountLink);
        clickToElement(driver,myAccountLink);
    }
}
