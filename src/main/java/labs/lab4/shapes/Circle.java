package labs.lab4.shapes;

public class Circle extends Shape{
    private double radius;

    public Circle(String color, FillType filled, double radius){
        super(color, filled);
        this.radius = radius;
    }

    public double getArea(){
        return 2*Math.pow(radius, 2)*3.14;
    }

    public static double calculateCircumference(double pi, double radius){
        return 2*radius*pi;
    }

    public static double calculateCircumference(double radius){
        return 2*radius*3.14;
    }

    public void displayInfo(){
        System.out.println(this.getColor() + " " + this.getFilled() + " " + this.radius + " " + this.getArea());
    }

}
