package com.epam.railways.model.shunting.master;

import com.epam.railways.model.MakingUpOfTrainsPlan;
import com.epam.railways.model.locomotive.Locomotive;
import com.epam.railways.model.train.TrainType;

public class GoodsShuntingMasterFactory extends ShuntingMasterFactory {
    @Override
    public ShuntingMaster createShuntingMaster(Locomotive locomotive, MakingUpOfTrainsPlan plan) {
        return GoodsShuntingMaster.getInstance(locomotive, plan);
    }
}
