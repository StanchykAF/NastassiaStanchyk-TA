package com.epam.tc.hw1.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import com.epam.tc.hw1.utils.DataProviderGenerator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SubTests {

    private Calculator calculator = null;
    private double precision = 0.001;

    @BeforeTest
    public void initialization() {
        calculator = new Calculator();
    }

    @Test(description = "Test sub operation with valid long values",
            dataProviderClass = DataProviderGenerator.class,
            dataProvider = "longValuesForSub")
    public void testSubOperationWithLongValues(long a, long b, long expectedResult) {
        long actualResult = calculator.sub(a, b);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test(description = "Test sub operation with valid double values",
            dataProviderClass = DataProviderGenerator.class,
            dataProvider = "doubleValuesForSub")
    public void testSubOperationWithDoubleValues(double a, double b, double expectedResult) {
        double actualResult = calculator.sub(a, b);
        assertThat(actualResult).isCloseTo(expectedResult, Assertions.offset(precision));
    }

    // Issue: long overflowed, should be handled
    @Test(description = "Test sub operation with min long values",
            expectedExceptions = ArithmeticException.class)
    public void testSumOperationWithMinValues() {
        calculator.sub(Long.MIN_VALUE, Long.MIN_VALUE);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}
