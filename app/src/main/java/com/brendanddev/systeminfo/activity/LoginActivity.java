package com.brendanddev.systeminfo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.brendanddev.systeminfo.R;

public class LoginActivity extends BaseActivity {

    private final static String TAG = "==== LoginActivity ====";
    private final static String ACTIVITY = "Login";


    @Override
    protected String getLogTag() { return TAG; }

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView activityName = findViewById(R.id.activityName);
        activityName.setText(ACTIVITY);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this::onClickLogin);
    }



    public void onClickLogin(View view) {
        Log.d(TAG, "onClickLogin() - Login Button Pressed");

        TextView usernameText = findViewById(R.id.usernameInput);
        TextView passwordText = findViewById(R.id.passwordInput);
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Required fields missing!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent switchActivity = new Intent(LoginActivity.this, HomeActivity.class);
        switchActivity.putExtra("username", username);
        startActivity(switchActivity);
    }



}