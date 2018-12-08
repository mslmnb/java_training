package com.epam._old.horoscope.model.signs;

import com.epam._old.horoscope.model.DateRange;
import com.epam._old.horoscope.model.elements.AirElement;

import java.util.Date;

public class Aquarius extends AirElement {
    final static int START_DAY = 20;
    final static int START_MONTH = 1;
    final static int FINISH_DAY = 18;
    final static int FINISH_MONTH = 2;

    public Aquarius() {
        super(new DateRange(START_DAY, START_MONTH, FINISH_DAY, FINISH_MONTH));
    }

    public String getName() {
        return "Водолей";
    }

    public boolean isMyRange(Date date) {
        return false;
    }

    public String getSlogan() {
        return "Будущее зависит от меня";
    }

    public String getHobby() {
        return "маячить перед глазами";
    }

    public String getHandBook() {
        return "Как вырастить ежика в домашних условиях и спасти мир";
    }


    public String getAppropriateProfession() {
        return "инженер конструктор машины времени";
    }
}
