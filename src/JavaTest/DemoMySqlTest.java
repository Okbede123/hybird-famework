package JavaTest;

import src2.cores.ultilities.MySQLConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoMySqlTest {

    public static Connection getMyConnection(){
        return MySQLConnUtils.getMySQLConnection();
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("get connection...");

        //lấy ra đối tượng connection kết nối vào db

        Connection connection = DemoMySqlTest.getMyConnection();
        System.out.println("opened connection " + connection);

        Statement statement = connection.createStatement();

        String sql = "Select Emp.Emp_Id,Emp.First_Name,Emp.Last_Name,Emp.Dept_Id From Employee Emp";

        //thực thi câu lệnh sql trả về đối tượng ResultSet
        ResultSet resultSet = statement.executeQuery(sql);

        //duyệt kết quả trả về
        while (resultSet.next()){
            //di chuyển con trỏ xuống  bản ghi kế tiếp
            int empld = resultSet.getInt(1);
            String empFirstName = resultSet.getString(2);
            String emLastName = resultSet.getString("Last_Name");

            System.out.println("------------");
            System.out.println("Emp id: " + empld);
            System.out.println("Emp FirstName: " + empFirstName);
            System.out.println("Emp LastName: " + emLastName);
        }

        //đóng kết nối
        connection.close();
        System.out.println("-------------Closed connection--------------");
    }
}
