package DButils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection getConnect(){
        String driver="com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/user?characterEncoding=UTF-8";
        String user = "root";
        String password = "root";
      try {
          Class.forName(driver);
          return DriverManager.getConnection(url,user,password);
      }catch (Exception e){
          e.printStackTrace();
      }
      return null;
    }

    public static void close(Connection connection){
        if (connection!=null){
            try {
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
