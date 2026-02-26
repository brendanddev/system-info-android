package com.brendanddev.systeminfo.model;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;

public class MemoryInfo {

    private final long totalRam;
    private final long availableRam;
    private final long totalStorage;
    private final long availableStorage;

    /**
     * Constructs a MemoryInfo object with the current memory information.
     * @param context The context used to access the ActivityManager system service.
     */
    public MemoryInfo(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);

        totalRam = memoryInfo.totalMem / (1024 * 1024);
        availableRam = memoryInfo.availMem / (1024 * 1024);
        totalStorage = Environment.getDataDirectory().getTotalSpace() / (1024 * 1024 * 1024);
        availableStorage = Environment.getDataDirectory().getFreeSpace() / (1024 * 1024 * 1024);
    }

    public long getTotalRam() { return totalRam; }
    public long getAvailableRam() { return availableRam; }
    public long getTotalStorage() { return totalStorage; }
    public long getAvailableStorage() { return availableStorage; }


}
