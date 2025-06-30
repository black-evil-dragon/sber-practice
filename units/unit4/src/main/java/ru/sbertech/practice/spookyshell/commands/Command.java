package ru.sbertech.practice.spookyshell.commands;


public interface Command {

    String getCommandWord();
    String getCommandDescription();

    void execute();
}
