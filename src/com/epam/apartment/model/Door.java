package com.epam.apartment.model;

public class Door extends BaseEntity {

    public Door() {}

    private float height;
    private float Width;

    public Door(float height, float width) {
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
