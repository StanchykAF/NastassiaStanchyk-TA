package com.epam.tc.hw1.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import com.epam.tc.hw1.utils.DataProviderGenerator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SumTests {

    private Calculator calculator = null;

    @BeforeTest
    public void initialization() {
        calculator = new Calculator();
    }

    @Test(description = "Test sum operation with valid long values",
            dataProviderClass = DataProviderGenerator.class,
            dataProvider = "longValuesForSum")
    public void testSumOperationWithLongValues(long a, long b, long expectedResult) {
        long actualResult = calculator.sum(a, b);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test(description = "Test sum operation with valid double values",
            dataProviderClass = DataProviderGenerator.class,
            dataProvider = "doubleValuesForSum")
    public void testSumOperationWithDoubleValues(double a, double b, double expectedResult) {
        double actualResult = calculator.sum(a, b);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    // Issue: long overflowed, should be handled
    @Test(description = "Test sum operation with max long values",
            expectedExceptions = ArithmeticException.class)
    public void testSumOperationWithMaxValues() {
        calculator.sum(Long.MAX_VALUE, Long.MAX_VALUE);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}
