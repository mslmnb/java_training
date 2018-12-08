package com.epam._old.horoscope.model.signs;

import com.epam._old.horoscope.model.DateRange;
import com.epam._old.horoscope.model.elements.FireElement;

import java.util.Date;

public class Aries extends FireElement {
    final static int START_DAY = 21;
    final static int START_MONTH = 3;
    final static int FINISH_DAY = 20;
    final static int FINISH_MONTH = 4;

    public Aries() {
        super(new DateRange(START_DAY, START_MONTH, FINISH_DAY, FINISH_MONTH));
    }

    public String getName() {
        return "Овен";
    }

    public boolean isMyRange(Date date) {
        return false;
    }

    public String getSlogan() {
        return "Там, где все тормозят, я жму на газ!";
    }

    public String getHobby() {
        return "Cперва делать, потом задавать вопросы.";
    }

    public String getHandBook() {
        return "Книга собственных мудрых мыслей и изречений в шестидесяти томах";
    }

    public String getAppropriateProfession() {
        return "сексопатолог";
    }
}
