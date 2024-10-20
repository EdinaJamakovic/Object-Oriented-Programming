package labs;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class DataStructures {
    private List<TaskItem> tasks = new ArrayList<>();
    private static List<DataStructures> dsObjects = new ArrayList<>();

    public DataStructures() {
        tasks = Arrays.asList(
                new TaskItem(1,"Push lab code to the github", Status.TO_DO),
                new TaskItem(2,"Prepare for the quiz", Status.IN_PROGRESS),
                new TaskItem(3,"Go over tasks from lab2", Status.COMPLETED));
        dsObjects.add(this);
    }

    public static void getAllObjects(){
        for(DataStructures object: dsObjects){
            System.out.print(object + " ");
        }
        System.out.println();
    }

    public static void getAllByStatus(Status status){
        for(DataStructures object: dsObjects){
            object.tasks.stream()
                    .filter(task -> task.taskStatus == status)
                    .forEach(task -> System.out.println(task.taskId));
        }
        System.out.println();
    }

    public void getByStatus(Status status){
            this.tasks.stream()
                    .filter(task -> task.taskStatus == status)
                    .forEach(task -> System.out.println(task));
        System.out.println();
    }

    public void getById2(){
        this.tasks.stream()
                    .filter(task -> task.taskId >= 2)
                    .forEach(task -> System.out.println(task));
    }

    public void getTaskDescriptions(){
        this.tasks.stream()
                .forEach(task -> System.out.println(task.taskDescription));
    }

    static class TaskItem {
        private int taskId;
        private String taskDescription;
        private Status taskStatus;

        public TaskItem (int taskId, String taskDescription, Status taskStatus) {
            this.taskId = taskId;
            this.taskDescription = taskDescription;
            this.taskStatus = taskStatus;
        }
        public int getId(){
            return this.taskId;
        }

        public String getDescription(){
            return this.taskDescription;
        }
    }
}

