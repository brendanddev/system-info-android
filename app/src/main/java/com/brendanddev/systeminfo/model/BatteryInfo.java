package com.brendanddev.systeminfo.model;

<<<<<<< HEAD
=======
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

>>>>>>> cf1ea56cbfa1a940a40fd2aff7b4d9391ffb1a3e
public class BatteryInfo {

    private int batteryPercentage;
    private String batteryHealth;
    private double batteryTemp;
    private boolean batteryExists;
<<<<<<< HEAD
=======
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
>>>>>>> cf1ea56cbfa1a940a40fd2aff7b4d9391ffb1a3e










}
