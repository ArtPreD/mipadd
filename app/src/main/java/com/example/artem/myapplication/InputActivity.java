package com.example.artem.myapplication;

import java.util.Map;

public interface InputActivity {

    Map<String, String> getUserData();
    void showErrorMessage(String message);

}
