package labs;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class DbConnect {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3307/lab3";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "27012006";

    private Connection connection = null;

    public DbConnect() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DataStructures.TaskItem> getAllTasks() {
        List<DataStructures.TaskItem> tasks = new ArrayList<>();
        String query = "SELECT * FROM tasks";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                tasks.add(
                        new DataStructures.TaskItem(
                                resultSet.getInt("id"),
                                resultSet.getString("task_description"),
                                Status.valueOf(resultSet.getString("task_status")))
                );
            }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return tasks;
    }

    public DataStructures.TaskItem getByTaskId(int id){
        String query = "SELECT * FROM tasks WHERE id = ?";
        DataStructures.TaskItem task = null;
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                    task = new DataStructures.TaskItem(
                    resultSet.getInt("id"),
                    resultSet.getString("task_description"),
                    Status.valueOf(resultSet.getString("task_status"))
                );
            }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return task;
    }


    public void createTask(int id, String description, Status status) {
        String query = "INSERT INTO tasks (id, task_description, task_status) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, description);
            statement.setString(3, status.name()); // Use .name() to get the string representation of the enum

            statement.executeUpdate(); // Use executeUpdate() for INSERT, UPDATE, DELETE
            System.out.println("Task created successfully: " + description);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTaskDescription(int id, String newDescription) {
        String query = "UPDATE tasks SET task_description = ? WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newDescription);
            statement.setInt(2, id);

            int rowsAffected = statement.executeUpdate(); // Execute update

            if (rowsAffected > 0) {
                System.out.println("Task updated successfully: " + newDescription);
            } else {
                System.out.println("No task found with ID: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DbConnect newConnection = new DbConnect();
        newConnection.createTask(7, "Read a book", Status.TO_DO);
        newConnection.updateTaskDescription(2, "Prepare for the upcoming exam");
        List<DataStructures.TaskItem> tasks = newConnection.getAllTasks();
        for (DataStructures.TaskItem task : tasks) {
            System.out.println(task.getId() + ": " + task.getDescription());
        }
    }

}



