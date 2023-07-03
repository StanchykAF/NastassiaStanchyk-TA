package com.epam.tc.hw1.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.utils.DataProviderGenerator;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

@Log4j2
public class MultTests extends BaseTest {

    @Test(description = "Test multiplying with valid long values",
            dataProviderClass = DataProviderGenerator.class,
            dataProvider = "longValuesForMult")
    public void testMultOperationWithLongValues(long a, long b, long expectedResult) {
        log.info("Multiplying test for long values " + a + " and " + b);
        long actualResult = calculator.mult(a, b);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    // Issue with non-integer values. Result is rounded down
    @Test(description = "Test multiplying with valid double values",
            dataProviderClass = DataProviderGenerator.class,
            dataProvider = "doubleValuesForMult")
    public void testMultOperationWithDoubleValues(double a, double b, double expectedResult) {
        log.info("Multiplying test for double values " + a + " and " + b);
        double actualResult = calculator.mult(a, b);
        assertThat(actualResult).isCloseTo(expectedResult, Assertions.offset(precision));
    }

    // Issue: long overflowed, should be handled
    @Test(description = "Test multiplying with max long values")
    public void testMultOperationWithMaxValues() {
        log.info("Multiplying test for long max values");
        Assertions.assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> calculator.mult(Long.MAX_VALUE, Long.MAX_VALUE));
    }
}
