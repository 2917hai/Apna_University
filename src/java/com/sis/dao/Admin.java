/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.dao;

import com.sis.bean.AdminBean;
import com.sis.utility.ConnectionPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Umesh Yadav
 */
public class Admin {

    Connection conn;

    public AdminBean GetAdmin(int id) {
        AdminBean ab = new AdminBean();

        conn = ConnectionPool.ConnectDB();
        String sql = "select * from Manager where id='" + id + "'  ";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ab.setName(rs.getString("name"));
                ab.setEmail(rs.getString("email"));
                ab.setPassword(rs.getString("password"));
                ab.setRepassword(rs.getString("repassword"));
                ab.setDob(rs.getString("dob"));
                ab.setId(rs.getInt("id"));

            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ab;
    }

    public static void main(String[] args) {

//        Admin a = new Admin();
//        AdminBean ab = a.GetAdmin(101);
//        System.err.println(ab.getId());
    }

}
