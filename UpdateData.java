import java.sql.*;
import java.util.*;
public class UpdateData {
    public static void main(String[] args) throws SQLException
    {
        com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(d);
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Deva");
        if (cn!=null)
        {
            Statement stmt=cn.createStatement();
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter name email and phone number to update data:");
            String nm=sc.nextLine();
            String e=sc.nextLine();
            int n=sc.nextInt();
            int val=stmt.executeUpdate("update jdbc set email='"+e+"',number="+n+" where name='"+nm+"'");
            if(val>0)
            {
                System.out.println("Data updated Successfully:");
            }
            else {
                System.out.println("Something went wrong...!");
            }
        }
        else {
            System.out.println("Connection failed.");
        }

    }

}
