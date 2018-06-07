package com.pms.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DBConnection {

    static Connection con = null;
    public static Connection getConnection() 
    {
        if(con==null)
        {
            try 
            {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pmsdb", "root","");
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, "Connection ERROR");
                System.out.println("Connecton error");
                e.printStackTrace();
            }
            return con;
        }
        else
        {
            return con;
        }
    }

  
    public static void main(String[] args) {
    getConnection();
   
    }
}