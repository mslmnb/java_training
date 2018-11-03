package com.epam.railways.model.wagon;

public class ThirdClassWagon extends PassengerWagon {

    public ThirdClassWagon() {
    }

    public ThirdClassWagon(float carryingCapacity, float lightWeight, float loadWeight) {
        super(carryingCapacity, lightWeight, loadWeight);
    }

    @Override
    public String toString() {
        return "ThirdClassWagon{" + super.toString();
    }

}
