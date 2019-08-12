
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileManager t = new FileManager();

        for (String line : t.read("src/testinput1.txt")) {
            System.out.println(line);
        }
        
        
        List<String> practiseLines = new ArrayList<String>();
        practiseLines.add("Hi");
        practiseLines.add("Hallo");
        practiseLines.add("Guten abend");
        practiseLines.add("Wie heiBt du?");
        t.save("src/testing.txt", practiseLines);
        
        //t.save("src/textinput1.txt", "hello");
    }
}
