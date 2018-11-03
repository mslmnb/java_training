package com.epam.railways.model.wagon;

public abstract class PassengerWagon extends Wagon{

    public PassengerWagon() {
    }

    public PassengerWagon(float carryingCapacity, float lightWeight, float loadWeight) {
        super(carryingCapacity, lightWeight, loadWeight);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
