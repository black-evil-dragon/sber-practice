package ru.sbertech.practice.spookyshell.commands.directory;

import ru.sbertech.practice.spookyshell.core.Command;
import ru.sbertech.practice.spookyshell.core.CommandInfo;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@CommandInfo(name="ls", description="показать содержимое директории")
public class ListDirectory implements Command {

    @Override
    public void execute(String[] args) {
        String targetPath = args.length > 0 ? args[0] : ".";
        Path currentDir = Paths.get(System.getProperty("user.dir"));
        Path targetDir;

        if (targetPath.equals("~")) {
            targetDir = Paths.get(System.getProperty("user.home"));
        } else {
            targetDir = Paths.get(targetPath);
            // Если путь относительный - разрешаем относительно текущей директории
            if (!targetDir.isAbsolute()) {
                targetDir = currentDir.resolve(targetDir).normalize();
            }
        }

        File dir = targetDir.toFile();

        // Проверки
        if (!dir.exists()) {
            System.err.println("Директория не существует: " + targetDir);
            return;
        }

        if (!dir.isDirectory()) {
            System.err.println("Указанный путь не является директорией: " + targetDir);
            return;
        }

        // Получаем и выводим содержимое
        File[] files = dir.listFiles();
        if (files == null) {
            System.err.println("Ошибка доступа к директории: " + targetDir);
            return;
        }

        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
