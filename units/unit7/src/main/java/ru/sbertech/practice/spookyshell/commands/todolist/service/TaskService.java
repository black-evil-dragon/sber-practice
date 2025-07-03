package ru.sbertech.practice.spookyshell.commands.todolist.service;

import ru.sbertech.practice.spookyshell.commands.todolist.data.TaskManager;
import ru.sbertech.practice.spookyshell.commands.todolist.model.Task;

import java.util.List;

public class TaskService {
    private final TaskManager manager;

    public TaskService(TaskManager manager) {
        this.manager = manager;
    }

    public void addTask(String name) {
        Task task = new Task(name);
        manager.add(task);

        System.out.printf("Задача [%s] %s добавлена%n", task.getUid(), task.getName());
    }

    public void addTask(String[] names) {
        for (String name : names) {
            addTask(name);
        }
    }

    public List<Task> getAllTasks() {
        return manager.getAll();
    }

    public void completeTask(String uid) {
        Task task = manager.getById(uid);
        if (task != null) {
            task.setCompleted(true);
            manager.update(task);

            System.out.printf("Задача [%s] %s завершена!%n", task.getUid(), task.getName());
        }
    }

    public void completeTask(String[] uids) {
        for (String uid : uids) {
            completeTask(uid);
        }
    }


    public void deleteTask(String uid) {
        Task task = manager.getById(uid);
        if (task != null) {
            manager.delete(uid);

            System.out.printf("Задача [%s] %s удалена!%n", task.getUid(), task.getName());

        }
    }

    public void deleteTask(String[] uids) {
        for (String uid : uids) {
            deleteTask(uid);
        }
    }
}
