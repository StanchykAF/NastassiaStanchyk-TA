package com.epam.tc.hw5.pom.elements;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class Header {

    @FindBy(xpath = "//ul[contains(@class, 'uui-navigation')]/li/a[contains(text(),'Service')]")
    private WebElement serviceMenu;

    @FindBy(css = ".dropdown.uui-profile-menu .profile-photo")
    private WebElement profileMenuButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(css = ".uui-navigation.nav > li > a")
    private List<WebElement> headerMenus;

    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<String> getHeaderMenusNames() {
        return headerMenus.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
