package com.epam.tc.hw1.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.utils.DataProviderGenerator;
import java.util.Random;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

@Log4j2
public class DivTests extends BaseTest {

    @Test(description = "Test division with valid long values",
            dataProviderClass = DataProviderGenerator.class,
            dataProvider = "longValuesForDiv")
    public void testDivOperationWithLongValues(long a, long b, long expectedResult) {
        log.info("Division test for long values " + a + " and " + b);
        long actualResult = calculator.div(a, b);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test(description = "Test division with valid double values",
            dataProviderClass = DataProviderGenerator.class,
            dataProvider = "doubleValuesForDiv")
    public void testDivOperationWithDoubleValues(double a, double b, double expectedResult) {
        log.info("Division test for double values " + a + " and " + b);
        double actualResult = calculator.div(a, b);
        assertThat(actualResult).isCloseTo(expectedResult, Assertions.offset(precision));
    }

    @Test(description = "Test division by zero")
    public void testDivisionByZero() {
        log.info("Division by zero");
        Assertions.assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> calculator.div(new Random().nextLong(), 0))
                .withMessageContaining("divide by zero");
    }
}
