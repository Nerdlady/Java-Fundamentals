package com.company.main.io.commands;

import com.company.main.annotations.Alias;
import com.company.main.annotations.Inject;
import com.company.main.contracts.*;

@Alias("cmp")
public class CompareFilesCommand extends Command implements Executable {
    @Inject
    private ContentComparer tester;
    public CompareFilesCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (this.checkLenght( 3)) {

            String firstPath = data[1];
            String secondPath = data[2];
            this.tester.compareContent(firstPath, secondPath);
        }
    }
}
