package com.epam.railways.model.train.factory;

import com.epam.railways.model.locomotive.Locomotive;
import com.epam.railways.model.wagon.Wagon;

import java.util.List;

public interface TrainFactory {
    public Locomotive createLocomotive();
    public Wagon createWagon ();
}
