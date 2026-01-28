package com.brendanddev.systeminfo.model;

import android.os.Build;

public class DeviceInfo {

    private static String model;
    private static String manufacturer;
    private String brand;
    private String type;
    private int sdk;
    private String board;
    private String host;

    public DeviceInfo() {
        model = Build.MODEL;
        manufacturer = Build.MANUFACTURER;
        this.brand = Build.BRAND;
        this.type = Build.TYPE;
        this.sdk = Build.VERSION.SDK_INT;
        this.board = Build.BOARD;
        this.host = Build.HOST;
    }

    public static String getModel() { return model; }
    public static String getManufacturer() { return manufacturer; }
    public String getBrand() { return brand; }
    public String getType() { return type; }
    public int getSdk() { return sdk; }
    public String getBoard() { return board; }
    public String getHost() { return host; }


}