package com.company._07_1984.inputOutput;

import com.company._07_1984.interfaces.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConcoleReader implements Reader {
    private BufferedReader reader;

    public ConcoleReader() {
        this.reader =  new BufferedReader(new InputStreamReader(System.in));;
    }

    @Override
    public String readLine() throws IOException {
        return reader.readLine();
    }
}
