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
public class FacultyRegister extends HttpServlet {

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
        String pincode = request.getParameter("pincode");

// ---------- Document Uploads ----------
        String idProof = request.getParameter("idProof");
//        Part idProofFile = request.getPart("idProofFile");
//        Part marksheets = request.getPart("marksheets");
//        Part resume = request.getPart("resume");
//        Part researchPapers = request.getPart("researchPapers");
//        Part experienceCert = request.getPart("experienceCert");
//        Part gradCert = request.getPart("gradCert");
//        Part pgCert = request.getPart("pgCert");
//        Part phdCert = request.getPart("phdCert");
//        Part otherCert = request.getPart("otherCert");

        ///-----------------------------  professional details -----------------------------------
        String facultyId = request.getParameter("facultyId");
        String department = request.getParameter("department");
        String designation = request.getParameter("designation");
        String qualification = request.getParameter("qualification");
        String specialization = request.getParameter("specialization");
        int experience = Integer.parseInt(request.getParameter("experience"));
        String prevInstitution = request.getParameter("prevInstitution");

// ---------- Login Details ----------
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String securityQ = request.getParameter("securityQ");
        String securityA = request.getParameter("securityA");

        //-------------- personal Information--------------------
        FacultyBean sb = new FacultyBean();
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

        //------------------------ Academic Information -------------------
        //--------------------------------  Login details --------------------------
        sb.setPassword(password);
        sb.setRepassword(repassword);
        sb.setSecurityA(securityA);
        sb.setSecurityQ(securityQ);

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

//        InputStream idStream = idProofFile.getInputStream();
//        byte idd[] = new byte[(int) idProofFile.getSize()];
//        idStream.read(idd);
//        sb.setIdProofFile(idd);
//
//        InputStream markStream = marksheets.getInputStream();
//        byte[] marksBytes = new byte[(int) marksheets.getSize()];
//        markStream.read(marksBytes);
//        sb.setMarksheets(marksBytes);
//
//        InputStream resumeStream = resume.getInputStream();
//        byte[] resumedata = new byte[(int) resume.getSize()];
//        resumeStream.read(resumedata);
//        sb.setResume(resumedata);
//
//        InputStream researchPapersStream = researchPapers.getInputStream();
//        byte[] researchPapersdata = new byte[(int) researchPapers.getSize()];
//        researchPapersStream.read(researchPapersdata);
//        sb.setResearchPapers(researchPapersdata);
//
//        InputStream experienceCertStream = experienceCert.getInputStream();
//        byte[] experienceCertdata = new byte[(int) experienceCert.getSize()];
//        experienceCertStream.read(experienceCertdata);
//        sb.setExperienceCert(experienceCertdata);
//
//        InputStream gradCertStream = gradCert.getInputStream();
//        byte[] gradCertdata = new byte[(int) gradCert.getSize()];
//        gradCertStream.read(gradCertdata);
//        sb.setGradCert(gradCertdata);
//
//        InputStream pgCertStream = pgCert.getInputStream();
//        byte[] pgCertdata = new byte[(int) pgCert.getSize()];
//        pgCertStream.read(pgCertdata);
//        sb.setPgCert(pgCertdata);
//
//        InputStream phdCertStream = phdCert.getInputStream();
//        byte[] phdCertdata = new byte[(int) phdCert.getSize()];
//        phdCertStream.read(phdCertdata);
//        sb.setPhdCert(phdCertdata);
//
//        InputStream otherCertStream = otherCert.getInputStream();
//        byte[] otherCertData = new byte[(int) otherCert.getSize()];
//        otherCertStream.read(otherCertData);
//        sb.setOtherCert(otherCertData);
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
        int r = sd.RegisterFaculty(sb);

        if (r > 0) {

            response.sendRedirect("RegisterSuccess1.jsp");
            // out.println("done");
        } else {

            response.sendRedirect("facultyRegister.html");
            //out.println("failed....!");

        }
        out.println("</body>");
        out.println("</html>");

    }
}
