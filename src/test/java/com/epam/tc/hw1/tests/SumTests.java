package com.epam.tc.hw1.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.utils.DataProviderGenerator;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

@Log4j2
public class SumTests extends BaseTest {

    @Test(description = "Test sum operation with valid long values",
            dataProviderClass = DataProviderGenerator.class,
            dataProvider = "longValuesForSum")
    public void testSumOperationWithLongValues(long a, long b, long expectedResult) {
        log.info("Addition test for long values " + a + " and " + b);
        long actualResult = calculator.sum(a, b);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test(description = "Test sum operation with valid double values",
            dataProviderClass = DataProviderGenerator.class,
            dataProvider = "doubleValuesForSum")
    public void testSumOperationWithDoubleValues(double a, double b, double expectedResult) {
        log.info("Addition test for double values " + a + " and " + b);
        double actualResult = calculator.sum(a, b);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    // Issue: long overflowed, should be handled
    @Test(description = "Test sum operation with max long values")
    public void testSumOperationWithMaxValues() {
        log.info("Addition test for long max values");
        Assertions.assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> calculator.sum(Long.MAX_VALUE, Long.MAX_VALUE));
    }
}
