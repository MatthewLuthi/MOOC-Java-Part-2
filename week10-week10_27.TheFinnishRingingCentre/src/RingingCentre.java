
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RingingCentre {

    private Map<Bird, List<String>> observations;

    public RingingCentre() {
        observations = new HashMap<Bird, List<String>>();
    }

    private boolean birdObserved(Bird bird) {
        return observations.containsKey(bird);
    }

    private List<String> getPlaces(Bird bird) {
        return observations.get(bird);
    }

    public void observe(Bird bird, String place) {
        if (birdObserved(bird)) {
            getPlaces(bird).add(place);
        } else {
            List<String> places = new ArrayList<String>();
            places.add(place);

            observations.put(bird, places);
        }
    }

    public void observations(Bird bird) {
        int size = 0;
        
        if (birdObserved(bird)) {
            size = getPlaces(bird).size();
        }
        
        System.out.println(bird + " observations: " + size);

        if (size > 0) {
            for (String place : getPlaces(bird)) {
                System.out.println(place);
            }
        }
    }
}
