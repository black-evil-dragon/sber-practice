package ru.sbertech.practice.spookyshell.commands.todolist.data;

import ru.sbertech.practice.spookyshell.commands.todolist.model.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2Manager implements TaskManager, AutoCloseable {
    private static final String DB_URL = "jdbc:h2:./todo_db";
    private static final String DB_USER = "spookyshell";
    private static final String DB_PASSWORD = "";

    private final Connection connection;


    public H2Manager() {
        try {
            this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            initializeDatabase();
//            System.out.println("[DEBUG] H2Manager: База данных H2 успешно инициализирована.");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize H2 database", e);
        }
    }


    private void initializeDatabase() throws SQLException {
        String query = """
                CREATE TABLE IF NOT EXISTS tasks (
                    uid INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(255) NOT NULL,
                    completed BOOLEAN DEFAULT FALSE,
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                )
                """;

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(query);
        }
    }


    @Override
    public void add(Task task) {
        String query = "INSERT INTO tasks (name, completed) VALUES (?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, task.getName());
            pstmt.setBoolean(2, task.isCompleted());
            pstmt.executeUpdate();

            // Получаем сгенерированный ID
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    task.setUid(String.valueOf(rs.getInt(1)));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add task", e);
        }
    }


    @Override
    public List<Task> getAll() {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT uid, name, completed FROM tasks ORDER BY created_at";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Task task = new Task(
                        rs.getString("uid"),
                        rs.getString("name"),
                        rs.getBoolean("completed")
                );

                tasks.add(task);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tasks;
    }


    @Override
    public Task getById(String uid) {
        String query = "SELECT uid, name, completed FROM tasks WHERE uid = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, Integer.parseInt(uid));

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Task(
                            rs.getString("uid"),
                            rs.getString("name"),
                            rs.getBoolean("completed")
                    );
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }


    @Override
    public void update(Task task) {
        String query = "UPDATE tasks SET name = ?, completed = ? WHERE uid = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, task.getName());
            pstmt.setBoolean(2, task.isCompleted());
            pstmt.setInt(3, Integer.parseInt(task.getUid()));
            pstmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void delete(String uid) {
        String query = "DELETE FROM tasks WHERE uid = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, Integer.parseInt(uid));
            pstmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void close() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}