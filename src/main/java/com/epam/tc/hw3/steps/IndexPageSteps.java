package com.epam.tc.hw3.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw3.models.User;
import com.epam.tc.hw3.pom.pages.IndexPage;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class IndexPageSteps extends BaseSteps {

    private IndexPage indexPage;

    public IndexPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        indexPage = new IndexPage(driver);
    }

    public IndexPageSteps openPage() {
        log.info("Open Index page");
        indexPage.openPage();
        return this;
    }

    public IndexPageSteps login(User user) {
        log.info("Log in as user " + user.getUsername());
        indexPage.clickProfileMenuButton();
        indexPage.enterUsername(user.getUsername());
        indexPage.enterPassword(user.getPassword());
        indexPage.clickEnterButton();
        return this;
    }

    public IndexPageSteps checkNumberOfImages(int expectedNumber) {
        log.info("Check number of images on Index page");
        assertThat(indexPage.getNumberOfImages()).isEqualTo(expectedNumber);
        return this;
    }

    public IndexPageSteps checkTextsUnderIcons(List<String> expectedTexts) {
        log.info("Check texts under images on Index page");
        assertThat(indexPage.getTextsUnderIcons()).isEqualTo(expectedTexts);
        return this;
    }

    public IndexPageSteps checkIfFrameExist() {
        log.info("Check if frame is displayed");
        assertThat(indexPage.isFrameExist()).isTrue();
        return this;
    }

    public IndexPageSteps switchToFrame() {
        log.info("Switch to frame");
        indexPage.switchToFrame();
        return this;
    }

    public IndexPageSteps checkIfFrameButtonExist() {
        log.info("Check if frame button is displayed in frame");
        assertThat(indexPage.getFrame().isFrameButtonExist()).isTrue();
        return this;
    }

    @Override
    public IndexPageSteps checkPageTitle(String expectedTitle) {
        super.checkPageTitle(expectedTitle);
        return this;
    }

    @Override
    public IndexPageSteps checkUsername(String expectedUsername) {
        super.checkUsername(expectedUsername);
        return this;
    }

    @Override
    public IndexPageSteps checkHeaderMenusNames(List<String> expectedMenusNames) {
        super.checkHeaderMenusNames(expectedMenusNames);
        return this;
    }

    @Override
    public IndexPageSteps switchToOriginalWindow() {
        super.switchToOriginalWindow();
        return this;
    }

    @Override
    public IndexPageSteps checkLeftSectionMenusNames(List<String> expectedMenusNames) {
        super.checkLeftSectionMenusNames(expectedMenusNames);
        return this;
    }
}
