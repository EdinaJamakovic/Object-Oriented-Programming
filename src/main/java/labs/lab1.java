package labs;
import java.util.Scanner;

public class lab1 {
    //task1
    public static void main(String[] args) {
        janeDoe();
        helloWorld();
        secondsInYear();
        sum();
        isPositive();
        greaterNum();
    }

    public static void janeDoe() {
        System.out.println("My name is Jane Doe");
    }

    public static void helloWorld() {
        System.out.println("Hello World \n" + " (And all the people of the world.)");
    }

    public static void secondsInYear() {
        System.out.println(365 * 24 * 3600);
    }

    public static void sum() {
        System.out.println("Enter two numbers: ");
        Scanner reader = new Scanner(System.in);
        int a = Integer.parseInt(reader.nextLine());
        int b = Integer.parseInt(reader.nextLine());
        System.out.println("The sum is: " + (a + b));
    }

    public static void isPositive() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int a = Integer.parseInt(reader.nextLine());
        if (a > 0) {
            System.out.println("Number is positive.");
        }
    }

    public static void greaterNum() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int a = Integer.parseInt(reader.nextLine());
        int b = Integer.parseInt(reader.nextLine());
        if (a > b)
            System.out.println("Number " + a + " is greater.");
        else if (b > a)
            System.out.println("Number " + b + " is greater.");
        else
            System.out.println("The numbers are equal.");
    }

}
