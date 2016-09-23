package com.company._07_1984;

import com.company._07_1984.core.DataImpl;
import com.company._07_1984.core.DispathcerImpl;
import com.company._07_1984.core.EngineImpl;
import com.company._07_1984.creators.ObservableCreatorImpl;
import com.company._07_1984.creators.ObserverCreatorImpl;
import com.company._07_1984.inputOutput.ConcoleReader;
import com.company._07_1984.inputOutput.ConsoleWriter;
import com.company._07_1984.interfaces.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ConcoleReader();
        Writter writter = new ConsoleWriter();
        Data data = new DataImpl();
        ObservableCreator observableCreator = new ObservableCreatorImpl();
        ObserverCreator observerCreator = new ObserverCreatorImpl();
        Dispatcher dispatcher = new DispathcerImpl(data,reader,writter,observerCreator,observableCreator);
        Engine engine = new EngineImpl(reader,dispatcher);
        try {
            engine.run();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
