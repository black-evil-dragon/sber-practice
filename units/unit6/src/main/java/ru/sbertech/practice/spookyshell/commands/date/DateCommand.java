package ru.sbertech.practice.spookyshell.commands.date;

import ru.sbertech.practice.spookyshell.core.Command;
import ru.sbertech.practice.spookyshell.core.CommandInfo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@CommandInfo(name="date", description="выводит текущую дату")
public class DateCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
}