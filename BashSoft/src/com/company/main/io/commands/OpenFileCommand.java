package com.company.main.io.commands;

import com.company.main.annotations.Alias;
import com.company.main.contracts.*;
import com.company.main.staticData.SessionData;

import java.awt.*;
import java.io.File;

@Alias("open")
public class OpenFileCommand extends Command implements Executable {

    public OpenFileCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (this.checkLenght( 2)) {

            String fileName = data[1];
            String filePath = SessionData.currentPath + "\\" + fileName;
            File file = new File(filePath);
            Desktop.getDesktop().open(file);
        }
    }
}
