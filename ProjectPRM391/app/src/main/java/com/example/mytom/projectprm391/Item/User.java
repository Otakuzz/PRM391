package com.example.mytom.projectprm391.Item;

/**
 * Created by Mytom on 3/15/2017.
 */

public class User {
    private int userID;
    private String userName;
    private String password;
    private String email;
    private String phone;

    public User() {
    }

    public User(int userID, String phone, String email, String userName) {
        this.userID = userID;
        this.phone = phone;
        this.email = email;
        this.userName = userName;
    }

    public User(int userID, String userName, String password, String email, String phone) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
