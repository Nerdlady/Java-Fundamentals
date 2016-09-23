package com.company._01EventImplementation;

import com.company._01EventImplementation.listeners.Handler;
import com.company._01EventImplementation.models.Dispatcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Dispatcher dispatcher = new Dispatcher();
        Handler handler = new Handler();
        dispatcher.addNameChangeListener(handler);
        while (true){
            String line = reader.readLine();
            if (line.equals("End")){
                break;
            }


            dispatcher.setName(line);
        }
    }
}
