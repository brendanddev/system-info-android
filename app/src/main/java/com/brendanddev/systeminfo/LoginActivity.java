package com.brendanddev.systeminfo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

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

        // Set text in activity name text view to current activity name
        TextView activityName = (TextView) findViewById(R.id.activityName);
        activityName.setText(ACTIVITY);

        // Set click listener for the submit button
        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this);
    }

    /**
     * Handles click events for the views in this activity.
     *
     * @param view The view that was clicked.
     */
    @Override
    public void onClick(View view) {
        int buttonId = view.getId();
        Log.d(TAG, "Button ID: " + buttonId + " was pressed!");

        if (buttonId == R.id.submitButton) {
            TextView usernameText = (TextView) findViewById(R.id.usernameText);
            TextView passwordText = (TextView) findViewById(R.id.passwordText);
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



}