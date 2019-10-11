package db;

import java.sql.*;
import javax.swing.*;

public class DbConnect {
    static public Statement st;
    static public Connection c;
    static public PreparedStatement insertClient;
    static public PreparedStatement getUser;
    static public PreparedStatement updateUser;
    static public PreparedStatement insertUser;
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/clientsoldb","root","kripanand");
            st=c.createStatement();
            insertClient=c.prepareStatement("insert into admin_login(name,gender,dob,country,address,language)values(?,?,?,?,?,?)");
            getUser=c.prepareStatement("select * from admin_login where name like ?");
            updateUser=c.prepareStatement("update admin_login set name=?,gender=?,dob=?,country=?,address=?,language=? where cid=?");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}

   