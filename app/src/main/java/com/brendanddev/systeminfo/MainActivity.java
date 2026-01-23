package com.brendanddev.systeminfo;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    private final static String TAG = "==== MainActivity ====";

    @Override
    protected String getLogTag() { return TAG; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int batteryPercentage = getBatteryPrecentage();

        TextView batteryPercentageTextView = (TextView) findViewById(R.id.batteryPercentage);
        batteryPercentageTextView.setText("" + batteryPercentageTextView.getText().toString() + "" + batteryPercentage);
    }



    public int getBatteryPrecentage() {
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryIntent = getApplicationContext().registerReceiver(null, intentFilter);

        try {
            int level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

            if (level != -1 && scale != -1) {
                return (level * 100) / scale;
            } else {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
    }



}