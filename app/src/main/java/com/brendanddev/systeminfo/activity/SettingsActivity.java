package com.brendanddev.systeminfo.activity;

import android.os.Bundle;

import com.brendanddev.systeminfo.R;

/**
 * Handles the settings screen.
 *
 * @author Brendan Dileo
 */
public class SettingsActivity extends BaseActivity {

    private static final String TAG = "==== SettingsActivity ====";

    @Override
    protected String getLogTag() { return TAG; }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
}