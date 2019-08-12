package helpers;

import java.util.Random;

public class GetRandom {
    /**
     * For example generate(0, 4) will spit out numbers between 0-3
     * @param lowerBound Lowest number inclusive
     * @param higherBound Highest number exclusive
     * @return 
     */
    public static int generate(int lowerBound, int higherBound) {
        Random rand = new Random();
        return rand.nextInt(higherBound - lowerBound) + lowerBound;
    }
}
