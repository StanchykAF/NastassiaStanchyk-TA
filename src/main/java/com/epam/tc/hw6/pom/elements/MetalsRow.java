package com.epam.tc.hw6.pom.elements;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class MetalsRow {

    @FindBy(xpath = "//label[normalize-space() = 'Selen']")
    private WebElement selenRadio;

    public MetalsRow(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
