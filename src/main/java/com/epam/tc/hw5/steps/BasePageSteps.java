package com.epam.tc.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.pom.elements.ServiceMenu;
import com.epam.tc.hw5.pom.pages.BasePage;
import com.epam.tc.hw5.utils.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class BasePageSteps extends BaseSteps {

    @When("I click on {string} button in Header")
    public void clickOnButtonInHeader(String menu) {
        log.info("Click on '" + menu + "' dropdown menu");
        new BasePage(TestContext.getInstance().get("driver", WebDriver.class)).getHeader().getServiceMenu().click();
    }

    @When("^I click on (.*) button in Service dropdown$")
    public void clickOnButtonInServiceDropdown(String menuElement) {
        log.info("Click SERVICE dropdown menu element '" + menuElement + "'");
        ServiceMenu serviceMenu = new ServiceMenu(TestContext.getInstance().get("driver", WebDriver.class));
        waitVisibilityOf(serviceMenu.getServiceMenuElement(menuElement)).click();
    }

    @Then("{string} page should be opened")
    public void pageShouldBeOpened(String pageName) {
        log.info("Verifying page title");
        assertThat(TestContext.getInstance().get("driver", WebDriver.class).getTitle())
                .isEqualTo(pageName);
    }
}
