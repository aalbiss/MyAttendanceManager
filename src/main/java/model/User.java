package model;

import java.sql.*;

public class User {
    
    private String fullName;
    private String username;
    private String mail;
    private String password;
    private String confirmPass;
    private String role;
    
    public User() {
        fullName = "";
        username = "";
        mail = "";
        password = "";
        confirmPass = "";
        role = "";
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getMail() {
        return mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getConfirmPass() {
        return confirmPass;
    }
    
    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
}
