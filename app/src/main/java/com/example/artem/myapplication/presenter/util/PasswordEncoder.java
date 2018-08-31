package com.example.artem.myapplication.presenter.util;

public class PasswordEncoder {

    public static String encryptPassword(String password){
        return password;
    }

    public static boolean matchPassword(String fromDB, String fromUI){
        return fromDB.equals(fromUI);
    }
}
