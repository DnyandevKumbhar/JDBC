import java.sql.SQLException;
import java.sql.*;

public class JdbcConnectio {
    public static void main(String[] args) throws SQLException
    {
        com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(d);
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Deva");
        if(cn!=null)
        {
            System.out.println("Connetcted");
        }
        else
        {
            System.out.println("Not connected");
        }
    }
}
