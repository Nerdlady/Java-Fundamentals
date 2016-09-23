package com.company.main.io.commands;

import com.company.main.annotations.Alias;
import com.company.main.annotations.Inject;
import com.company.main.contracts.*;
@Alias("ls")
public class TraverseFoldersCommand extends Command implements Executable {
    @Inject
    private DirectoryManager ioManager;

    public TraverseFoldersCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (this.checkLenght( 1) && checkLenght(2)) {

            if (data.length == 1) {
                this.ioManager.traverseDirectory(0);
            }

            if (data.length == 2) {
                this.ioManager.traverseDirectory(Integer.parseInt(data[1]));
            }
        }
    }
}
