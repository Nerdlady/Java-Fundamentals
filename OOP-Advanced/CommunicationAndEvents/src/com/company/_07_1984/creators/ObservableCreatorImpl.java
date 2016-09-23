package com.company._07_1984.creators;

import com.company._07_1984.interfaces.Observable;
import com.company._07_1984.interfaces.ObservableCreator;
import com.company._07_1984.models.entities.Company;
import com.company._07_1984.models.entities.Employee;

public class ObservableCreatorImpl implements ObservableCreator {
    @Override
    public Observable createObservable(String[] observableParameters) {
        String type = observableParameters[0];
        String id = observableParameters[1];
        String name = observableParameters[2];

        switch (type) {
            case "Employee":
                int income = Integer.valueOf(observableParameters[3]);
                return new Employee(id, name, income);
            case "Company":
                int turnover = Integer.valueOf(observableParameters[3]);
                int revenue = Integer.valueOf(observableParameters[4]);
                return new Company(id, name, turnover, revenue);
            default:
                throw new IllegalArgumentException("Invalid entity type.");
        }
    }
}
