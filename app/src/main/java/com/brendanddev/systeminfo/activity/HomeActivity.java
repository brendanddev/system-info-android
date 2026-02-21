package com.brendanddev.systeminfo.activity;

import android.os.Bundle;

import com.brendanddev.systeminfo.R;

public class HomeActivity extends BaseActivity {

    private static final String TAG = "==== HomeActivity ====";


    @Override
    protected String getLogTag() { return TAG; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}