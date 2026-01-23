package com.brendanddev.systeminfo;

import android.os.Build;

public class DeviceInfo {

    private String model;
    private String manufacturer;
    private String brand;
    private String type;
    private int sdk;
    private String board;
    private String host;

    public DeviceInfo() {
        this.model = Build.MODEL;
        this.manufacturer = Build.MANUFACTURER;
        this.brand = Build.BRAND;
        this.type = Build.TYPE;
        this.sdk = Build.VERSION.SDK_INT;
        this.board = Build.BOARD;
        this.host = Build.HOST;
    }

    public String getModel() { return model; }
    public String getManufacturer() { return manufacturer; }
    public String getBrand() { return brand; }
    public String getType() { return type; }
    public int getSdk() { return sdk; }
    public String getBoard() { return board; }
    public String getHost() { return host; }


}