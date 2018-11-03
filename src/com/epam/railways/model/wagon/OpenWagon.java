package com.epam.railways.model.wagon;

/**
 * Created by Mussulmanbekova_GE on 02.11.2018.
 */
public class OpenWagon extends GoodsWagon {

    public OpenWagon() {
    }

    public OpenWagon(float carryingCapacity, float lightWeight, float loadWeight) {
        super(carryingCapacity, lightWeight, loadWeight);
    }

    @Override
    public String toString() {
        return "OpenWagon{" + super.toString();
    }

}
