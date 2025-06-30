package ru.sbertech.practice.spookyshell.commands;

import java.io.File;

public class PwdCommand extends BaseCommand {
    private static final String COMMAND_WORD = "pwd";
    private static final String COMMAND_DESCRIPTION = "выводит текущий рабочий каталог";

    public PwdCommand() {
        super(COMMAND_WORD, COMMAND_DESCRIPTION);
    }

    @Override
    public void execute() {
        System.out.println(new File("").getAbsolutePath());
    }
}