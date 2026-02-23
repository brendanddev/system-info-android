package com.brendanddev.systeminfo.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Utility class for managing user data and preferences in SharedPreferences.
 *
 * @author Brendan Dileo
 */
public class DataLoader {

    private static final String TAG = "==== DataLoader ====";
    private Context context;
    public static final String SP_USER_DATA = "user_data";
    public static final String SP_USER_PREFS = "user_prefs";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_CATEGORY = "category";


    /**
     * Creates a new DataLoader instance.
     * @param context The application context used to access SharedPreferences.
     */
    public DataLoader(Context context) {
        this.context = context;
    }

    /**
     * Saves the users info to SharedPreferences.
     * @param name The users name.
     * @param email The users email.
     * @param password The users password.
     */
    public void saveData(String name, String email, String password) {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(SP_USER_DATA, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password);
        editor.apply();
        Log.d(TAG, "Saving User Data!");
    }

    /**
     * Saves the users preferences to SharedPreferences.
     * @param category The selected category.
     */
    public void saveSettings(String category) {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(SP_USER_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_CATEGORY, category);
        editor.apply();
        Log.d(TAG, "Saving User Preferences!");
    }

    /**
     * Loads the users saved data from SharedPreferences.
     * @return The SharedPreferences file containing the users data.
     */
    public SharedPreferences loadData() {
        return this.context.getSharedPreferences(SP_USER_DATA, Context.MODE_PRIVATE);
    }

    /**
     * Loads the users saved preferences from SharedPreferences.
     * @return The saved category string, defaults to DEVICE if none saved.
     */
    public String loadSettings() {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(SP_USER_PREFS, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_CATEGORY, Category.DEVICE.toString());
    }

}
