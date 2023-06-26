package com.epam.tc.hw2.pages;

import java.time.Duration;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class BasePage {

    protected WebDriver driver;
    protected static final int WAIT_TIMEOUT_SECONDS = 20;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebDriverWait getNewWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }

    protected WebElement waitVisibilityOf(WebElement element) {
        return getNewWait().until(ExpectedConditions.visibilityOf(element));
    }

    protected WebDriver switchToFrame(WebElement frame) {
        return driver.switchTo().frame(frame);
    }

    public void switchToOriginalWindow() {
        log.info("Switch to default content");
        driver.switchTo().defaultContent();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
