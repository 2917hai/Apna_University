/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.dao;

import com.sis.bean.StudentsBean;
import com.sis.controller.UpdateStudentData;
import com.sis.utility.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Umesh Yadav
 */
public class UpdateProfileDao {

    Connection conn;

    public int UpdateProfile(StudentsBean sb) {
        int r = 0;
        Connection conn = ConnectionPool.ConnectDB();

        String sql = "UPDATE student SET name=?, fatherName=?, motherName=?, dob=?, gender=?, "
                + "photo=?, sign=?, email=?, mobile=?, alterMobile=?, permanentAddress=?, "
                + "currentAddress=?, city=?, state=?, pincode=?, aadharNo=?, aadhar=?, "
                + "latestQualification=?, cast=?, income=?, domicile=? "
                + "WHERE enrollment=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sb.getName());
            ps.setString(2, sb.getFatherName());
            ps.setString(3, sb.getMotherName());
            ps.setString(4, sb.getDob());
            ps.setString(5, sb.getGender());
            ps.setBytes(6, sb.getPhoto());
            ps.setBytes(7, sb.getSign());
            ps.setString(8, sb.getEmail());
            ps.setString(9, sb.getMobile());
            ps.setString(10, sb.getAlterMobile());
            ps.setString(11, sb.getPermanentAddress());
            ps.setString(12, sb.getCurrentAddress());
            ps.setString(13, sb.getCity());
            ps.setString(14, sb.getState());
            ps.setInt(15, sb.getPincode());
            ps.setString(16, sb.getAadharNo());
            ps.setBytes(17, sb.getAadhar());
            ps.setBytes(18, sb.getLatestQualification());
            ps.setBytes(19, sb.getCast());
            ps.setBytes(20, sb.getIncome());
            ps.setBytes(21, sb.getDomicile());
            ps.setString(22, sb.getEnrollment());

            // 4️⃣ Execute update
            r = ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateStudentData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public static void main(String[] args) {

        UpdateProfileDao up = new UpdateProfileDao();

    }

}
