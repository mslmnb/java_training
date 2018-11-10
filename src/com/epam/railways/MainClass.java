package com.epam.railways;

import com.epam.railways.model.MakingUpOfTrainsPlan;
import com.epam.railways.model.locomotive.Locomotive;
import com.epam.railways.model.shunting.master.GoodsShuntingMasterFactory;
import com.epam.railways.model.shunting.master.PassangerShuntingMasterFactory;
import com.epam.railways.model.shunting.master.ShuntingMaster;
import com.epam.railways.model.shunting.master.ShuntingMasterFactory;
import com.epam.railways.model.train.Train;
import com.epam.railways.model.train.TrainType;
import com.epam.railways.model.wagon.Wagon;

import static com.epam.railways.model.train.TrainType.GOODS;
import static com.epam.railways.model.train.TrainType.PASSANGER;
import static com.epam.railways.model.wagon.WagonType.*;

public class MainClass {
    public static void main(String[] args) {

        float carryingCapacity = 55;
        float lightWeight = 70;
        float loadWeight = 50;
        float power = 496400;

        System.out.println("***** СОЗДАНИЕ ПАССАЖИРСКОГО ПОЕЗДА *****");
        Locomotive locomotive = Locomotive.getInstance(PASSANGER, power);

        // Формирую план
        MakingUpOfTrainsPlan plan = new MakingUpOfTrainsPlan();
        for (int i=0; i<3; i++) {
            plan.addWagon(Wagon.getInstance(FIRST_CLASS, carryingCapacity, lightWeight, loadWeight));
        }
        for (int i=0; i<4; i++) {
            plan.addWagon(Wagon.getInstance(SECOND_CLASS, carryingCapacity, lightWeight, loadWeight));
        }

        // Формирую поезд
        ShuntingMaster shuntingMaster = createShuntingMaster(new PassangerShuntingMasterFactory(), locomotive, plan);
        createTrainAndPrint(shuntingMaster);

        System.out.println();


        System.out.println("***** СОЗДАНИЕ ГРУЗОВОГО ПОЕЗДА*****");
        locomotive = Locomotive.getInstance(GOODS, power);

        // Формирую план
        plan = new MakingUpOfTrainsPlan();
        for (int i=0; i<3; i++) {
            plan.addWagon(Wagon.getInstance(OPEN, carryingCapacity, lightWeight, loadWeight));
        }
        for (int i=0; i<4; i++) {
            plan.addWagon(Wagon.getInstance(COVERED, carryingCapacity, lightWeight, loadWeight));
        }

        // Формирую поезд
        shuntingMaster = createShuntingMaster(new GoodsShuntingMasterFactory(), locomotive, plan);
        createTrainAndPrint(shuntingMaster);

        System.out.println();
        System.out.println("***** Проверка на превышение грузоподъемноcти поезда *****" );
        for (int i=0; i<70; i++) {
            plan.addWagon(Wagon.getInstance(OPEN, carryingCapacity, lightWeight, loadWeight));
        }
        shuntingMaster = createShuntingMaster(new GoodsShuntingMasterFactory(), locomotive, plan);
        try {
            System.out.println(shuntingMaster.createTrain());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("***** Проверка1 на несовместимость типов *****" );
        shuntingMaster = createShuntingMaster(new PassangerShuntingMasterFactory(), locomotive, plan);
        try {
            System.out.println(shuntingMaster.createTrain());
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
        shuntingMaster = createShuntingMaster(new GoodsShuntingMasterFactory(), locomotive, plan);
        try {
            System.out.println(shuntingMaster.createTrain());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void createTrainAndPrint(ShuntingMaster shuntingMaster) {
        try {
            Train train = shuntingMaster.createTrain();
            System.out.println(train);
            System.out.println("Мощность локомотива в тоннах: " + train.getLocomotivePowerInTonn());
            System.out.println("Вес вагонов с грузом в тоннах: " + train.getFullWeight());
            System.out.println("Количество вагонов: " + train.getWagonCount());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static ShuntingMaster createShuntingMaster(ShuntingMasterFactory factory, Locomotive locomotive, MakingUpOfTrainsPlan plan) {
        return factory.createShuntingMaster(locomotive, plan);
    }

}
/*
***** СОЗДАНИЕ ПАССАЖИРСКОГО ПОЕЗДА *****
Запущен обработчик пассажирских вагонов
Train{locomotive=id=1, power=496400.0}, wagons[type, fullweight]=[FIRST_CLASS, 120.0], [FIRST_CLASS, 120.0], [FIRST_CLASS, 120.0], [SECOND_CLASS, 120.0], [SECOND_CLASS, 120.0], [SECOND_CLASS, 120.0], [SECOND_CLASS, 120.0]}
Мощность локомотива в тоннах: 2577.4783
Вес вагонов с грузом в тоннах: 840.0
Количество вагонов: 7

***** СОЗДАНИЕ ГРУЗОВОГО ПОЕЗДА*****
Запущен обработчик грузовых вагонов
Train{locomotive=id=10, power=496400.0}, wagons[type, fullweight]=[COVERED, 120.0], [COVERED, 120.0], [OPEN, 120.0], [OPEN, 120.0], [OPEN, 120.0], [COVERED, 120.0], [COVERED, 120.0]}
Мощность локомотива в тоннах: 2577.4783
Вес вагонов с грузом в тоннах: 840.0
Количество вагонов: 7

***** Проверка на превышение грузоподъемноcти поезда *****
Превышение грузоподъемности поезда
***** Проверка1 на несовместимость типов *****
Несовместимый тип локомотива
***** Проверка2 на несовместимость типов *****
Несовместимый тип wagon

 */
