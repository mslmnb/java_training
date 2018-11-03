package com.epam.railways;

import com.epam.railways.model.train.GoodsShuntingMaster;
import com.epam.railways.model.train.PassengerShuntingMaster;

public class MainClass {
    public static void main(String[] args) {
        System.out.println(new GoodsShuntingMaster().createTrain());
        System.out.println(new PassengerShuntingMaster().createTrain());

    }
}
