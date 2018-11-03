package com.epam.railways.model.wagon;

import com.epam.railways.model.BaseEntity;
import static com.epam.railways.Utilities.checkPositive;

public abstract class Wagon extends BaseEntity {
    private float carryingCapacity;
    private float lightWeight;
    private float loadWeight;

    public Wagon() {
    }

    public Wagon(float carryingCapacity, float lightWeight, float loadWeight) {
        checkPositive(carryingCapacity, "Значение carryingCapacity должно быть положительно");
        checkPositive(lightWeight, "Значение lightWeight должно быть положительно");
        checkPositive(loadWeight, "Значение loadWeight должно быть положительно");
        if (carryingCapacity < loadWeight) {
            throw new IllegalArgumentException("Значение loadWeight не должно превышать carryingCapacity");
        }
        this.carryingCapacity = carryingCapacity;
        this.lightWeight = lightWeight;
        this.loadWeight = loadWeight;
    }

    public float getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(float carryingCapacity) {
        checkPositive(carryingCapacity, "Значение carryingCapacity должно быть положительно");
        if (carryingCapacity < this.loadWeight) {
            throw new IllegalArgumentException("Значение loadWeight не должно превышать carryingCapacity");
        }
        this.carryingCapacity = carryingCapacity;
    }

    public float getLightWeight() {
        return lightWeight;
    }

    public void setLightWeight(float lightWeight) {
        checkPositive(lightWeight, "Значение lightWeight должно быть положительно");
        this.lightWeight = lightWeight;
    }

    public float getLoadWeight() {
        return loadWeight;
    }

    public void setLoadWeight(float loadWeight) {
        checkPositive(loadWeight, "Значение loadWeight должно быть положительно");
        if (this.carryingCapacity < loadWeight) {
            throw new IllegalArgumentException("Значение loadWeight не должно превышать carryingCapacity");
        }
        this.loadWeight = loadWeight;
    }

    @Override
    public String toString() {
        return "id=" + getId() +
                ", carryingCapacity=" + carryingCapacity +
                ", lightWeight=" + lightWeight +
                ", loadWeight=" + loadWeight +
                '}';
    }
}
