package com.epam.railways.model.wagon;

import com.epam.railways.model.BaseEntity;
import com.epam.railways.model.train.TrainType;

import static com.epam.railways.Utilities.checkNull;
import static com.epam.railways.Utilities.checkPositive;

public class Wagon extends BaseEntity {
    private WagonType type;
    private float carryingCapacity;
    private float lightWeight;
    private float loadWeight;

    public Wagon() {
    }

    private Wagon(WagonType type, float carryingCapacity, float lightWeight, float loadWeight) {
        this.type = type;
        this.carryingCapacity = carryingCapacity;
        this.lightWeight = lightWeight;
        this.loadWeight = loadWeight;
    }

    public static Wagon getInstance(WagonType type, float carryingCapacity, float lightWeight, float loadWeight) {
        checkNull(type,"Неопределен объект type");
        checkPositive(carryingCapacity, "Значение carryingCapacity должно быть положительно");
        checkPositive(lightWeight, "Значение lightWeight должно быть положительно");
        checkPositive(loadWeight, "Значение loadWeight должно быть положительно");
        if (carryingCapacity < loadWeight) {
            throw new IllegalArgumentException("Значение loadWeight не должно превышать carryingCapacity");
        }
        return new Wagon(type, carryingCapacity, lightWeight, loadWeight);
    }

        public WagonType getType() {
        return type;
    }

    public TrainType getTrainType() {
        return type.getTrainType();
    }

    public void setType(WagonType type) {
        this.type = type;
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

    public float getFullWeight() {
        return lightWeight + loadWeight;
    }

    @Override
    public String toString() {
        return "id=" + getId() +
                ", type=" + type +
                ", carryingCapacity=" + carryingCapacity +
                ", lightWeight=" + lightWeight +
                ", loadWeight=" + loadWeight +
                '}';
    }
}
