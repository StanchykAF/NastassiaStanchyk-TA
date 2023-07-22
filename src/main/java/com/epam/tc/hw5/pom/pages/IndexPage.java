package com.epam.tc.hw5.pom.pages;

import com.epam.tc.hw5.pom.elements.LoginForm;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class IndexPage extends BasePage {

    public static final String PAGE_URL = "index.html";

    private LoginForm loginForm;

    public IndexPage(WebDriver driver) {
        super(driver);
        loginForm = new LoginForm(driver);
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
}
