package com.epam.tc.hw6.pom.elements;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LeftSection {

    @FindBy(css = ".sidebar-menu > li > a > span")
    private List<WebElement> leftMenu;

    @FindBy(xpath = "//a[@ui='label']/span[contains(text(), 'Service')]")
    private WebElement serviceMenu;

    public LeftSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<String> getLeftSidebarMenuNames() {
        return leftMenu.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
