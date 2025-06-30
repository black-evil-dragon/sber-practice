package ru.sbertech.practice.spookyshell.commands;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateCommand implements Command {
    private static final String word = "date";
    private static final String description = "выводит текущую дату";


    public DateCommand() {}

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
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
}