package com.epam.horoscope;

import com.epam.horoscope.model.Horoscope;
import com.epam.horoscope.model.signs.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class Testing {
    public static void main(String[] args) {
        int year = 2014;
        int month = 1;
        int day = 25;

        Calendar date = new GregorianCalendar(year, month - 1, day);

        List<Horoscope> horoscopeSigns = new ArrayList<>();
        horoscopeSigns.add(new Aquarius());
        horoscopeSigns.add(new Aries());
        horoscopeSigns.add(new Cancer());
        horoscopeSigns.add(new Capricorn());
        horoscopeSigns.add(new Gemini());
        horoscopeSigns.add(new Leo());
        horoscopeSigns.add(new Libra());
        horoscopeSigns.add(new Pisces());
        horoscopeSigns.add(new Sagittarius());
        horoscopeSigns.add(new Scorpio());
        horoscopeSigns.add(new Taurus());
        horoscopeSigns.add(new Virgo());

        System.out.println(horoscopeSigns.stream().filter(s->s.isMyRange(date)).collect(Collectors.toList()));
    }
}

/*
[Созвездие: Водолей
Стихия: Воздух
Девиз: Будущее зависит от меня
Хобби: маячить перед глазами
Настольная книга: Как вырастить ежика в домашних условиях и спасти мир
Подходящая профессия: инженер конструктор машины времени
]
 */
