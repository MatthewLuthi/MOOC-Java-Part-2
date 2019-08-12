
public class Judge implements Comparable<Judge> {
    private int vote;
    
    public Judge() {
        vote = 0;
    }
    
    public void vote() {
        vote = GenerateRandom.getRandom(10, 20);
    }
    
    public int getVote() {
        return vote;
    }
    
    @Override
    public String toString() {
        return Integer.toString(vote);
    }

    @Override
    public int compareTo(Judge otherJudge) {
        return vote - otherJudge.getVote();
    }
}
