package com.epam.tc.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.epam.tc.hw5.steps", "com.epam.tc.hw5.hooks"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
