package ru.frigesty.utils;

import java.util.concurrent.ThreadLocalRandom;

import static ru.frigesty.tests.TestData.*;

public class RandomUtils {

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);

        return values[index];
    }

    public static String getRandomCity(String state) {
        String city;
        switch (state) {
            case "NCR": {
                city = getRandomItemFromArray(stateNCR);
                return city;
            }
            case "Uttar Pradesh": {
                city = getRandomItemFromArray(stateUttarPradesh);
                return city;
            }
            case "Haryana": {
                city = getRandomItemFromArray(stateHaryana);
                return city;
            }
            case "Rajasthan": {
                city = getRandomItemFromArray(stateRajasthan);
                return city;
            }
        }
        return null;
    }
}