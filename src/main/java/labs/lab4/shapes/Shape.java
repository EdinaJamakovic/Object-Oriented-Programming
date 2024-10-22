package labs.lab4.shapes;

public class Shape {
    private String color;
    private FillType filled;

    public Shape(String color, FillType filled){
        this.color = color;
        this.filled = filled;
    }

    public void displayInfo(){
        System.out.println(this.color + " " + this.filled.name());
    }

    public String getColor(){
       return this.color;
    }

    public FillType getFilled(){
        return this.filled;
    }
}
