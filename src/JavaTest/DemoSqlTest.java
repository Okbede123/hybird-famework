package JavaTest;

import src2.cores.ultilities.SQLConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoSqlTest {
    public static Connection getMyConnection(){
        return SQLConnUtils.getSQLServerConnection();
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("Get connection...");

        //lấy đối tuong connection  ket noi vao db

        Connection connection = SQLConnUtils.getSQLServerConnection();
        System.out.println("Opened connection" + connection);
        Statement statement = connection.createStatement();
        //phải chọn dataname , bảng, và table
        String sql = "SELECT * FROM [automationtest].[dbo].[Product_Type];";

        //Thực thi câu lệnh sql trả về đôi tượng resultSet

        ResultSet resultSet = statement.executeQuery(sql);

        //duyet ket qua tra ve
        while (resultSet.next()){
            //di chuyển con trỏ xuống bản ghi kế tiếp
            String empFirstName = resultSet.getString(1);
            String empLastName = resultSet.getString("NAME");
            System.out.println("-----------------");
            System.out.println("Emp FirstName:" + empFirstName);
            System.out.println("Emp LastName: " + empLastName);
        }

        connection.close();
        System.out.println("------------Close--------------");

    }
}
