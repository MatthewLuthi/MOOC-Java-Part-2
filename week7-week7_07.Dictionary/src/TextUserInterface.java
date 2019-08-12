
import java.util.Scanner;

public class TextUserInterface {

    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        while (true) {
            if (!readInput()) {
                break;
            }
        }
    }

    public boolean readInput() {
        System.out.print("Statement: ");
        String statement = reader.nextLine();
        statement = stringCleaner(statement);

        if (statement.contains("quit")) {
            System.out.println("Cheers!");
            return false;
        }

        //System.out.println("Unknown statement\n");
        handleInput(statement);
        System.out.println();
        return true;
    }

    public void handleInput(String statement) {
        if (statement.contains("add")) {
            add();
        } else if (statement.contains("translate")) {
            translate();
        } else {
            System.out.println("Unknown statement");
        }
    }

    public void add() {
        System.out.print("In English: ");
        String word = reader.nextLine();
        System.out.print("Translation: ");
        String translation = reader.nextLine();
        
        word = stringCleaner(word);
        translation = stringCleaner(translation);
        
        dictionary.add(word, translation);
    }

    public void translate() {
        System.out.print("Give a word: ");
        String word = reader.nextLine();
        word = stringCleaner(word);

        System.out.print("Translation: ");
        System.out.println(dictionary.translate(word));

    }

    private String stringCleaner(String word) {
        word = word.toLowerCase();
        return word.toLowerCase();
    }
}
