package com.epam.tc.hw5.pom.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ServiceMenu {

    private WebDriver driver;
    private final String serviceMenuElement = "//ul[@class='dropdown-menu' or @class='sub']//*[contains(text(), '%s')]";

    public ServiceMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getServiceMenuElement(String elementName) {
        return driver.findElement(By.xpath(String.format(serviceMenuElement, elementName)));
    }
}
