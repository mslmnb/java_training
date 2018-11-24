package com.epam.railways.model.train;

import com.epam.railways.model.BaseEntity;
import com.epam.railways.model.locomotive.Locomotive;
import com.epam.railways.model.wagon.Wagon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.railways.Utilities.checkNull;

public class Train extends BaseEntity {
    private TrainType type;
    private Locomotive locomotive;
    private List<Wagon> wagons = new ArrayList<>();

    private Train(TrainType type, Locomotive locomotive) {
        this.type = type;
        this.locomotive = locomotive;
    }

    public static Train getInstance(TrainType type, Locomotive locomotive) {
        checkNull(locomotive, "Неопределен объект locomotive.");
        checkNull(type, "Неопределен объект trainType.");
        if (!type.equals(locomotive.getTrainType())) {
            throw new IllegalArgumentException("Несовместимый тип локомотива");
        }
        return new Train(type, locomotive);
    }

    public TrainType getType() {
        return type;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void addWagon(Wagon wagon) {
        checkNull(wagon, "Неопределен объект wagon.");
        if (!type.equals(wagon.getTrainType())) {
            throw new IllegalArgumentException("Несовместимый тип wagon");
        }
        if (!wagons.contains(wagon)) {
            wagons.add(wagon);
        }
    }

    public float getFullWeight() {
        return (wagons.size()==0) ? 0 : wagons.stream().map(w->w.getFullWeight()).reduce((x, y) -> x+y).get();
    }

    public float getLocomotivePowerInTonn() {
        return locomotive.getPowerInTonn();
    }

    public int getWagonCount() {
        return wagons.size();
    }

    @Override
    public String toString() {
        return "Train{" +
                "locomotive=" + locomotive +
                ", wagons[type, fullweight]=" + wagons.stream()
                                    .map(w -> "[" + w.getType().name() + ", " +  w.getFullWeight() + "]")
                                    .collect(Collectors.joining(", ")) +
                '}';
    }
}
