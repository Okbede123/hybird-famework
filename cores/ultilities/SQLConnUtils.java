package src2.cores.ultilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnUtils {
    public static Connection getSQLServerConnection(){
        String hostName = "localhost";
        String sqlInstanceName = "SQLEXPRESS";
        String database = "automationtest";
        String userName = "sa";
        String password = "halong123";
        return getSQLServerConnection(hostName,sqlInstanceName,database,userName,password);
    }

    public static Connection getSQLServerConnection(String hostName,String sqlInstanceName,String database,String userName,String password){
        Connection connection = null;
        try {
            String connectionURL = "jdbc:sqlserver://"+ hostName+":1433" + ";instance="+ sqlInstanceName+";databaseName="+database;
            connection = DriverManager.getConnection(connectionURL,userName,password);
        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}
