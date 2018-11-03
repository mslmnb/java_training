package com.epam.apartment.model;

import static com.epam.apartment.Utilities.checkPositive;

public class Door extends BaseEntity {

    public Door() {}

    private float height;
    private float Width;

    public Door(float height, float width) {
        checkPositive(height, "Значение height должно быть положительно");
        checkPositive(width, "Значение width должно быть положительно");
        this.height = height;
        Width = width;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return Width;
    }

    @Override
    public String toString() {
        return "Door{" +
                "id=" + getId() +
                '}';
    }
}
