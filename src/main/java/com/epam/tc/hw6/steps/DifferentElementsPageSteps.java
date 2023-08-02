package com.epam.tc.hw6.steps;

import com.epam.tc.hw6.models.DifferentElementsCheckbox;
import com.epam.tc.hw6.models.DifferentElementsDropdown;
import com.epam.tc.hw6.models.DifferentElementsRadio;
import com.epam.tc.hw6.pom.pages.DifferentElementsPage;
import io.qameta.allure.Step;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class DifferentElementsPageSteps extends BaseSteps {

    private DifferentElementsPage differentElementsPage;

    public DifferentElementsPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        differentElementsPage = new DifferentElementsPage(driver);
    }

    @Step("Open Different elements page by url")
    public DifferentElementsPageSteps openPage() {
        log.info("Open Different elements page");
        super.openPage(DifferentElementsPage.PAGE_URL);
        return this;
    }

    @Step("Click '{checkbox}' checkbox")
    public DifferentElementsPageSteps clickCheckbox(DifferentElementsCheckbox checkbox) {
        log.info("Click '" + checkbox + "' checkbox");
        switch (checkbox) {
            case WATER:
                waitVisibilityOf(differentElementsPage.getConditionsRow().getWaterCheckbox()).click();
                break;
            case WIND:
                waitVisibilityOf(differentElementsPage.getConditionsRow().getWindCheckbox()).click();
                break;
            default:
                throw new RuntimeException("Something went wrong!");
        }
        return this;
    }

    @Step("Select '{radio}' radio")
    public DifferentElementsPageSteps selectRadio(DifferentElementsRadio radio) {
        log.info("Select '" + radio + "' radio");
        switch (radio) {
            case SELEN:
                waitVisibilityOf(differentElementsPage.getMetalsRow().getSelenRadio()).click();
                break;
            default:
                throw new RuntimeException("Something went wrong!");
        }
        return this;
    }

    @Step("Select '{option}' in dropdown")
    public DifferentElementsPageSteps selectInDropdown(DifferentElementsDropdown option) {
        log.info("Select '" + option + "' in dropdown");
        new Select(differentElementsPage.getColorsDropdown().getSelectDropdown()).selectByVisibleText(option.getText());
        return this;
    }

    @Step("Get Log panel")
    public List<String> getLogRows() {
        log.info("Get Log panel");
        return differentElementsPage.getLogInfoPanel().getLogRows();
    }
}
