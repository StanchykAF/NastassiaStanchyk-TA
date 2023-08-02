package com.epam.tc.hw5.pom.elements;

import java.util.List;
import java.util.stream.Collectors;
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

    public List<String> getLogRows() {
        return logRows.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
