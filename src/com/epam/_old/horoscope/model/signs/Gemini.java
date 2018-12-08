package com.epam._old.horoscope.model.signs;

import com.epam._old.horoscope.model.DateRange;
import com.epam._old.horoscope.model.elements.AirElement;

import java.util.Date;

public class Gemini extends AirElement{

    final static int START_DAY = 21;
    final static int START_MONTH = 5;
    final static int FINISH_DAY = 20;
    final static int FINISH_MONTH = 6;

    public Gemini() {
        super(new DateRange(START_DAY, START_MONTH, FINISH_DAY, FINISH_MONTH));
    }

    public String getName() {
        return "Близнецы";
    }

    public boolean isMyRange(Date date) {
        return false;
    }

    public String getSlogan() {
        return "Кто владеет информацией, тот владеет информацией";
    }

    public String getHobby() {
        return "Cовершать необдуманные поступки.";
    }

    public String getHandBook() {
        return "Как разговорить каменную глыбу";
    }

    public String getAppropriateProfession() {
        return "продавать воздух";
    }
}
