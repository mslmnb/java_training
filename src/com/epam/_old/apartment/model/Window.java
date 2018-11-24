package com.epam.apartment.model;

import static com.epam.apartment.Utilities.checkPositive;

public class Window extends BaseEntity {

    private float height;
    private float width;

    public Window(float height, float width) {
        checkPositive(height, "Значение height должно быть положительно");
        checkPositive(width, "Значение width должно быть положительно");
        this.height = height;
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "Window{" +
                "id=" + getId() +
                '}';
    }
}
