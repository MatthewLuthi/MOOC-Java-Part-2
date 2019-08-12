
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public List<String> read(String file) throws FileNotFoundException {
        List<String> lines = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        try {
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return lines;
    }

    public void save(String file, String text) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        FileWriter writer = new FileWriter(file);

        for (String line : texts) {
            writer.write(line + "\n");
        }
        writer.close();
    }
}
