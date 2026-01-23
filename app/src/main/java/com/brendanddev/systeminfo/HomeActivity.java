package com.brendanddev.systeminfo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class HomeActivity extends BaseActivity {

    private final static String TAG = "==== HomeActivity ====";
    private final static String ACTIVITY = "Home";

    @Override
    protected String getLogTag() { return TAG; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView activityName = (TextView) findViewById(R.id.activityName);
        activityName.setText(ACTIVITY);

        TextView welcomeText = (TextView) findViewById(R.id.welcomeText);

        Intent intent = getIntent();
        String incomingText = intent.getStringExtra("username");

        String welcomeMessage = String.format("Welcome %s!", incomingText);
        welcomeText.setText(welcomeMessage);
    }
}