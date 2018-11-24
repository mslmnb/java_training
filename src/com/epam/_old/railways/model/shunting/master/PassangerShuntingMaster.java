package com.epam.railways.model.shunting.master;

import com.epam.railways.model.MakingUpOfTrainsPlan;
import com.epam.railways.model.locomotive.Locomotive;
import com.epam.railways.model.wagon.Wagon;

import java.util.List;

import static com.epam.railways.Utilities.checkNull;
import static com.epam.railways.model.train.TrainType.PASSANGER;

public class PassangerShuntingMaster extends ShuntingMaster {

    private PassangerShuntingMaster(Locomotive locomotive, MakingUpOfTrainsPlan plan) {
        super(PASSANGER, locomotive, plan);
    }

    public static ShuntingMaster getInstance(Locomotive locomotive, MakingUpOfTrainsPlan plan) {
        checkNull(locomotive, "Неопределен объект locomotive");
        checkNull(plan, "Неопределен объект plan.");
        return new PassangerShuntingMaster(locomotive, plan);
    }

    @Override
    void shake(List<Wagon> wagons) {
        System.out.println("Запущен обработчик пассажирских вагонов");
    }
}
