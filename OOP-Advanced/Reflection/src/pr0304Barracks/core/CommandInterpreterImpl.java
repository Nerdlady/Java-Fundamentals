package pr0304Barracks.core;

import pr0304Barracks.contracts.*;
import pr0304Barracks.core.commands.Command;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMANDS_PACKAGE = "pr0304Barracks.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String pathName = COMMANDS_PACKAGE + commandName.toUpperCase().charAt(0) + commandName.substring(1) + "Command";
        Executable command = null;
        try {
            Class<Command> commandClass = (Class<Command>)Class.forName(pathName);
            Constructor constructor = commandClass.getConstructor(String[].class);
            command = (Command) constructor.newInstance((Object) data);
            this.inject(commandClass,command);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return command;
    }

    private void inject(Class<Command> commandClass, Executable command) throws IllegalAccessException {
        Field[] commnadClassFields = commandClass.getDeclaredFields();
        Field[] fields = CommandInterpreterImpl.class.getDeclaredFields();

        for (Field commnadClassField : commnadClassFields) {
            if (!commnadClassField.isAnnotationPresent(Inject.class)){
                continue;
            }

            commnadClassField.setAccessible(true);
            for (Field field : fields) {
                if(!field.getType().equals(commnadClassField.getType())){
                    continue;
                }
                field.setAccessible(true);
                commnadClassField.set(command,field.get(this));
            }
        }
    }
}
