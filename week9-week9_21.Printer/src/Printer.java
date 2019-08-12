import java.io.File;
import java.util.Scanner;

public class Printer {
    private File file;
    private Scanner reader;
    
    public Printer(String fileName) throws Exception {
        file = new File(fileName);
        reader = new Scanner(file);
    }
    
    public void printLinesWhichContain(String word) throws Exception{
        reader = new Scanner(file);
        if (word.isEmpty()) {
            while (reader.hasNext()) {
                System.out.println(reader.nextLine());
            }
            
            return;
        }
        
        while (reader.hasNext()) {
            String fileLine = reader.nextLine();
            if (fileLine.contains(word)) {
                System.out.println(fileLine);
            }
        }
    }
}
