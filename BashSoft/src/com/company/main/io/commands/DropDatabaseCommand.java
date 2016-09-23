package com.company.main.io.commands;

import com.company.main.annotations.Alias;
import com.company.main.annotations.Inject;
import com.company.main.contracts.Database;
import com.company.main.contracts.Executable;
import com.company.main.io.OutputWriter;

@Alias("dropdb")
public class DropDatabaseCommand extends Command implements Executable {
    @Inject
    private Database repository;
    public DropDatabaseCommand(String input, String[] data) {
        super(input, data);

    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (this.checkLenght( 1)) {
            this.repository.unloadData();
            OutputWriter.writeMessageOnNewLine("Database dropped!");
        }
    }
}
