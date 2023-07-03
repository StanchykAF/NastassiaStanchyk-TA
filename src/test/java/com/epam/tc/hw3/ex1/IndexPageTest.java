package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.steps.IndexPageSteps;
import com.epam.tc.hw3.utils.PropertiesReader;
import org.testng.annotations.Test;

public class IndexPageTest extends BaseTest {

    @Test(description = "Test Index Page elements")
    public void testIndexPageElements() {
        new IndexPageSteps(driver).openPage()
                .checkPageTitle("Home Page")
                .login(loginUser)
                .checkUsername(PropertiesReader.readProperty("user.profile.name"))
                .checkHeaderMenusNames(headersMenusNames)
                .checkNumberOfImages(4)
                .checkTextsUnderIcons(textsUnderIcons)
                .checkIfFrameExist()
                .switchToFrame()
                .checkIfFrameButtonExist()
                .switchToOriginalWindow()
                .checkLeftSectionMenusNames(leftSideBarMenu);
    }
}
