package JavaTest.DemoSoftAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TC_01(){
        String name = "tester";
        AssertEqual(name,"tester");
        name = "homnay";
        AssertEqual(name,"test2");
        name = "homkia";
        AssertEqual(name,"test24");

    }
    //@Test
    public void TC_02(){
        String name = "autotester";
        softAssert.assertEquals(name,"htttester");
        softAssert.assertAll();
    }
    @Test
    public void TC_03(){
        String name = "autotester";
        AssertEqual(name,"test");
    }

    @Test
    public void TC_04(){
        int test = 5;
        String test2 = "okbede";
       boolean check = test == 54;
       AssertTrue(check);

        check = test == 154;

        AssertTrue(check);
    }

    public boolean AssertEqual(Object actual,Object expected){
        boolean check = true;
        try {
            Assert.assertEquals(actual,expected);
        }catch (Throwable sai){
            check = false;
            System.out.println("sai");
        }
        return check;
    }

    public void AssertTrue(boolean actual){
        try {
            Assert.assertTrue(actual);
        }catch (Exception sai){
            System.out.println(sai);
        }
    }
}
