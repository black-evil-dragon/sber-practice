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
    }

    public List<Task> getAllTasks() {
        return manager.getAll();
    }

    public void completeTask(int uid) {
        Task task = manager.getById(uid);
        if (task != null) {
            task.setCompleted(true);
            manager.update(task);
        }
    }
}
