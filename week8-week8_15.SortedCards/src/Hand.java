import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {
    private ArrayList<Card> hand;
    
    public Hand() {
        hand = new ArrayList<Card>();
    }
    
    public void add(Card card) {
        hand.add(card);
    }   

    public void print() {
        for (Card card : hand) {
            System.out.println(card);
        }
    }
    
    public void sort() {
        Collections.sort(hand);
    }

    @Override
    public int compareTo(Hand otherHand) {
        int firstHandValue = 0, secondHandValue = 0;
        
        for (Card card : hand) {
            firstHandValue += card.getValue();
        }
        
        for (Card card : otherHand.hand) {
            secondHandValue += card.getValue();
        }
        
        int mostValuableHand = firstHandValue - secondHandValue;
        return mostValuableHand;
    }
    
    public void sortAgainstSuit() {
        Collections.sort(hand, new SortAgainstSuitAndValue());
    }
}
