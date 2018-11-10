package com.epam.railways.model.shunting.master;

import com.epam.railways.model.MakingUpOfTrainsPlan;
import com.epam.railways.model.locomotive.Locomotive;
import com.epam.railways.model.wagon.Wagon;

import java.util.List;

import static com.epam.railways.Utilities.checkNull;
import static com.epam.railways.model.train.TrainType.GOODS;

public class GoodsShuntingMaster extends ShuntingMaster {

    private GoodsShuntingMaster(Locomotive locomotive, MakingUpOfTrainsPlan plan) {
        super(GOODS, locomotive, plan);
    }

    public static ShuntingMaster getInstance(Locomotive locomotive, MakingUpOfTrainsPlan plan) {
        checkNull(locomotive, "Неопределен объект locomotive");
        checkNull(plan, "Неопределен объект plan.");
        return new GoodsShuntingMaster(locomotive, plan);
    }

    @Override
    void shake(List<Wagon> wagons) {
        System.out.println("Запущен обработчик грузовых вагонов");
    }
}
