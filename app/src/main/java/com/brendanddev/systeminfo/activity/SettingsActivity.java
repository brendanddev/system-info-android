package com.brendanddev.systeminfo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.brendanddev.systeminfo.R;

public class SettingsActivity extends BaseActivity {

    private static final String TAG = "==== SettingsActivity ====";
    private static final String ACTIVITY = "Settings";

    @Override
    protected String getLogTag() { return TAG; }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Set name of current activity
        TextView activityName = findViewById(R.id.activityName);
        if (activityName != null) {
            activityName.setText(ACTIVITY);
        }

        Button closeButton = findViewById(R.id.closeButton);
        closeButton.setOnClickListener(this::onClickClose);
    }

    public static final String REQUEST_RESULT = "REQUEST_RESULT";

    public void onClickClose(View view) {
        Log.d(TAG, "onClickClose()");
        Intent returnIntent = new Intent();
        returnIntent.putExtra(SettingsActivity.REQUEST_RESULT, 42);
        setResult(RESULT_OK, returnIntent);
        finish();
    }

}