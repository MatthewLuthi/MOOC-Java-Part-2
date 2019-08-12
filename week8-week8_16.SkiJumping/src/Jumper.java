import java.util.ArrayList;
import java.util.Collections;

public class Jumper implements Comparable<Jumper> {
    private String name;
    private int points;
    private int jumpLength;
    private ArrayList<Judge> judges;
    private ArrayList<Integer> jumpLengths;
    
    public Jumper(String name) {
        this.name = name;
        points = 0;
        jumpLength = 0;
        judges = new ArrayList<Judge>();
        for (int i = 0; i < 5; i++) {
            judges.add(new Judge());
        }
        jumpLengths = new ArrayList<Integer>();
    }
    
    public void jump() {
        jumpLength = GenerateRandom.getRandom(60, 120);
        jumpLengths.add(jumpLength);
    }
    
    public void voteJump() {
        for (Judge judge : judges) {
            judge.vote();
        }
        
        calculatePoints();
    }
    
    public void calculatePoints() {
        Collections.sort(judges);
    
        for (int i = 1; i < (judges.size()-1); i++) {
            points +=  judges.get(i).getVote();
        }
        
        points += jumpLength;
    }

    @Override
    public int compareTo(Jumper otherJumper) {
        return points - otherJumper.getPoints();
    }
    
    public int getPoints() {
        return points;
    }
    
    public String getName() {
        return name;
    }
    
    public int getJumpLength() {
        return jumpLength;
    }
    
    public ArrayList<Judge> getJudges() {
        return judges;
    }
    
    public ArrayList<Integer> getJumpLengths() {
        return jumpLengths;
    }
    
    @Override
    public String toString() {
        return name+" ("+points+" points)";
    }
    
    public int getLastJumpLength() {
        return jumpLengths.get(jumpLengths.size()-1);
    }
}
