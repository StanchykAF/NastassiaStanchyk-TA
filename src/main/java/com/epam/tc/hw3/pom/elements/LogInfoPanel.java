package com.epam.tc.hw3.pom.elements;

import java.util.List;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LogInfoPanel {

    @FindBy(css = "ul.logs > li")
    private List<WebElement> logRows;

    public LogInfoPanel(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
