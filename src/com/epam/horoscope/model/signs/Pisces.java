package com.epam.horoscope.model.signs;

import com.epam.horoscope.model.DateRange;
import com.epam.horoscope.model.elements.WaterElement;

import java.util.Date;

public class Pisces extends WaterElement {

    final static int START_DAY = 19;
    final static int START_MONTH = 2;
    final static int FINISH_DAY = 20;
    final static int FINISH_MONTH = 3;

    public Pisces() {
        super(new DateRange(START_DAY, START_MONTH, FINISH_DAY, FINISH_MONTH));
    }

    public String getName() {
        return "Рыбы";
    }

    public boolean isMyRange(Date date) {
        return false;
    }

    public String getSlogan() {
        return "Мое сочувствие вам очень дорого обойдется";
    }

    public String getHobby() {
        return "Cчитать ворон";
    }

    public String getHandBook() {
        return "Как подружиться с марсианами";
    }

    public String getAppropriateProfession() {
        return "профессиональный ревун";
    }
}
