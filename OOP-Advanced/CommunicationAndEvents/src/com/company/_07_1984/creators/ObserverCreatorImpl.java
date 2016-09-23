package com.company._07_1984.creators;

import com.company._07_1984.interfaces.Observer;
import com.company._07_1984.interfaces.ObserverCreator;
import com.company._07_1984.models.Institution;

public class ObserverCreatorImpl implements ObserverCreator {
    @Override
    public Observer create(String[] observerParameters) {
        String id = observerParameters[1];
        String name = observerParameters[2];
        String[] subjects = new String[observerParameters.length - 3];
        for (int i = 3; i < observerParameters.length; i++) {
            subjects[i - 3] = observerParameters[i];
        }

        return new Institution(id, name, subjects);
    }
}
