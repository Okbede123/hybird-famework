package src2.cores.ultilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerJTDSConnUtils {

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
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String connectionURL = "jdbc:jtds:sqlserver://"+ hostName+":1433/"+ database +";instance="+sqlInstanceName;
            connection = DriverManager.getConnection(connectionURL,userName,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
