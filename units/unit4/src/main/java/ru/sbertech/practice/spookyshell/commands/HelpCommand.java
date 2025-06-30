package ru.sbertech.practice.spookyshell.commands;

import java.util.HashMap;
import java.util.Map;

public class HelpCommand extends BaseCommand {

    private static final String COMMAND_WORD = "help";
    private static final String COMMAND_DESCRIPTION = "выводит список доступных команд";


    private Map<String, Command> commands = new HashMap<>();

    public HelpCommand() {
        super(COMMAND_WORD, COMMAND_DESCRIPTION);
    }


    public void setCommands(Map<String, Command> commands) {
        if (commands != null) {
            this.commands = commands;
        }
    }


    @Override
    public void execute() {
        System.out.println("Доступные команды:");
        for (Command command : commands.values()) {
            if (command != null) {
                System.out.println(command.getCommandWord() + " - " + command.getCommandDescription());
            }
        }
    }
}
