package ru.sbertech.practice.spookyshell.commands;

public abstract class BaseCommand implements Command {

    protected String COMMAND_WORD;
    protected String COMMAND_DESCRIPTION;

    public BaseCommand(String commandWord, String commandDescription) {
        if (commandWord != null) {
            this.COMMAND_WORD = commandWord;
            this.COMMAND_DESCRIPTION = commandDescription;
        }
    }
    @Override
    public String getCommandWord() {
        return COMMAND_WORD;
    }

    @Override
    public String getCommandDescription() {
        return COMMAND_DESCRIPTION;
    }


}
