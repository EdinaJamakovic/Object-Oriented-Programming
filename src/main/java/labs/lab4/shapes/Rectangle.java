package labs.lab4.shapes;

public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(String color, FillType filled, double width, double height){
        super(color,filled);
        this.width = width;
        this.height = height;
    }

    public void displayInfo(){
        System.out.println(this.getColor() + " " + this.getFilled() + " " + this.width + " " + this.height);
    }

    public double getArea(){
        return width*height;
    }
}


