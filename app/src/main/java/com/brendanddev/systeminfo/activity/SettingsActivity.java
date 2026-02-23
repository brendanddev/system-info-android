package com.brendanddev.systeminfo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.brendanddev.systeminfo.R;
import com.brendanddev.systeminfo.util.Category;
import com.brendanddev.systeminfo.util.DataLoader;

/**
 * Handles the settings screen.
 *
 * @author Brendan Dileo
 */
public class SettingsActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "==== SettingsActivity ====";
    public static final String EXTRA_CATEGORY = "EXTRA_CATEGORY";

    private DataLoader dataLoader;
    private Category selectedCategory = Category.DEVICE;



    @Override
    protected String getLogTag() {
        return TAG;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        dataLoader = new DataLoader(this);

        Spinner spinner = findViewById(R.id.categorySpinner);
        spinner.setOnItemSelectedListener(this);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(this::onClickSave);

        String category = dataLoader.loadSettings();
        int position = Category.positionFromString(category);
        spinner.setSelection(position);
    }

    /**
     * Handles the save button click.
     * @param view The view that was clicked.
     */
    private void onClickSave(View view) {
        String category = selectedCategory.toString();
        dataLoader.saveSettings(category);

        Intent returnIntent = new Intent();
        returnIntent.putExtra(EXTRA_CATEGORY, category);
        setResult(RESULT_OK, returnIntent);

        finish();
    }

    /**
     * Handles a spinner item being selected.
     *
     * @param parent The AdapterView where the selection happened
     * @param view The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id The row id of the item that is selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] categories = getResources().getStringArray(R.array.categories);
        selectedCategory = Category.mapPosition(position);
        Log.d(TAG, "Item Selected: " + categories[position] + ", Selected Category: " + selectedCategory);
    }

    /**
     * Handles selection disappearing.
     * @param parent The AdapterView that now contains no selected item.
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d(TAG, "Nothing Selected");
    }





}