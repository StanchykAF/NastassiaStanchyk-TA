package com.epam.tc.hw3.pom.elements;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ColorsDropdown {

    @FindBy(css = "select.uui-form-element")
    private WebElement selectDropdown;

    public ColorsDropdown(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
