package com.epam.railways;

import com.epam.railways.model.MakingUpOfTrainsPlan;
import com.epam.railways.model.locomotive.Locomotive;
import com.epam.railways.model.ShuntingMaster;
import com.epam.railways.model.train.Train;
import com.epam.railways.model.wagon.Wagon;

import static com.epam.railways.model.train.TrainType.GOODS;
import static com.epam.railways.model.train.TrainType.PASSANGER;
import static com.epam.railways.model.wagon.WagonType.*;

public class MainClass {
    public static void main(String[] args) {

        float carryingCapacity = 30;
        float lightWeight = 58;
        float loadWeight = 25;
        float power = 496400;

        Locomotive locomotive = Locomotive.getInstance(GOODS, power);

        MakingUpOfTrainsPlan plan = new MakingUpOfTrainsPlan();
        for (int i=0; i<7; i++) {
            plan.addWagon(Wagon.getInstance(OPEN, carryingCapacity, lightWeight, loadWeight));
        }
        for (int i=0; i<4; i++) {
            plan.addWagon(Wagon.getInstance(COVERED, carryingCapacity, lightWeight, loadWeight));
        }
        //System.out.println(plan);

        ShuntingMaster goodsShuntingMaster = ShuntingMaster.getInstance(GOODS, locomotive, plan);
        try {
            Train train = goodsShuntingMaster.createTrain();
            System.out.println(train);
            System.out.println("Мощность локомотива в тоннах: " + train.getLocomotivePowerInTonn());
            System.out.println("Вес вагонов с грузом в тоннах: " + train.getFullWeight());
            System.out.println("Количество вагонов: " + train.getWagonCount());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
        System.out.println("***** Проверка на превышение грузоподъемноcти поезда *****" );
        for (int i=0; i<70; i++) {
            plan.addWagon(Wagon.getInstance(OPEN, carryingCapacity, lightWeight, loadWeight));
        }
        goodsShuntingMaster = ShuntingMaster.getInstance(GOODS, locomotive, plan);
        try {
            System.out.println(goodsShuntingMaster.createTrain());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("***** Проверка1 на несовместимость типов *****" );
        goodsShuntingMaster = ShuntingMaster.getInstance(PASSANGER, locomotive, plan);
        try {
            System.out.println(goodsShuntingMaster.createTrain());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("***** Проверка2 на несовместимость типов *****" );
        plan = new MakingUpOfTrainsPlan();
        for (int i=0; i<7; i++) {
            plan.addWagon(Wagon.getInstance(FIRST_CLASS, carryingCapacity, lightWeight, loadWeight));
        }
        for (int i=0; i<4; i++) {
            plan.addWagon(Wagon.getInstance(COVERED, carryingCapacity, lightWeight, loadWeight));
        }
        goodsShuntingMaster = ShuntingMaster.getInstance(GOODS, locomotive, plan);
        try {
            System.out.println(goodsShuntingMaster.createTrain());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
/*
Train{locomotive=id=1, power=496400.0}, wagons[type, fullweight]=[OPEN, 83.0], [OPEN, 83.0], [OPEN, 83.0], [OPEN, 83.0], [OPEN, 83.0],
                                        [OPEN, 83.0], [OPEN, 83.0], [COVERED, 83.0], [COVERED, 83.0], [COVERED, 83.0], [COVERED, 83.0]}
Мощность локомотива в тоннах: 2577.4783
Вес вагонов с грузом в тоннах: 913.0
Количество вагонов: 11

***** Проверка на превышение грузоподъемноcти поезда *****
Превышение грузоподъемности поезда
***** Проверка1 на несовместимость типов *****
Несовместимый тип локомотива
***** Проверка2 на несовместимость типов *****
Несовместимый тип wagon

 */
