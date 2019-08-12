package file;

import java.io.File;
import java.util.Scanner;

public class Analysis {
    private File file;
    private Scanner reader;
    
    public Analysis(File file) {
        this.file = file;
        //reader = new Scanner(file);
    }
    
    public int lines() {
        try {
            reader = new Scanner(file);
        } catch (Exception e) {
            System.out.println("File could not be found: "+e.getMessage());
        }
        
        int lines = 0;
        while (reader.hasNextLine()) {
            reader.nextLine();
            lines++;
        }
        
        return lines;
    }
    
    public int characters() {
        try {
            reader = new Scanner(file);
        } catch (Exception e) {
            System.out.println("File could not be found: "+e.getMessage());
        }
        
        int nChars = 0;
        while (reader.hasNextLine()) {
            String currentLine = reader.nextLine();
            nChars += currentLine.length()+1; //newLine character which is "eaten" in carriage return must also be included
        }
        
        return nChars;
    }
}
