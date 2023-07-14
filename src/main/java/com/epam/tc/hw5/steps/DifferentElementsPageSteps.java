package com.epam.tc.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.models.DifferentElementsCheckbox;
import com.epam.tc.hw5.models.DifferentElementsRadio;
import com.epam.tc.hw5.pom.pages.DifferentElementsPage;
import com.epam.tc.hw5.utils.TestContext;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class DifferentElementsPageSteps extends BaseSteps{

    @ParameterType(".*")
    public DifferentElementsCheckbox differentElementsCheckbox(String value) {
        return DifferentElementsCheckbox.valueOf(value.toUpperCase().replace(" ", "_"));
    }

    @ParameterType(".*")
    public DifferentElementsRadio differentElementsRadio(String value) {
        return DifferentElementsRadio.valueOf(value.toUpperCase().replace(" ", "_"));
    }

    @When("I select checkbox {differentElementsCheckbox} on Different Elements Page")
    public void iSelectCheckboxOnDifferentElementsPage(DifferentElementsCheckbox checkbox) {
        log.info("Click '" + checkbox + "' checkbox");
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(
                TestContext.getInstance().get("driver", WebDriver.class));
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
    }

    @And("I select radio {differentElementsRadio} on Different Elements Page")
    public void iSelectRadioOnDifferentElementsPage(DifferentElementsRadio radio) {
        log.info("Select '" + radio + "' radio");
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(
                TestContext.getInstance().get("driver", WebDriver.class));
        switch (radio) {
            case SELEN:
                waitVisibilityOf(differentElementsPage.getMetalsRow().getSelenRadio()).click();
                break;
            default:
                throw new RuntimeException("Something went wrong!");
        }
    }

    @And("^I select (.*) in dropdown on Different Elements Page$")
    public void iSelectInDropdownOnDifferentElementsPage(String option) {
        log.info("Select '" + option + "' in dropdown");
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(
                TestContext.getInstance().get("driver", WebDriver.class));
        new Select(differentElementsPage.getColorsDropdown().getSelectDropdown()).selectByVisibleText(option);
    }

    @Then("{string} should be displayed in Log rows")
    public void shouldBeDisplayedInLogRows(String expectedString) {
        log.info("Verifying row in Log");
        List<String> logRows = new DifferentElementsPage(TestContext.getInstance().get("driver", WebDriver.class))
                .getLogInfoPanel()
                .getLogRows();
        assertThat(logRows).anyMatch(row -> row.contains(expectedString));
    }
}
