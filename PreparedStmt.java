import java.sql.*;
import java.util.Scanner;

public class PreparedStmt {
    public static void main(String [] args) throws SQLException
    {
        Scanner sc=new Scanner(System.in);
        com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(d);
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Deva");

        if(cn!=null)
        {
            System.out.println("1.Create table");
            System.out.println("2.Insert Data");
            System.out.println("3.Delete data");
            System.out.println("4.Update data");
            System.out.println("5.Show data");
            System.out.println("Enter your choice.");
            int c=sc.nextInt();
            switch(c)
            {
                case 1:
                    Statement ct=cn.createStatement();
                    int cr=ct.executeUpdate("create table emp(id int(10) primary key auto_increment,name varchar(50),email varchar(50),contact varchar(10))");
                 //   System.out.println(cr);
                    if(cr>0)
                    {
                        System.out.println("table created successfully");
                    }
                    else
                    {
                        System.out.println("table creation failed");
                    }
                    break;
                case 2:
                    System.out.println("Enter Name email and phone number:");
                    int num=sc.nextInt();
                    String name=sc.next();
                    String email=sc.next();

                    PreparedStatement pst=cn.prepareStatement("insert into jdbc values(?,?,?)");
                    pst.setString(1,name);
                    pst.setString(2,email);
                    pst.setInt(3,num);
                    int val= pst.executeUpdate();
                    if(val>0)
                    {
                        System.out.println("Record inserted...");
                    }
                    else {
                        System.out.println("Insertion failed");
                    }
                    break;
               case 3:
                    System.out.println("Enter name to delete record");
                    String nm=sc.next();
                    PreparedStatement pt=cn.prepareStatement("delete from jdbc where email=?");
                    pt.setString(1,nm);
                    int va= pt.executeUpdate();
                    if(va>0)
                    {
                        System.out.println("Record deleted...");
                    }
                    else {
                        System.out.println("Deletion failed");
                    }
                    break;
                case 4:
                    System.out.println("Enter name email and contact for update");

                    String nam=sc.next();
                    String eml=sc.next();
                    int nu=sc.nextInt();
                    PreparedStatement ups=cn.prepareStatement("update jdbc set email=?,number=? where name=?");
                    ups.setString(1,eml);
                    ups.setInt(2,nu);
                    ups.setString(3,nam);
                    int r=ups.executeUpdate();
                    if(r>0)
                    {
                        System.out.println("Data updated successfully");
                    }
                    else
                    {
                        System.out.println("Updation failed");
                    }
                    break;
                case 5:
                    PreparedStatement spt=cn.prepareStatement("select * from jdbc");
                    ResultSet rs=spt.executeQuery();
                    while (rs.next())
                    {
                        System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
                    }
                    break;
                default:
                    System.out.println("Wrong choice...");

                    break;
            }

        }
        else
        {
            System.out.println("Connection failed");
        }
    }
}
