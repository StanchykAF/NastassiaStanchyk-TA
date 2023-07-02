package com.epam.tc.hw3.pom.pages;

import com.epam.tc.hw3.models.ServiceDropDownMenu;
import com.epam.tc.hw3.pom.elements.Header;
import com.epam.tc.hw3.pom.elements.LeftSection;
import com.epam.tc.hw3.pom.elements.ServiceMenu;
import java.time.Duration;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
@Getter
public class BasePage {

    protected WebDriver driver;
    protected Header header;
    protected LeftSection leftSection;
    protected static final int WAIT_TIMEOUT_SECONDS = 20;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
        leftSection = new LeftSection(driver);
        PageFactory.initElements(driver, this);
    }

    protected WebDriverWait getNewWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }

    protected WebElement waitVisibilityOf(WebElement element) {
        return getNewWait().until(ExpectedConditions.visibilityOf(element));
    }

    protected void switchToFrame(WebElement frame) {
        driver.switchTo().frame(frame);
    }

    public void switchToOriginalWindow() {
        log.info("Switch to default content");
        driver.switchTo().defaultContent();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickServiceDropdownMenuElement(ServiceDropDownMenu menuElement) {
        log.info("Click SERVICE dropdown menu element '" + menuElement + "'");
        waitVisibilityOf(header.getServiceMenu()).click();
        ServiceMenu serviceMenu = new ServiceMenu(driver);
        switch (menuElement) {
            case SUPPORT:
                waitVisibilityOf(serviceMenu.getSupport()).click();
                break;
            case DATES:
                waitVisibilityOf(serviceMenu.getDates()).click();
                break;
            case SEARCH:
                waitVisibilityOf(serviceMenu.getSearch()).click();
                break;
            case DIFFERENT_ELEMENTS:
                waitVisibilityOf(serviceMenu.getDifferentElements()).click();
                break;
            case PERFORMANCE:
                waitVisibilityOf(serviceMenu.getPerformance()).click();
                break;
            default:
                throw new RuntimeException("Something went wrong!");
        }
    }
}
