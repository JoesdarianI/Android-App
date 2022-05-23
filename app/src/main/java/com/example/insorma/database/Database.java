package com.example.insorma.database;

import com.example.insorma.Model.User;

import java.util.Vector;

public class Database {

    private static Vector<User> userList = new Vector<>();
    private static User userLogin = null;
    public static Vector<User> getUserList() {
        return userList;
    }

    public static void setUserList(Vector<User> userList){
        Database.userList = userList;
    }

    public static User getUserLogin() {
        return userLogin;
    }

    public static void setUserLogin(User userLogin) {
        Database.userLogin = userLogin;
    }
}
