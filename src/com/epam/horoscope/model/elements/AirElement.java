package com.epam.horoscope.model.elements;

import com.epam.horoscope.model.DateRange;
import com.epam.horoscope.model.Horoscope;

public abstract class AirElement extends Horoscope {

    public AirElement(DateRange dateRange) {
        super(dateRange);
    }

    public String getElement() {
        return "Воздух";
    }
}
