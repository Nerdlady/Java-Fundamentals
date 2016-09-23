package com.company.main.exceptions;

public class InvalidCommandException extends RuntimeException {
    private static final String INVALID_COMMAND = "The command '%s' is invalid";
    public InvalidCommandException(String command) {
        super(String.format(INVALID_COMMAND,command));
    }

}
