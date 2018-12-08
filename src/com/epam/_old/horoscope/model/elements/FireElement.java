package com.epam._old.horoscope.model.elements;

import com.epam._old.horoscope.model.DateRange;
import com.epam._old.horoscope.model.Horoscope;

public abstract class FireElement extends Horoscope {
    
    public FireElement(DateRange dateRange) {
        super(dateRange);
    }

    public String getElement() {
        return "Огонь";
    }
}
