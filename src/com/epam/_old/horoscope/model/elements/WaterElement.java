package com.epam._old.horoscope.model.elements;

import com.epam._old.horoscope.model.DateRange;
import com.epam._old.horoscope.model.Horoscope;

public abstract class WaterElement extends Horoscope {

    public WaterElement(DateRange dateRange) {
        super(dateRange);
    }

    public String getElement() {
        return "Вода";
    }
}
