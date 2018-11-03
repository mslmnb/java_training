package com.epam.railways.model;

import com.epam.railways.model.locomotive.Locomotive;
import com.epam.railways.model.wagon.Wagon;

import java.util.HashSet;
import java.util.Set;

import static com.epam.railways.Utilities.checkNull;

public class MakingUpOfTrainsPlan {
    Set<BaseEntity> dataSet = new HashSet<>();

    public Set<BaseEntity> getDataSet() {
        return dataSet;
    }

    public void setDataSet(Set<BaseEntity> dataSet) {
        this.dataSet = dataSet;
    }

    public void addLocomotive(Locomotive locomotive) {
        checkNull(locomotive, "Неопределен объект locomotive.");
        for (BaseEntity data: dataSet) {
            if (data instanceof Locomotive) {
                throw new IllegalArgumentException("Локомотив уже добавлен.");
            }
        }
        dataSet.add(locomotive);
    }

    public void deleteLocomotive(Locomotive locomotive) {
        checkNull(locomotive, "Неопределен объект locomotive.");
        for (BaseEntity data: dataSet) {
            if (locomotive.equals(data)) {
                dataSet.remove(data);
            }
        }
    }

    public void addWagon(Wagon wagon) {
        checkNull(wagon, "Неопределен объект wagon.");
        dataSet.add(wagon);
    }

    public void deleteWagon(Wagon wagon) {
        checkNull(wagon, "Неопределен объект wagon.");
        for (BaseEntity data: dataSet) {
            if (wagon.equals(data)) {
                dataSet.remove(data);
            }
        }

    }

    @Override
    public String toString() {
        return "MakingUpOfTrainsPlan{" +
                "dataSet=" + dataSet +
                '}';
    }
}
