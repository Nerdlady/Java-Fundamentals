package com.company.main.io.commands;

import com.company.main.annotations.Alias;
import com.company.main.annotations.Inject;
import com.company.main.contracts.*;

@Alias("readdb")
public class ReadDatabaseCommand extends Command implements Executable {
    @Inject
    private Database repository;
    public ReadDatabaseCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (this.checkLenght(2)) {
            String fileName = data[1];
            this.repository.loadData(fileName);
        }
    }
}
