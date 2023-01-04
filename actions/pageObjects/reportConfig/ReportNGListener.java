package src2.actions.pageObjects.reportConfig;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import src2.cores.commons.BaseTest;
import src2.cores.commons.GlobalConstants;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportNGListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        //để là false để hiển thị thành ảnh, nếu true sẽ hiển thị dạng text
        System.setProperty("org.uncommons.reportng.escape-output", "false");

        //lấy driver ra
        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();

        //chụp hình
        String screenshotPath = captureScreenshot(webDriver, result.getName());
        //trạng thái của testcase pass/fail/skip
        Reporter.getCurrentTestResult();
        Reporter.log("<br><a target=\"_blank\" href=\"file:///" + screenshotPath + "\">" + "<img src=\"file:///" + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
        Reporter.setCurrentTestResult(null);

    }

//    public void onTestFailure(ITestResult result) {
//
//        //để là false để hiển thị thành ảnh, nếu true sẽ hiển thị dạng text
//        System.setProperty("org.uncommons.reportng.escape-output", "false");
//
//        //lấy driver ra
//        Object testClass = result.getInstance();
//        WebDriver webDriver = ((BaseTest) testClass).getDriver();
//
//        //chụp hình
//        String screenshotPath = captureScreenshot_Base64(webDriver, result.getName());
//        //trạng thái của testcase pass/fail/skip
//        Reporter.getCurrentTestResult();
//        //Reporter.log("<br><a target=\"_blank\" href=\"file:///" + screenshotPath + "\">" + "<img src=\"file:///" + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
//        Reporter.log("<br><a target=\"_blank\" href=\"data:image/png;base64," + screenshotPath + "\">" + "<img src=\"data:image/png;base64," + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
//        Reporter.setCurrentTestResult(null);
//
//    }

    public String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenPath = GlobalConstants.REPORTNG_PATH + screenshotName + "_" + formater.format(calendar.getTime()) + ".png";
            FileUtils.copyFile(source, new File(screenPath));
            return screenPath;
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
            return e.getMessage();
        }
    }

    public String captureScreenshot_Base64(WebDriver driver, String screenshotName) {
        String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        return screenshotBase64;
    }
}
