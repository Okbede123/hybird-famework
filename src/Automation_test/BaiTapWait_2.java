package Automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BaiTapWait_2 {
    WebDriver driver;
    WebDriverWait webDriverWait;
    JavascriptExecutor getjava;
    KhoiTaoDriver khoiTaoDriver = new KhoiTaoDriver();



    String doidau = File.separator;

    String folderFile = khoiTaoDriver.getProperty + doidau + "out" + doidau + "UpLoadFiles" + doidau;

    String file1 = "demo1.png";
    String file2 = "demo2.jpg";
    String file3 = "demo3.jpg";

    String locationFile1 = folderFile+file1;
    String locationFile2 = folderFile+file2;
    String locationFile3 = folderFile+file3;

    @BeforeClass
    public void BeforeClass(){
        //System.getProperty(khoiTaoDriver.getProperty);

        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //@Test
    public void TC_01(){
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'contentWrapper']")));
        System.out.println(driver.findElement(By.xpath("//span[text() = 'No Selected Dates to display.']")).getText());
        driver.findElement(By.xpath("//span[@class = 'rcTitle']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'rcMain']//table")));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@id = 'rcMView_PrevY']")));
        driver.findElement(By.xpath("//td[@id = 'rcMView_PrevY']")).click();
        driver.findElement(By.xpath("//td[@id = 'rcMView_PrevY']")).click();
        driver.findElement(By.xpath("//td[@id = 'rcMView_PrevY']")).click();
        driver.findElement(By.xpath("//td[@id = 'rcMView_1997']")).click();
        driver.findElement(By.xpath("//td[@id = 'rcMView_Jun']")).click();
        driver.findElement(By.xpath("//a[@id = 'rcMView_OK']")).click();
        WebElement bienMatLoading = driver.findElement(By.xpath("//div[@class = 'RadAjax RadAjax_Silk' and contains(@id,'ctl00_ContentPlaceholder1_RadAjaxLoadingPanel1c')]/div[@class = 'raDiv']"));
        webDriverWait.until(ExpectedConditions.stalenessOf(bienMatLoading));
        driver.findElement(By.xpath("//td/a[text() = '19']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class = 'rcSelected']")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Thursday, June 19, 1997')]")));
        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Thursday, June 19, 1997')]")).getText(),"Thursday, June 19, 1997");
    }

    @Test
    public void TC_02(){

        //List<By> download = (List<By>) By.xpath("//span[text() = 'Download']");
        driver.get("https://gofile.io/uploadFiles");
        System.out.println(folderFile );
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'col-sm-auto']/button")));
        driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys(locationFile1 + "\n" + locationFile2 + "\n" + locationFile3);

        List<WebElement> loadingbar = driver.findElements(By.xpath("//div[@class = 'progress position-relative mt-1']"));
        for (WebElement getloading:loadingbar) {
            webDriverWait.until(ExpectedConditions.stalenessOf(getloading));
        }
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Your files have been successfully uploaded')]")));

        driver.findElement(By.xpath("//a[@id = 'rowUploadSuccess-downloadPage']")).click();

        String idhientaiwindow = driver.getWindowHandle();
        Set<String> windowtabs = driver.getWindowHandles();
//        Object[] list = windowtabs.toArray();
//        for (int i = 0; i < list.length; i++) {
//            driver.switchTo().window((String) list[1]);
//            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id = 'rowFolder-folderName']")));
//            Assert.assertTrue(driver.findElement(By.xpath("//span[@id = 'rowFolder-folderName']")).isDisplayed());
//            List<WebElement> download = driver.findElements(By.xpath("//span[text() = 'Download']"));
//            for (WebElement getdownload:download) {
//                Assert.assertTrue(getdownload.isDisplayed());
//            }
//
//        }

//        ArrayList<String> test = new ArrayList<>();
//        for (String getdowwnload: windowtabs) {
//            test.add(getdowwnload);
//        }
//
//        driver.switchTo().window(test.get(1));
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id = 'rowFolder-folderName']")));
//        Assert.assertTrue(driver.findElement(By.xpath("//span[@id = 'rowFolder-folderName']")).isDisplayed());
//        for (String laylisst: test) {
//            driver.switchTo().window(test.)
//
//        }
        for (String id: windowtabs) {

            if(!id.equals(idhientaiwindow)){
                driver.switchTo().window(id);
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id = 'rowFolder-folderName']")));
                Assert.assertTrue(driver.findElement(By.xpath("//span[@id = 'rowFolder-folderName']")).isDisplayed());
            }
        }

    }
}
