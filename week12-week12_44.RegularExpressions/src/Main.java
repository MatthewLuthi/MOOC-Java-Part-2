
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give a string: ");
        System.out.println(clockTime(scanner.nextLine()));
        
    }
    
    public static boolean isAWeekDay(String string) {   
        if (string.matches("mon|tue|wed|thu|fri|sat|sun")) {
            return true;
        }
        
        return false;
    }
   
    public static boolean allVowels(String string) {
        if (string.matches("[aeiouäö]+")) {
            return true;
        }
        
        return false;
    }
    
     public static boolean clockTime(String string) {
        String[] tokens = string.split(":");
        
        for (String token : tokens) {
            if (!token.matches("[0-9]{2}")) {
                return false;
            }
        }
        
        for (int i = 0; i < 3; i++) {
            int numbers = Integer.parseInt(tokens[i]);
            if (i == 0 && (numbers < 0 || numbers > 23)) {
                return false;
            }
            
            if (numbers < 0 || numbers > 59) {
                return false;
            }
        }
        
        return true;
    }
}
