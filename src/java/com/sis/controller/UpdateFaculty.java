package com.sis.controller;

import com.sis.bean.FacultyBean;
import com.sis.dao.FacultyRegisterDao;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)// 10MB limit
public class UpdateFaculty extends HttpServlet {

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
        String EmpId = request.getParameter("empId");
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
        String pincode = request.getParameter("pincode");

// ---------- Document Uploads ----------
        String idProof = request.getParameter("idProof");

        ///-----------------------------  professional details -----------------------------------
        String facultyId = request.getParameter("facultyId");
        String department = request.getParameter("department");
        String designation = request.getParameter("designation");
        String qualification = request.getParameter("qualification");
        String specialization = request.getParameter("specialization");
        int experience = Integer.parseInt(request.getParameter("experience"));
        String prevInstitution = request.getParameter("prevInstitution");

        //-------------- personal Information--------------------
        FacultyBean sb = new FacultyBean();
        sb.setEmpId(EmpId);
        sb.setName(name);
        sb.setFather(father);
        sb.setMother(mother);
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
        sb.setPhone(phone);
        sb.setAphone(aphone);
        sb.setAddress(address);
        sb.setCaddress(caddress);
        sb.setCity(city);
        sb.setState(state);
        sb.setPincode(pincode);

        /// -------------------------------    Professional details  ---------------------------------
        sb.setFacultyId(facultyId);
        sb.setDepartment(department);
        sb.setDesignation(designation);
        sb.setQualification(qualification);
        sb.setSpecialization(specialization);
        sb.setExperience(experience);
        sb.setPrevInstitution(prevInstitution);

        //------------------- Documents ------------------------
        sb.setIdProof(idProof);
//        out.println("===== Personal Info =====<br>");
//        out.println("EmpId        : " + EmpId + "<br>");
//        out.println("Name         : " + name + "<br>");
//        out.println("Father       : " + father + "<br>");
//        out.println("Mother       : " + mother + "<br>");
//        out.println("DOB          : " + dob + "<br>");
//        out.println("Gender       : " + gender + "<br>");
//
//        out.println("===== Contact Info =====<br>");
//        out.println("Email        : " + email + "<br>");
//        out.println("Phone        : " + phone + "<br>");
//        out.println("Alt Phone    : " + aphone + "<br>");
//        out.println("Address      : " + address + "<br>");
//        out.println("Current Addr : " + caddress + "<br>");
//        out.println("City         : " + city + "<br>");
//        out.println("State        : " + state + "<br>");
//        out.println("Pincode      : " + pincode + "<br>");
//
//        out.println("===== Professional Details =====<br>");
//        out.println("FacultyId    : " + facultyId + "<br>");
//        out.println("Department   : " + department + "<br>");
//        out.println("Designation  : " + designation + "<br>");
//        out.println("Qualification: " + qualification + "<br>");
//        out.println("Specialization: " + specialization + "<br>");
//        out.println("Experience   : " + experience + "<br>");
//        out.println("PrevInstitute: " + prevInstitution + "<br>");
//
//        out.println("===== Documents =====<br>");
//        out.println("Id Proof     : " + idProof + "<br>");
//
//        out.println("===== File Sizes =====<br>");
//        out.println("Photo Size   : " + photoPart.getSize() + " bytes<br>");
//        out.println("Sign Size    : " + signPart.getSize() + " bytes<br>");

//        out.println("ID Proof File Bytes Length: " + (sb.getIdProofFile() != null ? sb.getIdProofFile().length : 0) + "<br>");
//        out.println("Marksheets Bytes Length: " + (sb.getMarksheets() != null ? sb.getMarksheets().length : 0) + "<br>");
//        out.println("Resume Bytes Length: " + (sb.getResume() != null ? sb.getResume().length : 0) + "<br>");
//        out.println("Research Papers Bytes Length: " + (sb.getResearchPapers() != null ? sb.getResearchPapers().length : 0) + "<br>");
//        out.println("Experience Cert Bytes Length: " + (sb.getExperienceCert() != null ? sb.getExperienceCert().length : 0) + "<br>");
//        out.println("Graduation Cert Bytes Length: " + (sb.getGradCert() != null ? sb.getGradCert().length : 0) + "<br>");
//        out.println("PG Cert Bytes Length: " + (sb.getPgCert() != null ? sb.getPgCert().length : 0) + "<br>");
//        out.println("PhD Cert Bytes Length: " + (sb.getPhdCert() != null ? sb.getPhdCert().length : 0) + "<br>");
//        out.println("Other Cert Bytes Length: " + (sb.getOtherCert() != null ? sb.getOtherCert().length : 0) + "<br>");
        FacultyRegisterDao sd = new FacultyRegisterDao();
        int r = sd.updateFacultyData(sb);

        if (r > 0) {

            response.sendRedirect("FacultyUpdateSuccess.jsp");
            // out.println("done");
        } else {

            response.sendRedirect("FacultyUpdateFailed.jsp");
            //out.println("failed....!");

        }
        out.println("</body>");
        out.println("</html>");

    }
}
