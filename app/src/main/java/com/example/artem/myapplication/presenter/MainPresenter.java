package com.example.artem.myapplication.presenter;

import com.example.artem.myapplication.InputActivity;

public interface MainPresenter {

    boolean loginUser();
    void registerNewUser();
    void attachView(InputActivity activity);
    void detachView();

}
