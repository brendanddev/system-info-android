package com.brendanddev.systeminfo.activity;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.brendanddev.systeminfo.R;
import com.brendanddev.systeminfo.util.DataLoader;

/**
 * Handles the home screen.
 *
 * @author Brendan Dileo
 */
public class HomeActivity extends BaseActivity {
    private static final String TAG = "==== HomeActivity ====";
    private DataLoader dataLoader;


    @Override
    protected String getLogTag() { return TAG; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        dataLoader = new DataLoader(this);

        TextView welcomeMessageView = findViewById(R.id.welcomeMessage);
        SharedPreferences sharedPreferences = dataLoader.loadData();
        String name = sharedPreferences.getString(DataLoader.KEY_NAME, null);

        if (name == null) {
            showAlertDialog();
            return;
        }
        welcomeMessageView.setText("Welcome " + name + "!");
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


}