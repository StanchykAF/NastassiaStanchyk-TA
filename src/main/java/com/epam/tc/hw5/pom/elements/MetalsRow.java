package com.epam.tc.hw5.pom.elements;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Getter
public class MetalsRow {

    private WebDriver driver;
    private final String metalsRowElement = "//label[normalize-space() = '%s']";

    public MetalsRow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getMetalsRowElement(String elementName) {
        return driver.findElement(By.xpath(String.format(metalsRowElement, elementName)));
    }
}
