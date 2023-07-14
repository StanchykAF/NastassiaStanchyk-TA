package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.utils.TestContext;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseSteps {

    protected static final int WAIT_TIMEOUT_SECONDS = 20;

    protected WebDriverWait getNewWait() {
        return new WebDriverWait(TestContext.getInstance().get("driver", WebDriver.class),
                Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }

    protected WebElement waitVisibilityOf(WebElement element) {
        return getNewWait().until(ExpectedConditions.visibilityOf(element));
    }
}
