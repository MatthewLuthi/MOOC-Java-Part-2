
import java.util.ArrayList;

public class Container {
    private int maxWeight;
    private ArrayList<Suitcase> suitcases;
    
    public Container(int maxWeight) {
        suitcases = new ArrayList<Suitcase>();
        this.maxWeight = maxWeight;
    }
    
    public void addSuitcase(Suitcase suitcase) {
        if ((suitcase.totalWeight() + totalWeight()) <= maxWeight) {
            suitcases.add(suitcase);
        }
    }
    
    public int totalWeight() {
        int totalWeight = 0;
        
        for (Suitcase suitcase : suitcases) {
            totalWeight += suitcase.totalWeight();
        }
        
        return totalWeight;
    }
    
    public void printThings() {
        for (Suitcase suitcase : suitcases) {
            for (Thing thing : suitcase.getThings()) {
                System.out.println(thing);
            }
        }
    }
    
    @Override
    public String toString() {
        return suitcases.size()+" suitcases ("+totalWeight()+" kg)";
    }
}
