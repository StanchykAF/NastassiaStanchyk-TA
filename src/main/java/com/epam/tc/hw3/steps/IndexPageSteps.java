package com.epam.tc.hw3.steps;

import com.epam.tc.hw3.models.User;
import com.epam.tc.hw3.pom.pages.IndexPage;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        super.openPage(IndexPage.PAGE_URL);
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

    public int getNumberOfImages() {
        log.info("Get number of images on Index page");
        return indexPage.getIconsBenefit().size();
    }

    public List<String> getTextsUnderIcons() {
        log.info("Get texts under images on Index page");
        return indexPage.getTextUnderIcons().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean isFrameExist() {
        log.info("Is frame displayed?");
        return indexPage.getFrame().getFrame().isDisplayed();
    }

    public IndexPageSteps switchToFrame() {
        log.info("Switch to frame");
        driver.switchTo().frame(indexPage.getFrame().getFrame());
        return this;
    }

    public boolean isFrameButtonExist() {
        log.info("Check if frame button is displayed in frame");
        return indexPage.getFrame().getFrameButton().isDisplayed();
    }

    @Override
    public IndexPageSteps switchToOriginalWindow() {
        super.switchToOriginalWindow();
        return this;
    }
}
