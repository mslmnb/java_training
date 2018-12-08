package com.epam._old.horoscope.model.signs;

import com.epam._old.horoscope.model.DateRange;
import com.epam._old.horoscope.model.elements.AirElement;

import java.util.Date;

public class Libra extends AirElement{

    final static int START_DAY = 24;
    final static int START_MONTH = 9;
    final static int FINISH_DAY = 23;
    final static int FINISH_MONTH = 10;

    public Libra() {
        super(new DateRange(START_DAY, START_MONTH, FINISH_DAY, FINISH_MONTH));
    }

    public String getName() {
        return "Весы";
    }

    public boolean isMyRange(Date date) {
        return false;
    }

    public String getSlogan() {
        return "Долго запрягаю, то быстро еду";
    }

    public String getHobby() {
        return "Cмотреться в зеркало.";
    }

    public String getHandBook() {
        return "Как стать похожим на Мону Лизу";
    }

    public String getAppropriateProfession() {
        return "защитник окружающей среды";
    }
}
