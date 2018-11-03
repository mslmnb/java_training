package com.epam.railways.model.train.factory;

import com.epam.railways.model.locomotive.Locomotive;
import com.epam.railways.model.locomotive.PassangerLocomotive;
import com.epam.railways.model.wagon.FirstClassWagon;
import com.epam.railways.model.wagon.Wagon;

/**
 * Created by Mussulmanbekova_GE on 02.11.2018.
 */
public class PassengerTrainFactory implements TrainFactory {
    @Override
    public Locomotive createLocomotive() {
        return new PassangerLocomotive();
    }

    @Override
    public Wagon createWagon() {
        // выдавать пассажирские вагоны случайным образом
        return new FirstClassWagon();
    }

    @Override
    public Locomotive addLocomotive(Locomotive locomotive) {
        return null;
    }
}
