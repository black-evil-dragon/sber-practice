package ru.sbertech.practice.spookyshell.commands;

import java.util.HashMap;
import java.util.Map;

public class HelpCommand implements Command {

    private static final String word = "help";
    private static final String description = "выводит список доступных команд";


    private Map<String, Command> commands = new HashMap<>();

    public HelpCommand() {}


    public void setCommands(Map<String, Command> commands) {
        if (commands != null) {
            this.commands = commands;
        }
    }


    @Override
    public String getCommandWord() {
        return word;
    }

    @Override
    public String getCommandDescription() {
        return description;
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
