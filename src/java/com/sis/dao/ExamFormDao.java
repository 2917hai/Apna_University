/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.dao;

import com.sis.bean.ExamForm;
import com.sis.utility.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Umesh Yadav
 */
public class ExamFormDao {

    Connection conn;

    public int fillform(ExamForm e) {

        conn = ConnectionPool.ConnectDB();
        int r = 0;
        String sql = "INSERT INTO fillExamForm ("
                + "enrollment, name, examType, exam, "
                + "p, c, m, b, h, e, "
                + "pcode, ccode, mcode, bcode, hcode, ecode, "
                + "mathmarks, physicsmarks, chemistrymarks, biomarks, hindimarks, englishmarks, "
                + "obtainMarks"
                + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, e.getEnrollment());
            pstmt.setString(2, e.getName());
            pstmt.setString(3, e.getExamType());
            pstmt.setString(4, e.getExam());

            pstmt.setString(5, e.getMath());
            pstmt.setString(6, e.getPhysics());
            pstmt.setString(7, e.getChemistry());
            pstmt.setString(8, e.getBio());
            pstmt.setString(9, e.getHindi());
            pstmt.setString(10, e.getEnglish());

            pstmt.setString(11, e.getMathcode());
            pstmt.setString(12, e.getPhysicscode());
            pstmt.setString(13, e.getChemistrycode());
            pstmt.setString(14, e.getBiocode());
            pstmt.setString(15, e.getHindicode());
            pstmt.setString(16, e.getEnglishcode());

            pstmt.setInt(17, e.getMathMarks());
            pstmt.setInt(18, e.getPhysicsMarks());
            pstmt.setInt(19, e.getChemistryMarks());
            pstmt.setInt(20, e.getBioMarks());
            pstmt.setInt(21, e.getHindiMarks());
            pstmt.setInt(22, e.getEnglishMarks());
            pstmt.setInt(23, e.getObtainMarks());
            r = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ExamFormDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return r;
    }

    public ExamForm viewFormData(String enrollment) {
        ExamForm ef = new ExamForm();
        conn = ConnectionPool.ConnectDB();
        String sql = "select * from fillExamForm  WHERE enrollment = ?";

        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, enrollment);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // ----- First Section -----
                ef.setEnrollment(rs.getString("enrollment"));
                ef.setName(rs.getString("name"));
                ef.setExamType(rs.getString("examType"));
                ef.setExam(rs.getString("exam"));

                // ----- Subject Names -----
                ef.setPhysics(rs.getString("p"));
                ef.setChemistry(rs.getString("c"));
                ef.setMath(rs.getString("m"));
                ef.setBio(rs.getString("b"));
                ef.setHindi(rs.getString("h"));
                ef.setEnglish(rs.getString("e"));

                // ----- Subject Codes -----
                ef.setPhysicscode(rs.getString("pcode"));
                ef.setChemistrycode(rs.getString("ccode"));
                ef.setMathcode(rs.getString("mcode"));
                ef.setBiocode(rs.getString("bcode"));
                ef.setHindicode(rs.getString("hcode"));
                ef.setEnglishcode(rs.getString("ecode"));

                // ----- Marks -----
                ef.setMathMarks(rs.getInt("mathmarks"));
                ef.setPhysicsMarks(rs.getInt("physicsmarks"));
                ef.setChemistryMarks(rs.getInt("chemistrymarks"));
                ef.setBioMarks(rs.getInt("biomarks"));
                ef.setHindiMarks(rs.getInt("hindimarks"));
                ef.setEnglishMarks(rs.getInt("englishmarks"));
                ef.setObtainMarks(rs.getInt("obtainMarks"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExamFormDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ef;
    }

    public static void main(String[] args) {
//        ExamFormDao ed = new ExamFormDao();
//        ExamForm e = new ExamForm();
//        e.setEnrollment("APANA1");
//        e.setName("Umesh");
//        e.setExamType("dlkjkd");
//        e.setExam("dkjdkj");
//        e.setMathMarks(50);
//        e.setPhysicsMarks(50);
//        e.setChemistryMarks(50);
//        e.setBioMarks(50);
//        e.setHindiMarks(50);
//        e.setEnglishMarks(50);
//        e.setTotalMarks(100);
//        int r = ed.fillform(e);
//        if (r > 0) {
//            System.out.println("Data added success");
//        } else {
//            System.out.println("Failed");
//        }
//
    }

}
