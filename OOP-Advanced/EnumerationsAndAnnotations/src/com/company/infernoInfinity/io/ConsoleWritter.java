package com.company.infernoInfinity.io;

import com.company.infernoInfinity.interfaces.Writter;

public class ConsoleWritter implements Writter {
    @Override
    public void write(String mesage) {
        System.out.print(mesage);
    }

    @Override
    public void writeOnNewLine(String message) {
        System.out.println(message);
    }
}
