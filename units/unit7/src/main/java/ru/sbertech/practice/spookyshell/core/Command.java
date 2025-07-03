package ru.sbertech.practice.spookyshell.core;

import java.util.Collections;
import java.util.Map;

public interface Command {
    void execute(String[] args) throws CommandExecutionException;

    default Map<String, String> getSubCommands() {
        return Collections.emptyMap();
    }
}

