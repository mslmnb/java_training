package com.epam.horoscope.model.elements;

import com.epam.horoscope.model.DateRange;
import com.epam.horoscope.model.Horoscope;

public abstract class WaterElement extends Horoscope {

    public WaterElement(DateRange dateRange) {
        super(dateRange);
    }

    public String getElement() {
        return "Вода";
    }
}
