package JavaTest;

import src2.cores.ultilities.MySQLConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DemoMySqlTest {

    public static Connection getMyConnection(){
        return MySQLConnUtils.getMySQLConnection();
    }

    public static void openDbAndCheck() throws SQLException {
        ArrayList<String> getUserLogin = new ArrayList<>();
        System.out.println("get connection...");

        //lấy ra đối tượng connection kết nối vào db

        Connection connection = DemoMySqlTest.getMyConnection();
        System.out.println("opened connection " + connection);

        Statement statement = connection.createStatement();

        String sql = "Select * from wp_users";

        //thực thi câu lệnh sql trả về đối tượng ResultSet
        ResultSet resultSet = statement.executeQuery(sql);

        //duyệt kết quả trả về
        while (resultSet.next()){
            //di chuyển con trỏ xuống  bản ghi kế tiếp
            int userId = resultSet.getInt(1);
            String userLogin = resultSet.getString(2);
            String userEmail = resultSet.getString("user_email");

            System.out.println("------------");
            System.out.println("Emp id: " + userId);
            System.out.println("Emp userLogin: " + userLogin);
            System.out.println("Emp Email: " + userEmail);
            getUserLogin.add(userEmail);
        }


        //đóng kết nối
        connection.close();
        System.out.println("-------------Closed connection--------------");
    }

//    public static void main(String[] args) throws SQLException {
//        ArrayList<String> getUserLogin = new ArrayList<>();
//        System.out.println("get connection...");
//
//        //lấy ra đối tượng connection kết nối vào db
//
//        Connection connection = DemoMySqlTest.getMyConnection();
//        System.out.println("opened connection " + connection);
//
//        Statement statement = connection.createStatement();
//
//        String sql = "Select * from wp_users";
//
//        //thực thi câu lệnh sql trả về đối tượng ResultSet
//        ResultSet resultSet = statement.executeQuery(sql);
//
//        //duyệt kết quả trả về
//        while (resultSet.next()){
//            //di chuyển con trỏ xuống  bản ghi kế tiếp
//            int userId = resultSet.getInt(1);
//            String userLogin = resultSet.getString(2);
//            String userEmail = resultSet.getString("user_email");
//
//            System.out.println("------------");
//            System.out.println("Emp id: " + userId);
//            System.out.println("Emp userLogin: " + userLogin);
//            System.out.println("Emp Email: " + userEmail);
//            getUserLogin.add(userEmail);
//        }
//
//
//        getListUserAdminFromDb(getUserLogin);
//        //đóng kết nối
//        connection.close();
//        System.out.println("-------------Closed connection--------------");
//    }

    public static int getListUserAdminFromDb() throws SQLException{
        ArrayList<String> getUserLogin = new ArrayList<>();
        Connection connection = DemoMySqlTest.getMyConnection();

        Statement statement = connection.createStatement();

        String sql = "Select * from wp_users";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            String userLogin = resultSet.getString(2);
            getUserLogin.add(userLogin);
        }
        return getUserLogin.size();
    }
}
