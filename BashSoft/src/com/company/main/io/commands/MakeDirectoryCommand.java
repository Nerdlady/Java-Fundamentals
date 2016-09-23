package com.company.main.io.commands;

import com.company.main.annotations.Alias;
import com.company.main.annotations.Inject;
import com.company.main.contracts.*;

@Alias("mkdir")
public class MakeDirectoryCommand extends Command implements Executable {
    @Inject
    private DirectoryManager ioManager;
    public MakeDirectoryCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (this.checkLenght(2)) {

            String folderName = data[1];
            this.ioManager.createDirectoryInCurrentFolder(folderName);
        }
    }
}
