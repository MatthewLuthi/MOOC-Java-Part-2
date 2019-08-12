
import java.util.ArrayList;

public class Suitcase {

    private ArrayList<Thing> things;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        things = new ArrayList<Thing>();
    }

    public Thing heaviestThing() {
        if (things.size() > 0) {
            Thing heaviest = things.get(0);

            for (Thing thing : things) {
                if (thing.getWeight() > heaviest.getWeight()) {
                    heaviest = thing;
                }
            }
            
            return heaviest;
        }

        return null;
    }

    public void printThings() {
        for (Thing thing : things) {
            System.out.println(thing);
        }
    }

    public void addThing(Thing thing) {
        if ((thing.getWeight() + totalWeight()) <= maxWeight) {
            things.add(thing);
        }
    }

    public int totalWeight() {
        int totalWeight = 0;
        for (Thing thing : things) {
            totalWeight += thing.getWeight();
        }
        return totalWeight;
    }

    public ArrayList<Thing> getThings() {
        return things;
    }

    @Override
    public String toString() {
        return languageCheck();
    }

    public String languageCheck() {
        if (things.size() == 0) {
            return "empty (" + totalWeight() + " kg)";
        } else if (things.size() == 1) {
            return things.size() + " thing (" + totalWeight() + " kg)";
        }

        return things.size() + " things (" + totalWeight() + " kg)";
    }
}
