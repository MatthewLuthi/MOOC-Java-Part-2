import java.util.HashMap;

public class PromissoryNote {
    private HashMap<String, Double> promissoryNotes;
    
    public PromissoryNote() {
        promissoryNotes = new HashMap<String, Double>();
    }
    
    public void setLoan(String toWhom, double value) {
        toWhom = stringCleaner(toWhom);
        promissoryNotes.put(toWhom, value);
    }
    
    public double howMuchIsTheDebt(String whose) {
        whose = stringCleaner(whose);
        
        if (promissoryNotes.containsKey(whose)) {
            return promissoryNotes.get(whose);
        }
        
        return 0;
    }
    
    private String stringCleaner(String string) {
        if (string == null) {
            return "UNKNOWN";
        }
        
        string = string.toLowerCase();
        return string.trim();
    }
}
