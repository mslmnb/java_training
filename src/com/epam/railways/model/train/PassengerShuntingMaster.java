package com.epam.railways.model.train;

import com.epam.railways.model.train.factory.PassengerTrainFactory;

/**
 * Created by Mussulmanbekova_GE on 02.11.2018.
 */
public class PassengerShuntingMaster extends ShuntingMaster {
    @Override
    public Train createTrain() {
        PassengerTrainFactory trainFactory = new PassengerTrainFactory();
        Train train = new PassengerTrain(trainFactory);
        train.addLocomotive();
        train.addWagon();
        return train;
    }
}
