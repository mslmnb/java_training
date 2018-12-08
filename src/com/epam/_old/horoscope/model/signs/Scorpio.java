package com.epam._old.horoscope.model.signs;

import com.epam._old.horoscope.model.DateRange;
import com.epam._old.horoscope.model.elements.WaterElement;

import java.util.Date;

public class Scorpio extends WaterElement{

    final static int START_DAY = 24;
    final static int START_MONTH = 10;
    final static int FINISH_DAY = 21;
    final static int FINISH_MONTH = 11;

    public Scorpio() {
        super(new DateRange(START_DAY, START_MONTH, FINISH_DAY, FINISH_MONTH));
    }

    public String getName() {
        return "Скорпион";
    }

    public boolean isMyRange(Date date) {
        return false;
    }

    public String getSlogan() {
        return "Для улыбки нужна веская причина";
    }

    public String getHobby() {
        return "Изводить людей своим поведением";
    }

    public String getHandBook() {
        return "1001 план по захвату мира";
    }

    public String getAppropriateProfession() {
        return "медиум, экстрасенс, таролог";
    }
}
