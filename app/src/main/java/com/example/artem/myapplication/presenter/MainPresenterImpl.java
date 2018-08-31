package com.example.artem.myapplication.presenter;

import android.util.Log;

import com.example.artem.myapplication.InputActivity;
import com.example.artem.myapplication.model.database.DBService;
import com.example.artem.myapplication.model.database.DBServiceImpl;
import com.example.artem.myapplication.model.database.model.User;
import com.example.artem.myapplication.presenter.util.PasswordEncoder;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainPresenterImpl implements MainPresenter {
    private static final String TAG = "MyLogs";

    private DBService data;
    private InputActivity activity;

    public MainPresenterImpl() {
        data = new DBServiceImpl();
    }

    public void attachView(InputActivity activity){
        Log.d(TAG, "attach activity " + activity.getClass().getName());
        this.activity = activity;
    }

    public void detachView(){
        Log.d(TAG, "detach activity " + activity.getClass().getName());
        activity = null;
    }

    @Override
    public boolean loginUser() {
        Log.d(TAG, "start login user");
        Map<String, String> userInfo = activity.getUserData();

        if (userInfo.get("email").isEmpty() || userInfo.get("password").isEmpty()){
            activity.showErrorMessage("Email or password can't be empty");
            return false;
        }else {
            if (!verifyEmail(userInfo.get("email"))){
                activity.showErrorMessage("Invalid email format");
                return false;
            }
            User user = data.findUserByLogin(userInfo.get("email"));
            if (user == null){
                activity.showErrorMessage("Email is not registered");
                return false;
            }else if (!PasswordEncoder.matchPassword(user.getPassword(), userInfo.get("password"))){
                activity.showErrorMessage("Incorrect password");
                return false;
            }
        }
        activity.showErrorMessage("");
        return true;
    }

    private boolean verifyEmail(String email){
        Pattern p = Pattern.compile("^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(?:\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@(?:[a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*(?:aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    @Override
    public void registerNewUser() {
        Log.d(TAG, "registerNewUser()");
        Map<String, String> userInfo = activity.getUserData();
    }
}
