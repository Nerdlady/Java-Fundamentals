package com.company._07_1984.interfaces;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface Dispatcher {
    void readEntities(int entitiesCount) throws IOException;
    void readInstitutions(int institutionsCount) throws IOException;
    void executeChange(String... changeTokens) throws IllegalAccessException, InvocationTargetException;
    void printChanges();
}
