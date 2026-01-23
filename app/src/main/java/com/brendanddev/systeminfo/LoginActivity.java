package com.brendanddev.systeminfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private final static String TAG = "==== LoginActivity ====";
    private final static String ACTIVITY = "Login";


    @Override
    protected String getLogTag() { return TAG; }

    /**
     *
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView activityName = (TextView) findViewById(R.id.activityName);
        activityName.setText(ACTIVITY);
    }


    @Override
    public void onClick(View view) {

//        Intent switchActivity = new Intent(LoginActivity.this, )

    }



}

//Intent switchActivity = new Intent(MainActivity.this, SecondActivity.class);
//startActivity(switchActivity);