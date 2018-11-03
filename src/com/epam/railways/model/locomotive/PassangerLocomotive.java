package com.epam.railways.model.locomotive;

public class PassangerLocomotive extends Locomotive {

    public PassangerLocomotive() {
    }

    public PassangerLocomotive(float power) {
        super(power);
    }

    @Override
    public String toString() {
        return "PassangerLocomotive{" + super.toString();
    }

}
