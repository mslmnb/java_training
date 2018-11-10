package com.epam.railways.model;

import com.epam.railways.model.locomotive.Locomotive;
import com.epam.railways.model.train.Train;
import com.epam.railways.model.train.TrainType;
import com.epam.railways.model.wagon.Wagon;

import static com.epam.railways.Utilities.checkNull;

public class ShuntingMaster {
    private TrainType trainType;
    private Locomotive locomotive;
    private MakingUpOfTrainsPlan plan;


    public ShuntingMaster() {
    }

    private ShuntingMaster(TrainType trainType, Locomotive locomotive, MakingUpOfTrainsPlan plan) {
        this.trainType = trainType;
        this.locomotive = locomotive;
        this.plan = plan;
    }

    public static ShuntingMaster getInstance(TrainType trainType, Locomotive locomotive, MakingUpOfTrainsPlan plan) {
        checkNull(trainType, "Неопределен объект trainType");
        checkNull(locomotive, "Неопределен объект locomotive");
        checkNull(plan, "Неопределен объект plan.");
        return new ShuntingMaster(trainType, locomotive, plan);
    }

    public TrainType getTrainType() {
        return trainType;
    }

    public void setTrainType(TrainType trainType) {
        checkNull(trainType, "Неопределен объект trainType.");
        this.trainType = trainType;
    }

    public MakingUpOfTrainsPlan getPlan() {
        return plan;
    }

    public void setPlan(MakingUpOfTrainsPlan plan) {
        checkNull(plan, "Неопределен объект plan.");
        this.plan = plan;
    }

    public Train createTrain() {
        checkNull(plan, "Неопределен объект plan.");
        Train train = Train.getInstance(trainType, locomotive);

        for (Wagon wagon : plan.getWagons()) {
            if (locomotive.getPowerInTonn() >= train.getFullWeight() + wagon.getFullWeight())
                train.addWagon(wagon);
            else {
                throw new IllegalArgumentException("Превышение грузоподъемности поезда");
            }
        }
        return train;
    }

}
