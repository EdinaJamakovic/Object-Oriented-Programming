package labs.lab6;
import java.util.HashMap;

public class PromissoryNote {
    private HashMap<String, Double> loans;

    public PromissoryNote() {
        this.loans = new HashMap<>();
    }

    public void setLoan(String toWhom, double value) {
        this.loans.put(toWhom, value);
    }

    public double howMuchIsTheDebt(String whose) {
        return this.loans.getOrDefault(whose, 0.0);
    }

    public static void main(String[] args) {
        PromissoryNote mattisNote = new PromissoryNote();
        mattisNote.setLoan("Arto", 51.5);
        mattisNote.setLoan("Mikael", 30);
        System.out.println(mattisNote.howMuchIsTheDebt("Arto"));
        System.out.println(mattisNote.howMuchIsTheDebt("Joel"));
    }
}

