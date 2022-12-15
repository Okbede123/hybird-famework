import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Scanner;

public class DemoFifeFox_Chorme {
    WebDriver driver;

    public static void main(String[] args) {
        DemoFifeFox_Chorme khoitao = new DemoFifeFox_Chorme();
        khoitao.GetUrl();
    }

    public void GetUrl() {
        Scanner sc = new Scanner(System.in);
        System.out.println("chay fifefox hay chomre");
        int choose = sc.nextInt();
        switch (choose) {
            case 0: {
                driver = new FirefoxDriver();
                break;
            }
            case 1: {
                driver = new ChromeDriver();
                break;
            }
            default: {
                GetUrl();
                break;
            }
            //System.out.println("khong co su lua chon khac");

        }
        System.out.println("dang chay");
        driver.get("https://dantri.com.vn/");
    }
}
//    public void GetUrl2(){
//        Scanner sc2 = new Scanner(System.in);
//        System.out.println("moi chon lai");
//        int choose = sc2.nextInt();
//        switch (choose){
//            case 0:{
//                driver = new FirefoxDriver() ;
//                break;
//            }
//            case 1: driver = new ChromeDriver();
//            default:GetUrl2();
//                //System.out.println("khong co su lua chon khac");
//
//        }
//        driver.get("https://dantri.com.vn/");
//    }
//}
