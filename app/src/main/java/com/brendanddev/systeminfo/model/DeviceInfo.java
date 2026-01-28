package com.brendanddev.systeminfo.model;

import android.os.Build;

public class DeviceInfo {

    public static String getModel() { return Build.MODEL; }
    public static String getManufacturer() { return Build.MANUFACTURER; }
    public String getBrand() { return Build.BRAND; }
    public String getType() { return Build.TYPE; }

}