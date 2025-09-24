/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.controller;

import com.sis.bean.ExamForm;
import com.sis.dao.ExamFormDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Umesh Yadav
 */
public class FillExamForm extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FillExamForm</title>");
            out.println("</head>");
            out.println("<body>");

            String enrollment = request.getParameter("Enrollment");
            String name = request.getParameter("name");
            String exam = request.getParameter("exam");
            String examType = request.getParameter("examType");

            int math = Integer.parseInt(request.getParameter("marks1"));;
            int physics = Integer.parseInt(request.getParameter("marks3"));
            int chemistry = Integer.parseInt(request.getParameter("marks2"));
            int bio = Integer.parseInt(request.getParameter("marks6"));
            int hindi = Integer.parseInt(request.getParameter("marks4"));
            int english = Integer.parseInt(request.getParameter("marks5"));
            int obtain = Integer.parseInt(request.getParameter("total"));

            String m = request.getParameter("math");
            String c = request.getParameter("chemistry");
            String p = request.getParameter("physics");
            String b = request.getParameter("bio");
            String h = request.getParameter("hindi");
            String e = request.getParameter("english");

            String mcode = request.getParameter("mathcode");
            String ccode = request.getParameter("chemistrycode");
            String pcode = request.getParameter("physicscode");
            String bcode = request.getParameter("biocode");
            String hcode = request.getParameter("hindicode");
            String ecode = request.getParameter("englishcode");

            ExamForm ef = new ExamForm();
            ef.setEnrollment(enrollment);
            ef.setName(name);
            ef.setExam(exam);
            ef.setExamType(examType);
            ef.setMathMarks(math);
            ef.setPhysicsMarks(physics);
            ef.setChemistryMarks(chemistry);
            ef.setEnglishMarks(english);
            ef.setHindiMarks(hindi);
            ef.setBioMarks(bio);
            ef.setObtainMarks(obtain);
            ef.setMath(m);
            ef.setPhysics(p);
            ef.setChemistry(c);
            ef.setBio(b);
            ef.setHindi(h);
            ef.setEnglish(e);
            ef.setPhysicscode(pcode);
            ef.setChemistrycode(ccode);
            ef.setMathcode(mcode);
            ef.setBiocode(bcode);
            ef.setHindicode(hcode);
            ef.setEnglishcode(ecode);

            ExamFormDao ed = new ExamFormDao();
            int r = ed.fillform(ef);
            if (r > 0) {
                response.sendRedirect("successExamForm.jsp");
            } else {
                response.sendRedirect("failedExamForm.jsp");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
