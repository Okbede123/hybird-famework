package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoTestNGMultiple_Server {



    //parameter dùng để check multi server. xem ở file demoTestNGparameterMultiserver
    //nếu value là DEV thì in ra dev
    //nếu value là LIVE thì in ra live
    @Parameters("server")
    @Test
    public void TC_01(String serverName){
        String duyetsv = getServerName(serverName);
        System.out.println(duyetsv);

    }

    //hàm duyệt môi trường
    private String getServerName(String svname){
        switch (svname){
            case "DEV":{
                svname = "day la mt dev";
                break;
            }
            case "LIVE":{
                svname = "day la my live";
                break;
            }

            default:{
                System.out.println("sai");
                break;
            }
        }
        return svname;
    }
}
