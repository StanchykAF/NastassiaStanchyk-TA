package com.epam.tc.hw1.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import com.epam.tc.hw1.utils.DataProviderGenerator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultTests {

    private Calculator calculator = null;
    private double precision = 0.001;

    @BeforeTest
    public void initialization() {
        calculator = new Calculator();
    }

    @Test(description = "Test multiplying with valid long values",
            dataProviderClass = DataProviderGenerator.class,
            dataProvider = "longValuesForMult")
    public void testMultOperationWithLongValues(long a, long b, long expectedResult) {
        long actualResult = calculator.mult(a, b);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    // Issue with non-integer values. Result is rounded down
    @Test(description = "Test multiplying with valid double values",
            dataProviderClass = DataProviderGenerator.class,
            dataProvider = "doubleValuesForMult")
    public void testMultOperationWithDoubleValues(double a, double b, double expectedResult) {
        double actualResult = calculator.mult(a, b);
        assertThat(actualResult).isCloseTo(expectedResult, Assertions.offset(precision));
    }

    // Issue: long overflowed, should be handled
    @Test(description = "Test multiplying with max long values",
            expectedExceptions = ArithmeticException.class)
    public void testMultOperationWithMaxValues() {
        calculator.mult(Long.MAX_VALUE, Long.MAX_VALUE);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}
