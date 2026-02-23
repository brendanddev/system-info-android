package com.brendanddev.systeminfo.util;


/**
 * Represents the available categories.
 *
 * @author Brendan Dileo
 */
public enum Category {
    DEVICE,
    BATTERY,
    MEMORY;

    /**
     * Maps a spinner position to its corresponding Category.
     * @param position The position selected in the spinner.
     * @return The Category at the given position.
     */
    public static Category mapPosition(int position) {
        return values()[position];      // 'values()' returns enum constants in an array
    }

    /**
     * Returns the spinner position of the given category string.
     * @param value The category string to find the position of.
     * @return The position of the category in the spinner.
     */
    public static int positionFromString(String value) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].toString().equals(value)) {
                return i;
            }
        }
        return 0;
    }

}
