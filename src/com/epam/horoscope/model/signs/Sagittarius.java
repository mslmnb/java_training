package com.epam.horoscope.model.signs;

import com.epam.horoscope.model.DateRange;
import com.epam.horoscope.model.elements.FireElement;

import java.util.Date;

public class Sagittarius extends FireElement {

    final static int START_DAY = 22;
    final static int START_MONTH = 11;
    final static int FINISH_DAY = 21;
    final static int FINISH_MONTH = 12;

    public Sagittarius() {
        super(new DateRange(START_DAY, START_MONTH, FINISH_DAY, FINISH_MONTH));
    }

    public String getName() {
        return "Стрелец";
    }

    public boolean isMyRange(Date date) {
        return false;
    }

    public String getSlogan() {
        return "Хоть я не обязательный, зато обаятельный";
    }

    public String getHobby() {
        return "Вешать лапшу на уши";
    }

    public String getHandBook() {
        return "Как стать философом на за пять минут";
    }

    public String getAppropriateProfession() {
        return "ловец пиратов в Карибском море";
    }
}
