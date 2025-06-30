package ru.sbertech.practice.spookyshell.commands;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeCommand implements Command {
    private static final String word = "time";
    private static final String description = "выводит текущее время";

    public TimeCommand() {}

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
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}