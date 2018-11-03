package com.epam.railways.model.train;

import com.epam.railways.model.BaseEntity;
import com.epam.railways.model.locomotive.Locomotive;
import com.epam.railways.model.train.factory.TrainFactory;
import com.epam.railways.model.wagon.Wagon;

import java.util.ArrayList;
import java.util.List;

public abstract class Train extends BaseEntity{
    Locomotive locomotive;
    List<Wagon> wagons = new ArrayList<>();

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }

    abstract void addWagon();
    abstract void addLocomotive();

    @Override
    public String toString() {
        return "Train{" +
                "locomotive=" + locomotive +
                ", wagons=" + wagons +
                '}';
    }
}
