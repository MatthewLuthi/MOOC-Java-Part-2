package farmsimulator;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GetRandom {
    public static int generate(int lowerBound, int upperBound) {
        Random rand = new Random();
        return rand.nextInt(upperBound - lowerBound) + lowerBound;
    }
    
    public static double generate(double lowerBound, double upperBound) {
        return ThreadLocalRandom.current().nextDouble(lowerBound, upperBound);
    }
}
