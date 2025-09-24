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
public class ExamForm {

    private String enrollment;      // PK + FK
    private String name;
    private String examType;
    private String exam;
    private int mathMarks;
    private int physicsMarks;
    private int chemistryMarks;
    private int bioMarks;
    private int hindiMarks;
    private int englishMarks;
    private int obtainMarks;
    private String math;
    private String physics;
    private String chemistry;
    private String bio;
    private String hindi;
    private String english;
    private String mathcode;
    private String physicscode;
    private String chemistrycode;
    private String biocode;
    private String hindicode;
    private String englishcode;

    // ✅ Default constructor
    public ExamForm() {
    }

    // ✅ Parameterized constructor
    public ExamForm(String enrollment, String name, String examType, String exam, int mathMarks, int physicsMarks, int chemistryMarks, int bioMarks, int hindiMarks, int englishMarks, int obtainMarks, String math, String physics, String chemistry, String bio, String hindi, String english, String mathcode, String physicscode, String chemistrycode, String biocode, String hindicode, String englishcode) {
        this.enrollment = enrollment;
        this.name = name;
        this.examType = examType;
        this.exam = exam;
        this.mathMarks = mathMarks;
        this.physicsMarks = physicsMarks;
        this.chemistryMarks = chemistryMarks;
        this.bioMarks = bioMarks;
        this.hindiMarks = hindiMarks;
        this.englishMarks = englishMarks;
        this.obtainMarks = obtainMarks;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        this.bio = bio;
        this.hindi = hindi;
        this.english = english;
        this.mathcode = mathcode;
        this.physicscode = physicscode;
        this.chemistrycode = chemistrycode;
        this.biocode = biocode;
        this.hindicode = hindicode;
        this.englishcode = englishcode;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public int getMathMarks() {
        return mathMarks;
    }

    public void setMathMarks(int mathMarks) {
        this.mathMarks = mathMarks;
    }

    public int getPhysicsMarks() {
        return physicsMarks;
    }

    public void setPhysicsMarks(int physicsMarks) {
        this.physicsMarks = physicsMarks;
    }

    public int getChemistryMarks() {
        return chemistryMarks;
    }

    public void setChemistryMarks(int chemistryMarks) {
        this.chemistryMarks = chemistryMarks;
    }

    public int getBioMarks() {
        return bioMarks;
    }

    public void setBioMarks(int bioMarks) {
        this.bioMarks = bioMarks;
    }

    public int getHindiMarks() {
        return hindiMarks;
    }

    public void setHindiMarks(int hindiMarks) {
        this.hindiMarks = hindiMarks;
    }

    public int getEnglishMarks() {
        return englishMarks;
    }

    public void setEnglishMarks(int englishMarks) {
        this.englishMarks = englishMarks;
    }

    public int getObtainMarks() {
        return obtainMarks;
    }

    public void setObtainMarks(int obtainMarks) {
        this.obtainMarks = obtainMarks;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getPhysics() {
        return physics;
    }

    public void setPhysics(String physics) {
        this.physics = physics;
    }

    public String getChemistry() {
        return chemistry;
    }

    public void setChemistry(String chemistry) {
        this.chemistry = chemistry;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getHindi() {
        return hindi;
    }

    public void setHindi(String hindi) {
        this.hindi = hindi;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getMathcode() {
        return mathcode;
    }

    public void setMathcode(String mathcode) {
        this.mathcode = mathcode;
    }

    public String getPhysicscode() {
        return physicscode;
    }

    public void setPhysicscode(String physicscode) {
        this.physicscode = physicscode;
    }

    public String getChemistrycode() {
        return chemistrycode;
    }

    public void setChemistrycode(String chemistrycode) {
        this.chemistrycode = chemistrycode;
    }

    public String getBiocode() {
        return biocode;
    }

    public void setBiocode(String biocode) {
        this.biocode = biocode;
    }

    public String getHindicode() {
        return hindicode;
    }

    public void setHindicode(String hindicode) {
        this.hindicode = hindicode;
    }

    public String getEnglishcode() {
        return englishcode;
    }

    public void setEnglishcode(String englishcode) {
        this.englishcode = englishcode;
    }

}
