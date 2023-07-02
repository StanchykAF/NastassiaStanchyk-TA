package com.epam.tc.hw3.ex2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.models.DifferentElementsCheckbox;
import com.epam.tc.hw3.models.DifferentElementsDropdown;
import com.epam.tc.hw3.models.DifferentElementsRadio;
import com.epam.tc.hw3.models.ServiceDropDownMenu;
import com.epam.tc.hw3.models.User;
import com.epam.tc.hw3.pom.pages.DifferentElementsPage;
import com.epam.tc.hw3.pom.pages.IndexPage;
import com.epam.tc.hw3.utils.PropertiesReader;
import java.util.List;
import org.testng.annotations.Test;

public class DifferentElementsTest extends BaseTest {

    @Test(description = "Test Index Page elements")
    public void testIndexPageElements() {
        IndexPage indexPage = new IndexPage(driver);
        // 1. Open test site by URL
        indexPage.openPage();
        // 2. Assert Browser title
        assertThat(indexPage.getPageTitle()).isEqualTo("Home Page");
        // 3. Perform login
        indexPage.login(new User(
                PropertiesReader.readProperty("user.name"),
                PropertiesReader.readProperty("user.password")
        ));
        // 4. Assert Username is logging
        assertThat(indexPage.getUserName()).isEqualTo(PropertiesReader.readProperty("user.profile.name"));
        // 5. Open through the header menu Service -> Different Elements Page
        indexPage.clickServiceDropdownMenuElement(ServiceDropDownMenu.DIFFERENT_ELEMENTS);
        // 6. Select checkboxes
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        differentElementsPage.clickCheckbox(DifferentElementsCheckbox.WATER);
        differentElementsPage.clickCheckbox(DifferentElementsCheckbox.WIND);
        // 7. Select radio
        differentElementsPage.selectRadio(DifferentElementsRadio.SELEN);
        // 8. Select in dropdown
        differentElementsPage.selectInDropdown(DifferentElementsDropdown.YELLOW);
        // 9. Check log rows
        List<String> actualLogRows = differentElementsPage.getLogRows();
        assertThat(actualLogRows.stream().allMatch(actualRow -> expectedLogRows.stream().anyMatch(actualRow::contains)))
                .withFailMessage("Actual log rows " + actualLogRows + " don't match with expected log rows "
                        + expectedLogRows)
                .isTrue();
    }
}
