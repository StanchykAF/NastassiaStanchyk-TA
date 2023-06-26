package com.epam.tc.hw1.tests;

import com.epam.tat.module4.Calculator;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

@Log4j2
public class BaseTest {

    protected Calculator calculator;
    protected double precision = 0.001;

    @BeforeClass
    public void initialization() {
        log.info("Initialization");
        calculator = new Calculator();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        log.info("Tear down");
        calculator = null;
    }
}
