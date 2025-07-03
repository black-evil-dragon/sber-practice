package ru.sbertech.practice.spookyshell;


import ru.sbertech.practice.spookyshell.commands.system.ExitCommand;
import ru.sbertech.practice.spookyshell.commands.system.HelpCommand;
import ru.sbertech.practice.spookyshell.core.Command;
import ru.sbertech.practice.spookyshell.core.CommandExecutionException;
import ru.sbertech.practice.spookyshell.core.CommandInfo;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Shell {
    /// Карта для хранения всех команд
    private final Map<String, Command> commands = new HashMap<>();


    /// 1. Сканирует пакет с командами
    /// 2. Создает экземпляр каждого класса, помеченного аннотацией @CommandInfo
    /// 3. Сохраняет экземпляры команд в Map
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


    /// Рекурсивное сканирование директории на наличие классов команд.
    ///
    /// @param directory   Директория для сканирования
    /// @param packageName Имя пакета для поиска классов
    /// @throws Exception Может выбросить различные исключения при работе с классами
    private void scanDirectory(File directory, String packageName) throws Exception {
        File[] files = directory.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                // again
                scanDirectory(file, packageName + "." + file.getName());

            } else if (file.getName().endsWith(".class")) {
                String className = packageName + '.' + file.getName().replace(".class", "");
                Class<?> cls = Class.forName(className);

                if (cls.isAnnotationPresent(CommandInfo.class)) {
                    CommandInfo info = cls.getAnnotation(CommandInfo.class);
                    Command command = (Command) cls.getDeclaredConstructor().newInstance();
                    commands.put(info.name(), command);

                }
            }
        }
    }

    /// Устанавливает для команды Help ссылку на все остальные команды
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

            try {
                command.execute(args);
            } catch (CommandExecutionException e) {
                System.err.println("Ошибка выполнения команды '" + e.getCommandName() + "':");
                System.err.println("Причина: " + e.getMessage());
                if (e.getCause() != null) {
                    System.err.println("Детали: " + e.getCause().getMessage());
                }
                System.err.println("Аргументы: " + String.join(" ", e.getArgs()));
            }

            if (command instanceof ExitCommand) {
                break;
            }
        }

        scanner.close();
    }

}
