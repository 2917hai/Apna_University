/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.dao;

import com.sis.bean.FacultyBean;
import com.sis.utility.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Umesh Yadav
 */
public class FacultyRegisterDao {

    Connection conn;

    public String EmpId() {
        String newEmpId = "";
        String prefix = "APANAFACULTY";
        int nextNo = 1;

// database se max enrollment number nikalna
        conn = ConnectionPool.ConnectDB();
        String sql = "SELECT EmpId FROM faculty ORDER BY EmpId DESC LIMIT 1";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String lastEmpId = rs.getString("EmpId");  // e.g. "APANA5"
                String numPart = lastEmpId.replace(prefix, ""); // "5"
                nextNo = Integer.parseInt(numPart) + 1;

            }
            rs.close();
            ps.close();
            newEmpId = prefix + nextNo;  // "APANA6"
        } catch (SQLException ex) {
            Logger.getLogger(StudentsRegisterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return newEmpId;
    }

    public int RegisterFaculty(FacultyBean sb) {
        int r = 0;
        conn = ConnectionPool.ConnectDB();
        String EmpId = EmpId();
        String sql = "insert into faculty(EmpId,name,father,mother,dob,gender,photo,sign,email,phone,aphone,address,caddress,city,state,pincode,idProof,facultyId,department,designation,qualification,specialization,experience,prevInstitution,password,repassword,securityQ,securityA)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
//  ,idProofFile,marksheets,resum,researchPapers,experienceCert,gradCert,pgCert,phdCert,otherCert
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, EmpId);
            ps.setString(2, sb.getName());
            ps.setString(3, sb.getFather());
            ps.setString(4, sb.getMother());
            ps.setDate(5, java.sql.Date.valueOf(sb.getDob()));
            ps.setString(6, sb.getGender());
            ps.setBytes(7, sb.getPhoto());
            ps.setBytes(8, sb.getSign());
            ps.setString(9, sb.getEmail());
            ps.setString(10, sb.getPhone());
            ps.setString(11, sb.getAphone());
            ps.setString(12, sb.getAddress());
            ps.setString(13, sb.getCaddress());
            ps.setString(14, sb.getCity());
            ps.setString(15, sb.getState());
            ps.setString(16, sb.getPincode());
            ps.setString(17, sb.getIdProof());
//            ps.setBytes(18, sb.getIdProofFile());
//            ps.setBytes(19, sb.getMarksheets());
//            ps.setBytes(20, sb.getResume());
//            ps.setBytes(21, sb.getResearchPapers());
//            ps.setBytes(22, sb.getExperienceCert());
//            ps.setBytes(23, sb.getGradCert());
//            ps.setBytes(24, sb.getPgCert());
//            ps.setBytes(25, sb.getPhdCert());
//            ps.setBytes(26, sb.getOtherCert());
            ps.setString(18, sb.getFacultyId());
            ps.setString(19, sb.getDepartment());
            ps.setString(20, sb.getDesignation());
            ps.setString(21, sb.getQualification());
            ps.setString(22, sb.getSpecialization());
            ps.setInt(23, sb.getExperience());
            ps.setString(24, sb.getPrevInstitution());
            ps.setString(25, sb.getPassword());
            ps.setString(26, sb.getRepassword());
            ps.setString(27, sb.getSecurityQ());
            ps.setString(28, sb.getSecurityA());

            r = ps.executeUpdate();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(FacultyRegisterDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public FacultyBean GetById(String id) {
        FacultyBean sb = new FacultyBean();
        conn = ConnectionPool.ConnectDB();
        String sql = "select * from faculty where EmpId= '" + id + "'  ";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                sb.setEmpId(rs.getString("EmpId"));
                sb.setName(rs.getString("name"));
                sb.setFather(rs.getString("father"));
                sb.setMother(rs.getString("mother"));
                sb.setDob(rs.getString("dob"));
                sb.setGender(rs.getString("gender"));

                sb.setEmail(rs.getString("email"));
                sb.setPhone(rs.getString("phone"));
                sb.setAphone(rs.getString("aphone"));
                sb.setAddress(rs.getString("address"));
                sb.setCaddress(rs.getString("caddress"));
                sb.setCity(rs.getString("city"));
                sb.setState(rs.getString("state"));
                sb.setPincode(rs.getString("pincode"));

                sb.setPassword(rs.getString("password"));
                sb.setRepassword(rs.getString("repassword"));
                sb.setSecurityQ(rs.getString("securityQ"));
                sb.setSecurityA(rs.getString("securityA"));

                sb.setFacultyId(rs.getString("facultyId"));
                sb.setDepartment(rs.getString("department"));
                sb.setDesignation(rs.getString("designation"));
                sb.setQualification(rs.getString("qualification"));
                sb.setSpecialization(rs.getString("specialization"));
                sb.setExperience(rs.getInt("experience"));
                sb.setPrevInstitution(rs.getString("prevInstitution"));

// ------------- BLOB / FILE FIELDS -----------------
                sb.setPhoto(rs.getBytes("photo"));
                sb.setSign(rs.getBytes("sign"));
                sb.setIdProof(rs.getString("idProof"));
//                sb.setIdProofFile(rs.getBytes("idProofFile"));
//                sb.setMarksheets(rs.getBytes("marksheets"));
//                sb.setResume(rs.getBytes("resum"));
//                sb.setResearchPapers(rs.getBytes("researchPapers"));
//                sb.setExperienceCert(rs.getBytes("experienceCert"));
//                sb.setGradCert(rs.getBytes("gradCert"));
//                sb.setPgCert(rs.getBytes("pgCert"));
//                sb.setPhdCert(rs.getBytes("phdCert"));
//                sb.setOtherCert(rs.getBytes("otherCert"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultyRegisterDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sb;
    }

    public ArrayList<FacultyBean> getAllFaculty() {
        ArrayList<FacultyBean> al = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionPool.ConnectDB();
            String sql = "SELECT * FROM faculty";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                FacultyBean sb = new FacultyBean();

                sb.setEmpId(rs.getString("EmpId"));
                sb.setName(rs.getString("name"));
                sb.setFather(rs.getString("father"));
                sb.setMother(rs.getString("mother"));
                sb.setDob(rs.getString("dob"));
                sb.setGender(rs.getString("gender"));

                sb.setEmail(rs.getString("email"));
                sb.setPhone(rs.getString("phone"));
                sb.setAphone(rs.getString("aphone"));
                sb.setAddress(rs.getString("address"));
                sb.setCaddress(rs.getString("caddress"));
                sb.setCity(rs.getString("city"));
                sb.setState(rs.getString("state"));
                sb.setPincode(rs.getString("pincode"));

                sb.setPassword(rs.getString("password"));
                sb.setRepassword(rs.getString("repassword"));
                sb.setSecurityQ(rs.getString("securityQ"));
                sb.setSecurityA(rs.getString("securityA"));

                sb.setFacultyId(rs.getString("facultyId"));
                sb.setDepartment(rs.getString("department"));
                sb.setDesignation(rs.getString("designation"));
                sb.setQualification(rs.getString("qualification"));
                sb.setSpecialization(rs.getString("specialization"));
                sb.setExperience(rs.getInt("experience"));
                sb.setPrevInstitution(rs.getString("prevInstitution"));

                // --- BLOB / FILE FIELDS (Optional) ---
                sb.setPhoto(rs.getBytes("photo"));
                sb.setSign(rs.getBytes("sign"));
                sb.setIdProof(rs.getString("idProof"));
                // sb.setIdProofFile(rs.getBytes("idProofFile"));
                // sb.setMarksheets(rs.getBytes("marksheets"));
                // sb.setResume(rs.getBytes("resume"));
                // जरूरत हो तो बाकी भी जोड़ सकते हैं

                al.add(sb); // ✅ ArrayList में Add करें
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return al; // ✅ यह ArrayList return करेगा
    }

    public int deleteFaculty(String empId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = ConnectionPool.ConnectDB();
            String sql = "DELETE FROM faculty WHERE EmpId = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, empId);   // ✅ Parameter Bind
            rows = stmt.executeUpdate(); // ✅ Delete Execute

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rows; // ✅ कितनी rows delete हुई (0 = Not Found)
    }

    public int updateFacultyData(FacultyBean sb) {
        int r = 0;
        conn = ConnectionPool.ConnectDB();
        String sql = "UPDATE faculty SET name=?, father=?, mother=?, dob=?, gender=?, photo=?, sign=?, email=?, "
                + "phone=?, aphone=?, address=?, caddress=?, city=?, state=?, pincode=?, idProof=?, facultyId=?, "
                + "department=?, designation=?, qualification=?, specialization=?, experience=?, prevInstitution=? "
                + "WHERE empId=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sb.getName());
            ps.setString(2, sb.getFather());
            ps.setString(3, sb.getMother());
            ps.setDate(4, java.sql.Date.valueOf(sb.getDob())); // yyyy-MM-dd होना चाहिए
            ps.setString(5, sb.getGender());
            ps.setBytes(6, sb.getPhoto());
            ps.setBytes(7, sb.getSign());
            ps.setString(8, sb.getEmail());
            ps.setString(9, sb.getPhone());
            ps.setString(10, sb.getAphone());
            ps.setString(11, sb.getAddress());
            ps.setString(12, sb.getCaddress());
            ps.setString(13, sb.getCity());
            ps.setString(14, sb.getState());
            ps.setString(15, sb.getPincode());
            ps.setString(16, sb.getIdProof());
            ps.setString(17, sb.getFacultyId());
            ps.setString(18, sb.getDepartment());
            ps.setString(19, sb.getDesignation());
            ps.setString(20, sb.getQualification());
            ps.setString(21, sb.getSpecialization());
            ps.setInt(22, sb.getExperience());
            ps.setString(23, sb.getPrevInstitution());
            ps.setString(24, sb.getEmpId()); // ✅ WHERE clause parameter

            r = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FacultyRegisterDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public static void main(String[] args) {
//        FacultyBean sb = new FacultyBean();
//        sb.setEmpId("APANAFACULTY1");
//        sb.setName("Test Name");
//        sb.setFather("Test Father");
//        sb.setMother("Test Mother");
//        sb.setDob("2000-01-01");
//        sb.setGender("Male");
//
//// ---------- Photo & Sign ----------
//        sb.setPhoto("PhotoBytes".getBytes());   // Dummy byte[]
//        sb.setSign("SignBytes".getBytes());
//
//// ---------- Contact Info ----------
//        sb.setEmail("test@example.com");
//        sb.setPhone("9999999999");
//        sb.setAphone("8888888888");
//        sb.setAddress("Test Permanent Address");
//        sb.setCaddress("Test Current Address");
//        sb.setCity("Test City");
//        sb.setState("Test State");
//        sb.setPincode("123456");
//
//// ---------- Login Info ----------
////        sb.setPassword("password123");
////        sb.setRepassword("password123");
////        sb.setSecurityQ("Your first school?");
////        sb.setSecurityA("Test Answer");
//// ---------- Professional Info ----------
//        sb.setFacultyId("FAC123");
//        sb.setDepartment("Computer Science");
//        sb.setDesignation("Assistant Professor");
//        sb.setQualification("PhD");
//        sb.setSpecialization("AI/ML");
//        sb.setExperience(5);
//        sb.setPrevInstitution("Test University");
//
//// ---------- Documents ----------
//        sb.setIdProof("Aadhar");
////        sb.setIdProofFile("IDProofBytes".getBytes());
////        sb.setMarksheets("MarksheetsBytes".getBytes());
////        sb.setResume("ResumeBytes".getBytes());
////        sb.setResearchPapers("ResearchPapersBytes".getBytes());
////        sb.setExperienceCert("ExperienceCertBytes".getBytes());
////        sb.setGradCert("GradCertBytes".getBytes());
////        sb.setPgCert("PGCertBytes".getBytes());
////        sb.setPhdCert("PhDCertBytes".getBytes());
////        sb.setOtherCert("OtherCertBytes".getBytes());
//
//        FacultyRegisterDao sd = new FacultyRegisterDao();
//        int r = sd.updateFacultyData(sb);
//        if (r > 0) {
//            System.out.println("done");
//        } else {
//            System.out.println("Failed...!");
//        }

//        FacultyBean sb = sd.GetById("APANAFACULTY1");
//        System.out.println(sb.getName());
//        System.out.println(sb.getEmail());
    }

}
