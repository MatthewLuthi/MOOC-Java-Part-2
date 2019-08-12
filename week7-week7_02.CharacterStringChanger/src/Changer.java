
import java.util.ArrayList;

public class Changer {
    private ArrayList<Change> changes;
    
    public Changer() {
        changes = new ArrayList<Change>();
    }
    
    public void addChange(Change change) {
        changes.add(change);
    }
    
    public String change(String characterString) {
        String word = characterString;
        for (Change change : changes) {
            word = change.change(word);
        }
        
        return word;
    }
}
