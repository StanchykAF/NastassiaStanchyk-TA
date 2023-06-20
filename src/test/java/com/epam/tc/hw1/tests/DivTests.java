package com.epam.tc.hw1.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import com.epam.tc.hw1.utils.DataProviderGenerator;
import java.util.Random;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DivTests {

    private Calculator calculator = null;
    private double precision = 0.001;

    @BeforeTest
    public void initialization() {
        calculator = new Calculator();
    }

    @Test(description = "Test dividing with valid long values",
            dataProviderClass = DataProviderGenerator.class,
            dataProvider = "longValuesForDiv")
    public void testDivOperationWithLongValues(long a, long b, long expectedResult) {
        long actualResult = calculator.div(a, b);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test(description = "Test dividing with valid double values",
            dataProviderClass = DataProviderGenerator.class,
            dataProvider = "doubleValuesForDiv")
    public void testDivOperationWithDoubleValues(double a, double b, double expectedResult) {
        double actualResult = calculator.div(a, b);
        assertThat(actualResult).isCloseTo(expectedResult, Assertions.offset(precision));
    }

    @Test(description = "Test dividing by zero",
            expectedExceptions = NumberFormatException.class)
    public void testDividingByZero() {
        calculator.div(new Random().nextLong(), 0);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}
