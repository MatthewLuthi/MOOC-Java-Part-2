package tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover {
    private List<String> words;
    private int duplicates;
    
    public PersonalDuplicateRemover() {
        words = new ArrayList<String>();
        duplicates = 0;
    }
    
    @Override
    public void add(String characterString) {
        if (words.contains(characterString)) {
            duplicates++;
        } else {
           words.add(characterString); 
        }
    }
    
    @Override
    public int getNumberOfDetectedDuplicates() {
        return duplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        Set<String> uniqueWords = new HashSet<String>();
        
        for (String word : words) {
            uniqueWords.add(word);
        }
        
        return uniqueWords;
    }
    
    @Override
    public void empty() {
        words.clear();
        duplicates = 0;
    }

    public List<String> getWords() {
        return words;
    }
    
}
