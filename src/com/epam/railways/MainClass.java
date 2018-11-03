package com.epam.railways;

import com.epam.railways.model.MakingUpOfTrainsPlan;
import com.epam.railways.model.locomotive.GoodsLocomotive;
import com.epam.railways.model.locomotive.PassangerLocomotive;
import com.epam.railways.model.train.GoodsShuntingMaster;
import com.epam.railways.model.train.PassengerShuntingMaster;
import com.epam.railways.model.train.ShuntingMaster;
import com.epam.railways.model.wagon.*;

public class MainClass {
    public static void main(String[] args) {
//        System.out.println(new GoodsShuntingMaster().createTrain());
//        System.out.println(new PassengerShuntingMaster().createTrain());

        float carryingCapacity = 30;
        float lightWeight = 58;
        float loadWeight = 25;
        float power = 496400;

        MakingUpOfTrainsPlan plan = new MakingUpOfTrainsPlan();
        plan.addLocomotive(new GoodsLocomotive(power));
        for (int i=0; i<7; i++) {
            plan.addWagon(new OpenWagon(carryingCapacity, lightWeight, loadWeight));
        }
        for (int i=0; i<4; i++) {
            plan.addWagon(new CoveredWagon(carryingCapacity, lightWeight, loadWeight));
        }
        System.out.println(plan);

        ShuntingMaster goodsShuntingMaster = new GoodsShuntingMaster(plan);
        System.out.println(goodsShuntingMaster.createTrain());
    }
}
