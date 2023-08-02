package com.epam.tc.hw5.pom.pages;

import com.epam.tc.hw5.pom.elements.Header;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Getter
public class BasePage {

    public static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/";

    protected WebDriver driver;
    protected Header header;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
        PageFactory.initElements(driver, this);
    }
}
