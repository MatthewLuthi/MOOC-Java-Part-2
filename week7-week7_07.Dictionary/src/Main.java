
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input = "add\n" + "cheese\n" + "juusto\n" +
                       "add\n" + "beer\n" + "olut\n" +
                       "add\n" + "computer\n" + "tietokone\n" +
                       "translate\n" + "cheese\n" + 
                        "quit\n";
        //########################## Change parameter to System.in ################
        Scanner reader = new Scanner(input);
        
        TextUserInterface ui = new TextUserInterface(reader, new Dictionary());
        ui.start();
    }
}
