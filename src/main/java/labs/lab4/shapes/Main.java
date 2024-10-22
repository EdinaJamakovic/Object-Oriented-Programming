package labs.lab4.shapes;

public class Main {
    public static void main(String[] args){
        Rectangle rectangle = new Rectangle("white", FillType.FILLED, 2, 2);
        Circle circle = new Circle("black", FillType.NOT_FILLED, 1);
        rectangle.displayInfo();
        circle.displayInfo();
    }
}
