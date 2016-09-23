package com.company._07_1984.core;


import com.company._07_1984.interfaces.Dispatcher;
import com.company._07_1984.interfaces.Engine;
import com.company._07_1984.interfaces.Reader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class EngineImpl implements Engine {

    private Reader reader;
    private Dispatcher dispatcher;

    public EngineImpl(Reader reader,Dispatcher dispatcher) {
        this.reader = reader;
        this.dispatcher = dispatcher;
    }
    @Override
    public void run() throws IOException, InvocationTargetException, IllegalAccessException {
        String[] inputTokens = reader.readLine().split("\\s+");
        int entitiesCount = Integer.valueOf(inputTokens[0]);
        int institutionCount = Integer.valueOf(inputTokens[1]);
        int changesCount = Integer.valueOf(inputTokens[2]);

        this.dispatcher.readEntities(entitiesCount);
        this.dispatcher.readInstitutions(institutionCount);

        for (int i = 0; i < changesCount; i++) {
            inputTokens = reader.readLine().split("\\s+");
            this.dispatcher.executeChange(inputTokens);
        }

        this.dispatcher.printChanges();
    }
}
