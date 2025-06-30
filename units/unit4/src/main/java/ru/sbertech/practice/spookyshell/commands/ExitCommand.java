package ru.sbertech.practice.spookyshell.commands;

public class ExitCommand implements Command {
    private static final String word = "exit";
    private static final String description = "завершает работу приложения";

    public ExitCommand() {}

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
        System.out.println("Завершение работы :D");
    }
}