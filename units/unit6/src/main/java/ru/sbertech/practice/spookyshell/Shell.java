package ru.sbertech.practice.spookyshell;

import ru.sbertech.practice.spookyshell.commands.*;
import ru.sbertech.practice.spookyshell.core.Command;
import ru.sbertech.practice.spookyshell.core.CommandInfo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Shell {
    private final Map<String, Command> commands = new HashMap<>();

    public Shell() {
        try {
            String packageName = "ru.sbertech.practice.spookyshell.commands";
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String path = packageName.replace('.', '/');
            Enumeration<URL> resources = classLoader.getResources(path);

            while (resources.hasMoreElements()) {
                java.net.URL resource = resources.nextElement();
                if (resource.getProtocol().equals("file")) {
                    File file = new File(resource.getFile());
                    scanDirectory(file, packageName);
                }
            }

            setHelpCommands();
        } catch (Exception e) {
            if (e instanceof ClassNotFoundException) {
                System.out.println("Ошибка: не найден класс " + e.getMessage());
            } else {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }


    private void scanDirectory(File directory, String packageName) throws Exception {
        File[] files = directory.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                scanDirectory(file, packageName + "." + file.getName());
            } else if (file.getName().endsWith(".class")) {
                String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                Class<?> cls = Class.forName(className);

                if (cls.isAnnotationPresent(CommandInfo.class)) {
                    CommandInfo info = cls.getAnnotation(CommandInfo.class);
                    Command command = (Command) cls.getDeclaredConstructor().newInstance();
                    commands.put(info.name(), command);

                }
            }
        }
    }

    private void setHelpCommands() {
        for (Command command : commands.values()) {
            if (command instanceof HelpCommand) {
                ((HelpCommand) command).setCommands(commands);
            }
        }
    }

    public void run() {
        Path currentDir;
        Scanner scanner = new Scanner(System.in);

        System.out.println("GOLGANSE Corp. [Version 1.2]\n(c) Корпорация зла. Все права нужно защищать.");


        while (true) {
            currentDir = Paths.get(System.getProperty("user.dir"));

            System.out.print("\n" + currentDir + " @ ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split(" ");
            String commandName = parts[0];
            String[] args = Arrays.copyOfRange(parts, 1, parts.length);

            Command command = commands.get(commandName);
            if (command == null) {
                System.out.printf("Ошибка: неизвестная команда " + input + "\n");
                continue;
            }

            command.execute(args);

            if (command instanceof ExitCommand) {
                break;
            }
        }

        scanner.close();
    }

}
