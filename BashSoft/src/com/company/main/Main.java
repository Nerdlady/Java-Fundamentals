package com.company.main;

import com.company.main.contracts.*;
import com.company.main.io.CommandInterpreter;
import com.company.main.io.IOManager;
import com.company.main.io.InputReader;
import com.company.main.io.OutputWriter;
import com.company.main.judge.Tester;
import com.company.main.network.DownloadManager;
import com.company.main.repository.RepositoryFilter;
import com.company.main.repository.RepositorySorter;
import com.company.main.repository.StudentsRepository;


public class Main {

    public static void main(String[] args) {
        ContentComparer tester = new Tester();
        AsynchDownloader downloadManager = new DownloadManager();
        DirectoryManager ioManager = new IOManager();
        DataSorter sorter = new RepositorySorter();
        DataFilter filter = new RepositoryFilter();
        Database repository = new StudentsRepository(filter, sorter);
        Interpreter currentInterpreter = new CommandInterpreter(repository,tester,downloadManager,ioManager);
        Reader reader = new InputReader(currentInterpreter);

        try {
            reader.readCommands();
        } catch (Exception e) {
            OutputWriter.displayException(e.getMessage());
        }


    }
}
