package com.company.main.io;

import com.company.main.annotations.Alias;
import com.company.main.annotations.Inject;
import com.company.main.contracts.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;


public class CommandInterpreter implements Interpreter {
    private static final String COMMNADS_LOCATION ="src/com/company/main/io/commands";
    private static final String COMMNADS_PACKAGE ="com.company.main.io.commands.";
    private Database repository;
    private ContentComparer tester;
    private AsynchDownloader downloadManager;
    private DirectoryManager inputOutputManager;

    public CommandInterpreter(Database repository, ContentComparer tester, AsynchDownloader downloadManager, DirectoryManager inputOutputManager) {
        this.repository = repository;
        this.tester = tester;
        this.downloadManager = downloadManager;
        this.inputOutputManager = inputOutputManager;
    }

    public void interpretCommand(String input) {
        String[] data = input.split("\\s+");
        String commandName = data[0].toLowerCase();
        try {
            Executable command = parseCommand(input, data, commandName);
            command.execute();
        } catch (Exception e) {
            OutputWriter.displayException(e.getMessage());
        }
    }

    private Executable parseCommand(String input, String[] data, String command) throws IOException {
        File commandFolder = new File(COMMNADS_LOCATION);
        Executable executable =  null;
        for (File file : commandFolder.listFiles()) {
            if (!file.isFile() || !file.getName().endsWith(".java")){
                continue;
            }

            try {
                String className = file.getName().substring(0,file.getName().lastIndexOf("."));
                Class<Executable> executableClass = (Class<Executable>) Class.forName(COMMNADS_PACKAGE + className);

                if (!executableClass.isAnnotationPresent(Alias.class)){
                    continue;
                }
                 Alias alias = executableClass.getAnnotation(Alias.class);
                String value = alias.value();
                if (!value.equals(command)){
                    continue;
                }

                Constructor exeConstructor = executableClass.getConstructor(String.class,String[].class);
                executable = (Executable) exeConstructor.newInstance(input,data);
                this.injectDependancies(executable,executableClass);


            } catch (ReflectiveOperationException ex){
                ex.printStackTrace();
            }
        }

        return executable;
    }

    private void injectDependancies(Executable executable, Class<Executable> executableClass) throws ReflectiveOperationException {
        Field[] exeFields = executableClass.getDeclaredFields();
        Field[] theseFields = CommandInterpreter.class.getDeclaredFields();
        for (Field fieldToSet : exeFields) {
            if (!fieldToSet.isAnnotationPresent(Inject.class)){
                continue;
            }
            fieldToSet.setAccessible(true);

            for (Field thisField : theseFields) {
                if (!thisField.getType().equals(fieldToSet.getType())){
                    continue;
                }

                thisField.setAccessible(true);
                fieldToSet.set(executable,thisField.get(this));
            }

        }
    }


}
