package com.company.main.io;

import com.company.main.contracts.DirectoryManager;
import com.company.main.exceptions.InvalidFileNameException;
import com.company.main.exceptions.InvalidPathException;
import com.company.main.staticData.SessionData;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class IOManager implements DirectoryManager {

    public void traverseDirectory(int depth) {
        LinkedList<File> subFolder = new LinkedList<>();
        String path = SessionData.currentPath;
        int initialIndentation = path.split("\\\\").length;
        File root = new File(path);
        subFolder.add(root);

        while (subFolder.size() != 0) {
            File currentFolder = subFolder.removeFirst();
            int currentIndentation = currentFolder.toString().split("\\\\").length - initialIndentation;

            if (depth - currentIndentation < 0) {
                break;
            }

            OutputWriter.writeMessageOnNewLine(currentFolder.toString());

            if (currentFolder.listFiles() != null) {
                for (File file : currentFolder.listFiles()) {
                    if (file.isDirectory()) {
                        subFolder.add(file);
                    } else {
                        int indexOfLastSlash = file.toString().lastIndexOf("\\");
                        for (int i = 0; i < indexOfLastSlash; i++) {
                            OutputWriter.writeMessage("-");
                        }

                        OutputWriter.writeMessageOnNewLine(file.getName());
                    }
                }
            }
        }
    }

    public void createDirectoryInCurrentFolder(String name) {
        String path = getCurrentDirectoryPath() + "\\" + name;
        File file = new File(path);
        boolean wasDirMade = file.mkdir();
        if (!wasDirMade) {
            throw new InvalidFileNameException();

        }
    }

    public void changeCurrentDirRelativePath(String relativePath) throws IOException {
        if (relativePath.equals("")) {
            try {
                String currentPath = SessionData.currentPath;
                int indexOfLastSlash = currentPath.lastIndexOf("\\");
                String newPath = currentPath.substring(0, indexOfLastSlash);
                SessionData.currentPath = newPath;
            } catch (StringIndexOutOfBoundsException sioobe) {
                throw new InvalidPathException();
            }

        } else {
            String currentPath = SessionData.currentPath;
            currentPath += "\\" + relativePath;
            changeCurrentDirAbsolute(currentPath);
        }
    }

    public void changeCurrentDirAbsolute(String absolutePath) throws IOException {
        File file = new File(absolutePath);
        if (!file.exists()) {
            throw new InvalidPathException();
        }
        SessionData.currentPath = absolutePath;
    }

    private String getCurrentDirectoryPath() {
        String currentPath = SessionData.currentPath;
        return currentPath;
    }
}
