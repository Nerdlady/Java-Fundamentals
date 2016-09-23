package com.company.main.io.commands;

import com.company.main.annotations.Alias;
import com.company.main.annotations.Inject;
import com.company.main.contracts.DirectoryManager;
import com.company.main.contracts.Executable;

@Alias("cdabs")
public class ChangeAbsolutePathCommand extends Command implements Executable {
    @Inject
    private DirectoryManager ioManager;

    public ChangeAbsolutePathCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (this.checkLenght( 2)) {
            String absolutePath = data[1];
            this.ioManager.changeCurrentDirAbsolute(absolutePath);
        }
    }
}
