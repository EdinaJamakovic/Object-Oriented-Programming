package additionalTasks;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class tasks1 {
    public static void main(String[] args){
        //quadraticEquation();
        //max();
        //maxV2();
        //countOddEvenZero(new int[]{0,0,1,1,2,0,2,2});
        //numberFactors(12);
        //fullPiramid(10);
        //fibonacci(10);
        //factorial(5);
        //multiplicationTable(3);
        //divisibleBy9(27,8);
        //wordByWord("a b c d e f.");
        //minAndMax(new int[]{1,1,6,0,8});

    }

    public static void quadraticEquation(){
        Scanner reader = new Scanner(System.in);
        int a = reader.nextInt();
        int b = reader.nextInt();
        int c = reader.nextInt();
        if((Math.pow(b,2) - 4*a*c) < 0)
            System.out.println("The result is an imaginary number. Can't calculate.");
        else{
            double result1 = ((-b)+(Math.sqrt(Math.pow(b,2)-4*a*c)))/(2*a);
            double result2 = ((-b)-(Math.sqrt(Math.pow(b,2)-4*a*c)))/(2*a);
            System.out.println("The first result is: " + result1 + ". The second result is: " + result2);
        }
    }

    public static void max(){
        Scanner reader = new Scanner(System.in);
        int max = 0;
        for(int i = 0; i < 3; i++){
            int currentNum = reader.nextInt();
            if(currentNum > max)
                max = currentNum;
        }
        System.out.println("The greatest number is: " + max);
    }

    public static void maxV2(){
        Scanner reader = new Scanner(System.in);
        int a = reader.nextInt(), b = reader.nextInt(), c = reader.nextInt();
        System.out.println("The largest number is: "+ Math.max(Math.max(a,b),c));
    }

    public static void isApproximate(double a, double b){
        if(Math.round(a*1000) == Math.round(b*1000))
            System.out.println("They are approximately the same.");
        else
            System.out.println("They are not the same");
    }

    public static void countOddEvenZero(int[] arr){
        int zeros = 0, even = 0, odd = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0)
                zeros++;
            else if(arr[i]%2 == 0)
                even++;
            else
                odd++;
        }
        System.out.println("The number of zeros is: " + zeros);
        System.out.println("The number of even numbers is: " + even);
        System.out.println("The number of odd numbers is: " + odd);
    }

    public static void numberFactors(int num){
        for(int i = 1; i <= num; i++){
            if(num%i==0){
                System.out.println(i);
            }
        }
    }

    public static void fullPiramid(int rows){
        for(int i = 1; i < rows + 1; i++){
            for(int j = 0; j <(rows - i)*2; j++){
                System.out.print(" ");
            }
            for(int k = 0; k < 1+(i-1)*2; k++){
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    public static void fibonacci(int n){
        int n1 = 0, n2 = 1;
        int temp = 0;
        int sum = 1;
        System.out.print(0 + " " + 1 + " ");
        for(int i = 0; i < n - 2; i++){
            temp = n2;
            n2 = n1 + n2;
            n1 = temp;
            sum += n2;
            System.out.print(n2 + " ");
        }
        System.out.println();
        System.out.println("sum is: " + sum);

    }

    public static void factorial(int n){
        int fact = 1;
        for(int i = 1; i <= n; i++){
            fact*=i;
        }
        System.out.println(fact);
    }

    public static void multiplicationTable(int n){
        for(int i = 10; i >= 1; i--){
            System.out.println(i + " * " + n + " = " + (i*n));
        }
    }

    public static void divisibleBy9(int n1, int n2){
        int firstNum = Math.min(n1,n2);
        int lastNum = Math.max(n1,n2);
        for(int i = firstNum; i <= lastNum; i++){
            if(i%9==0)
                System.out.println(i);
        }
    }

    public static void wordByWord(String sentence){
        String[] words = sentence.split(" ");
        for(String word: words){
            System.out.println(word);
        }
    }

    public static void isAnagram(String firstWord, String secondWord){

    }

    public static void minAndMax(int[] nums){
        int min = nums[0];
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < min)
                min = nums[i];
            else if(nums[i] > max)
                max = nums[i];
        }
        System.out.println("min: "+ min +" max: " + max);
    }

}

