package Automation_test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.*;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.List;

public class BaiTapActionChuot {

    WebDriver driver;
    WebDriverWait waitelement;
    JavascriptExecutor getjava;
    KhoiTaoDriver khoitao = new KhoiTaoDriver();

    Actions action;

    Alert alert;

    //C:\Users\Admin\IdeaProjects\AutoMationTest\out\production\DragDropHTML5\drag_and_drop_helper.js

    String dragDropHelperPath = khoitao.getProperty + "\\out\\production\\DragDropHTML5\\drag_and_drop_helper.js";


    @BeforeClass
    public void BeforeClass() {
        System.setProperty(khoitao.khoiTaoChomre, khoitao.getProperty + khoitao.source);
        driver = new ChromeDriver();
        //khoi tao action
        action = new Actions(driver);

        driver.manage().window().maximize();

        getjava = (JavascriptExecutor) driver;
        waitelement = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //@Test
    public void GetUrl() {

        driver.get("https://automationfc.github.io/jquery-tooltip/");
        //đi đến 1 element và dùng perform để chạy
        action.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.ui-tooltip-content")).isDisplayed());

    }

    // @Test
    public void TC_02_Actions() {
        driver.get("http://www.myntra.com/");
        action.moveToElement(driver.findElement(By.xpath("//div[@class = 'desktop-navLink']//a[text() = 'Kids']"))).perform();
        //action.moveToElement(driver.findElement(By.xpath("//li[@data-reactid = '479']/a[text() = 'Brands']"))).click();
        getjava.executeScript("arguments[0].click();", driver.findElement(By.xpath("//li[@data-reactid = '479']/a[text() = 'Brands']")));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'title-container']/h1[text() = 'Kids Wear Online Store']")).getText(), "Kids Wear Online Store");
    }

    //@Test
    public void TC_03_Actions() {
        driver.get("https://www.fahasa.com/");
        action.moveToElement(driver.findElement(By.xpath("//div[@class = 'fhs_center_right fhs_mouse_point fhs_dropdown_hover fhs_dropdown_click']/span[@class = 'icon_menu']"))).perform();
        //driver.findElement(By.xpath("(//div[@class = 'fhs_center_right fhs_mouse_point fhs_dropdown_hover fhs_dropdown_click']/span)[1]")).click();
        //khoitao.SleepInTime(1);
        //Assert.assertTrue(driver.findElement(By.xpath("//li[@class = ' parent dropdown aligned-left  ']/a[@title='Đồ Chơi']")).isDisplayed());
        //driver.findElement(By.xpath("//li[@class = 'parent dropdown aligned-left']//a[@title = 'Đồ Chơi']")).click();
        //action.click(driver.findElement(By.xpath("//li[@class = ' parent dropdown aligned-left  ']/a[@title='Đồ Chơi']")));
        //getjava.executeScript("arguments[0].click();",driver.findElement(By.xpath("//li[@class = 'parent dropdown aligned-left']//a[@title = 'Sách Trong Nước']")));
        action.moveToElement(driver.findElement(By.xpath("//li[@class = ' parent dropdown aligned-left  ']/a[@title='Đồ Chơi']"))).perform();
        //driver.findElement(By.xpath("(//div[@class = 'widget-html']//div[@class = 'widget-inner']//ul[@class = 'nav-links']//a[text() = 'Ô Tô'])[2]")).click();
        action.click(driver.findElement(By.xpath("(//div[@class = 'widget-html']//div[@class = 'widget-inner']//ul[@class = 'nav-links']//a[text() = 'Ô Tô'])[2]"))).perform();
    }

    //@Test
    public void TC_04_ClickAndHold() {

        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> numberall = driver.findElements(By.xpath("//ol/li[@class = 'ui-state-default ui-selectee']"));


        action.clickAndHold(numberall.get(0)).moveToElement(numberall.get(7)).release().perform();
        List<WebElement> choosenumber = driver.findElements(By.xpath("//ol/li[@class = 'ui-state-default ui-selectee ui-selected']"));
        for (WebElement layso : choosenumber) {
            Assert.assertTrue(layso.isDisplayed());
            System.out.println(layso.getText());
        }
        Assert.assertEquals(choosenumber.size(), 8);

    }

    //@Test
    public void TC_05_ClickRandom(){
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> numberall = driver.findElements(By.xpath("//ol/li[@class = 'ui-state-default ui-selectee']"));


        //nhấn phim control(ctrl)
        action.keyDown(Keys.CONTROL).perform();

        for (WebElement chonso: numberall) {
            action.click(chonso).perform();
        }
        //action.click(numberall.get(2)).perform();
        //action.click(numberall.get(7)).perform();

        //thả phím control (ctrl)
        action.keyUp(Keys.CONTROL).perform();

        List<WebElement> choosenumber = driver.findElements(By.xpath("//ol/li[@class = 'ui-state-default ui-selectee ui-selected']"));

        Assert.assertEquals(choosenumber.size(),12);
    }

    //@Test
    public void TC_06_DoubleClick(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        action.doubleClick(driver.findElement(By.xpath("//button[contains(text(),'Double click me')]"))).perform();

        Assert.assertEquals(driver.findElement(By.xpath("//p[text() = 'Hello Automation Guys!']")).getText(),"Hello Automation Guys!");
    }

    //@Test
    public void TC_07_RightClick(){
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        action.contextClick(driver.findElement(By.xpath("//span[text() = 'right click me']"))).perform();
        action.click(driver.findElement(By.xpath("//span[text() = 'Edit']"))).perform();
        //chờ alert xuất hiện
        alert = waitelement.until(ExpectedConditions.alertIsPresent());
        //in ra cái alert
        System.out.println(alert.getText());
        alert.accept();

        action.contextClick(driver.findElement(By.xpath("//span[text() = 'right click me']"))).perform();
        action.click(driver.findElement(By.xpath("//span[text() = 'Cut']"))).perform();
        System.out.println(alert.getText());
        alert.accept();
    }

    //@Test
    public void TC_08_KeoTha(){
        driver.get("https://automationfc.github.io/kendo-drag-drop/");

        WebElement vongtronnho = driver.findElement(By.xpath("//div[@id = 'draggable']"));
        WebElement vongtronto = driver.findElement(By.xpath("//div[@id = 'droptarget']"));

        action.dragAndDrop(vongtronnho,vongtronto).perform();

        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'You did great!')]")).getText(),"You did great!");

        //lay ra gia tri cssvalue màu
        String mau = vongtronto.getCssValue("background-color");
       System.out.println(mau);

       //chuyển đổi màu sang dạng hex và chuyeern thành viết thường
        String mauhexa = Color.fromString(mau).asHex().toLowerCase();
        Assert.assertEquals(mauhexa,"#03a9f4");

    }

    //@Test
    public void TC_09_KeoTha_HTML5_CSS() throws Exception{
        //chỉ work vs css
        driver.get("https://automationfc.github.io/drag-drop-html5/");
        String collumnA = "div#column-a";
        String collumnB = "div#column-b";

        String dragDropHelperContent = getContentFile(dragDropHelperPath);

        dragDropHelperContent = dragDropHelperContent + "$(\"" + collumnA + "\").simulateDragDrop({ dropTarget: \"" + collumnB + "\"});";
        // Drag and drop A to B
        getjava.executeScript(dragDropHelperContent);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"B");
        //Drag B to A
        getjava.executeScript(dragDropHelperContent);
    }

    @Test
    public void TC_10_KeoTha_HTML5_Xpath() throws Exception{
        //chỉ work vs css
        driver.get("https://automationfc.github.io/drag-drop-html5/");
        String collumnA = "//div[@id = 'column-a']";
        String collumnB = "//div[@id = 'column-b']";
        dragAndDropHTML5ByXpath(collumnA,collumnB);

        Assert.assertEquals(driver.findElement(By.xpath(collumnA)).getText(),"B");
        Assert.assertEquals(driver.findElement(By.xpath(collumnB)).getText(),"A");

    }

    public String getContentFile(String filePath) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(filePath);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            stream.close();
        }
    }

    public void dragAndDropHTML5ByXpath(String sourceLocator, String targetLocator) throws AWTException {

        WebElement source = driver.findElement(By.xpath(sourceLocator));
        WebElement target = driver.findElement(By.xpath(targetLocator));

        // Setup robot
        Robot robot = new Robot();
        robot.setAutoDelay(500);

        // Get size of elements
        Dimension sourceSize = source.getSize();
        Dimension targetSize = target.getSize();

        // Get center distance
        int xCentreSource = sourceSize.width / 2;
        int yCentreSource = sourceSize.height / 2;
        int xCentreTarget = targetSize.width / 2;
        int yCentreTarget = targetSize.height / 2;

        Point sourceLocation = source.getLocation();
        Point targetLocation = target.getLocation();
        System.out.println(sourceLocation.toString());
        System.out.println(targetLocation.toString());

        // Make Mouse coordinate center of element
        sourceLocation.x += 20 + xCentreSource;
        sourceLocation.y += 110 + yCentreSource;
        targetLocation.x += 20 + xCentreTarget;
        targetLocation.y += 110 + yCentreTarget;

        System.out.println(sourceLocation.toString());
        System.out.println(targetLocation.toString());

        // Move mouse to drag from location
        robot.mouseMove(sourceLocation.x, sourceLocation.y);

        // Click and drag
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x, ((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);

        // Move to final position
        robot.mouseMove(targetLocation.x, targetLocation.y);

        // Drop
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
}
