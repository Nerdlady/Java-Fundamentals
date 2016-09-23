package com.company.main.io.commands;

import com.company.main.annotations.Alias;
import com.company.main.annotations.Inject;
import com.company.main.contracts.DirectoryManager;
import com.company.main.contracts.Executable;

@Alias("cdrel")
public class ChangeRelativePathCommand extends Command implements Executable {
    @Inject
    private DirectoryManager directoryManager;


    public ChangeRelativePathCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (this.checkLenght( 2)) {
            String relativePath = data[1];
            this.directoryManager.changeCurrentDirRelativePath(relativePath);
        }
    }
}
