package labs.lab6;
import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> translated;

    public Dictionary() {
        this.translated = new HashMap<>();
    }

    public void add(String word, String translation) {
        translated.put(word, translation);
    }

    public String translate(String word) {
        return translated.getOrDefault(word, "Word " + word + " is not in dictionary");
    }

    public int amountOfWords() {
        return translated.size();
    }

    public ArrayList<String> translationList() {
        ArrayList<String> list = new ArrayList<>();
        for (String key : translated.keySet()) {
            list.add(key + " = " + translated.get(key));
        }
        return list;
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.add("apina", "monkey");
        dictionary.add("banaani", "banana");
        dictionary.add("cembalo", "harpsichord");

        System.out.println(dictionary.translate("apina"));
        System.out.println(dictionary.translate("porkkana"));

        System.out.println(dictionary.amountOfWords());

        ArrayList<String> translations = dictionary.translationList();
        for (String translation : translations) {
            System.out.println(translation);
        }
    }
}
