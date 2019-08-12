package boxes;

import java.util.ArrayList;
import java.util.List;

public class MaxWeightBox extends Box {
    private int maxWeight;
    private List<Thing> things;
    
    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        things = new ArrayList<Thing>();
    }
    
    private int totalWeight() {
        int weight = 0;
        for (Thing thing : things) {
            weight += thing.getWeight();
        }
        
        return weight;
    }

    @Override
    public void add(Thing thing) {
        if (thing.getWeight() + totalWeight() <= maxWeight) {
            things.add(thing);
        }    
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return (things.contains(thing));
    }
    
}
