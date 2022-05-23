package com.example.insorma.Model;

public class User {
    private String userEmail;
    private String userUsername;
    private String userPhonenumber;
    private String userPassword;

    public User(String userEmail, String userUsername, String userPhonenumber, String userPassword) {
        this.userEmail = userEmail;
        this.userUsername = userUsername;
        this.userPhonenumber = userPhonenumber;
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPhonenumber() {
        return userPhonenumber;
    }

    public void setUserPhonenumber(String userPhonenumber) {
        this.userPhonenumber = userPhonenumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
