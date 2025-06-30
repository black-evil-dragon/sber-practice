package ru.sbertech.practice.spookyshell;

import ru.sbertech.practice.spookyshell.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Shell {
    private Map<String, Command> commands = new HashMap<>();

    public Shell() {
        init();
    }


    public void init() {
        ExitCommand exitCommand = new ExitCommand();
        commands.put(exitCommand.getCommandWord(), exitCommand);

        HelpCommand helpCommand = new HelpCommand();
        commands.put(helpCommand.getCommandWord(), helpCommand);

        DateCommand dateCommand = new DateCommand();
        commands.put(dateCommand.getCommandWord(), dateCommand);

        TimeCommand timeCommand = new TimeCommand();
        commands.put(timeCommand.getCommandWord(), timeCommand);

        PwdCommand pwdCommand = new PwdCommand();
        commands.put(pwdCommand.getCommandWord(), pwdCommand);


        helpCommand.setCommands(commands);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("GOLGANSE Corp. [Version 0.0.0.0.1]\n(c) Корпорация зла. Все права нужно защищать.\n");

        while (true) {
            System.out.print(">> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            Command command = commands.get(input);
            if (command == null) {
                System.out.printf("Ошибка: неизвестная команда " + input + "\n");
                continue;

            }

            command.execute();

            if (command instanceof ExitCommand) {
                break;
            }
        }

        scanner.close();
    }

}
