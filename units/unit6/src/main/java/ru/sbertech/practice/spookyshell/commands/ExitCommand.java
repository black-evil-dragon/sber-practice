package ru.sbertech.practice.spookyshell.commands;


import ru.sbertech.practice.spookyshell.core.Command;
import ru.sbertech.practice.spookyshell.core.CommandInfo;

@CommandInfo(name="exit", description="завершает работу приложения")
public class ExitCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Завершение работы :D");
    }
}