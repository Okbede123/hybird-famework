package Automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BaiTapJavaSsciptExpcutor {
    WebDriver driver;
    WebDriverWait webDriverWait;
    KhoiTaoDriver khoiTaoDriver = new KhoiTaoDriver();
    JavascriptExecutor getjava;

    String webMongmuon = "https://demo.guru99.com/";


    String layUserID;
    String layMatKhau;
    String getUrl = "https://demo.guru99.com/v4/";
    String getUrl2 = "https://demo.guru99.com/v4/";
    String dateOfBirth = "1950-01-31";
    String address = "halongfdfđfghdf\nghfghfgjghjfghj";
    String addressCheck = "halongfdfđfghdf ghfghfgjghjfghj";

    @BeforeClass
    public void BeforeClass(){
        System.setProperty(khoiTaoDriver.khoiTaoChomre,khoiTaoDriver.getProperty+khoiTaoDriver.source);
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        getjava = (JavascriptExecutor) driver;
    }

    //@Test
    public void TC_01_JE(){

        getjava.executeScript("window.location ='http://live.techpanda.org/'");

        //phải ép kiểu tường minh về dạng string
        String getDomain = (String) getjava.executeScript("return document.domain");
        //System.out.println(getjava.executeScript("return document.domain"));
        Assert.assertEquals(getDomain,"live.techpanda.org");
        String getUrl = (String) getjava.executeScript("return document.URL");
        Assert.assertEquals(getUrl,"http://live.techpanda.org/");

        getjava.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[text() = 'Mobile']")));
        getjava.executeScript("arguments[0].click();",driver.findElement(By.xpath("//h2//a[@title = 'Samsung Galaxy']//parent::h2//following-sibling::div/button/span")));


        //System.out.println(getjava.executeScript("return document.documentElement.innerText.match('Samsung Galaxy was added to your shopping cart.')[0]"));
        Assert.assertTrue(areExpectedTextInInnerText("Samsung Galaxy was added to your shopping cart."));
        hightlightElement("//li/span[text() = 'Samsung Galaxy was added to your shopping cart.']");

        getjava.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[text() = 'Customer Service']")));

        Assert.assertEquals(getjava.executeScript("return document.title;"),"Customer Service");

        //getjava.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//div[@class = 'main-container col3-layout']")));
        scrollToBottomPage();
        sendkeyToElementByJS("//input[@type = 'email']","okbede" + khoiTaoDriver.RandomNum() + "@fasd.com");

        clickToElementByJS("//span/span[text() = 'Subscribe']");

        areExpectedTextInInnerText("Thank you for your subscription.");

        getjava.executeScript("window.location ='https://demo.guru99.com/v4/'");
        Assert.assertEquals(getjava.executeScript("return document.URL"),"http://demo.guru99.com/v4/");
    }

    //@Test
    public void TC_02_JE(){
        driver.get("https://login.ubuntu.com/");

        khoiTaoDriver.SleepInTime(5);

        String inputemail = "dfsdfsdfg@";

        By luuemail = By.xpath("//div[@data-qa-id = 'login_create_account_radio']//preceding-sibling::div//input");

        WebElement emailInput = driver.findElement(By.xpath("//div[@data-qa-id = 'login_create_account_radio']//preceding-sibling::div//input"));

        List<WebElement> luu = driver.findElements(By.xpath("//div[@class = 'p-modal__dialog']"));

        if(luu.size() > 0){
            driver.findElement(By.xpath("//button[@class = 'p-button--positive js-close']")).click();
        }

        getjava.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[@data-qa-id = 'login_button']")));
       //String gettext = (String) getjava.executeScript("return arguments[0].validationMessage",driver.findElement(By.xpath("//div[@data-qa-id = 'login_create_account_radio']//preceding-sibling::div//input")));
        String gettext = (String) getjava.executeScript("return arguments[0].validationMessage",driver.findElement(luuemail));
        //System.out.println(gettext);
        Assert.assertEquals(gettext,"Please fill out this field.");

        //khoiTaoDriver.SleepInTime(6);
       emailInput.sendKeys(inputemail);

       driver.findElement(By.xpath("//button[@data-qa-id = 'login_button']")).click();

        String gettext2 = (String) getjava.executeScript("return arguments[0].validationMessage",driver.findElement(luuemail));

       Assert.assertEquals(gettext2,"Please enter a part following '@'. '" + inputemail + "' is incomplete.");


    }

    //@Test
    public void TC_03_JE(){
        driver.get("https://automationfc.github.io/html5/index.html");
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();
       String gettext = (String) getjava.executeScript("return arguments[0].validationMessage",driver.findElement(By.xpath("//input[@id = 'fname']")));
       Assert.assertEquals(gettext,"Vui lòng điền vào trường này.");

    }

    //@Test
    public void TC_04_RemoveAttribute(){
        driver.get("https://demo.guru99.com/v4/");

        driver.findElement(By.xpath("//a[text() = 'here']")).click();
        List<WebElement> checkPopup = driver.findElements(By.xpath("//iframe[@id = 'google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0']"));
        if(checkPopup.size() > 0){
            driver.get("https://demo.guru99.com/");
            //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#dismiss-button")));
        //driver.findElement(By.xpath("svg path[d = 'M0 0h48v48H0z']")).click();
        //getjava.executeScript("arguments[0].click();",driver.findElement(By.xpath("svg path[d = 'M0 0h48v48H0z']")));
        }

        Assert.assertEquals("https://demo.guru99.com/",driver.getCurrentUrl());
        //driver.findElement(By.name("emailid")).sendKeys("okbede" + getRandom()+ "@assd.com");
        driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys("okbede" + khoiTaoDriver.RandomNum() + "@ssss.com");
        driver.findElement(By.name("btnLogin")).click();

        layUserID = driver.findElement(By.xpath("//td[text() = 'User ID :']/following-sibling::td[@align = 'center']")).getText();
        layMatKhau = driver.findElement(By.xpath("//td[text() = 'Password :']/following-sibling::td[@align = 'center']")).getText();
        driver.get("https://demo.guru99.com/v4/");
        driver.findElement(By.cssSelector("input[type = text]")).sendKeys(layUserID);
        driver.findElement(By.cssSelector("input[type = password]")).sendKeys(layMatKhau);
        driver.findElement(By.cssSelector("input[type = submit]")).click();

        driver.findElement(By.xpath("//ul[@class = 'menusubnav']//li[2]")).click();
        //driver.findElement(By.name("name")).sendKeys();
        driver.findElement((By.xpath("//tr//td//input[@name= 'name']"))).sendKeys("okbede");

        driver.findElement(By.xpath("//input[@type = 'radio' and @value = 'f']")).click();

        WebElement ngayThang = driver.findElement(By.xpath("//tr//td//input[@type= 'date']"));

        getjava.executeScript("arguments[0].removeAttribute('type')",ngayThang);
        khoiTaoDriver.SleepInTime(2);
        ngayThang.sendKeys("1950-01-31");

    }

    @Test
    public void TC_05_JE(){
        getjava.executeScript("window.location = 'http://live.techpanda.org/'");
        getjava.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[@id = 'header-account']//ul//li//a[text() = 'My Account']")));

        clickToElementByJS("//span/span[text() = 'Create an Account']");
        sendkeyToElementByJS("//input[@id = 'firstname']","okbede123");
        sendkeyToElementByJS("//input[@id = 'middlename']","ong");
        sendkeyToElementByJS("//input[@id = 'lastname']","be de");
        sendkeyToElementByJS("//input[@id = 'email_address']","okbede" + khoiTaoDriver.RandomNum() + "asd@asdd.com");
        sendkeyToElementByJS("//input[@id = 'password']","okbede123");
        sendkeyToElementByJS("//input[@id = 'confirmation']","okbede123");
        clickToElementByJS("//button[@title = 'Register']");
        String text = (String) getjava.executeScript("return document.documentElement.innerText;");
        //System.out.println(text);
        if(text.contains("Thank you for registering with Main Website Store.")){
            Assert.assertTrue(text.contains("Thank you for registering with Main Website Store."));
        }
        clickToElementByJS("//li/a[text() = 'Log Out']");
        khoiTaoDriver.SleepInTime(7);
        System.out.println(driver.getTitle());
        //Assert.assertTrue(driver.getTitle() == "Home page");
        Assert.assertEquals(driver.getTitle(),"Home page");

    }

    public Object executeForBrowser(String javaScript) {
        return getjava.executeScript(javaScript);
    }

    public String getInnerText() {
        return (String) getjava.executeScript("return document.documentElement.innerText;");
    }

    public boolean areExpectedTextInInnerText(String textExpected) {
        String textActual = (String) getjava.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        getjava.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(String url) {
        getjava.executeScript("window.location = '" + url + "'");
    }

    public void hightlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        getjava.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        khoiTaoDriver.SleepInTime(1);
        getjava.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator) {
        getjava.executeScript("arguments[0].click();", getElement(locator));
    }

    public void scrollToElementOnTop(String locator) {
        getjava.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void scrollToElementOnDown(String locator) {
        getjava.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        getjava.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        getjava.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public String getElementValidationMessage(String locator) {
        return (String) getjava.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        boolean status = (boolean) getjava.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(locator));
        return status;
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }
}
