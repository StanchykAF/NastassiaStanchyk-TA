package com.epam.tc.hw1.utils;

import java.util.Random;
import org.testng.annotations.DataProvider;

public class DataProviderGenerator {

    private static final Random RANDOM = new Random();

    @DataProvider(name = "longValuesForSum")
    public static Object[][] generateLongValuesForSumOperation() {
        long longNum1 = RANDOM.nextLong()/2;
        long longNum2 = RANDOM.nextLong()/2;
        return new Object[][] {
                {0, 0, 0},
                {115L, 76L, 191L},
                {longNum1, longNum2, Math.addExact(longNum1, longNum2)}
        };
    }

    @DataProvider(name = "doubleValuesForSum")
    public static Object[][] generateDoubleValuesForSumOperation() {
        return new Object[][] {
                {0.0, 0.0, 0.0},
                {1.56, 7.6, 9.16},
                {3.141, 2.718, 5.859}
        };
    }

    @DataProvider(name = "longValuesForSub")
    public static Object[][] generateLongValuesForSubOperation() {
        long longNum1 = RANDOM.nextLong()/2;
        long longNum2 = RANDOM.nextLong()/2;
        return new Object[][] {
                {0, 0, 0},
                {115L, 76L, 39L},
                {longNum1, longNum2, Math.subtractExact(longNum1, longNum2)}
        };
    }

    @DataProvider(name = "doubleValuesForSub")
    public static Object[][] generateDoubleValuesForSubOperation() {
        return new Object[][] {
                {0.0, 0.0, 0.0},
                {1.56, 7.6, -6.04},
                {3.141, 2.718, 0.423}
        };
    }

    @DataProvider(name = "longValuesForDiv")
    public static Object[][] generateLongValuesForDivOperation() {
        long longNum1 = RANDOM.nextLong();
        long longNum2 = RANDOM.nextLong();
        return new Object[][] {
                {0, 2, 0},
                {1L, 2L, 0L},
                {6, 2, 3},
                {longNum1, longNum2, Math.floorDiv(longNum1, longNum2)}
        };
    }

    @DataProvider(name = "doubleValuesForDiv")
    public static Object[][] generateDoubleValuesForDivOperation() {
        return new Object[][] {
                {0.0, 2.0, 0.0},
                {1.0, 2.0, 0.5},
                {3.141, 2.718, 1.156}
        };
    }

    @DataProvider(name = "longValuesForMult")
    public static Object[][] generateLongValuesForMultOperation() {
        long longNum = RANDOM.nextLong();
        return new Object[][] {
                {0, 0, 0},
                {16L, 42L, 672L},
                {longNum, 0, 0},
                {longNum, 1, longNum}
        };
    }

    @DataProvider(name = "doubleValuesForMult")
    public static Object[][] generateDoubleValuesForMultOperation() {
        return new Object[][] {
                {0.0, 0.0, 0.0},
                {-1.0, -2.0, 2.0},
                {3.141, 2.718, 8.537}
        };
    }
}
