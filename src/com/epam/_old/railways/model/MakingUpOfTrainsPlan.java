package com.epam.railways.model;

import com.epam.railways.model.wagon.Wagon;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.epam.railways.Utilities.checkNull;

public class MakingUpOfTrainsPlan {
    Set<Wagon> wagons = new HashSet<>();

    public MakingUpOfTrainsPlan() {
    }

    public Set<Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(Set<Wagon> wagons) {
        this.wagons = wagons;
    }

    public void addWagon(Wagon wagon) {
        checkNull(wagon, "Неопределен объект wagon.");
        wagons.add(wagon);
    }

    public void deleteWagon(Wagon wagon) {
        checkNull(wagon, "Неопределен объект wagon.");
        for (BaseEntity data: wagons) {
            if (wagon.equals(data)) {
                wagons.remove(data);
            }
        }
    }

    @Override
    public String toString() {
        return "MakingUpOfTrainsPlan{" +
                "wagons[type, fullweight]==" + wagons.stream()
                .map(w -> "[" + w.getType().name() + ", " +  w.getFullWeight() + "]")
                .collect(Collectors.joining(", ")) +
                '}';
    }
}
