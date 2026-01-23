package com.brendanddev.systeminfo;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Base activity class that provides automatic lifecycle logging for all activities.
 */
public abstract class BaseActivity extends AppCompatActivity {


    /**
     * Each subclass will provide its implementation to retrieve the childs tag.
     *
     * @return The TAG string used for logging in the specific activity.
     */
    protected abstract String getLogTag();

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(getLogTag(), "onCreate()");
    }

    /**
     * Called after onCreate() or onRestart(), when the activity becomes visible.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(getLogTag(), "onStart()");
    }

    /**
     * Called after onPause() or onStart(), when the activity gains focus.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(getLogTag(), "onResume()");
    }

    /**
     * Called when another activity comes into the foreground.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(getLogTag(), "onPause()");
    }

    /**
     * Called when the activity is no longer visible.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(getLogTag(), "onStop()");
    }

    /**
     * Called when the user navigates back to the activity after onStop().
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(getLogTag(), "onRestart()");
    }

    /**
     * Called when the activity is finishing or being destroyed by the system.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(getLogTag(), "onDestroy()");
    }


}
