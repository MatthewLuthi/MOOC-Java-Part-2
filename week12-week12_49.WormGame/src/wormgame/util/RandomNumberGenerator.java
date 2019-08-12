package wormgame.util;

import java.util.Random;

public class RandomNumberGenerator {
    public static int generateNumber(int min, int max) {
        Random rand = new Random();
        return (rand.nextInt((max - min) + 1) + min);
    }
}
