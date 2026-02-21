package com.brendanddev.systeminfo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.brendanddev.systeminfo.R;
import com.brendanddev.systeminfo.util.DataLoader;

/**
 * Handles the Sign Up screen.
 *
 * @author Brendan Dileo
 */
public class SignUpActivity extends BaseActivity {
    private static final String TAG = "==== SignUpActivity ====";
    private DataLoader dataLoader;



    @Override
    protected String getLogTag() { return TAG; }

    /**
     * Initializes the activity, sets up click listeners.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        dataLoader = new DataLoader(this);

        Button signUpButton = findViewById(R.id.signUpButton);
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

        dataLoader.saveData(nameValue, emailValue, passwordValue);
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


}