import java.sql.*;

public class Select {
    public static void main(String[] args) throws SQLException
    {
        com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(d);
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Deva");
        if(cn!=null)
        {
            Statement stmt=cn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from jdbc");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
            }
        }
        else {
            System.out.println("Connection failed");
        }

    }
}
