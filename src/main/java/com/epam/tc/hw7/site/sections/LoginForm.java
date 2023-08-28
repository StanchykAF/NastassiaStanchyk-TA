package com.epam.tc.hw7.site.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.tc.hw7.entities.User;

public class LoginForm extends Form<User> {

    private TextField name;
    private TextField password;
    private Button loginButton;
}
