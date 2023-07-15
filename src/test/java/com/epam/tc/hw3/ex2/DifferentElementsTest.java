package com.epam.tc.hw3.ex2;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.models.DifferentElementsCheckbox;
import com.epam.tc.hw3.models.DifferentElementsDropdown;
import com.epam.tc.hw3.models.DifferentElementsRadio;
import com.epam.tc.hw3.models.ServiceDropDownMenu;
import com.epam.tc.hw3.steps.DifferentElementsPageSteps;
import com.epam.tc.hw3.steps.IndexPageSteps;
import com.epam.tc.hw3.utils.PropertiesReader;
import java.util.List;
import org.testng.annotations.Test;

public class DifferentElementsTest extends BaseTest {

    @Test(description = "Test Different Elements Page elements")
    public void testDifferentElementsPageElements() {
        IndexPageSteps indexPageSteps = new IndexPageSteps(driver).openPage();
        assertThat(indexPageSteps.getPageTitle()).isEqualTo("Home Page");
        indexPageSteps.login(loginUser);
        assertThat(indexPageSteps.getUsername()).isEqualTo(PropertiesReader.readProperty("user.profile.name"));
        DifferentElementsPageSteps differentElementsPageSteps = (DifferentElementsPageSteps) indexPageSteps
                .clickServiceDropdownMenuElement(ServiceDropDownMenu.DIFFERENT_ELEMENTS);
        List<String> actualLogRows = differentElementsPageSteps
                .clickCheckbox(DifferentElementsCheckbox.WATER)
                .clickCheckbox(DifferentElementsCheckbox.WIND)
                .selectRadio(DifferentElementsRadio.SELEN)
                .selectInDropdown(DifferentElementsDropdown.YELLOW)
                .getLogRows();
        assertThat(actualLogRows.stream().allMatch(actualRow -> expectedLogRows.stream().anyMatch(actualRow::contains)))
                .withFailMessage("Actual log rows " + actualLogRows + " don't match with expected log rows "
                        + expectedLogRows)
                .isTrue();
    }
}
