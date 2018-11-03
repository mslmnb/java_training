package com.epam.railways.model.train;

import com.epam.railways.model.BaseEntity;
import com.epam.railways.model.MakingUpOfTrainsPlan;
import com.epam.railways.model.locomotive.GoodsLocomotive;
import com.epam.railways.model.locomotive.Locomotive;
import com.epam.railways.model.train.factory.GoodsTrainFactory;
import com.epam.railways.model.wagon.GoodsWagon;
import com.epam.railways.model.wagon.PassengerWagon;
import com.epam.railways.model.wagon.Wagon;

import static com.epam.railways.Utilities.checkNull;

public class GoodsShuntingMaster extends ShuntingMaster {

    public GoodsShuntingMaster() {
    }

    public GoodsShuntingMaster(MakingUpOfTrainsPlan plan) {
        super(plan);
    }

    @Override
    public Train createTrain() {
        MakingUpOfTrainsPlan makingUpOfTrainsPlan = getPlan();
        checkNull(makingUpOfTrainsPlan, "Неопределен объект plan.");

        GoodsTrainFactory trainFactory = new GoodsTrainFactory();  // пересмотреть
        Train train = new GoodsTrain(trainFactory);                 // пересмотреть

        for (BaseEntity data : makingUpOfTrainsPlan.getDataSet()) {
            if (data instanceof Wagon) {
                if (data instanceof GoodsWagon) {
                    train.addWagon((GoodsWagon) data);
                } else {
                    throw new IllegalArgumentException("Вагон должен быть грузовым");
                }
            } else if (data instanceof GoodsLocomotive) {
                train.setLocomotive((GoodsLocomotive) data);
            } else {
                throw new IllegalArgumentException("Локомотив должен быть грузовым");
            }
        }

//        train.addLocomotive();
//        train.addWagon();
        return train;
    }
}
