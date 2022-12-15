package TestNG;

import org.testng.annotations.*;

public class DemoTestNg {

    @BeforeClass
    public void BeforeClass(){
        System.out.println("BeforeClass");
    }
    @Test
    public void AfterClass(){
        System.out.println("AfterClass");
    }
    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("BeforeSuite");
    }
    @AfterSuite
    public void AfterSuite(){
        System.out.println("AfterSuite");
    }
    @BeforeTest
    public void BeforeTest(){
        System.out.println("Before Test");
    }
    @AfterTest
    public void AfterTest(){
        System.out.println("After Test");
    }
    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public void AfterMethod(){
        System.out.println("After Method");
    }
    @Test(groups = "user")
    public void Register(){
        System.out.println("test register");
    }

    @Test(groups = "user")
    public void Login(){
        System.out.println("test login");
    }
}
