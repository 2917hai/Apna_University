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
public class AdminBean {

    // ---- Data Members ----
    private int id;
    private String name;
    private String mobile;
    private String email;
    private String password;
    private String repassword;
    private String dob;

    // ---- Default Constructor ----
    public AdminBean() {
    }

    // ---- Parameterized Constructor ----
    public AdminBean(int id, String name, String mobile, String email, String password, String repassword, String dob) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.repassword = repassword;
        this.dob = dob;
    }

    // ---- Getter & Setter Methods ----
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

}
