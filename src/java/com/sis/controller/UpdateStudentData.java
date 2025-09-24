/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.controller;

import com.sis.bean.StudentsBean;
import com.sis.dao.UpdateProfileDao;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Umesh Yadav
 */
/**
 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
 * methods.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a s-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)  // 10MB limit
public class UpdateStudentData extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        String name = request.getParameter("name");
        String father = request.getParameter("father");
        String mother = request.getParameter("mother");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");

// File uploads (use Part for file)
        Part photoPart = request.getPart("photo");
        Part signPart = request.getPart("sign");

// ---------- Contact Info ----------
        String enrollment = request.getParameter("enroll");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String aphone = request.getParameter("aphone");
        String address = request.getParameter("address");
        String caddress = request.getParameter("caddress");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        int pincode = Integer.parseInt(request.getParameter("pincode"));
        String idProof = request.getParameter("idProof");
        Part idProofFile = request.getPart("idProofFile");
        Part marksheets = request.getPart("marksheets");
        Part casteCert = request.getPart("casteCert");
        Part incomeCert = request.getPart("incomeCert");
        Part domicileCert = request.getPart("domicileCert");

        StudentsBean sb = new StudentsBean();
        sb.setEnrollment(enrollment);
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

        UpdateProfileDao up = new UpdateProfileDao();
        int r = up.UpdateProfile(sb);
        if (r > 0) {
            response.sendRedirect("profileUpdateSuccess.jsp");
        } else {
            response.sendRedirect("profileUpdateFailed.jsp");
        }

        out.println("</body>");
        out.println("</html>");
    }
}

//// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
///**
// * Handles the HTTP <code>GET</code> method.
// *
// * @param request servlet request
// * @param response servlet response
// * @throws ServletException if a servlet-specific error occurs
// * @throws IOException if an I/O error occurs
// */
//@Override
//        protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//        protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//        public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
