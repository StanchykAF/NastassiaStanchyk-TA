package com.epam.tc.hw3.pom.elements;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LeftSection {

    @FindBy(xpath = "//a[@ui='label']/span[contains(text(), 'Service')]")
    private WebElement serviceMenu;

    public LeftSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
