package ru.sbertech.practice.spookyshell.commands.todolist.data;

import ru.sbertech.practice.spookyshell.commands.todolist.model.Task;

import java.util.List;

public interface TaskManager {
    void        add(Task task);
    List<Task>  getAll();
    Task        getById(String uid);
    void        update(Task task);
    void        delete(String uid);
}
