package com.epam.railways.model.train;

import com.epam.railways.model.train.factory.TrainFactory;

public class GoodsTrain extends Train{
    TrainFactory trainFactory;

    public GoodsTrain(TrainFactory trainFactory) {
        this.trainFactory = trainFactory;
    }

    @Override
    void addWagon() {
        getWagons().add(trainFactory.createWagon());
    }

    @Override
    void addLocomotive() {
        setLocomotive(trainFactory.createLocomotive());
    }
}
