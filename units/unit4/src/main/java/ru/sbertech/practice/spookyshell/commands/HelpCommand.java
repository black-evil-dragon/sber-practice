package ru.sbertech.practice.spookyshell.commands;

public class HelpCommand extends BaseCommand {

    private static final String COMMAND_WORD = "help";
    private static final String COMMAND_DESCRIPTION = "выводит список доступных команд";


    public HelpCommand() {
        super(COMMAND_WORD, COMMAND_DESCRIPTION);
    }


    @Override
    public void execute() {
        System.out.println("Вызван HelpCommand");
    }
}
