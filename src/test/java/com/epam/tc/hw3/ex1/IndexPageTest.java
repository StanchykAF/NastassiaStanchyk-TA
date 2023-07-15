package com.epam.tc.hw3.ex1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.steps.IndexPageSteps;
import com.epam.tc.hw3.utils.PropertiesReader;
import org.testng.annotations.Test;

public class IndexPageTest extends BaseTest {

    @Test(description = "Test Index Page elements")
    public void testIndexPageElements() {
        IndexPageSteps indexPageSteps = new IndexPageSteps(driver).openPage();
        assertThat(indexPageSteps.getPageTitle()).isEqualTo("Home Page");
        indexPageSteps.login(loginUser);
        assertThat(indexPageSteps.getUsername()).isEqualTo(PropertiesReader.readProperty("user.profile.name"));
        assertThat(indexPageSteps.getHeaderMenusNames()).isEqualTo(headersMenusNames);
        assertThat(indexPageSteps.getNumberOfImages()).isEqualTo(4);
        assertThat(indexPageSteps.getTextsUnderIcons()).isEqualTo(textsUnderIcons);
        assertThat(indexPageSteps.isFrameExist())
                .as("Frame 'frame' doesn't exist on page")
                .isTrue();
        indexPageSteps.switchToFrame();
        assertThat(indexPageSteps.isFrameButtonExist())
                .as("Button in frame 'frame' doesn't exist")
                .isTrue();
        indexPageSteps.switchToOriginalWindow();
        assertThat(indexPageSteps.getLeftSectionMenusNames()).isEqualTo(leftSideBarMenu);
    }
}
