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
import com.brendanddev.systeminfo.model.DeviceInfo;
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
    private ActivityResultLauncher<Intent> activityResultLauncher;

    private String currentCategory = "DEVICE";
    public static final String REQUEST_RESULT="REQUEST_RESULT";


    @Override
    protected String getLogTag() { return TAG; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dataLoader = new DataLoader(this);
        deviceInfo = new DeviceInfo();

        // Register launcher to start an activity and handle the result
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                this::handleResult);

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
    }


    /**
     * Handles the result returned from the SettingsActivity.
     * @param result The result returned from the launched activity.
     */
    private void handleResult(ActivityResult result) {
        int resultCode = result.getResultCode();
        if (resultCode == RESULT_OK) {
            Intent data = result.getData();
            Log.d(TAG, "RESULT_OK... Data: " + data.getIntExtra(REQUEST_RESULT, 0));
        } else if (resultCode == RESULT_CANCELED) {
            Log.d(TAG, "REQUEST_CANCELED");
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
        activityResultLauncher.launch(intent);
    }

    /**
     * Updates the selected category TextView based on the current category.
     */
    private void updateCategoryLabel() {
        TextView selectedCategoryValue = findViewById(R.id.selectedCategory);
        selectedCategoryValue.setText(currentCategory);
    }

    /**
     * Updates the category data TextViews based on the current category.
     */
    private void updateCategoryData() {
        TextView modelValue = findViewById(R.id.modelValue);
        TextView manufacturerValue = findViewById(R.id.manufacturerValue);
        TextView brandValue = findViewById(R.id.brandValue);
        TextView typeValue = findViewById(R.id.typeValue);

        modelValue.setText(deviceInfo.getModel());
        manufacturerValue.setText(deviceInfo.getManufacturer());
        brandValue.setText(deviceInfo.getBrand());
        typeValue.setText(deviceInfo.getType());
    }




}