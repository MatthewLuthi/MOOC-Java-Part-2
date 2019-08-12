package moving.logic;

import java.util.ArrayList;
import java.util.List;
import moving.domain.Box;
import moving.domain.Thing;

public class Packer {
    private int boxesVolume;
    
    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }
    
    public List<Box> packThings(List<Thing> things) {
        List<Box> boxes = new ArrayList<Box>();
        boxes.add(new Box(boxesVolume));
                
        int boxIndex = 0;
        for (Thing thing : things) {
            if (!boxes.get(boxIndex).addThing(thing)) {
                boxes.add(new Box(boxesVolume));
                boxIndex++;
                boxes.get(boxIndex).addThing(thing);
            }
        }
        
        return boxes;
    }

}
