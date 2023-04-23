/*Q2. WA to store student data in student table using .csv file and store 100 records in database table.*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class Student100 {
    public static void main(String[] args) throws SQLException,ClassNotFoundException, IOException
    {
       // com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
        Class.forName("com.mysql.cj.jdbc.Driver");
       // DriverManager.registerDriver(d);
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Deva");
        if(cn!=null)
        {
            FileReader f=new FileReader("G:\\C_giri's tech hub\\JAVA_Prog\\sturec.csv");
            BufferedReader br=new BufferedReader(f);
            String line;
            boolean b=false;
            while ((line=br.readLine())!=null)
            {
                String col[]=line.split(",");
                PreparedStatement pt=cn.prepareStatement("insert into stu values(?,?,?,?)");
                pt.setString(1,col[0]);
                pt.setString(2,col[1]);
                pt.setString(3,col[2]);
                pt.setString(4,col[3]);
                int r=pt.executeUpdate();
                if(r>0)
                {
                      b=true;
                }
            }
        if(b)
        {
            System.out.println("File loaded succesfully.");
        }
        else
        {
            System.out.println("failed file loading");
        }
    }
    }
}
