
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Only class with printing methods
 * @author Mxtt Offline
 */
public class UserInterface {
    private Scanner reader;
    private ArrayList<Jumper> jumpers;
    private int round;
    
    public UserInterface(Scanner reader) {
        this.reader = reader;
        jumpers = new ArrayList<Jumper>();
        round = 0;
    }
    
    public void start() {
        System.out.println("Kumpula ski jumping week");
        readParticipants();
        jumpingPhase();
        printTournamentResults();
        
    }
    
    public void readParticipants() {
        System.out.println("\nWrite the names of the participants one at a time; an empty string brings you to the jumping phase.");
        
        String name = "";
        do {
            System.out.print("  Participant name: ");
            name = reader.nextLine();
            if (!name.isEmpty()) {
                jumpers.add(new Jumper(name));
            }
        } while (!name.isEmpty());
        
        System.out.println("\nThe tournament begins!");
    }
    
    public void jumpingPhase() {
        while (newRound()) {
            jumpOrder();
            executeJump();
            results();
        }
    }
    
    public boolean newRound() {
        System.out.print("\nWrite \"jump\" to jump; otherwise you quit: ");
        String input = reader.nextLine();
        
        if (checkInput(input, "jump")) {
            round++;
            System.out.println("\nRound "+round);
            return true;
        }
        
        return false;
    }
    
    public boolean checkInput(String input, String correctInput) {
        if (stringUtils(input).contains(correctInput)) {
            return true;
        }
        
        return false;
    }
    
    public String stringUtils(String word) {
        word = word.toLowerCase();
        return word.trim();
    }
    
    public void jumpOrder() {
        Collections.sort(jumpers);
        
        System.out.println("\nJumping order:");
        for (int i = 0; i < jumpers.size(); i++) {
            System.out.println("  "+(i+1)+". "+jumpers.get(i));
        }
    }
    
    public void executeJump() {
        for (Jumper jumper : jumpers) {
            jumper.jump();
            jumper.voteJump();
        }
    }
    
    public void results() {
        System.out.println("\nResults of round "+round);
        for (Jumper jumper : jumpers) {
            System.out.println("  "+jumper.getName());
            System.out.println("    length: "+jumper.getJumpLength());
            System.out.println("    judge votes: "+jumper.getJudges());
        }
    }

    public void printTournamentResults() {
        System.out.println("\nThanks!");
        System.out.println("\nTournament results:");
        System.out.println("Position    Name");
        
        Collections.sort(jumpers);
        Collections.reverse(jumpers);
        for (int i = 0; i < jumpers.size(); i++) {
            System.out.println((i+1)+"           "+jumpers.get(i));
            System.out.print("            jump lengths: ");
            
            for (Integer jumpLength : jumpers.get(i).getJumpLengths()) {
                if (jumpLength == jumpers.get(i).getLastJumpLength()) {
                    System.out.print(jumpLength+" m");
                    break;
                }
                
                System.out.print(jumpLength+" m, ");
            }
            System.out.println();
        }
    }
}
