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
 * Handles the Sign Up screen.
 *
 * @author Brendan Dileo
 */
public class SignUpActivity extends BaseActivity {
    private static final String TAG = "==== SignUpActivity ====";
    private static final String SP_USER_DATA = "user_data";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";


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

        EditText nameInput = findViewById(R.id.nameInput);
        EditText emailInput = findViewById(R.id.emailInput);
        EditText passwordInput = findViewById(R.id.passwordInput);

        String nameValue = nameInput.getText().toString();
        String emailValue = emailInput.getText().toString();
        String passwordValue = passwordInput.getText().toString();
        Log.d(TAG, "Name: " + nameValue + ", Email: " + emailValue + ", Password: " + passwordValue);

        if (nameValue.isEmpty() || emailValue.isEmpty() || passwordValue.isEmpty()) {
            Toast.makeText(this, "Required Values are empty!", Toast.LENGTH_LONG).show();
            return;
        }

        saveData(nameValue, emailValue, passwordValue);

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
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

    /**
     * Saves the users info to SharedPreferences.
     * @param name The users name.
     * @param email The users email.
     * @param password The users password..
     */
    private void saveData(String name, String email, String password) {
        SharedPreferences sharedPreferences = this.getSharedPreferences(SP_USER_DATA, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password);
        editor.apply();
        Log.d(TAG, "Saving User Data!");
    }


}