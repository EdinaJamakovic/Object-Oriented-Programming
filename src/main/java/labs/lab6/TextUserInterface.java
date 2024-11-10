package labs.lab6;
import java.util.Scanner;

public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        System.out.println("Statement:");
        System.out.println("  quit - quit the text user interface");
        System.out.println("  translate - asks a word and prints its translation");
        System.out.println("  add - adds a word pair to the dictionary");

        while (true) {
            System.out.print("Statement: ");
            String command = reader.nextLine();

            if (command.equals("quit")) {
                System.out.println("Cheers");
                break;
            } else if (command.equals("add")) {
                add();
            } else if (command.equals("translate")) {
                translate();
            } else {
                System.out.println("Unknown statement");
            }
        }
    }

    private void add() {
        System.out.print("In Finnish: ");
        String finnishWord = reader.nextLine();
        System.out.print("Translation: ");
        String translation = reader.nextLine();
        dictionary.add(finnishWord, translation);
    }

    private void translate() {
        System.out.print("Write a word: ");
        String word = reader.nextLine();
        String translation = dictionary.translate(word);
        if (translation != null) {
            System.out.println("Translation: " + translation);
        } else {
            System.out.println("Word " + word + " is not in dictionary");
        }
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Scanner reader = new Scanner(System.in);
        TextUserInterface userIterface = new TextUserInterface(reader, dictionary);
        userIterface.start();
    }
}
