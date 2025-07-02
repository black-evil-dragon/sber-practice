package ru.sbertech.practice.spookyshell.commands.directory;

import ru.sbertech.practice.spookyshell.core.Command;
import ru.sbertech.practice.spookyshell.core.CommandExecutionException;
import ru.sbertech.practice.spookyshell.core.CommandInfo;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@CommandInfo(name = "ls", description = "показать содержимое директории")
public class ListDirectory implements Command {

    @Override
    public void execute(String[] args) throws CommandExecutionException {
        try {
            String targetPath = args.length > 0 ? args[0] : ".";
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
                throw new CommandExecutionException("ls", args,
                        "Директория не существует: " + targetDir);
            }

            if (!dir.isDirectory()) {
                throw new CommandExecutionException("ls", args,
                        "Указанный путь не является директорией: " + targetDir);
            }

            File[] files = dir.listFiles();
            if (files == null) {
                throw new CommandExecutionException("ls", args,
                        "Ошибка доступа к директории: " + targetDir);
            }

            for (File file : files) {
                System.out.println(file.getName());
            }
        } catch (SecurityException e) {
            throw new CommandExecutionException("ls", args,
                    "Ошибка безопасности при доступе к файловой системе", e);
        }
    }
}