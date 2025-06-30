package ru.sbertech.practice.spookyshell.commands;

public interface Command {

    String getCommandWord();
    String getCommandHelp();

    void execute();
}
