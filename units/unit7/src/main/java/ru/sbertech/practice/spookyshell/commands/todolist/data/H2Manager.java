package ru.sbertech.practice.spookyshell.commands.todolist.data;

import ru.sbertech.practice.spookyshell.commands.todolist.model.Task;

import java.util.List;

public class H2Manager implements TaskManager {

    @Override
    public void add(Task task) {

    }

    @Override
    public List<Task> getAll() {
        return List.of();
    }

    @Override
    public Task getById(int uid) {
        return null;
    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void delete(int uid) {

    }
}
