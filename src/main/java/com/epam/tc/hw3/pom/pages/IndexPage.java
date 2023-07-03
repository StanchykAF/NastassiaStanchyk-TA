package com.epam.tc.hw3.pom.pages;

import com.epam.tc.hw3.pom.elements.Frame;
import com.epam.tc.hw3.pom.elements.LoginForm;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class IndexPage extends BasePage {

    public static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    private LoginForm loginForm;
    private Frame frame;

    @FindBy(className = "icons-benefit")
    private List<WebElement> iconsBenefit;

    @FindBy(className = "benefit-txt")
    private List<WebElement> textUnderIcons;

    public IndexPage(WebDriver driver) {
        super(driver);
        loginForm = new LoginForm(driver);
        frame = new Frame(driver);
    }

    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public void clickProfileMenuButton() {
        header.getProfileMenuButton().click();
    }

    public void enterUsername(String username) {
        loginForm.getLoginInput().clear();
        loginForm.getLoginInput().sendKeys(username);
    }

    public void enterPassword(String password) {
        loginForm.getPasswordInput().clear();
        loginForm.getPasswordInput().sendKeys(password);
    }

    public void clickEnterButton() {
        loginForm.getEnterButton().click();
    }

    public int getNumberOfImages() {
        return iconsBenefit.size();
    }

    public List<String> getTextsUnderIcons() {
        return textUnderIcons.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean isFrameExist() {
        return frame.getFrame().isDisplayed();
    }

    public void switchToFrame() {
        driver.switchTo().frame(frame.getFrame());
    }
}
