package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTestNG_Depend {

    //dependsOnMethods dùng để truy xuất dữ liệu, ví dụ tc_01 liên quan đến tc02,tc03,tc04
    //nếu tc01 fail, các testcasse đánh (dependsOnMethods = "TC_01") liên quan dến tc01 sẽ ko chạy
    //riêng tc_04 liên quan đén cả 2 tc01 và 03
    @Test
    public void TC_01(){
        Assert.assertTrue(false);
    }
    @Test(dependsOnMethods = "TC_01")
    public void TC_02(){

    }
    @Test(dependsOnMethods = "TC_01")
    public void TC_03(){

    }
    @Test(dependsOnMethods = {"TC_01","TC_03"})
    public void TC_04(){

    }

}
