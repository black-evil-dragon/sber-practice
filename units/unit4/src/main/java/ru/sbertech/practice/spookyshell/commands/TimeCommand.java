package ru.sbertech.practice.spookyshell.commands;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeCommand extends BaseCommand {
    private static final String COMMAND_WORD = "time";
    private static final String COMMAND_DESCRIPTION = "выводит текущее время";

    public TimeCommand() {
        super(COMMAND_WORD, COMMAND_DESCRIPTION);
    }

    @Override
    public void execute() {
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}