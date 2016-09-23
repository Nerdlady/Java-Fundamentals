package com.company.main.contracts;

import java.io.IOException;

public interface DirectoryChanger {
    void changeCurrentDirRelativePath(String relativePath) throws IOException;

}
