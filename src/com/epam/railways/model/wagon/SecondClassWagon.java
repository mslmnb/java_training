package com.epam.railways.model.wagon;

public class SecondClassWagon extends PassengerWagon {

    public SecondClassWagon() {
    }

    public SecondClassWagon(float carryingCapacity, float lightWeight, float loadWeight) {
        super(carryingCapacity, lightWeight, loadWeight);
    }

    @Override
    public String toString() {
        return "SecondClassWagon{" + super.toString();
    }

}
