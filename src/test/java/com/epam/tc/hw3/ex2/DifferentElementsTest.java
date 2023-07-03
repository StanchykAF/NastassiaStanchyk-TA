package com.epam.tc.hw3.ex2;

import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.models.DifferentElementsCheckbox;
import com.epam.tc.hw3.models.DifferentElementsDropdown;
import com.epam.tc.hw3.models.DifferentElementsRadio;
import com.epam.tc.hw3.models.ServiceDropDownMenu;
import com.epam.tc.hw3.steps.DifferentElementsPageSteps;
import com.epam.tc.hw3.steps.IndexPageSteps;
import com.epam.tc.hw3.utils.PropertiesReader;
import org.testng.annotations.Test;

public class DifferentElementsTest extends BaseTest {

    @Test(description = "Test Different Elements Page elements")
    public void testDifferentElementsPageElements() {
        DifferentElementsPageSteps differentElementsPageSteps = (DifferentElementsPageSteps) new IndexPageSteps(driver)
                .openPage()
                .checkPageTitle("Home Page")
                .login(loginUser)
                .checkUsername(PropertiesReader.readProperty("user.profile.name"))
                .clickServiceDropdownMenuElement(ServiceDropDownMenu.DIFFERENT_ELEMENTS);
        differentElementsPageSteps
                .clickCheckbox(DifferentElementsCheckbox.WATER)
                .clickCheckbox(DifferentElementsCheckbox.WIND)
                .selectRadio(DifferentElementsRadio.SELEN)
                .selectInDropdown(DifferentElementsDropdown.YELLOW)
                .checkLog(expectedLogRows);
    }
}
