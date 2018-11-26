package com.epam.horoscope.model.elements;

import com.epam.horoscope.model.DateRange;
import com.epam.horoscope.model.Horoscope;

public abstract class EarthElement extends Horoscope {

    public EarthElement(DateRange dateRange) {
        super(dateRange);
    }

    public String getElement() {
        return "Земля";
    }
}
