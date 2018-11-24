package com.epam.railways;

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
