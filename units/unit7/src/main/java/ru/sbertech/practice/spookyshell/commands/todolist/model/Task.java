package ru.sbertech.practice.spookyshell.commands.todolist.model;

public class Task {
    private String uid;
    private String name;
    private boolean completed = false;


    public Task(String name) {
        this.name = name;
    }

    public Task(String uid, String name, boolean completed) {
        this.uid = uid;
        this.name = name;
        this.completed = completed;
    }



    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setCompleted(boolean b) {
        this.completed = b;
    }


    public String getName() {
        return name;
    }


    public boolean isCompleted() {
        return completed;
    }

    public String getUid() {
        return uid;
    }


    @Override
    public String toString() {
        if (completed) {
            return "[" + uid + "] " + name + " (done)";
        } else {
            return "[" + uid + "] " + name;
        }
    }
}
