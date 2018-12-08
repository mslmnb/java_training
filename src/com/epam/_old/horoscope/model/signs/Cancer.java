package com.epam._old.horoscope.model.signs;

import com.epam._old.horoscope.model.DateRange;
import com.epam._old.horoscope.model.elements.WaterElement;

import java.util.Date;

public class Cancer extends WaterElement{

    final static int START_DAY = 21;
    final static int START_MONTH = 6;
    final static int FINISH_DAY = 22;
    final static int FINISH_MONTH = 7;

    public Cancer() {
        super(new DateRange(START_DAY, START_MONTH, FINISH_DAY, FINISH_MONTH));
    }

    public String getName() {
        return "Рак";
    }

    public boolean isMyRange(Date date) {
        return false;
    }

    public String getSlogan() {
        return "Моему терпению нет предела";
    }

    public String getHobby() {
        return "Поплакать в жилетку друга";
    }

    public String getHandBook() {
        return "Искусство быть мучеником";
    }

    public String getAppropriateProfession() {
        return "оператор телефона доверия";
    }
}

