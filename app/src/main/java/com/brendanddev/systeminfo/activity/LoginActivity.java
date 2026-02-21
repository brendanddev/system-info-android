package com.brendanddev.systeminfo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.brendanddev.systeminfo.R;

/**
 * Handles the Login screen.
 *
 * @author Brendan Dileo
 */
public class LoginActivity extends BaseActivity {

    private static final String TAG = "==== LoginActivity ====";
    private static final String SP_USER_DATA = "user_data";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";


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

        EditText emailInput = findViewById(R.id.emailInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        String emailValue = emailInput.getText().toString();
        String passwordValue = passwordInput.getText().toString();

        if (emailValue.isEmpty() || passwordValue.isEmpty()) {
            Toast.makeText(this, "Required Values are empty!", Toast.LENGTH_LONG).show();
            return;
        }

        // Load user data from shared prefs
        SharedPreferences sharedPreferences = loadData();
        String emailData = sharedPreferences.getString(KEY_EMAIL, null);
        String passwordData = sharedPreferences.getString(KEY_PASSWORD, null);

        if (emailData == null || passwordData == null) {
            Toast.makeText(this, "No Account Found!", Toast.LENGTH_LONG).show();
            return;
        }

        if (!emailValue.equals(emailData) || !passwordValue.equals(passwordData)) {
            Toast.makeText(this, "Invalid Credentials!", Toast.LENGTH_LONG).show();
            return;
        }

        Log.d(TAG, "User Logged in Successfully!");
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
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

    /**
     * Loads the users saved data from SharedPreferences.
     * @return The SharedPreferences file containing the users data.
     */
    private SharedPreferences loadData() {
        return this.getSharedPreferences(SP_USER_DATA, Context.MODE_PRIVATE);
    }



}