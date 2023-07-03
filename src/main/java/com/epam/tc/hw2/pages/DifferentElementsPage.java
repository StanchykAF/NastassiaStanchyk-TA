package com.epam.tc.hw2.pages;

import com.epam.tc.hw2.models.DifferentElementsCheckbox;
import com.epam.tc.hw2.models.DifferentElementsDropdown;
import com.epam.tc.hw2.models.DifferentElementsRadio;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class DifferentElementsPage extends BasePage {

    // CHECKBOXES
    @FindBy(xpath = "//label[normalize-space() = 'Water']")
    private WebElement waterCheckbox;

    @FindBy(xpath = "//label[normalize-space() = 'Wind']")
    private WebElement windCheckbox;

    // RADIO
    @FindBy(xpath = "//label[normalize-space() = 'Selen']")
    private WebElement selenRadio;

    // DROPDOWN
    @FindBy(css = "select.uui-form-element")
    private WebElement selectDropdown;

    // LOGS PANEL
    @FindBy(css = "ul.logs > li")
    private List<WebElement> logRows;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckbox(DifferentElementsCheckbox checkbox) {
        log.info("Click '" + checkbox + "' checkbox");
        switch (checkbox) {
            case WATER:
                waitVisibilityOf(waterCheckbox).click();
                break;
            case WIND:
                waitVisibilityOf(windCheckbox).click();
                break;
            default:
                throw new RuntimeException("Something went wrong!");
        }
    }

    public void selectRadio(DifferentElementsRadio radio) {
        log.info("Select '" + radio + "' radio");
        switch (radio) {
            case SELEN:
                waitVisibilityOf(selenRadio).click();
                break;
            default:
                throw new RuntimeException("Something went wrong!");
        }
    }

    public void selectInDropdown(DifferentElementsDropdown option) {
        log.info("Select '" + option + "' in dropdown");
        new Select(selectDropdown).selectByVisibleText(option.getText());
    }

    public List<String> getLogRows() {
        return logRows.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
