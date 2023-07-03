package com.epam.tc.hw3.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw3.models.ServiceDropDownMenu;
import com.epam.tc.hw3.pom.elements.ServiceMenu;
import com.epam.tc.hw3.pom.pages.BasePage;
import java.time.Duration;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class BaseSteps {

    protected WebDriver driver;
    private BasePage basePage;
    protected static final int WAIT_TIMEOUT_SECONDS = 20;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(driver);
    }

    protected WebDriverWait getNewWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }

    protected WebElement waitVisibilityOf(WebElement element) {
        return getNewWait().until(ExpectedConditions.visibilityOf(element));
    }

    public BaseSteps switchToOriginalWindow() {
        log.info("Switch to default content");
        basePage.switchToDefaultContent();
        return this;
    }

    public BaseSteps checkPageTitle(String expectedTitle) {
        log.info("Check page title");
        assertThat(basePage.getPageTitle()).isEqualTo(expectedTitle);
        return this;
    }

    public BaseSteps checkUsername(String expectedUsername) {
        log.info("Check user name");
        assertThat(basePage.getUserName()).isEqualTo(expectedUsername);
        return this;
    }

    public BaseSteps checkHeaderMenusNames(List<String> expectedMenusNames) {
        log.info("Check names of header menus");
        assertThat(basePage.getHeader().getHeaderMenusNames()).isEqualTo(expectedMenusNames);
        return this;
    }

    public BaseSteps checkLeftSectionMenusNames(List<String> expectedMenusNames) {
        log.info("Check names of left panel menus");
        assertThat(basePage.getLeftSection().getLeftSidebarMenuNames()).isEqualTo(expectedMenusNames);
        return this;
    }

    public BaseSteps clickServiceDropdownMenuElement(ServiceDropDownMenu menuElement) {
        log.info("Click SERVICE dropdown menu element '" + menuElement + "'");
        waitVisibilityOf(basePage.getHeader().getServiceMenu()).click();
        ServiceMenu serviceMenu = new ServiceMenu(driver);
        switch (menuElement) {
            case SUPPORT:
                waitVisibilityOf(serviceMenu.getSupport()).click();
                return this;
            case DATES:
                waitVisibilityOf(serviceMenu.getDates()).click();
                return this;
            case SEARCH:
                waitVisibilityOf(serviceMenu.getSearch()).click();
                return this;
            case DIFFERENT_ELEMENTS:
                waitVisibilityOf(serviceMenu.getDifferentElements()).click();
                return new DifferentElementsPageSteps(driver);
            case PERFORMANCE:
                waitVisibilityOf(serviceMenu.getPerformance()).click();
                return this;
            default:
                throw new RuntimeException("Something went wrong!");
        }
    }
}
