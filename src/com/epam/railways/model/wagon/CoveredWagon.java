package com.epam.railways.model.wagon;

public class CoveredWagon extends GoodsWagon {

    public CoveredWagon() {
    }

    public CoveredWagon(float carryingCapacity, float lightWeight, float loadWeight) {
        super(carryingCapacity, lightWeight, loadWeight);
    }

    @Override
    public String toString() {
        return "CoveredWagon{" + super.toString();
    }

}
