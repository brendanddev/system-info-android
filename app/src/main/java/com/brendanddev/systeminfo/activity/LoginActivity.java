package com.brendanddev.systeminfo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.brendanddev.systeminfo.R;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "==== LoginActivity ====";


    @Override
    protected String getLogTag() { return TAG; }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this::onClickLogin);

        TextView signupRedirect = findViewById(R.id.signUpRedirect);
        signupRedirect.setOnClickListener(this::onClickSignUpRedirect);
    }


    /**
     * Handles the login button click.
     * @param view The view that was clicked.
     */
    private void onClickLogin(View view) {
        Log.d(TAG, "Login Button Clicked!");
    }

    /**
     * Handles the sign up redirect text click.
     * @param view The view that was clicked.
     */
    private void onClickSignUpRedirect(View view) {
        Log.d(TAG, "Sign Up Redirect Text Clicked!");

        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }


}