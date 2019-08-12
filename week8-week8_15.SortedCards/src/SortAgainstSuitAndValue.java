
import java.util.Comparator;

public class SortAgainstSuitAndValue implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        int sortedSuit = card1.getSuit() - card2.getSuit();
        if (sortedSuit == 0) {
            return card1.getValue() - card2.getValue();
        }
        return sortedSuit;
    }
    
}
