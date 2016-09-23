package com.company.main.contracts;

import java.io.IOException;

public interface DirectoryCreator {
    void createDirectoryInCurrentFolder(String name) throws IOException;
    void changeCurrentDirAbsolute(String absolutePath) throws IOException;
}
