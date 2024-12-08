package labs.lab10.task2;
import java.util.List;

public class GradeAnalyser {
    private List<Integer> grades;

    public GradeAnalyser(List<Integer> grades) {
        this.grades = grades;
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public void printSummary() {
        System.out.println("Grade Summary:");
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + calculateAverage());
    }
}
