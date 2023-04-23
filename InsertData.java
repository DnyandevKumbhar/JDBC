import java.sql.SQLException;
import java.sql.*;
import java.util.*;


public class InsertData {

    public static void main(String[] args) throws SQLException
    {
        com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(d);
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Deva");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Name email and phone number:");
        String name=sc.nextLine();
        String email=sc.next();
        int num=sc.nextInt();
        if(cn!=null)
        {
            Statement stmt=cn.createStatement();
            int val=stmt.executeUpdate("insert into jdbc values('"+name+"','"+email+"',"+num+")");
            if(val>0)
            {
                System.out.println("Record inserted successfully");
            }
            else
            {
                System.out.println("Some problem occuerd");
            }
        }
        else
        {
            System.out.println("Not connected");
        }
    }
}
