package TestNG_Listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportListener implements ITestListener {

    //sau đó implements ITestListener vào và viết lại hàm onTestFailure của nó và mang sang bên DEemo_Register dùng
    public void onTestFailure(ITestResult result){
        //khi test case chạy nếu fail sẽ in ra chữ test skip
        System.out.println("test skip");
    }

}
