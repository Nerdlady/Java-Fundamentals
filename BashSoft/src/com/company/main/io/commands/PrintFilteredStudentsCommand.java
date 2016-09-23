package com.company.main.io.commands;

import com.company.main.annotations.Alias;
import com.company.main.annotations.Inject;
import com.company.main.contracts.*;
import com.company.main.staticData.ExceptionMessages;

@Alias("filter")
public class PrintFilteredStudentsCommand extends Command  implements Executable {
    @Inject
    private Database repository;

    public PrintFilteredStudentsCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (this.checkLenght(3) || checkLenght( 4)) {
            String course = data[1];
            String filter = data[2].toLowerCase();
            String takeCommand = data[3].toLowerCase();
            String takeQuantity = data[4].toLowerCase();

            this.tryParseParametersForFilter(takeCommand, takeQuantity, course, filter);
        }
    }


    private void tryParseParametersForFilter(
            String takeCommand, String takeQuantity,
            String courseName, String filter) throws IllegalArgumentException {
        if (!takeCommand.equals("take")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TAKE_COMMAND);
        }

        if (takeQuantity.equals("all")) {
            this.repository.filterAndTake(courseName, filter);
            return;
        }

        try {
            this.repository.filterAndTake(courseName, filter);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(ExceptionMessages.IVALID_TAKE_QUANTITY_PARAMETER);
        }
    }
}
