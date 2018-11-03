package com.epam.railways.model.wagon;

import com.epam.railways.model.BaseEntity;

public abstract class Wagon extends BaseEntity {
    private float carryingCapacity;
    private float lightWeight;
    private float loadWeight;

    public float getCarryingCapacity() {
        return carryingCapacity;
    }

    void setCarryingCapacity(float carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public float getLightWeight() {
        return lightWeight;
    }

    void setLightWeight(float lightWeight) {
        this.lightWeight = lightWeight;
    }

    public float getLoadWeight() {
        return loadWeight;
    }

    void setLoadWeight(float loadWeight) {
        this.loadWeight = loadWeight;
    }
}
