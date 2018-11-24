package com.epam.railways.model.locomotive;

import com.epam.railways.model.BaseEntity;
import com.epam.railways.model.train.TrainType;

import static com.epam.railways.Utilities.checkNull;
import static com.epam.railways.Utilities.checkPositive;

public class Locomotive extends BaseEntity {
    private TrainType trainType;
    private float power;

    private Locomotive(TrainType trainType, float power) {
        this.power = power;
        this.trainType = trainType;
    }

    public static Locomotive getInstance(TrainType trainType, float power) {
        checkNull(trainType, "Неопределен объект trainType");
        checkPositive(power, "Значение power должно быть положительно");
        return new Locomotive(trainType, power);
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        checkPositive(power, "Значение power должно быть положительно");
        this.power = power;
    }

    public TrainType getTrainType() {
        return trainType;
    }

    public void setTrainType(TrainType trainType) {
        this.trainType = trainType;
    }

    public float getPowerInTonn() {
        return (float)(power*0.93 -46678)/161;
    }

    @Override
    public String toString() {
        return "id=" + getId() +
                ", power=" + power +
                '}';
    }
}
