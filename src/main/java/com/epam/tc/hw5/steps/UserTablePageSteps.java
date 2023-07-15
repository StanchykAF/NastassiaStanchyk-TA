package com.epam.tc.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.pom.pages.UserTablePage;
import com.epam.tc.hw5.utils.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class UserTablePageSteps {

    // TODO: остался тест раннер, xml файл и профиль мавена. И почистить файлы от коментов. И все. Ты молодец,
    //  почти справилась. Чуть-чуть осталось
    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayed(int expectedDropdownCount) {
        int actualDropdownCount = new UserTablePage(TestContext.getInstance().get("driver", WebDriver.class))
                .getTypeDropdowns().size();
        assertThat(actualDropdownCount).isEqualTo(expectedDropdownCount);
    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayed(int expectedUsernameCount) {
        int actualUsernameCount = new UserTablePage(TestContext.getInstance().get("driver", WebDriver.class))
                .getUsernames().size();
        assertThat(actualUsernameCount).isEqualTo(expectedUsernameCount);
    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayed(int expectedDescriptionTextCount) {
        int actualDescriptionTextCount = new UserTablePage(TestContext.getInstance().get("driver", WebDriver.class))
                .getDescriptionTexts().size();
        assertThat(actualDescriptionTextCount).isEqualTo(expectedDescriptionTextCount);
    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayed(int expectedCheckboxCount) {
        int actualCheckboxCount = new UserTablePage(TestContext.getInstance().get("driver", WebDriver.class))
                .getCheckboxes().size();
        assertThat(actualCheckboxCount).isEqualTo(expectedCheckboxCount);
    }

    @And("User table should contain following values:")
    public void userTableShouldContainFollowingValues(DataTable dataTable) {
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

    @And("^droplist should contain values in column Type for user (.*)$")
    public void droplistShouldContainValuesInColumnTypeForUser(String username, DataTable dataTable) {
        List<String> expectedDropdownOptions = dataTable.asList(String.class).subList(1, dataTable.asLists().size());
        int rowIndex = findRowIndexByUsername(username);
        List<String> actualDropdownOptions = new UserTablePage(TestContext.getInstance().get("driver", WebDriver.class))
                .getTypeDropdownOptions(rowIndex);

        assertThat(actualDropdownOptions).containsExactlyElementsOf(expectedDropdownOptions);
    }

    @When("I select 'vip' checkbox for {string}")
    public void iSelectVipCheckboxFor(String username) {
        int rowIndex = findRowIndexByUsername(username);
        new UserTablePage(TestContext.getInstance().get("driver", WebDriver.class))
                .getCheckboxes().get(rowIndex).click();
    }

    @Then("{int} log row has {string} text in log section")
    public void logRowHasTextInLogSection(int expectedRowsNumber, String expectedString) {
//        log.info("Verifying row in Log");
        List<String> logRows = new UserTablePage(TestContext.getInstance().get("driver", WebDriver.class))
                .getLogInfoPanel()
                .getLogRows();

        assertThat(logRows.size()).isEqualTo(expectedRowsNumber);
        assertThat(logRows).anyMatch(row -> row.contains(expectedString));
    }

    private int findRowIndexByUsername(String username) {
        UserTablePage userTablePage = new UserTablePage(TestContext.getInstance().get("driver", WebDriver.class));
        for (int i = 0; i < userTablePage.getRowCount(); i++) {
            if (userTablePage.getUsername(i).equals(username)) {
                return i;
            }
        }
        throw new RuntimeException("User with username '" + username + "' not found in the table");
    }
}
