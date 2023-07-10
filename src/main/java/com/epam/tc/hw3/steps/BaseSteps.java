package com.epam.tc.hw3.steps;

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

    protected void openPage(String url) {
        driver.navigate().to(BasePage.BASE_URL + url);
    }

    protected WebDriverWait getNewWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }

    protected WebElement waitVisibilityOf(WebElement element) {
        return getNewWait().until(ExpectedConditions.visibilityOf(element));
    }

    public BaseSteps switchToOriginalWindow() {
        log.info("Switch to default content");
        driver.switchTo().defaultContent();
        return this;
    }

    public String getPageTitle() {
        log.info("Get page title");
        return driver.getTitle();
    }

    public String getUsername() {
        log.info("Get user name");
        return basePage.getHeader().getUserName().getText();
    }

    public List<String> getHeaderMenusNames() {
        log.info("Get names of header menus");
        return basePage.getHeader().getHeaderMenusNames();
    }

    public List<String> getLeftSectionMenusNames() {
        log.info("Get names of left panel menus");
        return basePage.getLeftSection().getLeftSidebarMenuNames();
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
