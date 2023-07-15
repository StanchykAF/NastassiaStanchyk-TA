package com.epam.tc.hw5.pom.pages;

import com.epam.tc.hw5.pom.elements.LogInfoPanel;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class UserTablePage extends BasePage {

    public static final String PAGE_URL = "user-table.html";

    private LogInfoPanel logInfoPanel;

    @FindBy(css = "#user-table tbody tr")
    private List<WebElement> tableRows;

    @FindBy(css = "#user-table tbody tr td:nth-child(1)")
    private List<WebElement> rowNumber;

    @FindBy(css = "#user-table tbody tr td:nth-child(2) select")
    private List<WebElement> typeDropdowns;

    @FindBy(css = "#user-table tbody tr td:nth-child(3) a")
    private List<WebElement> usernames;

    @FindBy(css = "#user-table tbody tr td:nth-child(4) span")
    private List<WebElement> descriptionTexts;

    @FindBy(css = "#user-table tbody tr td:nth-child(4) input[type='checkbox']")
    private List<WebElement> checkboxes;

    public UserTablePage(WebDriver driver) {
        super(driver);
        logInfoPanel = new LogInfoPanel(driver);
    }

    public int getRowCount() {
        return tableRows.size();
    }

    public String getRowNumber(int index) {
        return rowNumber.get(index).getText();
    }

    public String getUsername(int index) {
        return usernames.get(index).getText();
    }

    public String getDescriptionText(int index) {
        return descriptionTexts.get(index).getText();
    }

    public boolean isCheckboxDisplayed(int index) {
        return checkboxes.get(index).isDisplayed();
    }

    public String getTypeDropdownValue(int index) {
        return typeDropdowns.get(index).getAttribute("value");
    }

    public List<String> getTypeDropdownOptions(int index) {
        WebElement dropdown = typeDropdowns.get(index);
        dropdown.click();
        List<WebElement> options = dropdown.findElements(By.tagName("option"));
        return options.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
