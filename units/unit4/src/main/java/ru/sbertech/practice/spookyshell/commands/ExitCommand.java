package ru.sbertech.practice.spookyshell.commands;

public class ExitCommand extends BaseCommand {
    private static final String COMMAND_WORD = "exit";
    private static final String COMMAND_DESCRIPTION = "завершает работу приложения";

    public ExitCommand() {
        super(COMMAND_WORD, COMMAND_DESCRIPTION);
    }

    @Override
    public void execute() {
        System.out.println("Завершение работы :D");
    }
}