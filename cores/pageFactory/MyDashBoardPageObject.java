package src2.cores.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src2.cores.commons.BasePageFactory;

public class MyDashBoardPageObject extends BasePageFactory {

    WebDriver driver;

    @FindBy(xpath = "//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p[contains(text(),'user01 account')]")
    WebElement myDashBoard;

    public MyDashBoardPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public String loginDashBoard() {
        waitElement(driver, myDashBoard);
        return getElementFactory(driver,myDashBoard);
    }
}
