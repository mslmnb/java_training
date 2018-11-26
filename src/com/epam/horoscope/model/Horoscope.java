package com.epam.horoscope.model;

import java.util.Calendar;

public abstract class Horoscope {

    private DateRange dateRange;

    public Horoscope(DateRange dateRange) {
        this.dateRange = dateRange;
    }

    public boolean isMyRange(Calendar date) {
        return dateRange.isMyRange(date);
    }

    public abstract String getName();
    public abstract String getElement();
    public abstract String getSlogan();
    public abstract String getHobby();
    public abstract String getHandBook();
    public abstract String getAppropriateProfession();

    @Override
    public String toString() {
        return "Созвездие: " + getName() + "\r\n" +
               "Стихия: " + getElement() + "\r\n" +
               "Девиз: " + getSlogan() + "\r\n" +
               "Хобби: " + getHobby() + "\r\n" +
               "Настольная книга: " + getHandBook() + "\r\n" +
               "Подходящая профессия: " + getAppropriateProfession() + "\r\n";

    }
}
