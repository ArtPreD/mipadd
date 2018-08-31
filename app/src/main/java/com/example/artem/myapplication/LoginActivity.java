package com.example.artem.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.artem.myapplication.presenter.MainPresenter;
import com.example.artem.myapplication.presenter.MainPresenterImpl;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, InputActivity{
    private static final String TAG = "MyLogs";

    private MainPresenter presenter;
    private EditText email;
    private EditText password;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "start create ActivityMain");
        setContentView(R.layout.activity_login);

        init();
        Log.d(TAG, "end create ActivityMain");
    }

    private void init(){
        presenter = new MainPresenterImpl();
        presenter.attachView(this);

        Button loginBtn = (Button) findViewById(R.id.login);
        loginBtn.setOnClickListener(this);
        Button registerBtn = (Button) findViewById(R.id.signUp);
        registerBtn.setOnClickListener(this);

        email = (EditText) findViewById(R.id.EnterEmail);
        password = (EditText) findViewById(R.id.EnterPassword);

        error = (TextView) findViewById(R.id.errorMessage);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                Log.d(TAG, "click login button");
               // if (presenter.loginUser()){
                //put user details in intent!!!
                    Intent intent1 = new Intent(this, DrawerActivity.class);
                    startActivity(intent1);
               // }
                break;
            case R.id.signUp:
                Log.d(TAG, "click register button");
                presenter.detachView();
                Log.d(TAG, "create new intent");
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivityForResult(intent, 1);
                break;
        }
    }

    public Map<String, String> getUserData(){
        Log.d(TAG, "call getUserData()");
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("email", email.getText().toString());
        userInfo.put("password", password.getText().toString());
        Log.d(TAG, "data collected. login: " + userInfo.get("email") + " password: " + userInfo.get("password"));
        return userInfo;
    }

    public void showErrorMessage(String message){
        Log.d(TAG, "send error message: " + message);
        error.setText(message);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null){
            return;
        }
        if (requestCode == 1){
            Toast.makeText(LoginActivity.this, data.getStringExtra("message"), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
        presenter = null;
    }
}
