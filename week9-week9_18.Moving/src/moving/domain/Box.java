package moving.domain;

import java.util.ArrayList;

public class Box implements Thing {
    private ArrayList<Thing> things;
    private int maxCapacity;
    
    public Box(int maximumCapacity) {
        maxCapacity = maximumCapacity;
        things = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing) {
        if ((thing.getVolume() + getVolume()) <= maxCapacity) {
            things.add(thing);
            return true;
        }
        
        return false;
    }

    @Override
    public int getVolume() {
        int volume = 0;
        for (Thing thing : things) {
            volume += thing.getVolume();
        }
        
        return volume;
    }
    
    @Override
    public String toString() {
        return things.toString();
    }
}
