package utils;

import java.util.Random;

public class GenerateUnits {
    public static String generateRandomUsername() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(1000) + "Username";

    }

}
