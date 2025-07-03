package ru.sbertech.practice.spookyshell.core;

public class CommandExecutionException extends Exception {
    private final String commandName;
    private final String[] args;

    public CommandExecutionException(String commandName, String[] args, String message) {
        super(message);
        this.commandName = commandName;
        this.args = args;
    }

    public CommandExecutionException(String commandName, String[] args, String message, Throwable cause) {
        super(message, cause);
        this.commandName = commandName;
        this.args = args;
    }


    public String getCommandName() {
        return commandName;
    }

    public String[] getArgs() {
        return args;
    }
}