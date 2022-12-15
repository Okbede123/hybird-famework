package TestNG;

import org.testng.annotations.Test;

public class DemoGroupTestNg {

    @Test(priority = 1,description = "test2")
    public void TC_01_(){
        System.out.println("1");
    }
    @Test(priority = 2,description = "test1")
    public void TC_02_(){
        System.out.println("2");
    }
    @Test(priority = 3)
    public void TC_03_(){
        System.out.println("3");
    }
    @Test(priority = 4)
    public void TC_04_(){
        System.out.println("4");
    }
}
