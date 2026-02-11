package com.brendanddev.systeminfo.model;

import android.os.Build;

public class DeviceInfo {

    private final String model;
    private final String manufacturer;
    private final String brand;
    private final String type;

    public DeviceInfo() {
        model = Build.MODEL;
        manufacturer = Build.MANUFACTURER;
        brand = Build.BRAND;
        type = Build.TYPE;
    }


    public String getModel() { return model; }
    public String getManufacturer() { return manufacturer; }
    public String getBrand() { return brand; }
    public String getType() { return type; }

}