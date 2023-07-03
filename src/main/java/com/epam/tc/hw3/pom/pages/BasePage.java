package com.epam.tc.hw3.pom.pages;

import com.epam.tc.hw3.pom.elements.Header;
import com.epam.tc.hw3.pom.elements.LeftSection;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Getter
public class BasePage {

    protected WebDriver driver;
    protected Header header;
    protected LeftSection leftSection;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
        leftSection = new LeftSection(driver);
        PageFactory.initElements(driver, this);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getUserName() {
        return header.getUserName().getText();
    }

}
