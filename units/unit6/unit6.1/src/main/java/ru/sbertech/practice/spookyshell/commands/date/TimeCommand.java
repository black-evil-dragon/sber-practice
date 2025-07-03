package ru.sbertech.practice.spookyshell.commands.date;

import ru.sbertech.practice.spookyshell.core.Command;
import ru.sbertech.practice.spookyshell.core.CommandInfo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



@CommandInfo(name="time", description="выводит текущее время")
public class TimeCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}