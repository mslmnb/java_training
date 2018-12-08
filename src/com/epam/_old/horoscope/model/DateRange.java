package com.epam._old.horoscope.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateRange {
    private int startDay;
    private int startMonth;
    private int finishDay;
    private int finishMonth;

    public DateRange(int startDay, int startMonth, int finishDay, int finishMonth) {
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.finishDay = finishDay;
        this.finishMonth = finishMonth;
    }

    boolean isMyRange(Calendar date){
        boolean result = false;
        int decemberMonth = 12;
        int januaryMonth = 1;
        int year = date.get(Calendar.YEAR);
        Calendar startDate = new GregorianCalendar(year, startMonth - 1, startDay);
        year = (finishMonth == januaryMonth) ? year + 1 : year;
        Calendar finishDate = new GregorianCalendar(year, finishMonth - 1, finishDay);
        if (date.compareTo(startDate)>=0 && date.compareTo(finishDate)<=0) {
            result = true;
        }
        return result;

    }
}
