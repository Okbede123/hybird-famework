import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoDangKyFacebook{
    WebDriver driver;
    
    public static void main(String[] args) {
        String testthu = System.getProperty("user.dir");
        System.setProperty("webdrive.chrome.driver",testthu + "\\chromedriver.exe");
        demoDangKyFacebook so1 = new demoDangKyFacebook();
        so1.TestCaseTaikhoanMatKhau("0563886668","okbedenb64","009896");


    }
    public void TestCaseTaikhoanMatKhau(String taikhoan,String matkhau,String maxacthuc){

//        boolean kiemtra = true;
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1366,768));
//        sleepWait(3);
//        WebElement element = driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']"));
//        element.click();
//        if(element.isDisplayed()){
//            System.out.println(kiemtra);
//        }
        sleepWait(3);
        driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys(taikhoan);
        driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys(matkhau);
        driver.findElement(By.xpath("//button[@name= 'login']")).click();
//        WebElement element = driver.findElement(By.xpath("//input[@type = 'text']"));
//
//        if(element.isDisplayed()){
//            element.sendKeys(maxacthuc);
//            driver.findElement(By.xpath("//button[@value = 'Tiếp tục']")).click();
//            driver.findElement(By.xpath("//input[@value = 'dont_save']")).click();
//            driver.findElement(By.xpath("//button[@value = 'Tiếp tục']")).click();
//        }

        WebElement element2 = driver.findElement(By.cssSelector("div[id = 'error_box']"));
        if(element2.isDisplayed()){
            System.out.println("mat khau da bi doi");
        }

        //driver.findElement(By.xpath("//button[@name= 'websubmit']")).click();

    }

    public void sleepWait(long x){
        try {
            Thread.sleep(x* 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
