package com.epam.railways.model.train.factory;

import com.epam.railways.model.locomotive.GoodsLocomotive;
import com.epam.railways.model.locomotive.Locomotive;
import com.epam.railways.model.wagon.CoveredWagon;
import com.epam.railways.model.wagon.Wagon;

public class GoodsTrainFactory implements TrainFactory {
    @Override
    public Locomotive createLocomotive() {
        return new GoodsLocomotive();
    }

    @Override
    public Wagon createWagon() {
        // выдавать грузовые вагоны случайным образом
        return new CoveredWagon();
    }
}
