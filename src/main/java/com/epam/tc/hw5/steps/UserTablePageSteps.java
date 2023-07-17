package com.epam.tc.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.pom.pages.UserTablePage;
import com.epam.tc.hw5.utils.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class UserTablePageSteps {

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayed(int expectedDropdownCount) {
        log.info("Verify number of Type dropdowns");
        int actualDropdownCount = new UserTablePage(TestContext.getInstance().get("driver", WebDriver.class))
                .getTypeDropdowns().size();
        assertThat(actualDropdownCount).isEqualTo(expectedDropdownCount);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayed(int expectedUsernameCount) {
        log.info("Verify number of Usernames");
        int actualUsernameCount = new UserTablePage(TestContext.getInstance().get("driver", WebDriver.class))
                .getUsernames().size();
        assertThat(actualUsernameCount).isEqualTo(expectedUsernameCount);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayed(int expectedDescriptionTextCount) {
        log.info("Verify number of Description texts");
        int actualDescriptionTextCount = new UserTablePage(TestContext.getInstance().get("driver", WebDriver.class))
                .getDescriptionTexts().size();
        assertThat(actualDescriptionTextCount).isEqualTo(expectedDescriptionTextCount);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayed(int expectedCheckboxCount) {
        log.info("Verify number of Checkboxes");
        int actualCheckboxCount = new UserTablePage(TestContext.getInstance().get("driver", WebDriver.class))
                .getCheckboxes().size();
        assertThat(actualCheckboxCount).isEqualTo(expectedCheckboxCount);
    }

    @Then("User table should contain following values:")
    public void userTableShouldContainFollowingValues(DataTable dataTable) {
        log.info("Verify that User Table contains certain values");
        List<List<String>> expectedTableData = dataTable.asLists(String.class).subList(1, dataTable.asLists().size());
        UserTablePage userTablePage = new UserTablePage(TestContext.getInstance().get("driver", WebDriver.class));
        for (int i = 0; i < expectedTableData.size(); i++) {
            List<String> row = expectedTableData.get(i);
            String expectedNumber = row.get(0).trim();
            String expectedUsername = row.get(1).trim();
            String expectedDescription = row.get(2).trim();

            assertThat(userTablePage.getRowNumber(i)).isEqualTo(expectedNumber);
            assertThat(userTablePage.getUsername(i)).isEqualTo(expectedUsername);
            assertThat(userTablePage.getDescriptionText(i)).isEqualToIgnoringWhitespace(expectedDescription);
        }
    }

    @Then("^droplist should contain values in column Type for user (.*)$")
    public void droplistShouldContainValuesInColumnTypeForUser(String username, DataTable dataTable) {
        log.info("Verify that dropdown contains certain values");
        List<String> expectedDropdownOptions = dataTable.asList(String.class).subList(1, dataTable.asLists().size());
        UserTablePage userTablePage = new UserTablePage(TestContext.getInstance().get("driver", WebDriver.class));
        int rowIndex = userTablePage.findRowIndexByUsername(username);
        List<String> actualDropdownOptions = userTablePage.getTypeDropdownOptions(rowIndex);
        assertThat(actualDropdownOptions).containsExactlyElementsOf(expectedDropdownOptions);
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectVipCheckboxFor(String username) {
        log.info("Select 'vip' checkbox for user " + username);
        UserTablePage userTablePage = new UserTablePage(TestContext.getInstance().get("driver", WebDriver.class));
        int rowIndex = userTablePage.findRowIndexByUsername(username);
        userTablePage.getCheckboxes().get(rowIndex).click();
    }

    @Then("{int} log row has {string} text in log section")
    public void logRowHasTextInLogSection(int expectedRowsNumber, String expectedString) {
        log.info("Verify row in Log");
        List<String> logRows = new UserTablePage(TestContext.getInstance().get("driver", WebDriver.class))
                .getLogInfoPanel()
                .getLogRows();

        assertThat(logRows.size()).isEqualTo(expectedRowsNumber);
        assertThat(logRows).anyMatch(row -> row.contains(expectedString));
    }
}
