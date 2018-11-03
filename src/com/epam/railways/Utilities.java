package com.epam.railways;

import com.epam.apartment.model.Direction;
import com.epam.apartment.model.Room;

import static com.epam.apartment.model.Direction.NORTH;
import static com.epam.apartment.model.Direction.SOUTH;

public class Utilities {

    public static void checkNull(Object obj, String message) {
        if (obj == null) {
            throw new NullPointerException(message);
        }
    }

    public static void checkPositive(float dimension, String message) {
        if (dimension <= 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
