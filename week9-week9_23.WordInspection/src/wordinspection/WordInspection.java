package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordInspection {

    private File file;
    private Scanner reader;
    private List<String> wordList;

    public WordInspection(File file) {
        this.file = file;

        try {
            reader = new Scanner(file);
            wordList = new ArrayList<String>();

            while (reader.hasNextLine()) {
                wordList.add(reader.nextLine());
            }
        } catch (Exception e) {
            System.out.println("File could not be found: " + e.getMessage());
        }
    }

    public int wordCount() {
        int count = 0;
        for (String word : wordList) {
            count++;
        }

        return count;
    }

    public List<String> wordsContainingZ() {
        List<String> wordsWithZ = new ArrayList<String>();

        for (String word : wordList) {
            if (word.contains("z")) {
                wordsWithZ.add(word);
            }
        }

        return wordsWithZ;
    }

    public List<String> wordsEndingInL() {
        List<String> wordsEndingInL = new ArrayList<String>();

        for (String word : wordList) {
            if (word.charAt(word.length() - 1) == 'l') {
                wordsEndingInL.add(word);
            }
        }

        return wordsEndingInL;
    }

    public List<String> palindromes() {
        List<String> readsSame = new ArrayList<String>();

        for (String word : wordList) {
            if (word.equalsIgnoreCase(reverseWord(word))) {
                readsSame.add(word);
            }
        }

        return readsSame;
    }

    public String reverseWord(String word) {
        String backwards = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            backwards += word.charAt(i);
        }
        
        return backwards;
    }

    private boolean checkAllVowels(String word) {
        String[] allVowels = {"a", "e", "i", "o", "u", "y", "ä", "ö"};

        for (int i = 0; i < allVowels.length; i++) {
            if (!word.contains(allVowels[i])) {
                return false;
            }
        }

        return true;
    }

    public List<String> wordsWhichContainAllVowels() {
        List<String> wordsWithAllVowels = new ArrayList<String>();
        //char[] allVowels = {'a', 'e', 'i', 'o', 'u', 'y', 'ä', 'ö'};
        //String[] allVowels = {"a", "e", "i", "o", "u", "y", "ä", "ö"};

        for (String word : wordList) {
            if (checkAllVowels(word)) {
                wordsWithAllVowels.add(word);
            }
        }

        return wordsWithAllVowels;
    }

    public List<String> getWordList() {
        return wordList;
    } 
}
