package com.epam.railways.model.shunting.master;

import com.epam.railways.model.MakingUpOfTrainsPlan;
import com.epam.railways.model.locomotive.Locomotive;
import com.epam.railways.model.train.TrainType;

public abstract class ShuntingMasterFactory {
    public abstract ShuntingMaster createShuntingMaster(Locomotive locomotive, MakingUpOfTrainsPlan plan);
}
