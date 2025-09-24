/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.dao;

import com.sis.bean.StudentsBean;
import com.sis.utility.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Umesh Yadav
 */
public class StudentsRegisterDAO {

    Connection conn;

    public StudentsBean StudentProfile(String enrollment) {
        StudentsBean sb = new StudentsBean();
        conn = ConnectionPool.ConnectDB();
        String sql = "select * from student  WHERE enrollment = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, enrollment);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sb.setEnrollment(rs.getString("enrollment"));   // APANA1, APANA2 ...
                sb.setName(rs.getString("name"));
                sb.setFatherName(rs.getString("fatherName"));
                sb.setMotherName(rs.getString("motherName"));
                sb.setDob(rs.getDate("dob").toString());   // अगर dob String है Bean में
                sb.setGender(rs.getString("gender"));
                sb.setPhoto(rs.getBytes("photo"));
                sb.setSign(rs.getBytes("sign"));
                sb.setEmail(rs.getString("email"));
                sb.setMobile(rs.getString("mobile"));
                sb.setAlterMobile(rs.getString("alterMobile"));
                sb.setCurrentAddress(rs.getString("currentAddress"));
                sb.setPermanentAddress(rs.getString("permanentAddress"));
                sb.setCity(rs.getString("city"));
                sb.setState(rs.getString("state"));
                sb.setPincode(rs.getInt("pincode"));
                sb.setTenthBoard(rs.getString("tenthBoard"));
                sb.setTenthYear(rs.getInt("tenthYear"));
                sb.setTenthRoll(rs.getString("tenthRoll"));
                sb.setTenthPercentage(rs.getFloat("tenthPercentage"));

                sb.setTwelthBoard(rs.getString("twelthBoard"));
                sb.setTwelthYear(rs.getInt("twelthYear"));
                sb.setTwelthRoll(rs.getString("twelthRoll"));
                sb.setTwelthPercentage(rs.getFloat("twelthPercentage"));

                sb.setEntranseRoll(rs.getString("entranseRoll"));
                sb.setEntranseRank(rs.getInt("entranseRank"));
                sb.setEntranseScore(rs.getInt("entranseScore"));

                sb.setCourse(rs.getString("course"));
                sb.setBranch(rs.getString("branch"));
                sb.setAdmissionType(rs.getString("admissionType"));
                sb.setAadhar(rs.getBytes("aadhar"));
                sb.setLatestQualification(rs.getBytes("latestQualification"));
                sb.setCast(rs.getBytes("cast"));
                sb.setIncome(rs.getBytes("income"));
                sb.setDomicile(rs.getBytes("domicile"));

                sb.setAadharNo(rs.getString("aadharNo"));
                sb.setPassword(rs.getString("password"));
                sb.setRepassword(rs.getString("repassword"));
                sb.setSequarityQ(rs.getString("sequarityQ"));
                sb.setSequarityA(rs.getString("sequarityA"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentsRegisterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb;
    }

    public StudentsBean getByEnroll(String enrollment) {
        StudentsBean sb = new StudentsBean();
        conn = ConnectionPool.ConnectDB();
        String sql = "SELECT password, dob FROM student WHERE enrollment = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, enrollment);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sb.setPassword(rs.getString("password"));
                sb.setDob(rs.getString("dob"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentsRegisterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sb;
    }

    public String getEnroll() {
        String newEnrollment = "";
        String prefix = "APANA";
        int nextNo = 1;

// database se max enrollment number nikalna
        conn = ConnectionPool.ConnectDB();
        String sql = "SELECT enrollment FROM student ORDER BY enrollment DESC LIMIT 1";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String lastEnroll = rs.getString("enrollment");  // e.g. "APANA5"
                String numPart = lastEnroll.replace(prefix, ""); // "5"
                nextNo = Integer.parseInt(numPart) + 1;

            }
            rs.close();
            ps.close();
            newEnrollment = prefix + nextNo;  // "APANA6"
        } catch (SQLException ex) {
            Logger.getLogger(StudentsRegisterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return newEnrollment;
    }

    public int RegisterStudents(StudentsBean sb) {
        int result = 0;
        String enroll = getEnroll();
        conn = ConnectionPool.ConnectDB();
        String sql = "insert into student (enrollment,name, fatherName, motherName,dob,  gender, photo, sign, email, mobile, alterMobile,currentAddress, permanentAddress, city, state, pincode, tenthBoard, tenthYear, tenthRoll, tenthPercentage, twelthBoard, twelthYear, twelthRoll, twelthPercentage, entranseRoll, entranseRank, entranseScore, course, branch, admissionType,aadhar, latestQualification, cast, income, domicile, aadharNo, password, repassword, sequarityQ, sequarityA) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, enroll);
            ps.setString(2, sb.getName());
            ps.setString(3, sb.getFatherName());
            ps.setString(4, sb.getMotherName());
            ps.setDate(5, java.sql.Date.valueOf(sb.getDob()));
            ps.setString(6, sb.getGender());
            ps.setBytes(7, sb.getPhoto());
            ps.setBytes(8, sb.getSign());
            ps.setString(9, sb.getEmail());
            ps.setString(10, sb.getMobile());
            ps.setString(11, sb.getAlterMobile());
            ps.setString(12, sb.getCurrentAddress());
            ps.setString(13, sb.getPermanentAddress());
            ps.setString(14, sb.getCity());
            ps.setString(15, sb.getState());
            ps.setInt(16, sb.getPincode());
            ps.setString(17, sb.getTenthBoard());
            ps.setInt(18, sb.getTenthYear());
            ps.setString(19, sb.getTenthRoll());
            ps.setFloat(20, sb.getTenthPercentage());

            ps.setString(21, sb.getTwelthBoard());
            ps.setInt(22, sb.getTwelthYear());
            ps.setString(23, sb.getTwelthRoll());
            ps.setFloat(24, sb.getTwelthPercentage());

            ps.setString(25, sb.getEntranseRoll());
            ps.setInt(26, sb.getEntranseRank());
            ps.setInt(27, sb.getEntranseScore());

            ps.setString(28, sb.getCourse());
            ps.setString(29, sb.getBranch());
            ps.setString(30, sb.getAdmissionType());
            ps.setBytes(31, sb.getAadhar());
            ps.setBytes(32, sb.getLatestQualification());
            ps.setBytes(33, sb.getCast());
            ps.setBytes(34, sb.getIncome());
            ps.setBytes(35, sb.getDomicile());

            ps.setString(36, sb.getAadharNo());
            ps.setString(37, sb.getPassword());
            ps.setString(38, sb.getRepassword());
            ps.setString(39, sb.getSequarityQ());
            ps.setString(40, sb.getSequarityA());

            result = ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsRegisterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public int UpdateData(StudentsBean sb) {
        int result = 0;
        String url = "update students set name='" + sb.getName() + "',name='" + sb.getName() + "', ";
        return result;
    }

    public ArrayList<StudentsBean> FindAll() {
        ArrayList<StudentsBean> all = new ArrayList<StudentsBean>();

        conn = ConnectionPool.ConnectDB();
        String sql = "select * from student";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                StudentsBean sb = new StudentsBean();
                sb.setEnrollment(rs.getString("enrollment"));   // APANA1, APANA2 ...
                sb.setName(rs.getString("name"));
                sb.setFatherName(rs.getString("fatherName"));
                sb.setMotherName(rs.getString("motherName"));
                sb.setDob(rs.getDate("dob").toString());   // अगर dob String है Bean में
                sb.setGender(rs.getString("gender"));
                sb.setPhoto(rs.getBytes("photo"));
                sb.setSign(rs.getBytes("sign"));
                sb.setEmail(rs.getString("email"));
                sb.setMobile(rs.getString("mobile"));
                sb.setAlterMobile(rs.getString("alterMobile"));
                sb.setCurrentAddress(rs.getString("currentAddress"));
                sb.setPermanentAddress(rs.getString("permanentAddress"));
                sb.setCity(rs.getString("city"));
                sb.setState(rs.getString("state"));
                sb.setPincode(rs.getInt("pincode"));
                sb.setTenthBoard(rs.getString("tenthBoard"));
                sb.setTenthYear(rs.getInt("tenthYear"));
                sb.setTenthRoll(rs.getString("tenthRoll"));
                sb.setTenthPercentage(rs.getFloat("tenthPercentage"));

                sb.setTwelthBoard(rs.getString("twelthBoard"));
                sb.setTwelthYear(rs.getInt("twelthYear"));
                sb.setTwelthRoll(rs.getString("twelthRoll"));
                sb.setTwelthPercentage(rs.getFloat("twelthPercentage"));

                sb.setEntranseRoll(rs.getString("entranseRoll"));
                sb.setEntranseRank(rs.getInt("entranseRank"));
                sb.setEntranseScore(rs.getInt("entranseScore"));

                sb.setCourse(rs.getString("course"));
                sb.setBranch(rs.getString("branch"));
                sb.setAdmissionType(rs.getString("admissionType"));
                sb.setAadhar(rs.getBytes("aadhar"));
                sb.setLatestQualification(rs.getBytes("latestQualification"));
                sb.setCast(rs.getBytes("cast"));
                sb.setIncome(rs.getBytes("income"));
                sb.setDomicile(rs.getBytes("domicile"));

                sb.setAadharNo(rs.getString("aadharNo"));
                sb.setPassword(rs.getString("password"));
                sb.setRepassword(rs.getString("repassword"));
                sb.setSequarityQ(rs.getString("sequarityQ"));
                sb.setSequarityA(rs.getString("sequarityA"));
                all.add(sb);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentsRegisterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return all;
    }

    public int DeleteData(String enrollment) {
        int r = 0;
        String sql = "DELETE FROM student WHERE enrollment = ?";

        try (Connection conn = ConnectionPool.ConnectDB();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, enrollment);
            r = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(StudentsRegisterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public static void main(String[] args) {
        StudentsRegisterDAO sd = new StudentsRegisterDAO();
//        StudentsBean sb = sd.getByEnroll("APANA1");
//        System.out.println(sb.getPassword());
//        System.out.println(sb.getDob());

//        ArrayList<StudentsBean> all = sd.FindAll();
//        for (StudentsBean sb : all) {
//            System.out.println(sb.getEnrollment() + "\n");
//        }
//        int r = sd.DeleteData("APANA1");
//        if (r > 0) {
//            System.out.println("done");
//        } else {
//            System.out.println("failedd");
//        }
    }

}
