package labs.lab4.people;
import java.util.List;
import java.util.ArrayList;

public class Student extends Person {
    private int credits;
    private int student_id;
    private List<Integer> grades;

    public Student(String name, String adress, int credits, int student_id,  List<Integer> grades){
        super(name, adress);
        this.credits = credits;
        this.student_id = student_id;
        this.grades = new ArrayList<Integer>(grades);
    }

    public Student(String name, String adress){
        super(name, adress);
        this.credits = 0;
    }

    public void study(){
        this.credits++;
    }

    public int credits(){
        return this.credits;
    }

    public int getStudentId(){
        return this.student_id;
    }

    public void setStudentId(int id){
        this.student_id = id;
    }

    public int getGrade(int index){
        return grades.get(index);
    }


    public void addGrade(int grade){
        if(grade < 5 || grade > 10){
            return;
        }
        else
            grades.add(grade);
    }

    public List<Integer> getGrades(){
        return grades;
    }

    public String toString(){
        return super.toString() + "\n   Credits: " + this.credits;
    }

}
