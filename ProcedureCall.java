import java.sql.*;
import java.util.*;

public class ProcedureCall {
    public static void main(String[] args) throws SQLException
    {
        Scanner sc=new Scanner(System.in);
        com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(d);
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Deva");
        if(cn!=null)
        {
            System.out.println("1.Insert Data.");
            System.out.println("2.Show data.");
            System.out.println("Enter your choice:");
            int c=sc.nextInt();
            CallableStatement cs;
            switch (c)
            {
                case 1:
                    cs=cn.prepareCall("{call inacc(?,?,?)}");
                    cs.setInt(1,2);
                    cs.setString(2,"vijay");
                    cs.setInt(3,15000);
                    if(!cs.execute())
                    {
                        System.out.println("Procedure executed.");
                    }
                    else
                    {
                        System.out.println("Procedure execution failed..");
                    }
                    break;
                case 2:
                    cs=cn.prepareCall("{call slt(?,?,?)}");
//                    cs.getInt(1);
//                    cs.getString(2);
//                    cs.getInt(3);
                    ResultSet res=cs.executeQuery();
                    while (res.next())
                    {
                        System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getInt(3));
                    }
                    break;
                default:
                    break;

            }

        }
        else {
            System.out.println("Connection failed");
        }
    }
}
