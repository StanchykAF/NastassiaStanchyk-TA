package com.epam.tc.hw2.pages;

import com.epam.tc.hw2.models.User;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class IndexPage extends BasePage {

    public static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    // HEADER
    @FindBy(css = ".dropdown.uui-profile-menu .profile-photo")
    private WebElement profileMenuButton;

    @FindBy(id = "name")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement enterButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(css = ".uui-navigation.nav > li > a")
    private List<WebElement> headerMenus;

    @FindBy(className = "icons-benefit")
    private List<WebElement> iconsBenefit;

    @FindBy(className = "benefit-txt")
    private List<WebElement> textUnderIcons;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(css = ".sidebar-menu > li > a > span")
    private List<WebElement> leftMenu;

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        log.info("Open Index page");
        driver.navigate().to(BASE_URL);
    }

    public void login(User user) {
        log.info("Log in as user " + user.getUsername());
        profileMenuButton.click();
        waitVisibilityOf(loginInput).clear();
        loginInput.sendKeys(user.getUsername());
        passwordInput.clear();
        passwordInput.sendKeys(user.getPassword());
        enterButton.click();
    }

    public String getUserName() {
        log.info("Get logged in user name");
        return waitVisibilityOf(userName).getText();
    }

    public List<String> getHeaderMenusNames() {
        log.info("Get names of header menu");
        return headerMenus.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public int getNumberOfImages() {
        return iconsBenefit.size();
    }

    public List<String> getTextsUnderIcons() {
        return textUnderIcons.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean isFrameExist() {
        log.info("Check if frame is displayed");
        return frame.isDisplayed();
    }

    public void switchToFrame() {
        log.info("Switch to frame");
        switchToFrame(frame);
    }

    public  boolean isFrameButtonExist() {
        log.info("Check if frame button is displayed in frame");
        return frameButton.isDisplayed();
    }

    public List<String> getLeftSidebarMenuNames() {
        return leftMenu.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
