package com.brendanddev.systeminfo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.brendanddev.systeminfo.R;
import com.brendanddev.systeminfo.model.BatteryInfo;
import com.brendanddev.systeminfo.model.DeviceInfo;


public class HomeActivity extends BaseActivity {

    private final static String TAG = "==== HomeActivity ====";
    private final static String ACTIVITY = "Home";
    private final static String[] options = {"Model", "Manufacturer", "Brand", "Type", "Battery Percentage"};
    private final static String USERNAME = "username";

    @Override
    protected String getLogTag() { return TAG; }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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

        // Show spinner
        Spinner spinner = findViewById(R.id.spinner);
        TextView spinnerLabel = findViewById(R.id.spinnerLabel);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                options
        );
        spinner.setAdapter(adapter);

        // Attach on click listener to close button
        Button closeButton = findViewById(R.id.closeButton);
        closeButton.setOnClickListener(this::onClickClose);
    }

    public void onClickClose(View view) {
        Log.d(TAG, "onClickClose()");
        finish();
    }
}