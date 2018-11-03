package com.epam.railways.model.train;

import com.epam.railways.model.BaseEntity;
import com.epam.railways.model.locomotive.Locomotive;
import com.epam.railways.model.wagon.Wagon;

import java.util.ArrayList;
import java.util.List;

import static com.epam.railways.Utilities.checkNull;

public abstract class Train extends BaseEntity{
    Locomotive locomotive;
    List<Wagon> wagons = new ArrayList<>();

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        checkNull(locomotive, "Неопределен объект locomotive.");
        this.locomotive = locomotive;
    }


    public List<Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(List<Wagon> wagons) {
        checkNull(wagons, "Неопределен объект wagons.");
        this.wagons = wagons;
    }

    public void addWagon(Wagon wagon) {
        checkNull(wagon, "Неопределен объект wagon.");
        if (!wagons.contains(wagon)) {
            wagons.add(wagon);
        }
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
