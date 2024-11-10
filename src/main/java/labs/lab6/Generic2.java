package labs.lab6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generic2 {
    public static <T> List<T> reverseList(List<T> list) {
        List<T> reversedList = new ArrayList<>(list);
        Collections.reverse(reversedList);
        return reversedList;
    }
}
