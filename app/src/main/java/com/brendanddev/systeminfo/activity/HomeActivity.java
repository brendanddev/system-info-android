package com.brendanddev.systeminfo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.brendanddev.systeminfo.R;
import com.brendanddev.systeminfo.model.BatteryInfo;
import com.brendanddev.systeminfo.model.DeviceInfo;


public class HomeActivity extends BaseActivity {

    private final static String TAG = "==== HomeActivity ====";
    private final static String ACTIVITY = "Home";
    private final static String[] options = {"Model", "Manufacturer", "Brand", "Type", "Battery Percentage"};

    @Override
    protected String getLogTag() { return TAG; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Set name of current activity
        TextView activityName = (TextView) findViewById(R.id.activityName);
        activityName.setText(ACTIVITY);

        // Set welcome message to include user name based on value passed in the intent
        Intent intent = getIntent();
        String incomingText = intent.getStringExtra("username");
        TextView welcomeText = (TextView) findViewById(R.id.welcomeText);
        String welcomeMessage = String.format("Welcome %s!", incomingText);
        welcomeText.setText(welcomeMessage);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        TextView spinnerLabel = (TextView) findViewById(R.id.spinnerLabel);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                options
        );



    }
}