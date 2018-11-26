package com.epam.horoscope.model.signs;

import com.epam.horoscope.model.DateRange;
import com.epam.horoscope.model.elements.FireElement;

import java.util.Date;

public class Leo extends FireElement{

    final static int START_DAY = 23;
    final static int START_MONTH = 7;
    final static int FINISH_DAY = 22;
    final static int FINISH_MONTH = 8;

    public Leo() {
        super(new DateRange(START_DAY, START_MONTH, FINISH_DAY, FINISH_MONTH));
    }

    public String getName() {
        return "Лев";
    }

    public boolean isMyRange(Date date) {
        return false;
    }

    public String getSlogan() {
        return "Все будет хорошо, то есть, так, как захочу я";
    }

    public String getHobby() {
        return "Командовать и указывать.";
    }

    public String getHandBook() {
        return "Как стать звездой за 10 минут";
    }

    public String getAppropriateProfession() {
        return "всех начальников начальник";
    }
}
