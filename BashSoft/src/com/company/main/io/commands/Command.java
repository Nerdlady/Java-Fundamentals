package com.company.main.io.commands;

import com.company.main.contracts.*;
import com.company.main.exceptions.InvalidCommandException;

public abstract class Command implements Executable{
    private String input;
    private String[] data;

    public Command(String input, String[] data) {
        setInput(input);
        setData(data);
    }

    public abstract void execute() throws Exception;

    protected String getInput() {
        return input;
    }

    protected void setInput(String input) {
        if (input == null || input.equals("")) {
            throw new InvalidCommandException(input);
        }
        this.input = input;
    }

    protected String[] getData() {
        return data;
    }

    protected void setData(String[] data) {
        if (data == null || data.length < 1) {
            throw new InvalidCommandException(this.input);
        }
        this.data = data;
    }

    protected boolean checkLenght( int count) {
        if (this.data.length != count) {
            throw new InvalidCommandException(this.input);
        }
        return true;
    }
}
