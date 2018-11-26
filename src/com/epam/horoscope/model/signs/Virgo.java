package com.epam.horoscope.model.signs;

import com.epam.horoscope.model.DateRange;
import com.epam.horoscope.model.elements.EarthElement;

import java.util.Date;

public class Virgo extends EarthElement{
    final static int START_DAY = 24;
    final static int START_MONTH = 9;
    final static int FINISH_DAY = 23;
    final static int FINISH_MONTH = 10;

    public Virgo() {
        super(new DateRange(START_DAY, START_MONTH, FINISH_DAY, FINISH_MONTH));
    }

    public String getName() {
        return "Весы";
    }

    public boolean isMyRange(Date date) {
        return false;
    }

    public String getSlogan() {
        return "Счастье — это когда ты все контролируешь";
    }

    public String getHobby() {
        return "Cуетиться и беспокоиться";
    }

    public String getHandBook() {
        return "Как правильно сложить рубашку. 1001 способ.";
    }

    public String getAppropriateProfession() {
        return "работник санэпиднадзора";
    }
}
