import java.sql.SQLException;
import java.sql.*;
import java.util.*;


public class DeleteData {
    public static void main(String[] args) throws SQLException
    {
        com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(d);
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Deva");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name for delete record:");
        String name=sc.nextLine();
        if(cn!=null)
        {
            Statement stmt=cn.createStatement();
            int val=stmt.executeUpdate("delete from jdbc where name='"+name+"'");
            if(val>0)
            {
                System.out.println("Data deleted succesfully");
            }
            else
            {
                System.out.println("Data not deleted");
            }
        }
        else
        {
            System.out.println("Connection failed...");
        }
    }
}
