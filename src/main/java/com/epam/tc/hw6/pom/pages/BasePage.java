package com.epam.tc.hw6.pom.pages;

import com.epam.tc.hw6.pom.elements.Header;
import com.epam.tc.hw6.pom.elements.LeftSection;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Getter
public class BasePage {

    public static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/";

    protected WebDriver driver;
    protected Header header;
    protected LeftSection leftSection;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
        leftSection = new LeftSection(driver);
        PageFactory.initElements(driver, this);
    }
}
