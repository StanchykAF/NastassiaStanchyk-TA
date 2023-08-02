package com.epam.tc.hw4.pom.elements;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ConditionsRow {

    @FindBy(xpath = "//label[normalize-space() = 'Water']")
    private WebElement waterCheckbox;

    @FindBy(xpath = "//label[normalize-space() = 'Wind']")
    private WebElement windCheckbox;

    public ConditionsRow(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
