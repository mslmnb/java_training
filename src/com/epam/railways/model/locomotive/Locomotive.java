package com.epam.railways.model.locomotive;

import com.epam.railways.model.BaseEntity;
import static com.epam.railways.Utilities.checkPositive;

public abstract class Locomotive extends BaseEntity{
    float power;

    public Locomotive() {
    }

    public Locomotive(float power) {
        checkPositive(power, "Значение power должно быть положительно");
        this.power = power;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        checkPositive(power, "Значение power должно быть положительно");
        this.power = power;
    }

    @Override
    public String toString() {
        return "id=" + getId() +
                ", power=" + power +
                '}';
    }
}
