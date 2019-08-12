
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        // printWithSmileys("Matti");
         printWithSmileys("Matthewrr");
        // printWithSmileys("Interface");
        //printWithSmileys("Mikael");
        //printWithSmileys("Arto");
    }
    
    private static void printWithSmileys(String characterString) {
        printRow(characterString);
        
        if (even(characterString)) {
            System.out.println("\n:) "+characterString+" :)");
        } else {
            System.out.println("\n:) "+characterString+"  :)");
        }
        
        printRow(characterString);
    }
    
    private static void printRow(String characterString) {
        if (even(characterString)) {
            for (int i = 0; i < evenRelation(characterString); i++) {
                System.out.print(":)");
            }
        } else {
            for (int i = 0; i < oddRelation(characterString); i++) {
                System.out.print(":)");
            }
        }
    }
    
    private static boolean even(String characterString) {
        if (characterString.length() % 2 == 0) {
            return true;
        }
        return false;
    }
    
    private static int evenRelation(String characterString) {
        int length = characterString.length();
        
        if (length % 10 == 0) {
            return 8;
        } else if (length % 8 == 0) {
            return 7;
        } else if (length % 6 == 0) {
            return 6;
        } else if (length % 4 == 0) {
            return 5;
        } else {
            return 3;
        }
    }
    
    private static int oddRelation(String characterString) {
        int length = characterString.length();
        if (length % 9 == 0) {
            return 8;
        } else if (length % 7 == 0) {
            return 7;
        } else if (length % 5 == 0) {
            return 6;
        } else if (length % 3 == 0) {
            return 5;
        } else {
            return 4;
        }
    }

}
