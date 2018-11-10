package com.epam.railways.model.wagon;

import com.epam.railways.model.train.TrainType;

import static com.epam.railways.model.train.TrainType.*;

public enum WagonType {
    BAGGAGE(GOODS),
    COVERED(GOODS),
    OPEN(GOODS),
    TANK(GOODS),
    FIRST_CLASS(PASSANGER),
    SECOND_CLASS(PASSANGER),
    THIRD_CLASS(PASSANGER);

    TrainType trainType;

    WagonType(TrainType trainType) {
        this.trainType = trainType;
    }

    public TrainType getTrainType() {
        return trainType;
    }
}
