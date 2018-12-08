package com.epam._old.horoscope.model.signs;

import com.epam._old.horoscope.model.DateRange;
import com.epam._old.horoscope.model.elements.EarthElement;

import java.util.Date;

public class Capricorn extends EarthElement{

    final static int START_DAY = 22;
    final static int START_MONTH = 12;
    final static int FINISH_DAY = 19;
    final static int FINISH_MONTH = 1;

    public Capricorn() {
        super(new DateRange(START_DAY, START_MONTH, FINISH_DAY, FINISH_MONTH));
    }

    public String getName() {
        return "Козерог";
    }

    public boolean isMyRange(Date date) {
        return false;
    }

    public String getSlogan() {
        return "Я выдержанный, словно дорогой коньяк";
    }

    public String getHobby() {
        return "Играть в главного";
    }

    public String getHandBook() {
        return "Как стать властелином Вселенной";
    }

    public String getAppropriateProfession() {
        return "советник по финансам Билла Гейтса";
    }
}
