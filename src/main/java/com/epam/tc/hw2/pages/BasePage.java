package com.epam.tc.hw2.pages;

import com.epam.tc.hw2.models.ServiceDropDownMenu;
import java.time.Duration;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class BasePage {

    @FindBy(xpath = "//ul[contains(@class, 'uui-navigation')]/li/a[contains(text(),'Service')]")
    private WebElement headerServiceMenu;

    @FindBy(xpath = "//ul[contains(@class, 'uui-navigation')]//a[contains(text(), 'Support')]")
    private WebElement supportSubmenu;

    @FindBy(xpath = "//ul[contains(@class, 'uui-navigation')]//a[contains(text(), 'Dates')]")
    private WebElement datesSubmenu;

    @FindBy(xpath = "//ul[contains(@class, 'uui-navigation')]//a[contains(text(), 'Search')]")
    private WebElement searchSubmenu;

    @FindBy(xpath = "//ul[contains(@class, 'uui-navigation')]//a[contains(text(), 'Different elements')]")
    private WebElement differentElementsSubmenu;

    @FindBy(xpath = "//ul[contains(@class, 'uui-navigation')]//a[contains(text(), 'Performance')]")
    private WebElement performanceSubmenu;

    protected WebDriver driver;
    protected static final int WAIT_TIMEOUT_SECONDS = 20;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
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
        waitVisibilityOf(headerServiceMenu).click();
        switch (menuElement) {
            case SUPPORT:
                waitVisibilityOf(supportSubmenu).click();
                break;
            case DATES:
                waitVisibilityOf(datesSubmenu).click();
                break;
            case SEARCH:
                waitVisibilityOf(searchSubmenu).click();
                break;
            case DIFFERENT_ELEMENTS:
                waitVisibilityOf(differentElementsSubmenu).click();
                break;
            case PERFORMANCE:
                waitVisibilityOf(performanceSubmenu).click();
                break;
            default:
                throw new RuntimeException("Something went wrong!");
        }
    }
}
