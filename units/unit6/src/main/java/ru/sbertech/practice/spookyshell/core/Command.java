package ru.sbertech.practice.spookyshell.core;

import java.lang.annotation.*;

public interface Command {
    void execute(String[] args);

//    String getCommandWord();
//    String getCommandDescription();
}

