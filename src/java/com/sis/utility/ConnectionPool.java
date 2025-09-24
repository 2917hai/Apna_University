/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Umesh Yadav
 */
public class ConnectionPool {
    
    static  Connection conn;
    public static Connection ConnectDB()
    {
         String url="jdbc:mysql://localhost:3306/University";
        String un="root";
        String pass="Umesh@8882";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
          conn=DriverManager.getConnection(url,un,pass);
            System.out.println("database connectivity success");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return conn;
    }
    public static void main(String[] args) {
        ConnectDB();
    }
    
}
