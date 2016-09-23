package com.company.main.io.commands;

import com.company.main.annotations.Alias;
import com.company.main.annotations.Inject;
import com.company.main.contracts.*;
import com.company.main.staticData.ExceptionMessages;
@Alias("order")
public class PrintOrderedStudentsCommand extends Command implements Executable {
    @Inject
    private Database repository;
    public PrintOrderedStudentsCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (this.checkLenght( 3) || checkLenght(4)) {
            String courseName = data[1];
            String orderType = data[2].toLowerCase();
            String takeCommand = data[3].toLowerCase();
            String takeQuantity = data[4].toLowerCase();

            this.tryParseParametersForOrder(takeCommand, takeQuantity, courseName, orderType);
        }
    }

    private void tryParseParametersForOrder(String takeCommand, String takeQuantity, String courseName, String orderType) throws IllegalArgumentException {
        if (!takeCommand.equals("take")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TAKE_COMMAND);
        }

        if (takeQuantity.equals("all")) {
            this.repository.orderAndTake(courseName, orderType);
            return;
        }

        try {
            this.repository.orderAndTake(courseName, orderType);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(ExceptionMessages.IVALID_TAKE_QUANTITY_PARAMETER);
        }
    }

}
