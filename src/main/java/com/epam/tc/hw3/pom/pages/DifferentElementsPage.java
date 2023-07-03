package com.epam.tc.hw3.pom.pages;

import com.epam.tc.hw3.pom.elements.ColorsDropdown;
import com.epam.tc.hw3.pom.elements.ConditionsRow;
import com.epam.tc.hw3.pom.elements.LogInfoPanel;
import com.epam.tc.hw3.pom.elements.MetalsRow;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class DifferentElementsPage extends BasePage {

    private ConditionsRow conditionsRow;
    private MetalsRow metalsRow;
    private ColorsDropdown colorsDropdown;
    private LogInfoPanel logInfoPanel;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        conditionsRow = new ConditionsRow(driver);
        metalsRow = new MetalsRow(driver);
        colorsDropdown = new ColorsDropdown(driver);
        logInfoPanel = new LogInfoPanel(driver);
    }
}
