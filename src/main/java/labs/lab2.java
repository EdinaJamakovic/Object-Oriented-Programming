package labs;
import java.util.Scanner;

public class lab2 {
    public static void main(String[] args){
        //passwordCheck();
        //sum();
        //sumUntilZero();
        //sumInRangeV2();
        //powOf2();
        //printText();
        //drawStarsPiramid(5);
        //drawStarsInvertedPiramid(5);
        //numberPiramid(5);
        guessNumber();
    }

    public static void passwordCheck() {
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("Enter password: ");
            String password = reader.nextLine();
            if (password.equals("carrot")) {
                System.out.println("Right!!!     Secret is 'lorem ipsum'");
                break;
            }
        }
    }

    public static void sum(){
        int sum = 0;
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter three numbers: ");
        for(int i = 0; i < 3; i++){
            sum += Integer.parseInt(reader.nextLine());
        }
        System.out.println("The sum is: " + sum);
    }

    public static void sumUntilZero(){
        Scanner reader = new Scanner(System.in);
        int sum = 0;
        while(true){
            System.out.println("Enter a number: ");
            int a = Integer.parseInt(reader.nextLine());
            sum += a;
            if(a == 0) {
                System.out.println("The sum is: " + sum);
                break;
            }
        }
    }

    public static void sumInRangeV1(){
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int firstNumber = Integer.parseInt(reader.nextLine());
        System.out.print("Enter the last number: ");
        int lastNumber = Integer.parseInt(reader.nextLine());
        int sum = 0;
        if (firstNumber < lastNumber) {
            int currentNumber = firstNumber + 1;
            while (currentNumber < lastNumber) {
                sum+= currentNumber;
                currentNumber++;
            }
        }

        else if (firstNumber > lastNumber) {
            int currentNumber = firstNumber - 1;
            while (currentNumber > lastNumber) {
                sum+= currentNumber;
                currentNumber--;  // Decrement the current number
            }
        }
        else {
            System.out.println("No numbers between " + firstNumber + " and " + lastNumber);
        }

        System.out.println("Sum is: " + sum);
    }

    public static void sumInRangeV2(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int a = Integer.parseInt(reader.nextLine());
        int b = Integer.parseInt(reader.nextLine());
        int step = a < b? 1:-1; // if a is smaller than b then we increment, if it's not we decrement
        int sum = 0;
        while((a < b - 1) || (a - 1 > b)){
            a += step;
            sum += a;
        }
        System.out.println("Sum is: " + sum);

    }

    public static void powOf2(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter exponent: ");
        int exp = Integer.parseInt(reader.nextLine());
        System.out.println("Two to the power of " + exp + " is: " + (int)Math.pow(2,exp));
    }

    public static void printText(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter how many times you want to print: ");
        int num = Integer.parseInt(reader.nextLine());
        for(int i = 0; i < num; i++){
            System.out.println("In the beginning there were the swamp, the hoe and Java.");
        }
    }

    public static void drawStarsPiramid(int rows){
        for(int i = 0; i <= rows; i++){
            for(int j = 0; j < i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void drawStarsInvertedPiramid(int rows){
        for(int i = rows; i > 0; i--){
            for(int j = 0; j < i; j++ ){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void numberPiramid(int rows){
        for(int i = 0; i <= rows; i ++){
            for(int j = 1; j <= i; j++ ){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void guessNumber(){
        Scanner reader = new Scanner(System.in);
        int correctNum = 12;
        int guesses = 0;
        System.out.println("Guess a number: ");
        while(true){
            int num = Integer.parseInt(reader.nextLine());
            guesses += 1;
            if(num == correctNum) {
                System.out.println("Correct! You've had " + guesses + " guesses.");
                break;
            }
            else if(num < correctNum){
                System.out.println("Higher! This is your " + guesses + " guess.");
            }
            else{
                System.out.println("Lower! This is your " + guesses + " guess.");
            }
        }
    }

}
