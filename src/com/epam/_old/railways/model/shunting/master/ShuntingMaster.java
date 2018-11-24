package com.epam.railways.model.shunting.master;

import com.epam.railways.model.MakingUpOfTrainsPlan;
import com.epam.railways.model.locomotive.Locomotive;
import com.epam.railways.model.train.Train;
import com.epam.railways.model.train.TrainType;
import com.epam.railways.model.wagon.Wagon;

import java.util.List;

import static com.epam.railways.Utilities.checkNull;

public abstract class ShuntingMaster {
    private TrainType trainType;
    private Locomotive locomotive;
    private MakingUpOfTrainsPlan plan;


    ShuntingMaster() {
    }

    ShuntingMaster(TrainType trainType, Locomotive locomotive, MakingUpOfTrainsPlan plan) {
        this.trainType = trainType;
        this.locomotive = locomotive;
        this.plan = plan;
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
        shake(train.getWagons());
        return train;
    }

    abstract void shake(List<Wagon> wagons);

}
