package com.brendanddev.systeminfo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import com.brendanddev.systeminfo.R;


public class HomeActivity extends BaseActivity {

    private final static String TAG = "==== HomeActivity ====";
    private final static String ACTIVITY = "Home";
    private final static String USERNAME = "username";
    private ActivityResultLauncher<Intent> Launch4Result;


    @Override
    protected String getLogTag() { return TAG; }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Launch4Result = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                this::handleResult);


        // Set name of current activity
        TextView activityName = findViewById(R.id.activityName);
        if (activityName != null) {
            activityName.setText(ACTIVITY);
        }

        // Set welcome message to include user name based on value passed in the intent
        TextView welcomeText = findViewById(R.id.welcomeText);
        if (welcomeText != null) {
            if (getIntent() != null && getIntent().hasExtra(USERNAME)) {
                String incomingText = getIntent().getStringExtra(USERNAME);
                if (incomingText != null) {
                    String welcomeMessage = String.format("Welcome %s!", incomingText);
                    welcomeText.setText(welcomeMessage);
                }
            } else {
                welcomeText.setText("Error!");
            }
        }

        // Attach on click listener to close button
        Button logOutButton = findViewById(R.id.closeButton);
        logOutButton.setOnClickListener(this::onClickLogOut);

        // Attach onclick to settings button
        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(this::onClickSettings);
    }


    public void onClickLogOut(View view) {
        Log.d(TAG, "onClickClose()");
        finish();
    }

    public void onClickSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        Launch4Result.launch(intent);
    }


    private void handleResult(ActivityResult result) {
        int resultCode = result.getResultCode();

        if (resultCode == RESULT_OK) {
            Intent data = result.getData();
            Log.d(TAG, "RESULT OK");
        } else if (resultCode == RESULT_CANCELED) {
            Log.d(TAG, "RESULT_CANCELED");
        } else {
            Log.d(TAG, "Unexpected error");
        }
    }


}