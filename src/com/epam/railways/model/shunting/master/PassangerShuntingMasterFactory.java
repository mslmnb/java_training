package com.epam.railways.model.shunting.master;

import com.epam.railways.model.MakingUpOfTrainsPlan;
import com.epam.railways.model.locomotive.Locomotive;
import com.epam.railways.model.train.TrainType;

public class PassangerShuntingMasterFactory extends ShuntingMasterFactory {
    @Override
    public ShuntingMaster createShuntingMaster(Locomotive locomotive, MakingUpOfTrainsPlan plan) {
        return PassangerShuntingMaster.getInstance(locomotive, plan);
    }
}
