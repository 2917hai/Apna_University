/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.dao;

import com.sis.bean.StudentsAttendanseBean;
import com.sis.utility.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Umesh Yadav
 */
public class AttendanceDAO {

    Connection conn;

    public StudentsAttendanseBean addAttendanse(String enrollment) {
        StudentsAttendanseBean sb = new StudentsAttendanseBean();
        String sql = "select * from attendance where enrollment= '" + enrollment + "' ";
        conn = ConnectionPool.ConnectDB();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                sb.setId(rs.getInt("id"));
                sb.setEnrollment(rs.getString("enrollment"));
                sb.setJan(rs.getString("jan"));
                sb.setFeb(rs.getString("feb"));
                sb.setMar(rs.getString("mar"));
                sb.setApr(rs.getString("apr"));
                sb.setMay(rs.getString("may"));
                sb.setJun(rs.getString("jun"));
                sb.setJul(rs.getString("jul"));
                sb.setAug(rs.getString("aug"));
                sb.setSep(rs.getString("sep"));
                sb.setOct(rs.getString("oct"));
                sb.setNov(rs.getString("nov"));
                sb.setDes(rs.getString("des"));
                sb.setStatus(rs.getString("status"));
                sb.setJanper(rs.getFloat("janper"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb;
    }

    public static void main(String[] args) {

    }

}
