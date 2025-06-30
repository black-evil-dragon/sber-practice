package ru.sbertech.practice.spookyshell.commands;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateCommand extends BaseCommand {
    private static final String COMMAND_WORD = "date";
    private static final String COMMAND_DESCRIPTION = "выводит текущую дату";


    public DateCommand() {
        super(COMMAND_WORD, COMMAND_DESCRIPTION);
    }

    @Override
    public void execute() {
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
}