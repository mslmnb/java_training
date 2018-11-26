package com.epam.horoscope.model.signs;

import com.epam.horoscope.model.DateRange;
import com.epam.horoscope.model.elements.EarthElement;

import java.util.Date;

public class Taurus extends EarthElement{
    final static int START_DAY = 24;
    final static int START_MONTH = 9;
    final static int FINISH_DAY = 23;
    final static int FINISH_MONTH = 10;

    public Taurus() {
        super(new DateRange(START_DAY, START_MONTH, FINISH_DAY, FINISH_MONTH));
    }

    public String getName() {
        return "Телец";
    }

    public boolean isMyRange(Date date) {
        return false;
    }

    public String getSlogan() {
        return "Храбрый идет первым,а умный — вторым!";
    }

    public String getHobby() {
        return "Беседовать за обедом.";
    }

    public String getHandBook() {
        return "Для истинных гурманов";
    }

    public String getAppropriateProfession() {
        return "инквизитор";
    }
}
