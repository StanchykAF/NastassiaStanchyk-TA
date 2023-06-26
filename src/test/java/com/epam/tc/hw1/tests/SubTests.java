package com.epam.tc.hw1.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.utils.DataProviderGenerator;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

@Log4j2
public class SubTests extends BaseTest {

    @Test(description = "Test sub operation with valid long values",
            dataProviderClass = DataProviderGenerator.class,
            dataProvider = "longValuesForSub")
    public void testSubOperationWithLongValues(long a, long b, long expectedResult) {
        log.info("Subtraction test for long values " + a + " and " + b);
        long actualResult = calculator.sub(a, b);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test(description = "Test sub operation with valid double values",
            dataProviderClass = DataProviderGenerator.class,
            dataProvider = "doubleValuesForSub")
    public void testSubOperationWithDoubleValues(double a, double b, double expectedResult) {
        log.info("Subtraction test for double values " + a + " and " + b);
        double actualResult = calculator.sub(a, b);
        assertThat(actualResult).isCloseTo(expectedResult, Assertions.offset(precision));
    }

    // Issue: long overflowed, should be handled
    @Test(description = "Test sub operation with min long values")
    public void testSubOperationWithMinValues() {
        log.info("Addition test for long min values");
        Assertions.assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> calculator.sub(Long.MIN_VALUE, Long.MIN_VALUE));
    }
}
