package com.epam.tc.hw4.pom.elements;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ServiceMenu {

    @FindBy(xpath = "//ul[@class='dropdown-menu' or @class='sub']//*[contains(text(), 'Support')]")
    private WebElement support;

    @FindBy(xpath = "//ul[@class='dropdown-menu' or @class='sub']//*[contains(text(), 'Dates')]")
    private WebElement dates;

    @FindBy(xpath = "//ul[@class='dropdown-menu' or @class='sub']//*[contains(text(), 'Search')]")
    private WebElement search;

    @FindBy(xpath = "//ul[@class='dropdown-menu' or @class='sub']//*[contains(text(), 'Different elements')]")
    private WebElement differentElements;

    @FindBy(xpath = "//ul[@class='dropdown-menu' or @class='sub']//*[contains(text(), 'Performance')]")
    private WebElement performance;

    public ServiceMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
