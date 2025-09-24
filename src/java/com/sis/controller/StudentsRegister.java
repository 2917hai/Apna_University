package com.sis.controller;

import com.sis.bean.StudentsBean;
import com.sis.dao.StudentsRegisterDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)  // 10MB limit
public class StudentsRegister extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        // ---------- TEXT INPUTS ----------
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet filedata</title>");
        out.println("</head>");
        out.println("<body>");

        //------------------  Personal Information -------------------
        String name = request.getParameter("name");
        String father = request.getParameter("father");
        String mother = request.getParameter("mother");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");

// File uploads (use Part for file)
        Part photoPart = request.getPart("photo");
        Part signPart = request.getPart("sign");

// ---------- Contact Info ----------
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String aphone = request.getParameter("aphone");
        String address = request.getParameter("address");
        String caddress = request.getParameter("caddress");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        int pincode = Integer.parseInt(request.getParameter("pincode"));

// ---------- Academic Info ----------
        String tenthBoard = request.getParameter("tenthBoard");
        int tenthYear = Integer.parseInt(request.getParameter("tenthYear"));
        String tenthRoll = request.getParameter("tenthRoll");
        float tenthPercentage = Float.parseFloat(request.getParameter("tenthMarks"));

        String twelfthBoard = request.getParameter("twelfthBoard");
        int twelfthYear = Integer.parseInt(request.getParameter("twelfthYear"));
        String twelfthRoll = request.getParameter("twelfthRoll");
        float twelthPercentage = Float.parseFloat(request.getParameter("twelfthMarks"));

        String examRoll = request.getParameter("examRoll");
        int examRank = Integer.parseInt(request.getParameter("examRank"));
        int examScore = Integer.parseInt(request.getParameter("examScore"));

// ---------- Course & Program ----------
        String course = request.getParameter("course");
        String branch = request.getParameter("branch");
        String admissionType = request.getParameter("admissionType");

// ---------- Document Uploads ----------
        String idProof = request.getParameter("idProof");
        Part idProofFile = request.getPart("idProofFile");
        Part marksheets = request.getPart("marksheets");
        Part casteCert = request.getPart("casteCert");
        Part incomeCert = request.getPart("incomeCert");
        Part domicileCert = request.getPart("domicileCert");

// ---------- Login Details ----------
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String securityQ = request.getParameter("securityQ");
        String securityA = request.getParameter("securityA");

        //-------------- personal Information--------------------
        StudentsBean sb = new StudentsBean();
        sb.setName(name);
        sb.setFatherName(father);
        sb.setMotherName(mother);
        sb.setDob(dob);
        sb.setGender(gender);
        InputStream photoStream = photoPart.getInputStream();
        byte[] data = new byte[(int) photoPart.getSize()];
        photoStream.read(data);
        sb.setPhoto(data);
        /////////////////////////////
        InputStream signStream = signPart.getInputStream();
        byte sign[] = new byte[(int) signPart.getSize()];
        signStream.read(sign);
        sb.setSign(sign);

        //--------------------------- Contact Information----------------------
        sb.setEmail(email);
        sb.setMobile(phone);
        sb.setAlterMobile(aphone);
        sb.setPermanentAddress(address);
        sb.setCurrentAddress(caddress);
        sb.setCity(city);
        sb.setState(state);
        sb.setPincode(pincode);

        //------------------------ Academic Information -------------------
        sb.setTenthBoard(tenthBoard);
        sb.setTenthRoll(tenthRoll);
        sb.setTenthYear(tenthYear);
        sb.setTenthPercentage(tenthPercentage);

        sb.setTwelthBoard(twelfthBoard);
        sb.setTwelthYear(twelfthYear);
        sb.setTwelthRoll(twelfthRoll);
        sb.setTwelthPercentage(twelthPercentage);

        sb.setEntranseRoll(examRoll);
        sb.setEntranseRank(examRank);
        sb.setEntranseScore(examScore);

        //------------------------- Course and Program ---------------------
        sb.setCourse(course);
        sb.setBranch(branch);
        sb.setAdmissionType(admissionType);

        //--------------------------------  Login details --------------------------
        sb.setPassword(password);
        sb.setRepassword(repassword);
        sb.setSequarityQ(securityQ);
        sb.setSequarityA(securityA);

        //------------------- Documents ------------------------
        sb.setAadharNo(idProof);
        InputStream idStream = idProofFile.getInputStream();
        byte id[] = new byte[(int) idProofFile.getSize()];
        idStream.read(id);
        sb.setAadhar(id);

        InputStream markStream = marksheets.getInputStream();
        byte[] marksBytes = new byte[(int) marksheets.getSize()];
        markStream.read(marksBytes);
        sb.setLatestQualification(marksBytes);

        InputStream casteStream = casteCert.getInputStream();
        byte[] casteBytes = new byte[(int) casteCert.getSize()];
        casteStream.read(casteBytes);
        sb.setCast(casteBytes);

        InputStream incomeStream = incomeCert.getInputStream();
        byte[] incomeBytes = new byte[(int) incomeCert.getSize()];
        incomeStream.read(incomeBytes);
        sb.setIncome(incomeBytes);

        InputStream domStream = domicileCert.getInputStream();
        byte[] domBytes = new byte[(int) domicileCert.getSize()];
        domStream.read(domBytes);
        sb.setDomicile(domBytes);

        StudentsRegisterDAO sd = new StudentsRegisterDAO();
        int r = sd.RegisterStudents(sb);
        out.println("done");

        if (r > 0) {
            response.sendRedirect("RegisterSuccess.jsp");
        } else {

            response.sendRedirect("StudentsRegister.html");
        }
        out.println("</body>");
        out.println("</html>");

    }
}
