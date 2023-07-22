package com.epam.tc.hw5.pom.elements;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ConditionsRow {

    private WebDriver driver;
    private final String conditionsRowElement = "//label[normalize-space() = '%s']";

    public ConditionsRow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getConditionsRowElement(String elementName) {
        return driver.findElement(By.xpath(String.format(conditionsRowElement, elementName)));
    }
}
