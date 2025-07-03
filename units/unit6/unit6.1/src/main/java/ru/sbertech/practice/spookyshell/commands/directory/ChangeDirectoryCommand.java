package ru.sbertech.practice.spookyshell.commands.directory;

import ru.sbertech.practice.spookyshell.core.Command;
import ru.sbertech.practice.spookyshell.core.CommandExecutionException;
import ru.sbertech.practice.spookyshell.core.CommandInfo;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@CommandInfo(name = "cd", description = "сменить текущую директорию")
public class ChangeDirectoryCommand implements Command {

    @Override
    public void execute(String[] args) throws CommandExecutionException {
        if (args.length == 0) {
            // Если аргументов нет - переходим в домашнюю директорию
            System.setProperty("user.dir", System.getProperty("user.home"));
            return;
        }

        String targetPath = args[0];
        Path currentDir = Paths.get(System.getProperty("user.dir"));
        Path targetDir;

        if (targetPath.equals("~")) {
            targetDir = Paths.get(System.getProperty("user.home"));
        } else {
            targetDir = Paths.get(targetPath);
            if (!targetDir.isAbsolute()) {
                targetDir = currentDir.resolve(targetDir).normalize();
            }
        }

        File dir = targetDir.toFile();

        if (!dir.exists()) {
            throw new CommandExecutionException("cd", args,
                    "Директория не существует: " + targetDir);
        }

        if (!dir.isDirectory()) {
            throw new CommandExecutionException("cd", args,
                    "Указанный путь не является директорией: " + targetDir);
        }

        // Устанавливаем новую текущую директорию
        System.setProperty("user.dir", targetDir.toString());
    }
}