package ru.sbertech.practice.spookyshell.commands.todolist;


import ru.sbertech.practice.spookyshell.commands.todolist.model.Task;
import ru.sbertech.practice.spookyshell.core.Command;
import ru.sbertech.practice.spookyshell.core.CommandExecutionException;
import ru.sbertech.practice.spookyshell.core.CommandInfo;

import ru.sbertech.practice.spookyshell.commands.todolist.data.H2Manager;
import ru.sbertech.practice.spookyshell.commands.todolist.service.TaskService;


import java.util.Arrays;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;


@CommandInfo(name = "task", description = "Менеджер задач", showOperations = true)
public class TaskCommand implements Command {
    private TaskService taskService = new TaskService(new H2Manager());
    private Map<String, String> COMMANDS = Map.of(
            "add", "Добавить задачу",
            "delete", "Удалить задачу",
            "complete", "Завершить задачу",
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
        String string = String.join(" ", params);

        if (command.isEmpty()) {
            printHelp();
            return;
        }


        if (!COMMANDS.containsKey(command)) {
            System.out.println("Команда не найдена. Напиши task для получения подробной информации!");
            return;
        }

        if (command.equals("add")) {
            taskService.addTask(string);

        } else if (command.equals("delete")) {
            taskService.deleteTask(params);

        } else if (command.equals("complete")) {
            taskService.completeTask(params);

        } else if (command.equals("show")) {
            List<Task> tasks = taskService.getAllTasks();

            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }


    private void printHelp() {
        System.out.println("Доступные команды ToDoLiMa-X:");
        for (Map.Entry<String, String> entry : COMMANDS.entrySet()) {
            System.out.println("\t" + entry.getKey() + " - " + entry.getValue());
        }
    }


    @Override
    public Map<String, String> getSubCommands() {
        return COMMANDS;
    }
}
