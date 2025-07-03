package ru.sbertech.practice.spookyshell.commands.system;

import ru.sbertech.practice.spookyshell.core.Command;
import ru.sbertech.practice.spookyshell.core.CommandInfo;

import java.util.Map;
import java.util.TreeMap;

@CommandInfo(name="help", description="выводит список доступных команд")
public class HelpCommand implements Command {
    private Map<String, Map<String, Command>> packageCommands = new TreeMap<>();


    private String resolvePackageName(Command command) {
        CommandInfo info = command.getClass().getAnnotation(CommandInfo.class);

        if (info != null && !info.packageName().isEmpty()) {
            return info.packageName();
        }

        Package pkg = command.getClass().getPackage();
        return pkg != null ? pkg.getName() : "default";
    }


    public void setCommands(Map<String, Command> commands) {
        this.packageCommands.clear();

        for (Command cmd : commands.values()) {
            String pkg = resolvePackageName(cmd);
            CommandInfo info = cmd.getClass().getAnnotation(CommandInfo.class);

            if (info != null) {
                this.packageCommands.computeIfAbsent(pkg, k -> new TreeMap<>()).put(info.name(), cmd);
            }
        }
    }


    @Override
    public void execute(String[] args) {
        System.out.println("Доступные команды:");
        for (Map.Entry<String, Map<String, Command>> pkgEntry : packageCommands.entrySet()) {
            System.out.println("[ " + pkgEntry.getKey() + " ]");

            for (Map.Entry<String, Command> cmdEntry : pkgEntry.getValue().entrySet()) {
                CommandInfo info = cmdEntry.getValue().getClass().getAnnotation(CommandInfo.class);
                System.out.println(">\t" + info.name() + " - " + info.description());
            }
            System.out.println();
        }
    }
}
