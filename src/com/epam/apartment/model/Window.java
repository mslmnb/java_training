package com.epam.apartment.model;

public class Window extends BaseEntity {

    private float height;
    private float width;

    public Window(float height, float width) {
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
