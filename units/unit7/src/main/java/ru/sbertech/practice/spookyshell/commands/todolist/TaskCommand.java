package ru.sbertech.practice.spookyshell.commands.todolist;


import ru.sbertech.practice.spookyshell.core.Command;
import ru.sbertech.practice.spookyshell.core.CommandExecutionException;
import ru.sbertech.practice.spookyshell.core.CommandInfo;

import ru.sbertech.practice.spookyshell.commands.todolist.data.H2Manager;
import ru.sbertech.practice.spookyshell.commands.todolist.service.TaskService;


import java.util.Arrays;
import java.util.Map;


@CommandInfo(name = "task", description = "Менеджер задач", showOperations = true)
public class TaskCommand implements Command {
    private TaskService taskService = new TaskService(new H2Manager());
    private Map<String, String> COMMANDS = Map.of(
            "add", "Добавить задачу",
            "remove", "Удалить задачу",
            "done", "Завершить задачу",
            "show", "Показать список задач"
    );
    @Override
    public void execute(String[] args) throws CommandExecutionException {
        if (args.length < 1) {
            printHelp();
            return;
        }

        String command = args[0];
        String[] params = Arrays.copyOfRange(args, 1, args.length);

        if (command.isEmpty()) {
            printHelp();
            return;
        }

        System.out.println("command: " + command);
        System.out.println("params: " + Arrays.toString(params));
    }

    private void printHelp() {
        System.out.println("Доступные команды ToDo List Manager X:");
        for (Map.Entry<String, String> entry : COMMANDS.entrySet()) {
            System.out.println("\t" + entry.getKey() + " - " + entry.getValue());
        }
    }

    @Override
    public Map<String, String> getSubCommands() {
        return COMMANDS;
    }
}
