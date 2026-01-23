package com.brendanddev.systeminfo.model;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

public class BatteryInfo {

    private int batteryPercentage;
    private String batteryHealth;
    private double batteryTemp;
    private boolean batteryExists;
    private boolean isCharging;
    private String chargeType;


    /**
     * Retrieves the current battery percentage.
     *
     * @param context
     * @return
     */
    public static int getBatteryPercentage(Context context) {
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, intentFilter);

        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        return level * 100 / scale;
    }

    public String getBatteryHealth() {
        return "BAD";
    }

    public double getBatteryTemp() {
        return 0.0;
    }

    public boolean isBatteryExists() {
        return false;
    }










}
