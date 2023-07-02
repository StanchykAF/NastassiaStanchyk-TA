package com.epam.tc.hw3.pom.pages;

import com.epam.tc.hw3.models.User;
import com.epam.tc.hw3.pom.elements.Frame;
import com.epam.tc.hw3.pom.elements.LoginForm;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class IndexPage extends BasePage {

    public static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    private LoginForm loginForm;
    private Frame frame;

    @FindBy(className = "icons-benefit")
    private List<WebElement> iconsBenefit;

    @FindBy(className = "benefit-txt")
    private List<WebElement> textUnderIcons;

    @FindBy(css = ".sidebar-menu > li > a > span")
    private List<WebElement> leftMenu;

    public IndexPage(WebDriver driver) {
        super(driver);
        loginForm = new LoginForm(driver);
        frame = new Frame(driver);
    }

    public void openPage() {
        log.info("Open Index page");
        driver.navigate().to(BASE_URL);
    }

    public void login(User user) {
        log.info("Log in as user " + user.getUsername());
        header.getProfileMenuButton().click();
        waitVisibilityOf(loginForm.getLoginInput()).clear();
        loginForm.getLoginInput().sendKeys(user.getUsername());
        loginForm.getPasswordInput().clear();
        loginForm.getPasswordInput().sendKeys(user.getPassword());
        loginForm.getEnterButton().click();
    }

    public String getUserName() {
        log.info("Get logged in user name");
        return waitVisibilityOf(header.getUserName()).getText();
    }

    public int getNumberOfImages() {
        return iconsBenefit.size();
    }

    public List<String> getTextsUnderIcons() {
        return textUnderIcons.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean isFrameExist() {
        log.info("Check if frame is displayed");
        return frame.getFrame().isDisplayed();
    }

    public void switchToFrame() {
        log.info("Switch to frame");
        switchToFrame(frame.getFrame());
    }

    public  boolean isFrameButtonExist() {
        log.info("Check if frame button is displayed in frame");
        return frame.getFrameButton().isDisplayed();
    }

    public List<String> getLeftSidebarMenuNames() {
        return leftMenu.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
