package ru.sbertech.practice.spookyshell.commands;

import java.io.File;

public class PwdCommand implements Command {
    private static final String word = "pwd";
    private static final String description = "выводит текущий рабочий каталог";

    public PwdCommand() {}

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
        System.out.println(new File("").getAbsolutePath());
    }
}