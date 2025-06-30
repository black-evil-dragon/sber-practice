package ru.sbertech.practice.spookyshell;

import ru.sbertech.practice.spookyshell.commands.Command;
import ru.sbertech.practice.spookyshell.commands.HelpCommand;

import java.util.HashMap;
import java.util.Map;

public class Shell {

    public void test() {
        Command helpCommand = new HelpCommand();

        Map<String, Command> commands = new HashMap<>() {{
            put(helpCommand.getCommandWord(), helpCommand);
        }};

    }

}
