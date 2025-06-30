package ru.sbertech.practice.spookyshell;

import ru.sbertech.practice.spookyshell.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Shell {
    private final Map<String, Command> commands = new HashMap<>();

    public Shell() {
        BaseCommand[] availableCommands = {
            new ExitCommand(),
            new HelpCommand(),
            new DateCommand(),
            new TimeCommand(),
            new PwdCommand()
        };


        for (BaseCommand command : availableCommands) {
            commands.put(command.getCommandWord(), command);
        }

        // Документируем
        if (commands.get("help") instanceof HelpCommand) {
            ((HelpCommand) commands.get("help")).setCommands(commands);
        }
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
