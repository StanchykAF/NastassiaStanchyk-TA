package com.epam.tc.hw4.ex2;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.BaseTest;
import com.epam.tc.hw4.models.DifferentElementsCheckbox;
import com.epam.tc.hw4.models.DifferentElementsDropdown;
import com.epam.tc.hw4.models.DifferentElementsRadio;
import com.epam.tc.hw4.models.ServiceDropDownMenu;
import com.epam.tc.hw4.steps.DifferentElementsPageSteps;
import com.epam.tc.hw4.steps.IndexPageSteps;
import com.epam.tc.hw4.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.List;
import org.testng.annotations.Test;

@Feature("Different Elements Page")
@Story("Different Elements Page Elements")
public class DifferentElementsTest extends BaseTest {

    @Test(description = "Test Different Elements Page elements")
    @Description("Test Different Elements Page elements")
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
