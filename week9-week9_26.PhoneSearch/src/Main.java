
import java.util.Scanner;
import ui.TextUserInterface;


public class Main {

    public static void main(String[] args) {
        // Start your program here
        // ATTENTION: In your program, you can create only one instance of class Scanner!
        Scanner scanner = new Scanner(System.in);
        TextUserInterface ui = new TextUserInterface(scanner);
        ui.start();
    }
}
