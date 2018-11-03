package com.epam.railways.model.wagon;

public class FirstClassWagon extends PassengerWagon {

    public FirstClassWagon() {
    }

    public FirstClassWagon(float carryingCapacity, float lightWeight, float loadWeight) {
        super(carryingCapacity, lightWeight, loadWeight);
    }

    @Override
    public String toString() {
        return "FirstClassWagon{" + super.toString();
    }

}
