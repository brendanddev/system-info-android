package com.brendanddev.systeminfo.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import com.brendanddev.systeminfo.R;
import com.brendanddev.systeminfo.model.BatteryInfo;
import com.brendanddev.systeminfo.model.DeviceInfo;
import com.brendanddev.systeminfo.model.MemoryInfo;
import com.brendanddev.systeminfo.util.DataLoader;

/**
 * Handles the home screen.
 *
 * @author Brendan Dileo
 */
public class HomeActivity extends BaseActivity {
    private static final String TAG = "==== HomeActivity ====";
    private DataLoader dataLoader;
    private DeviceInfo deviceInfo;
    private BatteryInfo batteryInfo;
    private MemoryInfo memoryInfo;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    private String currentCategory;
    public static final String EXTRA_CATEGORY = "EXTRA_CATEGORY";


    @Override
    protected String getLogTag() { return TAG; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dataLoader = new DataLoader(this);
        deviceInfo = new DeviceInfo();
        batteryInfo = new BatteryInfo(this);
        memoryInfo = new MemoryInfo(this);

        // Register launcher to start an activity and handle the result
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                this::handleResult);

        currentCategory = dataLoader.loadSettings();

        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(this::onClickSettings);

        TextView welcomeMessageView = findViewById(R.id.welcomeMessage);
        SharedPreferences sharedPreferences = dataLoader.loadData();
        String name = sharedPreferences.getString(DataLoader.KEY_NAME, null);

        if (name == null) {
            showAlertDialog();
            return;
        }
        welcomeMessageView.setText("Welcome " + name + "!");
        updateCategoryLabel();
        updateCategoryData();

        Log.d(TAG, "Current Category: " + currentCategory);
    }

    /**
     * Called when activity comes back into focus.
     */
    @Override
    protected void onResume() {
        super.onResume();
        updateCategoryLabel();
        updateCategoryData();
        Log.d(TAG, "Current Category: " + currentCategory);
    }


    /**
     * Handles the result returned from the SettingsActivity.
     * @param result The result returned from the launched activity.
     */
    private void handleResult(ActivityResult result) {
        Log.d(TAG, "handleResult()");
        int resultCode = result.getResultCode();

        if (resultCode == RESULT_OK) {
            Intent data = result.getData();
            if (data != null && data.getStringExtra(EXTRA_CATEGORY) != null) {
                currentCategory = data.getStringExtra(EXTRA_CATEGORY);
            }
        } else if (resultCode == RESULT_CANCELED) {
            Log.d(TAG, "RESULT_CANCELLED");
        } else {
            Log.d(TAG, "Unexpected Error... Code: " + resultCode);
        }
    }

    /**
     * Displays an alert dialog to the screen.
     */
    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Data seems to be corrupted, please log out!");
        builder.setCancelable(false);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * Handles the settings button click.
     * @param view The view that was clicked.
     */
    private void onClickSettings(View view) {
        Log.d(TAG, "Settings Button is Clicked!");

        Intent intent = new Intent(this, SettingsActivity.class);
        intent.putExtra(EXTRA_CATEGORY, currentCategory);
        activityResultLauncher.launch(intent);
    }

    /**
     * Updates the selected category TextView based on the current category.
     */
    private void updateCategoryLabel() {
        TextView selectedCategoryValue = findViewById(R.id.selectedCategory);
        String category = dataLoader.loadSettings();
        selectedCategoryValue.setText(currentCategory);
    }

    /**
     * Updates the category data TextViews based on the current category.
     */
    private void updateCategoryData() {

        TextView labelOne = findViewById(R.id.labelOne);
        TextView labelTwo = findViewById(R.id.labelTwo);
        TextView labelThree = findViewById(R.id.labelThree);
        TextView labelFour = findViewById(R.id.labelFour);

        TextView fieldOne = findViewById(R.id.fieldOne);
        TextView fieldTwo = findViewById(R.id.fieldTwo);
        TextView fieldThree = findViewById(R.id.fieldThree);
        TextView fieldFour = findViewById(R.id.fieldFour);

        if (currentCategory.equals("DEVICE")) {
            labelOne.setText("Model");
            labelTwo.setText("Manufacturer");
            labelThree.setText("Brand");
            labelFour.setText("Type");

            fieldOne.setText(deviceInfo.getModel());
            fieldTwo.setText(deviceInfo.getManufacturer());
            fieldThree.setText(deviceInfo.getBrand());
            fieldFour.setText(deviceInfo.getType());

        } else if (currentCategory.equals("BATTERY")) {
            labelOne.setText("Level");
            labelTwo.setText("Temperature");
            labelThree.setText("Status");
            labelFour.setText("Health");

            fieldOne.setText(batteryInfo.getLevel() + "%");
            fieldTwo.setText(batteryInfo.getTemperature() + "°C");
            fieldThree.setText(batteryInfo.getStatus());
            fieldFour.setText(batteryInfo.getHealth());

        } else if (currentCategory.equals("MEMORY")) {
            labelOne.setText("Total RAM");
            labelTwo.setText("Available RAM");
            labelThree.setText("Total Storage");
            labelFour.setText("Available Storage");

            fieldOne.setText(memoryInfo.getTotalRam() + " MB");
            fieldTwo.setText(memoryInfo.getAvailableRam() + " MB");
            fieldThree.setText(memoryInfo.getTotalStorage() + " GB");
            fieldFour.setText(memoryInfo.getAvailableStorage() + " GB");

        }
    }




}