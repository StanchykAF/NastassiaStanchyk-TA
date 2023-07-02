package com.epam.tc.hw3.pom.pages;

import com.epam.tc.hw3.models.DifferentElementsCheckbox;
import com.epam.tc.hw3.models.DifferentElementsDropdown;
import com.epam.tc.hw3.models.DifferentElementsRadio;
import com.epam.tc.hw3.pom.elements.ColorsDropdown;
import com.epam.tc.hw3.pom.elements.ConditionsRow;
import com.epam.tc.hw3.pom.elements.LogInfoPanel;
import com.epam.tc.hw3.pom.elements.MetalsRow;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@Log4j2
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

    public void clickCheckbox(DifferentElementsCheckbox checkbox) {
        log.info("Click '" + checkbox + "' checkbox");
        switch (checkbox) {
            case WATER:
                waitVisibilityOf(conditionsRow.getWaterCheckbox()).click();
                break;
            case WIND:
                waitVisibilityOf(conditionsRow.getWindCheckbox()).click();
                break;
            default:
                throw new RuntimeException("Something went wrong!");
        }
    }

    public void selectRadio(DifferentElementsRadio radio) {
        log.info("Select '" + radio + "' radio");
        switch (radio) {
            case SELEN:
                waitVisibilityOf(metalsRow.getSelenRadio()).click();
                break;
            default:
                throw new RuntimeException("Something went wrong!");
        }
    }

    public void selectInDropdown(DifferentElementsDropdown option) {
        log.info("Select '" + option + "' in dropdown");
        new Select(colorsDropdown.getSelectDropdown()).selectByVisibleText(option.getText());
    }

    public List<String> getLogRows() {
        return logInfoPanel.getLogRows().stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
