package com.epam.railways.model.locomotive;

public class GoodsLocomotive extends Locomotive {

    public GoodsLocomotive() {
    }

    public GoodsLocomotive(float power) {
        super(power);
    }

    @Override
    public String toString() {
        return "GoodsLocomotive{" + super.toString();
    }
}
