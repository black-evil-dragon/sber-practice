package ru.sbertech.practice.spookyshell.commands.directory;

import ru.sbertech.practice.spookyshell.core.Command;
import ru.sbertech.practice.spookyshell.core.CommandInfo;

import java.io.File;

@CommandInfo(name="pwd", description="выводит текущий рабочий каталог")
public class PwdCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }
}