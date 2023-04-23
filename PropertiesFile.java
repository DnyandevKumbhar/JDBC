/*Q3. WA to create .properties files and load database credential */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.sql.*;

public class PropertiesFile {
    public static void main(String[] args)throws SQLException,ClassNotFoundException, IOException
    {
        FileInputStream fi=new FileInputStream("G:\\C_giri's tech hub\\JAVA_Prog\\cre.properties");
        Properties p=new Properties();
        p.load(fi);
        String d=p.getProperty("driver");
        String url=p.getProperty("url");
        String uname=p.getProperty("username");
        String pass=p.getProperty("password");
        Class.forName(d);
        Connection cn=DriverManager.getConnection(url,uname,pass);
        if(cn!=null)
        {
            System.out.println("Connected");
        }
        else {
            System.out.println("Connection failed");
        }
    }

}
