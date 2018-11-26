package com.epam.horoscope.model.elements;

import com.epam.horoscope.model.DateRange;
import com.epam.horoscope.model.Horoscope;

public abstract class FireElement extends Horoscope {
    
    public FireElement(DateRange dateRange) {
        super(dateRange);
    }

    public String getElement() {
        return "Огонь";
    }
}
