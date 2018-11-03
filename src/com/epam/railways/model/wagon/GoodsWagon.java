package com.epam.railways.model.wagon;

/**
 * Created by Mussulmanbekova_GE on 02.11.2018.
 */
public abstract class GoodsWagon extends Wagon {

    public GoodsWagon() {
    }

    public GoodsWagon(float carryingCapacity, float lightWeight, float loadWeight) {
        super(carryingCapacity, lightWeight, loadWeight);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
