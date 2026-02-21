package com.brendanddev.systeminfo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.brendanddev.systeminfo.R;

/**
 * Handles the Sign Up screen.
 *
 * @author Brendan Dileo
 */
public class SignUpActivity extends BaseActivity {
    private static final String TAG = "==== SignUpActivity ====";


    @Override
    protected String getLogTag() { return TAG; }

    /**
     * Initializes the activity, sets up click listeners.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button signUpButton = findViewById(R.id.loginButton);
        signUpButton.setOnClickListener(this::onClickSignUp);

        TextView loginRedirect = findViewById(R.id.signUpRedirect);
        loginRedirect.setOnClickListener(this::onClickLoginRedirect);
    }

    /**
     * Handles the sign up button click.
     * @param view The view that was clicked.
     */
    private void onClickSignUp(View view) {
        Log.d(TAG, "Sign Up Button Clicked!");
    }

    /**
     * Handles the login redirect text click.
     * @param view The view that was clicked.
     */
    private void onClickLoginRedirect(View view) {
        Log.d(TAG, "Login Redirect Text Clicked!");

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }



}