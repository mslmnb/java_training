package com.epam.railways.model.train;

import com.epam.railways.model.MakingUpOfTrainsPlan;

import static com.epam.railways.Utilities.checkNull;

public abstract class ShuntingMaster {
    private MakingUpOfTrainsPlan plan;

    public ShuntingMaster() {
    }

    public ShuntingMaster(MakingUpOfTrainsPlan plan) {
        checkNull(plan, "Неопределен объект plan.");
        this.plan = plan;
    }

    public MakingUpOfTrainsPlan getPlan() {
        return plan;
    }

    public void setPlan(MakingUpOfTrainsPlan plan) {
        checkNull(plan, "Неопределен объект plan.");
        this.plan = plan;
    }

    public abstract Train createTrain() ;
}
