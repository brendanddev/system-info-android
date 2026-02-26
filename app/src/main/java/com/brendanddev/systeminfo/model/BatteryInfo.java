package com.brendanddev.systeminfo.model;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

public class BatteryInfo {

    private final int level;
    private final int temperature;
    private final String status;
    private final String health;


    /**
     * Constructs a BatteryInfo object with the current battery information.
     * @param context The context used to register the battery receiver.
     */
    public BatteryInfo(Context context) {
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, filter);

        if (batteryStatus != null) {
            level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            temperature = batteryStatus.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1) / 10;

            int statusInt = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            status = statusInt == BatteryManager.BATTERY_STATUS_CHARGING ? "Charging" : "Not Charging";

            int healthInt = batteryStatus.getIntExtra(BatteryManager.EXTRA_HEALTH, -1);
            health = healthInt == BatteryManager.BATTERY_HEALTH_GOOD ? "Good" : "Poor";
        } else {
            level = -1;
            temperature = -1;
            status = "Unknown";
            health = "Unknown";
        }
    }

    public int getLevel() { return level; }
    public int getTemperature() { return temperature; }
    public String getStatus() { return status; }
    public String getHealth() { return health; }

}
