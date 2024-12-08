package labs.lab10.task2;
import java.util.List;

public class Student {
    private String name;
    private String id;
    private List<Integer> grades;

    public Student(String name, String id, List<Integer> grades) {
        this.name = name;
        this.id = id;
        this.grades = grades;
    }

    public void printInfo() {
        System.out.println("Student information:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Grades: " + grades);
    }
}
