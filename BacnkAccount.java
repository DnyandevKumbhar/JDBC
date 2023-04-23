import java.sql.*;
import java.util.*;

public class BacnkAccount {
    public static void main(String[] args) throws SQLException
    {
        com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(d);
        Scanner sc=new Scanner(System.in);
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Deva");
        if(cn!=null)
        {
            System.out.println("1.Add account.");
            System.out.println("2.Deposit amount into account.");
            System.out.println("3.Withdraw amount from account.");
            System.out.println("4.view all users.");
            System.out.println("5.Account closure.");
            System.out.println("6.Balance enquiry.");
            System.out.println("Enter your choice:");
            int c=sc.nextInt();
            switch (c)
            {
                case 1:
                    System.out.println("Enter Account number name and balance:");
                    int n=sc.nextInt();
                    String nm=sc.next();
                    int bal=sc.nextInt();
                    PreparedStatement p=cn.prepareStatement("insert into acc values(?,?,?)");
                    p.setInt(1,n);
                    p.setString(2,nm);
                    p.setInt(3,bal);
                    int r=p.executeUpdate();
                    if(r>0)
                    {
                        System.out.println("Data inserted successfully.");
                    }
                    else
                    {
                        System.out.println("Insertion failed.");
                    }
                    break;
                case 2:
                    System.out.println("Enter account number and deposit amount:");
                    int ac=sc.nextInt();
                    int da=sc.nextInt();
                    PreparedStatement gd=cn.prepareStatement("select balance from acc where A_C_no=?");
                    gd.setInt(1,ac);
                    ResultSet rs=gd.executeQuery();
                    int pb=0;
                    while (rs.next())
                   {
                         pb=(rs.getInt(1));
                       // System.out.println(pb);
                   }
                    int tb=pb+da;
                    PreparedStatement dp=cn.prepareStatement("update acc set balance=? where A_C_no=?");
                    dp.setInt(1,tb);
                    dp.setInt(2,ac);
                    int rd=dp.executeUpdate();
                    if(rd>0)
                    {
                        System.out.println("Amount deposited successfully");
                    }
                    else
                    {
                        System.out.println("Deposite failed");
                    }
                    break;
                case 3:
                    System.out.println("Enter account number and amount:");
                    int aw=sc.nextInt();
                    int wa=sc.nextInt();
                    PreparedStatement wd=cn.prepareStatement("select balance from acc where A_C_no=?");
                    wd.setInt(1,aw);
                    ResultSet ws=wd.executeQuery();
                    int wb=0;
                    while (ws.next())
                    {
                        wb=(ws.getInt(1));
                    }
                    int twb=wb-wa;
                    PreparedStatement wp=cn.prepareStatement("update acc set balance=? where A_C_no=?");
                    wp.setInt(1,twb);
                    wp.setInt(2,aw);
                    int ew=wp.executeUpdate();
                    if(ew>0)
                    {
                        System.out.println("Amount withdraw successfully");
                    }
                    else
                    {
                        System.out.println("Withdraw failed");
                    }
                    break;
                case 4:
                    PreparedStatement s=cn.prepareStatement("select * from acc");
                    ResultSet sr=s.executeQuery();
                    while (sr.next())
                    {
                        System.out.println(sr.getInt(1)+"\t"+sr.getString(2)+"\t"+sr.getInt(3));
                    }
                    break;
                case 5:
                    System.out.println("Enter Account number for account closure:");
                    int acc=sc.nextInt();
                    PreparedStatement cps=cn.prepareStatement("delete from acc where A_C_no=?");
                    cps.setInt(1,acc);
                    int cl=cps.executeUpdate();
                    if(cl>0)
                    {
                        System.out.println("Account closed successfully");
                    }
                    else {
                        System.out.println("Account closure failed.");
                    }

                    break;
                case 6:
                    System.out.println("Enter account number for balance enquiry:");
                    int e=sc.nextInt();
                    PreparedStatement eps=cn.prepareStatement("select balance from acc where A_C_no=?");
                    eps.setInt(1,e);
                    ResultSet ers=eps.executeQuery();
                    while (ers.next())
                    {
                        System.out.println("Your total balance is:\t"+ers.getInt(1));
                    }
                    break;
                default:
                    break;

            }

        }
        else
        {
            System.out.println("Connection failed");
        }

    }
}

