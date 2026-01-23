package com.brendanddev.systeminfo;

import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void getDeviceInfo() {
        String model = Build.MODEL;
        String manufacturer = Build.MANUFACTURER;
        String brand = Build.BRAND;
        String type = Build.TYPE;
        int sdk = Build.VERSION.SDK_INT;
        String board = Build.BOARD;
        String host = Build.HOST;
    }



}