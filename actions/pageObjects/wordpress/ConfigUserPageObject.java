package src2.actions.pageObjects.wordpress;

import org.openqa.selenium.WebDriver;
import src2.cores.ultilities.MySQLConnUtils;
import src2.interrface.UI.wordpress.ConfigUserPageUI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConfigUserPageObject extends MenuAdminNavigation {

    WebDriver driver;
    public ConfigUserPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public int getNumberUserAdmin(){
        String text = getElementTextLocator(driver,ConfigUserPageUI.NUMBER_USER_ADMIN).replace(" items","");
        Integer getNumber = Integer.parseInt(text);
        return getNumber;
    }

    public int getNumberUserDb(){
        Connection connection = MySQLConnUtils.getMySQLConnection();
        Statement statement;
        List<Integer> totalUsers = new ArrayList<Integer>();
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM wp_users";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int userID = resultSet.getInt(1);
                totalUsers.add(userID);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(connection != null){
                    connection.close();
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return totalUsers.size();
    }
}
