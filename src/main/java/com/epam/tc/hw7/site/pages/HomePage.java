package com.epam.tc.hw7.site.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.site.sections.LoginForm;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends WebPage {

    private Label userName;
    private Icon userIcon;

    private LoginForm loginForm;

    public void login(User user) {
        userIcon.click();
        loginForm.loginAs(user);
        userName.is().displayed();
    }

    public String getUserName() {
        return userName.getText();
    }
}
