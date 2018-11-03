package com.epam.railways.model.wagon;

public class TankWagon extends GoodsWagon {

    public TankWagon() {
    }

    public TankWagon(float carryingCapacity, float lightWeight, float loadWeight) {
        super(carryingCapacity, lightWeight, loadWeight);
    }

    @Override
    public String toString() {
        return "TankWagon{" + super.toString();
    }
}
