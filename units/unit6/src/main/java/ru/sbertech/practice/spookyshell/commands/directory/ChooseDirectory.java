package ru.sbertech.practice.spookyshell.commands.directory;


import ru.sbertech.practice.spookyshell.core.Command;
import ru.sbertech.practice.spookyshell.core.CommandInfo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CommandInfo(name="cd", description="смена текущей рабочей директории")
public class ChooseDirectory implements Command {

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.err.println("Не указана директория");
            return;
        }

        String newDirPath = args[0];
        Path newDir;


        if (newDirPath.equals("~")) {
            newDir = Paths.get(System.getProperty("user.home"));
        } else {
            newDir = Paths.get(newDirPath);

            // Если путь относительный - преобразуем относительно текущей директории
            if (!newDir.isAbsolute()) {
                newDir = Paths.get(System.getProperty("user.dir")).resolve(newDir).normalize();
            }
        }

        // Проверка существования директории
        if (!Files.exists(newDir)) {
            System.err.println("Директория не существует: " + newDir);
            return;
        }

        // Проверка, что это действительно директория
        if (!Files.isDirectory(newDir)) {
            System.err.println("Указанный путь не является директорией: " + newDir);
            return;
        }

        // Проверка прав на чтение
        if (!Files.isReadable(newDir)) {
            System.err.println("Нет прав на чтение директории: " + newDir);
            return;
        }

        try {
            System.setProperty("user.dir", newDir.toString());
            System.out.println("Текущая директория изменена на: " + newDir);
        } catch (SecurityException e) {
            System.err.println("Ошибка безопасности при смене директории: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ошибка при смене директории: " + e.getMessage());
        }
    }
}
