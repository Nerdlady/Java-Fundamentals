package com.company._07_1984.inputOutput;

import com.company._07_1984.interfaces.Writter;

public class ConsoleWriter implements Writter {
    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }

    @Override
    public void write(String message) {
        System.out.print(message);
    }
}
