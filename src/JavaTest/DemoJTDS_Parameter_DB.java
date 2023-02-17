package JavaTest;

import src2.cores.ultilities.SQLServerJTDSConnUtils;

import java.sql.*;

public class DemoJTDS_Parameter_DB {

    public static Connection getMyConnection(){
        return SQLServerJTDSConnUtils.getSQLServerConnection();
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("Get connection...");

        //lấy đối tuong connection  ket noi vao db

        Connection connection = SQLServerJTDSConnUtils.getSQLServerConnection();
        System.out.println("Opened connection" + connection);
        Statement statement = connection.createStatement();
        //phải chọn dataname , bảng, và table
        String sql = "SELECT * FROM [automationtest].[dbo].[Product_Type];";
        String paramSql = "SELECT EMP_ID,END_DATE,TITLE,FIRST_NAME FROM EMPLOYEE  WHERE TITLE like ? and EMP_ID = ?;";

        //Thực thi câu lệnh sql trả về đôi tượng resultSet

//        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement preparedStatement = connection.prepareStatement(paramSql);
        preparedStatement.setString(1,"%ent");
        preparedStatement.setInt(2,2);

        ResultSet resultSet =  preparedStatement.executeQuery();

        //duyet ket qua tra ve
        while (resultSet.next()){
            //di chuyển con trỏ xuống bản ghi kế tiếp
            System.out.println(resultSet.getInt("EMP_ID"));
            System.out.println(resultSet.getString("END_DATE"));
            System.out.println(resultSet.getString("TITLE"));
            System.out.println(resultSet.getString("FIRST_NAME"));
        }

        connection.close();
        System.out.println("------------Close--------------");

    }
}
