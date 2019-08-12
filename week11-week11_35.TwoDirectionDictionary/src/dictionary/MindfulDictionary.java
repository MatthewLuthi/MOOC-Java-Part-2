package dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MindfulDictionary {
    private Map<String, String> dictionary;
    private String file;

    public MindfulDictionary() {
        dictionary = new HashMap<String, String>();
    }

    public MindfulDictionary(String file) {
        this();
        this.file = file;
    }

    public boolean load() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            String line;
            List<String[]> translations = new ArrayList<String[]>();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                translations.add(parts);
            }
            
            for (String[] translation : translations) {
                add(translation[0], translation[1]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
    
    public boolean save() {
        try {
            FileWriter writer = new FileWriter(file);
            for (String key : dictionary.keySet()) {
                writer.write((key+":"+dictionary.get(key)+"\n"));
            }
            
            writer.close();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    public void add(String word, String translation) {
        if (!dictionary.containsKey(word)) {
            dictionary.put(word, translation);
        }
    }

    public void printKeys() {
        for (String key : dictionary.keySet()) {
            System.out.println(key + " : " + dictionary.get(key));
        }
    }

    public String translate(String word) {
        if (dictionary.containsKey(word)) {
            return dictionary.get(word);
        }

        String translation = null;
        for (String key : dictionary.keySet()) {
            if (dictionary.get(key).contains(word)) {
                translation = key;
            }
        }

        return translation;
    }

    public void remove(String word) {
        if (dictionary.containsKey(word)) {
            dictionary.remove(word);
        } else {
            String removedKey = "";
            for (String key : dictionary.keySet()) {
                if (dictionary.get(key).contains(word)) {
                    removedKey = key;
                }
            }

            dictionary.remove(removedKey);
        }
    }
}
