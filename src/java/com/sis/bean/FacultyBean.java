/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.bean;

/**
 *
 * @author Umesh Yadav
 */
public class FacultyBean {

    private String EmpId;
    private String name;
    private String father;
    private String mother;
    private String dob;
    private String gender;
    private byte[] photo;
    private byte[] sign;

    // Contact Information
    private String email;
    private String phone;
    private String aphone;
    private String address;
    private String caddress;
    private String city;
    private String state;
    private String pincode;

    // Documents
    private String idProof;
    private byte[] idProofFile;
    private byte[] marksheets;
    private byte[] resume;
    private byte[] researchPapers;
    private byte[] experienceCert;
    private byte[] gradCert;
    private byte[] pgCert;
    private byte[] phdCert;
    private byte[] otherCert;

    // Professional Details
    private String facultyId;
    private String department;
    private String designation;
    private String qualification;
    private String specialization;
    private int experience;
    private String prevInstitution;

    // Login Details
    private String password;
    private String repassword;
    private String securityQ;
    private String securityA;

    public FacultyBean() {
    }

    public FacultyBean(String EmpId, String name, String father, String mother, String dob, String gender, byte[] photo, byte[] sign, String email, String phone, String aphone, String address, String caddress, String city, String state, String pincode, String idProof, byte[] idProofFile, byte[] marksheets, byte[] resume, byte[] researchPapers, byte[] experienceCert, byte[] gradCert, byte[] pgCert, byte[] phdCert, byte[] otherCert, String facultyId, String department, String designation, String qualification, String specialization, int experience, String prevInstitution, String password, String repassword, String securityQ, String securityA) {
        this.EmpId = EmpId;
        this.name = name;
        this.father = father;
        this.mother = mother;
        this.dob = dob;
        this.gender = gender;
        this.photo = photo;
        this.sign = sign;
        this.email = email;
        this.phone = phone;
        this.aphone = aphone;
        this.address = address;
        this.caddress = caddress;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.idProof = idProof;
        this.idProofFile = idProofFile;
        this.marksheets = marksheets;
        this.resume = resume;
        this.researchPapers = researchPapers;
        this.experienceCert = experienceCert;
        this.gradCert = gradCert;
        this.pgCert = pgCert;
        this.phdCert = phdCert;
        this.otherCert = otherCert;
        this.facultyId = facultyId;
        this.department = department;
        this.designation = designation;
        this.qualification = qualification;
        this.specialization = specialization;
        this.experience = experience;
        this.prevInstitution = prevInstitution;
        this.password = password;
        this.repassword = repassword;
        this.securityQ = securityQ;
        this.securityA = securityA;
    }

    public void setEmpId(String EmpId) {
        this.EmpId = EmpId;
    }

    public String getEmpId() {
        return EmpId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public byte[] getSign() {
        return sign;
    }

    public void setSign(byte[] sign) {
        this.sign = sign;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getIdProof() {
        return idProof;
    }

    public void setIdProof(String idProof) {
        this.idProof = idProof;
    }

    public byte[] getIdProofFile() {
        return idProofFile;
    }

    public void setIdProofFile(byte[] idProofFile) {
        this.idProofFile = idProofFile;
    }

    public byte[] getMarksheets() {
        return marksheets;
    }

    public void setMarksheets(byte[] marksheets) {
        this.marksheets = marksheets;
    }

    public byte[] getResume() {
        return resume;
    }

    public void setResume(byte[] resume) {
        this.resume = resume;
    }

    public byte[] getResearchPapers() {
        return researchPapers;
    }

    public void setResearchPapers(byte[] researchPapers) {
        this.researchPapers = researchPapers;
    }

    public byte[] getExperienceCert() {
        return experienceCert;
    }

    public void setExperienceCert(byte[] experienceCert) {
        this.experienceCert = experienceCert;
    }

    public byte[] getGradCert() {
        return gradCert;
    }

    public void setGradCert(byte[] gradCert) {
        this.gradCert = gradCert;
    }

    public byte[] getPgCert() {
        return pgCert;
    }

    public void setPgCert(byte[] pgCert) {
        this.pgCert = pgCert;
    }

    public byte[] getPhdCert() {
        return phdCert;
    }

    public void setPhdCert(byte[] phdCert) {
        this.phdCert = phdCert;
    }

    public byte[] getOtherCert() {
        return otherCert;
    }

    public void setOtherCert(byte[] otherCert) {
        this.otherCert = otherCert;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getPrevInstitution() {
        return prevInstitution;
    }

    public void setPrevInstitution(String prevInstitution) {
        this.prevInstitution = prevInstitution;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getSecurityQ() {
        return securityQ;
    }

    public void setSecurityQ(String securityQ) {
        this.securityQ = securityQ;
    }

    public String getSecurityA() {
        return securityA;
    }

    public void setSecurityA(String securityA) {
        this.securityA = securityA;
    }

}
