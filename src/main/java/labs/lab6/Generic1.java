package labs.lab6;
import java.util.List;

public class Generic1 {
    public static <T extends Number> void sumEvenOdd(List<T> numbers) {
        double evenSum = 0;
        double oddSum = 0;

        for (T number : numbers) {
            if (number.doubleValue() % 2 == 0) {
                evenSum += number.doubleValue();
            } else {
                oddSum += number.doubleValue();
            }
        }

        System.out.println("Sum of even numbers: " + evenSum);
        System.out.println("Sum of odd numbers: " + oddSum);
    }
}

