package com.epam.railways.model.train;

import com.epam.railways.model.train.factory.GoodsTrainFactory;

/**
 * Created by Mussulmanbekova_GE on 02.11.2018.
 */
public class GoodsShuntingMaster extends ShuntingMaster{
    @Override
    public Train createTrain() {
        GoodsTrainFactory trainFactory = new GoodsTrainFactory();
        Train train = new GoodsTrain(trainFactory);
        train.addLocomotive();
        train.addWagon();
        return train;
    }
}
