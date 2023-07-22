package com.epam.tc.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.pom.pages.DifferentElementsPage;
import com.epam.tc.hw5.utils.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class DifferentElementsPageSteps extends BaseSteps {

    @When("^I select checkbox (.*) on Different Elements Page$")
    public void selectCheckboxOnDifferentElementsPage(String checkbox) {
        log.info("Click '" + checkbox + "' checkbox");
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(
                TestContext.getInstance().get("driver", WebDriver.class));
        waitVisibilityOf(differentElementsPage.getConditionsRow().getConditionsRowElement(checkbox)).click();
    }

    @When("^I select radio (.*) on Different Elements Page$")
    public void selectRadioOnDifferentElementsPage(String radio) {
        log.info("Select '" + radio + "' radio");
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(
                TestContext.getInstance().get("driver", WebDriver.class));
        waitVisibilityOf(differentElementsPage.getMetalsRow().getMetalsRowElement(radio)).click();
    }

    @When("^I select (.*) in dropdown on Different Elements Page$")
    public void selectInDropdownOnDifferentElementsPage(String option) {
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
