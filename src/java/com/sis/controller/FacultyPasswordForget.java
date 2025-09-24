/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.controller;

import com.sis.bean.FacultyBean;
import com.sis.bean.StudentsBean;
import com.sis.dao.FacultyRegisterDao;
import com.sis.dao.StudentsRegisterDAO;
import com.sis.utility.ConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Umesh Yadav
 */
public class FacultyPasswordForget extends HttpServlet {

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
            out.println("<title>Servlet PasswordForget</title>");
            out.println("</head>");
            out.println("<body>");
            String enrollment = request.getParameter("Enrollment");
            String currentpassword = request.getParameter("current");
            String newpassword = request.getParameter("new");
            String confirmpassword = request.getParameter("confirm");
            String dob = request.getParameter("dob");
            FacultyRegisterDao sd = new FacultyRegisterDao();
            FacultyBean sb = sd.GetById(enrollment);

            if (currentpassword.equals(sb.getPassword()) && dob.equals(sb.getDob()) && newpassword.equals(confirmpassword)) {
                Connection conn;
                conn = ConnectionPool.ConnectDB();
                int r = 0;
                String sql = "UPDATE faculty SET password = '" + newpassword + "', repassword = '" + confirmpassword + "' WHERE empId ='" + enrollment + "' ";
                Statement stmt;
                try {
                    stmt = conn.createStatement();
                    r = stmt.executeUpdate(sql);
                    conn.close();

                } catch (SQLException ex) {
                    Logger.getLogger(PasswordForget.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (r > 0) {
                    response.sendRedirect("successFacultyPasswordForget.jsp");
                }

            } else {
                response.sendRedirect("failedFacultyPasswordForget.jsp");
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
