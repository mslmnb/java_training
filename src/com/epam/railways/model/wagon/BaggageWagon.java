package com.epam.railways.model.wagon;

/**
 * Created by Mussulmanbekova_GE on 02.11.2018.
 */
public class BaggageWagon extends PassengerWagon {

    public BaggageWagon() {
    }

    public BaggageWagon(float carryingCapacity, float lightWeight, float loadWeight) {
        super(carryingCapacity, lightWeight, loadWeight);
    }

    @Override
    public String toString() {
        return "BaggageWagon{" + super.toString();
    }
}
