package com.example.artem.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.artem.myapplication.presenter.MainPresenter;
import com.example.artem.myapplication.presenter.MainPresenterImpl;

import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, InputActivity {
    private static final String TAG = "MyLogs";

    private MainPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "start create register activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        Log.d(TAG, "end create register activity");
    }

    private void init(){
        presenter = new MainPresenterImpl();
        presenter.attachView(this);
    }

    @Override
    public void onClick(View v) {

    }


    public Map<String, String> getUserData() {
        return null;
    }


    public void showErrorMessage(String message) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
        presenter = null;
    }
}
